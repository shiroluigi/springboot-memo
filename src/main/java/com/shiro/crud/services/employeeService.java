package com.shiro.crud.services;


import com.shiro.crud.entities.employee;
import com.shiro.crud.entities.memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class employeeService {

    @Autowired
    private employeeRepository employeeRepository;
    @Autowired
    private memoRepository memoRepository;


    public List<employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public employee createEmployee(employee employee) {
        return employeeRepository.save(employee);
    }

    public memo addSingleMemo(UUID id, memo singleMemo) {
        Optional<employee> requestedEmployee = employeeRepository.findById(id);

        if (requestedEmployee.isPresent()) {
            employee emp = requestedEmployee.get();

            if (emp.getMemos() == null) {
                emp.setMemos(new ArrayList<>());
            }

            memo newMemo = new memo();
            newMemo.setTitle(singleMemo.getTitle());
            newMemo.setData(singleMemo.getData());
            newMemo.setDate(LocalDateTime.now());
            newMemo.setEmployee(emp);
            memoRepository.save(newMemo);

            emp.getMemos().add(newMemo);
            employeeRepository.save(emp);

            return newMemo;
        } else {
            return null;
        }
    }



}
