package com.example.back.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

@Table(name = "team_list")
public class Team implements Serializable {
    @Id
    @Column(name = "id_team",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_team;

    @Column(name = "team_name")
    private String team_name;

    @Column(name = "country_team")
    private String country_team;
}
