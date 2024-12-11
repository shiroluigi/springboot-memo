package com.shiro.crud.controllers;

import com.shiro.crud.entities.memo;
import com.shiro.crud.services.memoRepository;
import com.shiro.crud.services.memoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/memos")
public class memoController {

    @Autowired
    memoService mservice;

    @GetMapping
    public ResponseEntity<List<memo>> getAllMemos(){
        List<memo> memos = mservice.getAll();
        return new ResponseEntity<>(memos, HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<memo>> getMemoById(@PathVariable UUID id){
        if (mservice.getByUserId(id) != null) {
            return new ResponseEntity<>(mservice.getByUserId(id) , HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
