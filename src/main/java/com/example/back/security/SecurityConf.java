package com.example.back.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConf extends WebSecurityConfigurerAdapter {
    private final com.example.back.service.userService userService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users/**").hasRole("Admin")
                .antMatchers(HttpMethod.POST, "/users").hasRole("Admin")
                .antMatchers(HttpMethod.DELETE, "/users/{id}").hasRole("Admin")
                .antMatchers(HttpMethod.PATCH, "/users/{id}").hasAnyRole("Admin", "Member")
                .antMatchers(HttpMethod.GET, "/bets/**").hasAnyRole("Admin", "Member")
                .antMatchers(HttpMethod.POST, "/bet").hasRole("Member")
                .antMatchers(HttpMethod.DELETE, "/bet/**").hasRole( "Member")
                .antMatchers(HttpMethod.GET, "/categories").permitAll()
                .antMatchers(HttpMethod.POST, "/category").hasRole( "Admin")
                .antMatchers(HttpMethod.DELETE, "/category/{id}").hasRole( "Admin")
                .antMatchers(HttpMethod.GET, "/competitions").permitAll()
                .antMatchers(HttpMethod.POST, "/competition").hasRole( "Admin")
                .antMatchers(HttpMethod.DELETE, "/competition/{id}").hasRole( "Admin")
                .antMatchers(HttpMethod.GET, "/teams").permitAll()
                .antMatchers(HttpMethod.POST, "/team").hasRole( "Admin")
                .antMatchers(HttpMethod.DELETE, "/team/{idteam}").hasRole( "Admin")
                .antMatchers(HttpMethod.GET, "/games/**").permitAll()
                .antMatchers(HttpMethod.GET, "/gameday").permitAll()
                .antMatchers(HttpMethod.POST, "/game").hasRole( "Admin")
                .antMatchers(HttpMethod.DELETE, "/game/{id}").hasRole( "Admin")
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .csrf().disable();
    }

    @Bean
    PasswordEncoder bcryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)  {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(bcryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }
}
