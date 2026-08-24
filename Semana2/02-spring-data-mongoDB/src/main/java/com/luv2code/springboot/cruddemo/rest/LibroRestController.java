package com.luv2code.springboot.cruddemo.rest;

import tools.jackson.databind.json.JsonMapper;
import com.luv2code.springboot.cruddemo.entity.Libro;
import com.luv2code.springboot.cruddemo.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LibroRestController {

    private LibroService libroService;

    private JsonMapper jsonMapper;

    @Autowired
    public LibroRestController(LibroService theLibroService, JsonMapper theJsonMapper) {
        libroService = theLibroService;
        jsonMapper = theJsonMapper;
    }

    // expose "/libros" and return a list of libros
    @GetMapping("/libros")
    public List<Libro> findAll() {
        return libroService.findAll();
    }

    // add mapping for GET /libros/{libroId}
    //
    // El librosId ahora es String: un ObjectId de MongoDB, no un entero.

    @GetMapping("/libros/{libroId}")
    public Libro getLibro(@PathVariable String libroId) {

        Libro theLibro = libroService.findById(libroId);

        if (theLibro == null) {
            throw new RuntimeException("Libro id not found - " + libroId);
        }

        return theLibro;
    }

    // add mapping for POST /libros - add new libro

    @PostMapping("/libros")
    public Libro addLibro(@RequestBody Libro theLibro) {

        // also just in case they pass an id in JSON ... set id to null
        // this is to force a save of new item ... instead of update
        //
        // En JPA esto era setId(0). En MongoDB el equivalente es null: si el id
        // viene nulo se inserta un documento nuevo, y si viene con valor se
        // REEMPLAZA el documento que ya existía con ese id.

        theLibro.setId(null);

        Libro dbLibro = libroService.save(theLibro);

        return dbLibro;
    }

    // add mapping for PUT /libros - update existing libro

    @PutMapping("/libros")
    public Libro updateLibro(@RequestBody Libro theLibro) {

        Libro dbLibro = libroService.save(theLibro);

        return dbLibro;
    }

    // add mapping for PATCH /libros/{libroId} - patch libro ... partial
    // update

    @PatchMapping("/libros/{libroId}")
    public Libro patchLibro(@PathVariable String libroId,
            @RequestBody Map<String, Object> patchPayload) {

        // Step 1: Retrieve the existing libro from database
        Libro tempLibro = libroService.findById(libroId);

        if (tempLibro == null) {
            throw new RuntimeException("Libro id not found - " + libroId);
        }

        // Step 2: Security check - prevent ID modifications
        // The ID should never change, so reject any attempts to modify it
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException(
                    "Libro id cannot be modified. Remove 'id' from request body.");
        }

        // Step 3: Apply the partial update
        // This creates a NEW libro object with the updates applied
        Libro patchedLibro = jsonMapper.updateValue(tempLibro, patchPayload);

        // Step 4: Save the updated employee to database and return it
        Libro dbLibro = libroService.save(patchedLibro);

        return dbLibro;
    }

    // add mapping for DELETE /libros/{libroId} - delete libros

    @DeleteMapping("/libros/{libroId}")
    public String deleteLibro(@PathVariable String libroId) {

        Libro tempLibro = libroService.findById(libroId);

        // throw exception if null

        if (tempLibro == null) {
            throw new RuntimeException("Libro id not found - " + libroId);
        }

        libroService.deleteById(libroId);

        return "Deleted libro id - " + libroId;
    }

}
