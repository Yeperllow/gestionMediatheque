/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.web.controller;


import edu.uha.miage.projet.java.core.metier.Role;
import edu.uha.miage.projet.java.core.models.RoleModel;
import edu.uha.miage.projet.java.core.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;
   
    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model, /* #### V3.0 #### */HttpSession session) {

       
        model.addAttribute("roles", roleService.findAll());
        

        return "role/list";
    }

    @GetMapping("/create")
    public String create(Model model,  /* #### V3.0 #### */HttpSession session,  /* #### V3.0 #### */HttpServletRequest request) {
        Role role = new Role();
        model.addAttribute("role", role);
               
        return "role/edit";
    }

    @PostMapping("/create")
    public String created(@Valid Role role, BindingResult br, String lang) {
        if (br.hasErrors()) {
            return "role/edit";
        }
        if (!RoleModel.tryToSave(roleService, role, br)) {
          return "role/edit";
        }
        
        return "redirect:/role";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") int id, Model model) {
        
        model.addAttribute("role", roleService.findById(id).get());
        return "role/edit";
    }

    @PostMapping("/edit")
    public String edited(@Valid Role role, BindingResult br, String lang) {
        if (br.hasErrors()) {
            return "role/edit";
        }

        if (!RoleModel.tryToSave(roleService, role, br)) {
            return "role/edit";
         }

        return "redirect:/role";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
           
        roleService.delete(id);
       
        return "redirect:/role";
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
