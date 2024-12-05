package com.shiro.crud.controllers;


import com.shiro.crud.services.employeeRepository;
import com.shiro.crud.entities.employee;
import com.shiro.crud.services.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class employeeController {

    @Autowired
    public employeeService es;

    @GetMapping("/getall")
    public ResponseEntity<List<employee>> getEmployees() {
        List<employee> employees = es.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.FOUND);
    }
    @PostMapping("/create")
    public ResponseEntity<employee> createEmployee(@RequestBody employee newEmployee) {
        employee empObj = es.createEmployee(newEmployee);
        return new ResponseEntity<>(empObj, HttpStatus.CREATED);
    }


}
