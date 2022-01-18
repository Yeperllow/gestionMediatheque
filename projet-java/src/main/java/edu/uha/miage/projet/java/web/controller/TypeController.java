/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.web.controller;


import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Type;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMedia;
import edu.uha.miage.projet.java.core.metier.associations.ModificationType;
import edu.uha.miage.projet.java.core.models.TypeModel;
import edu.uha.miage.projet.java.core.service.TypeService;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import edu.uha.miage.projet.java.core.service.associations.ModificationTypeService;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/type")
public class TypeController {

    @Autowired
    TypeService typeService;
    
   
    @Autowired
    MessageSource messageSource;
    
    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    ModificationTypeService modificationTypeService;
    
    

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model, /* #### V3.0 #### */HttpSession session) {

       
        model.addAttribute("types", typeService.findAll());
        

        return "type/list";
    }

    @GetMapping("/create")
    public String create(Model model,  /* #### V3.0 #### */HttpSession session,  /* #### V3.0 #### */HttpServletRequest request) {
        model.addAttribute("type", new Type());
               
        return "type/edit";
    }

    @PostMapping("/create")
    public String created(@Valid Type type, BindingResult br, String lang) {
        if (br.hasErrors()) {
            return "type/edit";
        }
        if (!TypeModel.tryToSave(typeService, type, br)) {
          return "type/edit";
        }
        
        typeService.save(type);
        return "redirect:/type";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") int id, Model model) {
        
        model.addAttribute("type", typeService.findById(id).get());
        return "type/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Type type, BindingResult br, String lang) {
        if (br.hasErrors()) {
            return "type/edit";
        }

        if (!TypeModel.tryToSave(typeService, type, br)) {
            return "type/edit";
         }

        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Utilisateur utilisateur = utilisateurService.findByLogin(user.getUsername()).get();
        
        ModificationType modificationType = new ModificationType();
        modificationType.setType(type);
        modificationType.setUtilisateur(utilisateur);
        modificationType.setDateModification(new Date(System.currentTimeMillis()));
        modificationTypeService.save(modificationType);
        
        //System.out.println("UOOOOOOOOO");
        return "redirect:/type";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, String lang) {

        typeService.delete(id);
        
        return "redirect:/type";
    }
    
    @GetMapping("/recherche")
    public String rechercher(Model model) {
        
        model.addAttribute("type", new Type());
        return "type/recherche";
    }
    
    
    @PostMapping("/recherche")
    public String rechercherResult(Model model, Type type) {
        
        model.addAttribute("types", typeService.findByNomContaining(type.getNom()));
        return "type/list";
    }
/*
    @ExceptionHandler({SQLException.class, DataAccessException.class, DataIntegrityViolationException.class})
    public String databaseError(Exception exception, Model model) {
        
        model.addAttribute("exception", exception);
        
        return "category/databaseerror";
    }

    @ExceptionHandler(Exception.class)
    public String otherError(HttpServletRequest req, Exception exception, Model model) {

        model.addAttribute("exception", exception);

        return "otherError";
    }*/
}
