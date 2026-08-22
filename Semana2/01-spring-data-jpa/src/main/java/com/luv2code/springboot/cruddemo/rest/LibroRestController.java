package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.entity.Employee;
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

    // expose "/employees" and return a list of employees
    @GetMapping("/libros")
    public List<Libro> findAll() {
        return libroService.findAll();
    }

    // add mapping for GET /employees/{employeeId}

    @GetMapping("/libros/{libroId}")
    public Libro getLibro(@PathVariable int libroId) {

        Libro theLibro = libroService.findById(libroId);

        if (theLibro == null) {
            throw new RuntimeException("Libro id not found - " + employeeId);
        }

        return theLibro;
    }

    // add mapping for POST /libros - add new employee

    @PostMapping("/libros")
    public Libro addLibro(@RequestBody Libro theLibro) {

        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theLibro.setId(0);

        Libro dbLibro = libroService.save(theLibro);

        return dbLibro;
    }

    // add mapping for PUT /libros - update existing employee

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    // add mapping for PATCH /employees/{employeeId} - patch employee ... partial
    // update

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
            @RequestBody Map<String, Object> patchPayload) {

        // Step 1: Retrieve the existing employee from database
        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        // Step 2: Security check - prevent ID modifications
        // The ID should never change, so reject any attempts to modify it
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException(
                    "Employee id cannot be modified. Remove 'id' from request body.");
        }

        // Step 3: Apply the partial update
        // This creates a NEW employee object with the updates applied
        Employee patchedEmployee = jsonMapper.updateValue(tempEmployee, patchPayload);

        // Step 4: Save the updated employee to database and return it
        Employee dbEmployee = employeeService.save(patchedEmployee);

        return dbEmployee;
    }

    // add mapping for DELETE /employees/{employeeId} - delete employee

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null

        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}
