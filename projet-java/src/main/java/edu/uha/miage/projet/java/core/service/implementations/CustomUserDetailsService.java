/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Role;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
 
@Component
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UtilisateurService userRepo;
     
    /*@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userRepo.findByLogin(username).get();
        
        if (user == null) {
            
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }*/
    
    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Utilisateur user = userRepo.findByLogin(userName).get();
        List<GrantedAuthority> authorities = getUserAuthority(user.getRole());
        return buildUserForAuthentication(user, authorities);
    }

    private List<GrantedAuthority> getUserAuthority(Role role) {
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(role.getNom()));
        
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
        return grantedAuthorities;
    }

    private UserDetails buildUserForAuthentication(Utilisateur user, List<GrantedAuthority> authorities) {
        System.out.println(authorities);
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getMotDePasse(),
                user.isEtat(), true, true, true, authorities);
    }
 
}
