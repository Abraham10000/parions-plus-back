package com.example.back.service;


import com.example.back.model.Bet;
import com.example.back.model.User;
import com.example.back.repository.BetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BetService {
    private BetRepository betRepository;

    public List<Bet> getAll(){return betRepository.findAll();}

    public Optional<Bet> findById(Integer idbet){
        return betRepository.findById(idbet);
    }

    public List<Bet> getByStake_date(){
        return betRepository.sortBetBydate();
    }

    public List<Bet> getByStatus(){
        return betRepository.sortBetByStatus();
    }

  public Bet saveBet(Bet bettosave){
        return betRepository.save(bettosave);
  }

  public String deleteBet(Integer idbet){
        betRepository.deleteById(idbet);
        return "Delete Successfully";
  }
}
