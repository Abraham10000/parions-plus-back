package com.example.back.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

@Table(name = "competition")
public class Competition implements Serializable {
    @Id
    @Column(name = "id_competition",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_competition;

    @Column(name = "compet_name")
    private String compet_name;

    @OneToOne
    @JoinColumn(name = "id_category",nullable = false)
    private Category id_category;
}
