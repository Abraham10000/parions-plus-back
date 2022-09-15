package com.example.back.model;

import aj.org.objectweb.asm.ConstantDynamic;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity

@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "id_user", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user;

    @Column(name = "name",length = 255)
    private String name;

    @Column(name = "last_name",length = 255)
    private String last_name;

    @Column(name = "user_name",nullable = false,length = 50)
    private String username;

    @Column(name = "phone_number",nullable = false,length = 14)
    private String phone_number;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "fk_role_id")
    private Roles role;
}
