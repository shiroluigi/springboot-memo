package com.shiro.crud.services;

import com.shiro.crud.entities.employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface employeeRepository extends JpaRepository<employee, UUID> {
}
