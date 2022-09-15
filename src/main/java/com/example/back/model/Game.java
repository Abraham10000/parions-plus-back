package com.example.back.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity


@Table(name = "game_list")
public class Game implements Serializable {
    @Id
    @Column(name = "id_game",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_game;

    @OneToOne
    @JoinColumn(name = "id_competition", nullable = false,referencedColumnName = "id_competition")
    private Competition id_competition;

    @OneToOne
    @JoinColumn(name = "id_team_home",nullable = false)
    private Team team_home;

    @Column(name = "team_home_rating",nullable = false)
    private Float team_home_rating;

    @OneToOne
    @JoinColumn(name = "id_team_away",nullable = false)
    private Team team_away;

    @Column(name = "team_away_rating",nullable = false)
    private Float team_away_rating;

    @Column(name = "broadcast_time",nullable = false)
    private Time broadcast_time;

    @Column(name = "broadcast_day",nullable = false)
    private Date broadcast_day;
}
