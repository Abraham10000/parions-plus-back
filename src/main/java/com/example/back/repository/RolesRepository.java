package com.example.back.repository;

import com.example.back.model.Bet;
import com.example.back.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
}
