package com.example.back.controller;


import com.example.back.model.Competition;
import com.example.back.service.CompetitionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompetitionController {
    private final CompetitionService competitionService;

    @GetMapping("/competitions")
    public List<Competition> getAllCompet(){
        return competitionService.getAll();
    }


    @PostMapping("/competition")
    public Competition AddCompet(@RequestBody Competition newCompet){
        return competitionService.AddCompet(newCompet);
    }

    @DeleteMapping("/competition/{id}")
    public String DeleteCompet(@PathVariable Integer id){
        return competitionService.deleteCompet(id);
    }
}
