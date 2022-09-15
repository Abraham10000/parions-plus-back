package com.example.back.service;

import com.example.back.model.User;
import com.example.back.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class userService implements UserDetailsService {

    private final UserRepository userepository;

    public List<User> getALl(){
        return userepository.findAll();
    }

   public User getById(Long id){
        return userepository.findById(id).get();
    }

    public List<User> findName(String name){
        return userepository.findByNameContaining(name);
    }

    public User AddUser(User newUser){
        return userepository.save(newUser);
    }

    public User UpdateUser(Long id ,String name){
        Optional<User> user = userepository.findById(id);
        if(user.isPresent()){
            User user1 = user.get();
            user1.setName(name);
             return userepository.save(user1);
        } else {
            throw new NullPointerException("User not found");
        }
    }

    public String DeleteUserById(Long id){
        userepository.deleteById(id);
        return "Delete succesfully";
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  userepository.findUsersByUsername(username);
        return new UserDetailsPrincipal(user);
    }

    public User addUser(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userepository.save(user);
    }
}
