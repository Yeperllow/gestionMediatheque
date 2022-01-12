/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author kangacedricmarshallfry
 */
@Controller
public class UsersController {
    
    
    @GetMapping("/login")
    public String login() {
        return "templates/login";
    }
}
