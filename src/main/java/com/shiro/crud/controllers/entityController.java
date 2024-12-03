package com.shiro.crud.controllers;


import com.shiro.crud.services.employeeRepository;
import com.shiro.crud.entities.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class entityController {

    @Autowired
    employeeRepository er;

    @GetMapping("/getall")
    public ResponseEntity<List<employee>> getEmployees() {
        return new ResponseEntity<>(er.findAll(), HttpStatus.OK);
    }
    @GetMapping("/single/{uid}")
    public ResponseEntity<employee> getEmployee(@PathVariable String uid) {
        Optional<employee> employeeOptional = er.findById(UUID.fromString(uid));
        if (employeeOptional.isPresent()) {
            return new ResponseEntity<>(employeeOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create")
    public employee addEmployee(@RequestBody employee emp) {
        return er.save(emp);
    }
    @DeleteMapping("/delete/{uid}")
    public void deleteEmployee(@PathVariable int uid) {

    }

}
