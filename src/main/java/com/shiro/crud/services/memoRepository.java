package com.shiro.crud.services;

import com.shiro.crud.entities.memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface memoRepository extends JpaRepository<memo, UUID> {
}
