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

@Table(name = "category")
public class Category implements Serializable {
    @Id
    @Column(name = "id_category",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_category;

    @Column(name = "category_name")
    private String category_name;
}
//Repeated column in mapping for entity