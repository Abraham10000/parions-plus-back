package com.example.back.controller;

import com.example.back.model.Game;
import com.example.back.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class GameController {
    private final GameService gameService;

    @GetMapping("/games")
    public List<Game> getAllGame(){
        return gameService.getAll();
    }

    @GetMapping("/gameday")
    public List<Game> getGameDay(){
        return gameService.getGameDay();
    }

    @GetMapping("/games/sorted")
    public List<Game> getGameSortde(){
        return gameService.sortGameByDate();
    }

    @GetMapping("/games/{competname}")
    public List<Game> getGameByCompetName(@PathVariable String competToFind){
        return gameService.findGameByCompetName(competToFind);
    }

    @PostMapping("/game")
    public Game addNewGame(@RequestBody Game gameToAdd){
        return gameService.addgame(gameToAdd);
    }

    @DeleteMapping("/game/{id}")
    public String deleteGameByid(@PathVariable Integer id){
        return gameService.deleteGame(id);
    }
}
