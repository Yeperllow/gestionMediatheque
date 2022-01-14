/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.web.controller;


import edu.uha.miage.projet.java.core.metier.Tag;
import edu.uha.miage.projet.java.core.models.TagModel;
import edu.uha.miage.projet.java.core.service.TagService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author kangacedricmarshallfry
 */
@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    TagService tagService;
   
    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model, /* #### V3.0 #### */HttpSession session) {

       
        model.addAttribute("tags", tagService.findAll());
        model.addAttribute("success", false);
        model.addAttribute("fail", false);
        model.addAttribute("message", false);

        return "tag/list";
    }

    @GetMapping("/create")
    public String create(Model model,  /* #### V3.0 #### */HttpSession session,  /* #### V3.0 #### */HttpServletRequest request) {
        Tag tag = new Tag();
        model.addAttribute("tag", tag);
               
        return "tag/edit";
    }

    @PostMapping("/create")
    public String created(@Valid Tag tag, BindingResult br, String lang) {
        System.out.println("errrrrrrr");
        System.out.println(br);
        if (br.hasErrors()) {
            return "tag/edit";
        }
        if (!TagModel.tryToSave(tagService, tag, br)) {
          return "tag/edit";
        }
        
        //tagService.save(tag);
        return "redirect:/tag";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") int id, Model model) {
        
        model.addAttribute("tag", tagService.findById(id).get());
        return "tag/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Tag tag, BindingResult br, String lang) {
        if (br.hasErrors()) {
            return "tag/edit";
        }

        if (!TagModel.tryToSave(tagService, tag, br)) {
            return "tag/edit";
         }

        tagService.save(tag);
        return "redirect:/tag";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, String lang) {

        tagService.delete(id);
        return "redirect:/tag";
    }

    @ExceptionHandler({SQLException.class, DataAccessException.class, DataIntegrityViolationException.class})
    public String databaseError(Exception exception, Model model) {
        
        model.addAttribute("exception", exception);
        
        return "databaseerror";
    }

    @ExceptionHandler(Exception.class)
    public String otherError(HttpServletRequest req, Exception exception, Model model) {

        model.addAttribute("exception", exception);

        return "otherError";
    }
}
