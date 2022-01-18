/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.security;

import edu.uha.miage.projet.java.core.service.implementations.CustomUserDetailsService;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    
     @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomUserDetailsService userDetailsService;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
                auth
                    .userDetailsService(userDetailsService)
                    .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.formLogin();
        http.authorizeRequests(authorize -> authorize
                // #### V4.3
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/theme/bootstrap/css/**").permitAll()
                .mvcMatchers("/employe", "/employe/**").hasAuthority("ADMIN")
                .mvcMatchers("/client", "/client/**").hasAuthority("EMPLOYE")
                .mvcMatchers("/emprunt").hasAnyAuthority("CLIENT", "EMPLOYE")
                .mvcMatchers("/emprunt/**").hasAuthority("CLIENT")
                .mvcMatchers("/tag", "/tag/**").hasAuthority("EMPLOYE")
                .mvcMatchers("/media", "/media/**").hasAuthority("EMPLOYE")
                .mvcMatchers("/type", "/type/**").hasAuthority("EMPLOYE")
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/logout").authenticated()
                .anyRequest().authenticated()
                
                
        );
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }


}
