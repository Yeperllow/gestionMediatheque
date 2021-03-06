/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java;


import edu.uha.miage.projet.java.core.metier.Role;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.service.RoleService;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Order(2)
@Component
public class DemoUtilisateur implements CommandLineRunner {
    //private static final Logger LOGGER = LoggerFactory.getLogger(DemoCategories.class);

    @Autowired
    private UtilisateurService utilisateurService;
    
    
    @Autowired
    private RoleService roleService;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void run(String... arg0) throws Exception {
        
        /*
        Role role1 = new Role();
        role1.setNom("USER");
        Optional<Role> role1Tmp = roleService.findByNom("USER");
        if(!role1Tmp.isPresent())
        {
            roleService.save(role1);
        }
        
        
        
        Role role2 = new Role();
        role2.setNom("ADMIN");
        Optional<Role> role2Tmp = roleService.findByNom("ADMIN");
        if(!role2Tmp.isPresent())
        {
            roleService.save(role2);
        }*/
        

        Utilisateur user1 = new Utilisateur();
        user1.setLogin("bob2");
        user1.setNom("FFFF");
        user1.setPrenom("MMMM");
        user1.setMotDePasse(bCryptPasswordEncoder.encode("aaaaaa"));
        
        Optional<Role> role1Tmp = roleService.findByNom("EMPLOYE");
        if(!role1Tmp.isPresent())
        {
            roleService.save(role1Tmp.get());
        }
        
        user1.setRole(role1Tmp.get());
        Optional<Utilisateur> user1Tmp = utilisateurService.findByLogin("bob2");
        if(!user1Tmp.isPresent())
        {
            utilisateurService.save(user1);
        }
        
        
        
        Utilisateur user2 = new Utilisateur();
        user2.setLogin("bob3");
        user2.setNom("III");
        user2.setPrenom("OOO");
        user2.setMotDePasse(bCryptPasswordEncoder.encode("aaaaaa"));
        
        Optional<Role> role2Tmp = roleService.findByNom("ADMIN");
        if(!role2Tmp.isPresent())
        {
            roleService.save(role2Tmp.get());
        }
        
        user2.setRole(role2Tmp.get());
        Optional<Utilisateur> user2Tmp = utilisateurService.findByLogin("bob3");
        if(!user2Tmp.isPresent())
        {
            utilisateurService.save(user2);
        }
        
    }

  
}

