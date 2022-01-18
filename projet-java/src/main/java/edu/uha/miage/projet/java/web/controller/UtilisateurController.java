/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.web.controller;

import edu.uha.miage.projet.java.core.metier.Role;
import edu.uha.miage.projet.java.core.metier.Type;
import edu.uha.miage.projet.java.core.models.UtilisateurModel;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.service.RoleService;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kangacedricmarshallfry
 */
@Controller
public class UtilisateurController {

    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    RoleService roleService;
   
    @Autowired
    MessageSource messageSource;
    
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    

    @GetMapping({"/employe", "/client"})
    public String findAll(Model model, HttpServletRequest request) {
        model.addAttribute("utilisateurs", utilisateurService.findAll());
        
        if(request.getRequestURI().startsWith("/employe"))
        {
            model.addAttribute("role", "EMPLOYE");
        }
        
        if(request.getRequestURI().startsWith("/client"))
        {
            model.addAttribute("role", "CLIENT");
        }
        return "utilisateur/list";
    }

    @GetMapping({"/employe/create", "/client/create"})
    public String createEmploye(Model model, HttpServletRequest request) {
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        
        List<Role> roles = new ArrayList<>();
        if(request.getRequestURI().startsWith("/employe"))
        {
            roles.add(roleService.findByNom("EMPLOYE").get());
            model.addAttribute("roles", roles );
        }
        
        if(request.getRequestURI().startsWith("/client"))
        {
            roles.add(roleService.findByNom("CLIENT").get());
            model.addAttribute("roles", roles);
        }
               
        return "utilisateur/edit";
    }

    @PostMapping({"/employe/create", "/client/create"})
    public String created(Model model, @Valid Utilisateur utilisateur, BindingResult br, HttpServletRequest request) {
        
        List<Role> roles = new ArrayList<>();
        
        if(request.getRequestURI().startsWith("/employe"))
        {
            roles.add(roleService.findByNom("EMPLOYE").get());
            model.addAttribute("roles", roles );
        }
        else
        {
            roles.add(roleService.findByNom("CLIENT").get());
            model.addAttribute("roles", roles);
        }
        
        if (br.hasErrors()) {
            return "utilisateur/edit";
        }
        if (!UtilisateurModel.tryToSave(utilisateurService, bCryptPasswordEncoder,utilisateur, br)) {
          return "utilisateur/edit";
        }
        
        if(request.getRequestURI().startsWith("/employe"))
        {
            return "redirect:/employe";
        }
        
        else
        {
            return "redirect:/client";
        }        
        
    }

    @GetMapping({"/employe/edit", "/client/edit"})
    public String edit(@RequestParam(name = "id") int id, Model model, HttpServletRequest request) {
        
        model.addAttribute("utilisateur", utilisateurService.findById(id).get());
        
        List<Role> roles = new ArrayList<>();
        if(request.getRequestURI().startsWith("/employe"))
        {
            roles.add(roleService.findByNom("EMPLOYE").get());
            model.addAttribute("roles", roles );
        }
        else
        {
            if(request.getRequestURI().startsWith("/client"))
            {
                roles.add(roleService.findByNom("CLIENT").get());
                model.addAttribute("roles", roles);
            }
            
        }
        return "utilisateur/edit";
    }

    @PostMapping({"/employe/edit", "/client/edit"})
    public String edited(Model model, @Valid Utilisateur utilisateur, BindingResult br, HttpServletRequest request) {
        List<Role> roles = new ArrayList<>();
        
        if(request.getRequestURI().startsWith("/employe"))
        {
            roles.add(roleService.findByNom("EMPLOYE").get());
            model.addAttribute("roles", roles );
        }
        else
        {
            if(request.getRequestURI().startsWith("/client"))
            {
                roles.add(roleService.findByNom("CLIENT").get());
                model.addAttribute("roles", roles);
            }
            
        }
        
        if (br.hasErrors()) {
            return "utilisateur/edit";
        }

        if (!UtilisateurModel.tryToUpdate(utilisateurService, bCryptPasswordEncoder, utilisateur, br)) {
            return "utilisateur/edit";
         }

        
        if(request.getRequestURI().startsWith("/employe"))
        {
            return "redirect:/employe";
        }
        else
        {
            return "redirect:/client";
            
        }
    }

    @GetMapping({"/employe/delete/{id}", "/client/delete/{id}"})
    public String delete(@PathVariable("id") int id, HttpServletRequest request) {

        utilisateurService.delete(id);
        if(request.getRequestURI().startsWith("/employe"))
        {
            return "redirect:/employe";
        }
        else
        {
            return "redirect:/client";
            
        }
    }
    
    
    @GetMapping("/parametre")
    public String parametre(Model model) {
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Utilisateur utilisateur = utilisateurService.findByLogin(user.getUsername()).get();
        List<Role> roles = new ArrayList<>();
        roles.add(utilisateur.getRole());
        
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("roles", roles);
        
        
        return "utilisateur/edit";
    }
    
    
    @PostMapping({"/parametre"})
    public String parametreEdited(Model model, @Valid Utilisateur utilisateur, BindingResult br, HttpServletRequest request) {
        
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Utilisateur user = utilisateurService.findByLogin(userDetails.getUsername()).get();
        
        utilisateur.setId(user.getId());
        
        List<Role> roles = new ArrayList<>();
        roles.add(user.getRole());
        
        model.addAttribute("roles", roles);
        
        if (br.hasErrors()) {
            return "utilisateur/edit";
        }

        if (!UtilisateurModel.tryToUpdate(utilisateurService, bCryptPasswordEncoder, utilisateur, br)) {
            return "utilisateur/edit";
         }

       
        return "redirect:/parametre";
    }
    
    
    
    @GetMapping({"/employe/recherche", "/client/recherche"})
    public String rechercher(Model model, HttpServletRequest request) {
        
        
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateur/recherche";
    }
    
    
    @PostMapping({"/employe/recherche", "/client/recherche"})
    public String rechercherResult(Model model, Utilisateur utilisateur, HttpServletRequest request) {
        
        model.addAttribute("utilisateurs", utilisateurService.findByLoginContainingOrNomContainingOrPrenomContaining(utilisateur.getLogin(), utilisateur.getNom(), utilisateur.getPrenom()));
        return "utilisateur/list";
    }
    
    
    
    
    
    

    @ExceptionHandler({SQLException.class, DataAccessException.class, DataIntegrityViolationException.class})
    public String databaseError(Exception exception, Model model) {
        
        model.addAttribute("exception", exception);
        
        return "databaseerror";
    }

    
}
