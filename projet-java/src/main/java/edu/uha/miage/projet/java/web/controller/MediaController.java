/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.web.controller;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.models.MediaModel;
import edu.uha.miage.projet.java.core.metier.Tag;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.DecritMedia;
import edu.uha.miage.projet.java.core.models.DecritMediaModel;
import edu.uha.miage.projet.java.core.models.RoleModel;
import edu.uha.miage.projet.java.core.models.TagModel;
import edu.uha.miage.projet.java.core.service.MediaService;
import edu.uha.miage.projet.java.core.service.RoleService;
import edu.uha.miage.projet.java.core.service.TagService;
import edu.uha.miage.projet.java.core.service.TypeService;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import edu.uha.miage.projet.java.core.service.associations.DecritMediaService;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/media")
public class MediaController {

    @Autowired
    MediaService mediaService;
    
    @Autowired
    TypeService typeService;
    
     @Autowired
    TagService tagService;
     
    @Autowired
    DecritMediaService decritMediaService;
    
    @Autowired
    RoleService roleService;
   
   

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model, /* #### V3.0 #### */HttpSession session) {

        model.addAttribute("medias", mediaService.findAll());
        model.addAttribute("tagService", tagService);
        return "media/list";
    }

    @GetMapping("/create")
    public String create(Model model,  /* #### V3.0 #### */HttpSession session,  /* #### V3.0 #### */HttpServletRequest request) {
        Media media = new Media();
        model.addAttribute("media", media);
        model.addAttribute("types", typeService.findAll());
               
        return "media/edit";
    }

    @PostMapping("/create")
    public String created(@Valid Media media, BindingResult br, String lang) {
        
        if (br.hasErrors()) {
            return "media/edit";
        }
        if (!MediaModel.tryToSave(mediaService, media, br)) {
          return "media/edit";
        }
        
        return "redirect:/media";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") int id, Model model) {
        
        model.addAttribute("media", mediaService.findById(id).get());
        model.addAttribute("types", typeService.findAll());
        return "media/edit";
    }
    
    
    @GetMapping("/tag/edit")
    public String editTag(@RequestParam(name = "id") int id, Model model) {
        
        
        DecritMediaModel decritMediaModel = new DecritMediaModel();
        decritMediaModel.setId_media(id);
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("media", mediaService.findById(id).get());
        model.addAttribute("decritMediaModel", decritMediaModel);
      
        return "media/tag_media";
    }

    @PostMapping("/edit")
    public String edited(@Valid Media media, BindingResult br, String lang) {
        if (br.hasErrors()) {
            return "media/edit";
        }

        if (!MediaModel.tryToSave(mediaService, media, br)) {
            return "media/edit";
         }

        mediaService.save(media);
        return "redirect:/media";
    }
    
    
    
    @PostMapping("/tag/edit")
    public String editedTag(@Valid DecritMediaModel decritMediaModel, BindingResult br, String lang) {
        /*if (br.hasErrors()) {
            return "media/edit";
        }

        if (!MediaModel.tryToSave(mediaService, media, br)) {
            return "media/edit";
         }*/
        System.out.print("YOOOO");
        System.out.print(decritMediaModel);
        
        
        DecritMedia decritMedia = new DecritMedia();
        
        
        decritMedia.setTag(tagService.findById(decritMediaModel.getId_tag()).get());
        decritMedia.setMedia(mediaService.findById(decritMediaModel.getId_media()).get());
        decritMedia.setEtat(true);
        decritMediaService.save(decritMedia);
        
        
        return "redirect:/media";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, String lang) {

        mediaService.delete(id);
        return "redirect:/media";
    }

}
