package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Libro;
import com.luv2code.springboot.cruddemo.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl implements LibroService {

    // Antes se inyectaba EmployeeDAO. Ahora es el repositorio de Spring Data,
    // que no tiene implementación escrita a mano.
    private LibroRepository libroRepository;

    @Autowired
    public LibroServiceImpl(LibroRepository theLibroRepository) {
        libroRepository = theLibroRepository;
    }

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findById(String theId) {

        // findById() devuelve Optional<Libro>. Lo convertimos a null para
        // conservar el mismo contrato que tenía la versión con JPA: el
        // controlador sigue comprobando "if (tempLibro == null)".
        return libroRepository.findById(theId).orElse(null);
    }

    // Ojo: aquí ya no hay @Transactional.
    //
    // MongoDB en modo standalone (un contenedor suelto, sin replica set) no
    // soporta transacciones multi-documento. Y no hacen falta: cada operación
    // toca un solo documento, y MongoDB garantiza atomicidad por documento.
    @Override
    public Libro save(Libro theLibro) {
        return libroRepository.save(theLibro);
    }

    @Override
    public void deleteById(String theId) {
        libroRepository.deleteById(theId);
    }
}
