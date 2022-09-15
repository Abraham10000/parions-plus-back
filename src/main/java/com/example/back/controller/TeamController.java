package com.example.back.controller;

import com.example.back.model.Team;
import com.example.back.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/teams")
    public List<Team> getALl(){
        return teamService.getAllTeam();
    }

    @PostMapping("/team")
    public Team Addteam(@RequestBody Team newTeam){
        return teamService.AddTeam(newTeam);
    }

    @DeleteMapping("/team/{idteam}")
    public String deleteTeam(@PathVariable Integer idTeamToDelete){
        return teamService.DeleteTeam(idTeamToDelete);
    }
}
