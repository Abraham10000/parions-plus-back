package com.example.back.service;

import com.example.back.model.Category;
import com.example.back.model.Team;
import com.example.back.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeamService {
    public TeamRepository teamRepository;

    public List<Team> getAllTeam(){
        return teamRepository.findAll();
    }

    public Team AddTeam(Team team){
        return teamRepository.save(team);
    }

    public String DeleteTeam(Integer id){
         teamRepository.deleteById(id);
         return "Delete Successfully";
    }
}
