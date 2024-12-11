package com.shiro.crud.services;

import com.shiro.crud.entities.memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class memoService {
    @Autowired
    public memoRepository memoRepository;

    public List<memo> getAll() {
        return memoRepository.findAll();
    }

}
