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

@Order(1)
@Component
public class DemoRole implements CommandLineRunner {
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
        
        
        Role role1 = new Role();
        role1.setNom("ADMIN");
        Optional<Role> role1Tmp = roleService.findByNom("ADMIN");
        if(!role1Tmp.isPresent())
        {
            roleService.save(role1);
        }
        
        
        
        Role role2 = new Role();
        role2.setNom("EMPLOYE");
        Optional<Role> role2Tmp = roleService.findByNom("EMPLOYE");
        if(!role2Tmp.isPresent())
        {
            roleService.save(role2);
        }
        
        
        
        Role role3 = new Role();
        role3.setNom("CLIENT");
        Optional<Role> role3Tmp = roleService.findByNom("CLIENT");
        if(!role3Tmp.isPresent())
        {
            roleService.save(role3);
        }
        

      
        
    }

  
}

