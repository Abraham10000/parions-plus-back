package com.example.back.service;

import com.example.back.model.Game;
import com.example.back.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GameService {
    private GameRepository gameRepository;

    public List<Game> getAll(){
        return gameRepository.findAll();
    }

    public List<Game> getGameDay(){
        return gameRepository.getGameDay();
    }

    public List<Game> sortGameByDate(){
        return gameRepository.sortGameByDate();
    }

    public List<Game> findGameByCompetName(String competToFind){
        return gameRepository.getGamByCompetitionName(competToFind);
    }

    public Game addgame(Game game){
        return gameRepository.save(game);
    }

    public Game updateGame(Integer idGame, String NewTeamName){
        Optional<Game> game = gameRepository.findById(idGame);

        if (game.isPresent()){
            Game game1 = game.get();
          game1.getTeam_away().setTeam_name(NewTeamName);

          return gameRepository.save(game1);
        }else {
            throw new NullPointerException("Game not found");
        }
    }

    public String deleteGame(Integer idGame){
        gameRepository.deleteById(idGame);
        return "Ressource delete successfully";
    }
}
