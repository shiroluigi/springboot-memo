package com.shiro.crud.services;


import com.shiro.crud.entities.employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {

    @Autowired
    private employeeRepository employeeRepository;


    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public employee createEmployee(employee employee) {
        return employeeRepository.save(employee);
    }


}
