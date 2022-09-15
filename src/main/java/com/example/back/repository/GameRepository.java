package com.example.back.repository;

import com.example.back.model.Game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository <Game, Integer> {
    @Query(value = "select * from game_list order by broadcast_day asc" , nativeQuery = true)
    List<Game> sortGameByDate();

    @Query(value = "select * from game_list where broadcast_day = current_date order by broadcast_time asc", nativeQuery = true)
    List<Game> getGameDay();

    @Query(value = "select * from game_list inner join competition on game_list.id_competition = competition.id_competition where compet_name = :compet_given"
            ,nativeQuery = true)
    List<Game> getGamByCompetitionName(@Param("compet_given") String compet_toFind);
}