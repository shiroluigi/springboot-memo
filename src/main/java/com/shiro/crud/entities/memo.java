package com.shiro.crud.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "MEMO")
public class memo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;
    @Column(name = "TITLE")
    @NonNull
    private String title;
    @Column(name = "DATA")
    private String data;
    @Column(name = "Date")
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "emp_id", nullable = false)
    private employee employee;
}
