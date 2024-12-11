package com.shiro.crud.services;

import com.shiro.crud.entities.employee;
import com.shiro.crud.entities.memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class memoService {
    @Autowired
    public memoRepository memoRepository;
    @Autowired
    public employeeRepository employeeRepository;

    public List<memo> getAll() {
        return memoRepository.findAll();
    }

    public List<memo> getByUserId(UUID id) {
        Optional<employee> empOptional = employeeRepository.findById(id);
        if (empOptional.isPresent())
        {
            employee empObj = empOptional.get();
            return empObj.getMemos();
        }
        return null;
    }

}
