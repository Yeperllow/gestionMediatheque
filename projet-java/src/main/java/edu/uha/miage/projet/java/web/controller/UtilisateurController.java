/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.web.controller;

import edu.uha.miage.projet.java.core.models.UtilisateurModel;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.service.RoleService;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
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

    @GetMapping("/employe")
    public String findAll(Model model, /* #### V3.0 #### */HttpSession session) {
        model.addAttribute("employes", utilisateurService.findAll());
        
        return "employe/list";
    }

    @GetMapping("/employe/create")
    public String createEmploye(Model model,  /* #### V3.0 #### */HttpSession session,  /* #### V3.0 #### */HttpServletRequest request) {
        Utilisateur utilisateur = new Utilisateur();
        model.addAttribute("utilisateur", utilisateur);
        model.addAttribute("roles", roleService.findAll());
               
        return "employe/edit";
    }

    @PostMapping("/employe/create")
    public String created(Model model, @Valid Utilisateur utilisateur, BindingResult br) {
        
        model.addAttribute("roles", roleService.findAll());
        if (br.hasErrors()) {
            return "employe/edit";
        }
        if (!UtilisateurModel.tryToSave(utilisateurService, utilisateur, br)) {
          return "employe/edit";
        }
        
        return "redirect:/employe";
    }

    @GetMapping("/employe/edit")
    public String edit(@RequestParam(name = "id") int id, Model model) {
        
        model.addAttribute("utilisateur", utilisateurService.findById(id).get());
        model.addAttribute("roles", roleService.findAll());
        return "employe/edit";
    }

    @PostMapping("/employe/edit")
    public String edited(Model model, @Valid Utilisateur utilisateur, BindingResult br, String lang) {
        model.addAttribute("roles", roleService.findAll());
        if (br.hasErrors()) {
            return "employe/edit";
        }

        if (!UtilisateurModel.tryToUpdate(utilisateurService, utilisateur, br)) {
            return "employe/edit";
         }

        return "redirect:/employe";
    }

    @GetMapping("/employe/delete/{id}")
    public String delete(@PathVariable("id") int id, String lang) {

        utilisateurService.delete(id);
        return "redirect:/employe";
    }

    @ExceptionHandler({SQLException.class, DataAccessException.class, DataIntegrityViolationException.class})
    public String databaseError(Exception exception, Model model) {
        
        model.addAttribute("exception", exception);
        
        return "databaseerror";
    }

    /*@ExceptionHandler(Exception.class)
    public String otherError(HttpServletRequest req, Exception exception, Model model) {

        model.addAttribute("exception", exception);

        return "otherError";
    }*/
}
