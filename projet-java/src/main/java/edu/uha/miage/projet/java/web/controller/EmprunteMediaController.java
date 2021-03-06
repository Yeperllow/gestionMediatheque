/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.web.controller;

import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMedia;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMediaId;
import edu.uha.miage.projet.java.core.models.EmprunteMediaModel;
import edu.uha.miage.projet.java.core.service.MediaService;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import edu.uha.miage.projet.java.core.service.associations.EmprunteMediaService;
import java.sql.Date;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author kangacedricmarshallfry
 */
@Controller
@RequestMapping("/emprunt")
public class EmprunteMediaController {

    @Autowired
    EmprunteMediaService empruntService;
    
    @Autowired
    MediaService mediaService;
    
    @Autowired
    UtilisateurService utilisateurService;
   
    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model, HttpSession session) {
        
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Utilisateur utilisateur = utilisateurService.findByLogin(user.getUsername()).get();
        System.out.println("OOOOOOOO");
        if(utilisateur.getRole().getNom().equals("CLIENT"))
        {
            
            model.addAttribute("emprunts", empruntService.findByUtilisateur(utilisateur));
        }
        else {
            if(utilisateur.getRole().getNom().equals("EMPLOYE"))
            {
                model.addAttribute("emprunts", empruntService.findAll());
            }
        }
        
        return "emprunt/list";
    }

    @GetMapping("/create")
    public String create(Model model, @RequestParam(name = "id") int id_media) {
        
        EmprunteMedia emprunteMedia = new EmprunteMedia();
        emprunteMedia.setMedia(mediaService.findById(id_media).get());
        emprunteMedia.setDateDebut(new Date(System.currentTimeMillis()));
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        Utilisateur utilisateur = utilisateurService.findByLogin(user.getUsername()).get();
        emprunteMedia.setUtilisateur(utilisateur);
        
        model.addAttribute("emprunteMedia", emprunteMedia);
               
        return "emprunt/edit";
    }

    @PostMapping("/create")
    public String created(Model model, @Valid EmprunteMedia emprunteMedia, BindingResult br) {

        if (br.hasErrors()) {
            return "emprunt/edit";
        }
        if (!EmprunteMediaModel.tryToSave(empruntService, emprunteMedia, br)) {
          return "emprunt/edit";
        }
        
        return "redirect:/emprunt";
    }

   
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "utilisateur") int utilisateur, @RequestParam(name = "media") int media) {
        
        EmprunteMediaId emprunteMediaId = new EmprunteMediaId();
        emprunteMediaId.setUtilisateur(utilisateur);
        emprunteMediaId.setMedia(media);
        empruntService.delete(emprunteMediaId);
        return "redirect:/emprunt";
    }

    
}
