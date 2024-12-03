package com.shiro.crud.controllers;

import com.shiro.crud.entities.memo;
import com.shiro.crud.services.memoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/memos")
public class memoController {

    @Autowired
    memoRepository mrepos;

    @GetMapping("/{uid}")
    public ResponseEntity<memo> getMemos(@PathVariable String uid){
        Optional<memo> singleMemo = mrepos.findById(UUID.fromString(uid));
        if(singleMemo.isPresent()){
            return ResponseEntity.ok((memo) singleMemo.get());
        }
        return ResponseEntity.notFound().build();

    }
}
