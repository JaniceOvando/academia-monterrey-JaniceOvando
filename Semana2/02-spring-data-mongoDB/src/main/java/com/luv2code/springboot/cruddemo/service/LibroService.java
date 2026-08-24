package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Libro;

import java.util.List;

public interface LibroService {

    List<Libro> findAll();

   Libro findById(String theId);

   Libro save(Libro theLibro);

    void deleteById(String theId);

}
