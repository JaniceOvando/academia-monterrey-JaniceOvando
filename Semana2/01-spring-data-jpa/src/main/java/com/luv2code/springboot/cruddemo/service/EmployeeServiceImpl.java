package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.dao.LibroRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private LibroRepository libroRepository;

    @Autowired
    public EmployeeServiceImpl(LibroRepository theLibroRepository) {
        libroRepository = theLibroRepository;
    }

    @Override
    public List<Employee> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = libroRepository.findById(theId);

        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        return libroRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        libroRepository.deleteById(theId);
    }
}






