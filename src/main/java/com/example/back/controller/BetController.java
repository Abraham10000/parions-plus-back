package com.example.back.controller;

import com.example.back.model.Bet;
import com.example.back.service.BetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
public class BetController {
    private final BetService betService;

    @GetMapping("/bets")
    public List<Bet> getAll(){
        return betService.getAll();
    }

    @GetMapping("/bets/date")
    public List<Bet> sortBetByDate(){
        return betService.getByStake_date();
    }

    @GetMapping("/bets/status")
    public List<Bet> sortBetByStatus(){
        return betService.getByStatus();
    }

    @PostMapping("/bet")
    public Bet addBet(@RequestBody Bet newBet){
        return betService.saveBet(newBet);
    }

    @DeleteMapping("/bet/id")
    public String deleteBet(@PathVariable Integer idBet){
        return betService.deleteBet(idBet);
    }
}
