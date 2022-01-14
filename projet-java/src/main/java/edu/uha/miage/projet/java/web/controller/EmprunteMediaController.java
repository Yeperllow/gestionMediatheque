/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.web.controller;

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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String findAll(Model model, /* #### V3.0 #### */HttpSession session) {
        model.addAttribute("emprunts", empruntService.findAll());
        
        return "emprunt/list";
    }

    @GetMapping("/create")
    public String create(Model model, @RequestParam(name = "id") int id_media) {
        
        EmprunteMedia emprunteMedia = new EmprunteMedia();
        emprunteMedia.setMedia(mediaService.findById(id_media).get());
        emprunteMedia.setDateDebut(new Date(System.currentTimeMillis()));
        emprunteMedia.setUtilisateur(utilisateurService.findByLogin("bob").get());
        
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

    /*@GetMapping("/employe/edit")
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
*/
    @GetMapping("/delete")
    public String delete(@RequestParam(name = "utilisateur") int utilisateur, @RequestParam(name = "media") int media) {
        
        EmprunteMediaId emprunteMediaId = new EmprunteMediaId();
        emprunteMediaId.setUtilisateur(utilisateur);
        emprunteMediaId.setMedia(media);
        empruntService.delete(emprunteMediaId);
        return "redirect:/emprunt";
    }

    /*@ExceptionHandler({SQLException.class, DataAccessException.class, DataIntegrityViolationException.class})
    public String databaseError(Exception exception, Model model) {
        
        model.addAttribute("exception", exception);
        
        return "databaseerror";
    }

    @ExceptionHandler(Exception.class)
    public String otherError(HttpServletRequest req, Exception exception, Model model) {

        model.addAttribute("exception", exception);

        return "otherError";
    }*/
}
