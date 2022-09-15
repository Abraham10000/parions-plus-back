package com.example.back.model;

import lombok.*;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

@Table(name = "bet_stake")
public class Bet implements Serializable {
    @Id
    @Column(name = "id_bet",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_bet;

    @Column(name = "bet_stake",nullable = false)
    private Float bet_stake;

    @OneToOne
    @JoinColumn(name = "id_game",nullable = false)
    private Game id_game;

    @ManyToMany
    @JoinColumn(name = "id_user",nullable = false)
    Set<User> id_user;

     @Column(name = "stake_date", nullable = false)
    private String stake_date ;

     @Column(name = "status", nullable = false)
    private String status;
}
