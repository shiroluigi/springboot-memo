package com.shiro.crud.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "EMPLOYEE")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "EMP_ID")
    private UUID emp_id;
    @Column(name = "EMP_NAME")
    @NonNull
    private String emp_name;
    @Column(name = "EMP_JOB")
    @NonNull
    private String emp_job;
    @Column(name = "PASSWORD")
    @NonNull
    private String password;
    @Column(name = "USERNAME")
    @NonNull
    private String username;

}
