package com.example.back.service;

import com.example.back.model.Competition;
import com.example.back.model.Game;
import com.example.back.repository.CompetitionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CompetitionService {
    private CompetitionRepository competitionRepository;
    public List<Competition> getAll(){
        return competitionRepository.findAll();
    }

    public Optional<Competition> getCompetByid(Integer id){
        return competitionRepository.findById(id);
    }


    public Competition AddCompet(Competition compet){
        return competitionRepository.save(compet);
    }

    public String deleteCompet(Integer idcompet){
        competitionRepository.deleteById(idcompet);

        return "Resource Deleted";
    }
}
