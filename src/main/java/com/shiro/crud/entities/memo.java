package com.shiro.crud.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "EMPLOYEE")
public class memo {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "TITLE")
    @NonNull
    private String title;
    @Column(name = "DATA")
    private String data;
    @Column(name = "Date")
    private LocalDateTime date;
}
