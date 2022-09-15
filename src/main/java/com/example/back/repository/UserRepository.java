package com.example.back.repository;

import com.example.back.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    @Query(value = "select * from users where name ilike %:nametofind%",nativeQuery = true)
    List<User> findUsersByHisName(@Param("nametofind") String name);


    List<User> findByNameContaining(String name);

    User findUsersByUsername(String username);
}
