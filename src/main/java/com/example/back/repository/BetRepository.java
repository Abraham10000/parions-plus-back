package com.example.back.repository;

import com.example.back.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet , Integer> {
    @Query(value = "select * from bet_stake order by stake_date asc", nativeQuery = true)
    public List<Bet> sortBetBydate();

    @Query(value = "select * from bet_stake order by status desc", nativeQuery = true)
    List<Bet> sortBetByStatus();
}
