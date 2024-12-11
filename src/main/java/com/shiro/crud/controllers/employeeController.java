package com.shiro.crud.controllers;


import com.shiro.crud.entities.memo;
import com.shiro.crud.services.employeeRepository;
import com.shiro.crud.entities.employee;
import com.shiro.crud.services.employeeService;
import com.shiro.crud.services.memoService;
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
    public memoService ms;

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
    @PostMapping("/add-memo/{id}")
    public ResponseEntity<memo> addMemo(@RequestBody memo reqMemo, @PathVariable UUID id) {
        memo res = es.addSingleMemo(id, reqMemo);
        if (res == null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>( res ,HttpStatus.CREATED);
    }


}
