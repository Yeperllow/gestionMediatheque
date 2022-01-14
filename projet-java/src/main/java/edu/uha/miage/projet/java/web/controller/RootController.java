
package edu.uha.miage.projet.java.web.controller;

import edu.uha.miage.projet.java.core.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping()
public class RootController {
    @Autowired
    MediaService mediaService;
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {     
        model.addAttribute("medias", mediaService.findAll());
        return "home";
    }
   
}
