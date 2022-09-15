package com.example.back.service;

import com.example.back.model.Roles;
import com.example.back.repository.RolesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private RolesRepository repository;
    public Roles addRole(Roles role){
        return repository.save(role);
    }
}
