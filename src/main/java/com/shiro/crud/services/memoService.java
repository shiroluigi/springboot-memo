package com.shiro.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class memoService {
    @Autowired
    public memoRepository memoRepository;

    public memoService() {

    }
}
