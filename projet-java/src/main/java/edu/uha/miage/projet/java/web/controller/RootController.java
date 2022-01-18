
package edu.uha.miage.projet.java.web.controller;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Tag;
import edu.uha.miage.projet.java.core.metier.associations.DecritMedia;
import edu.uha.miage.projet.java.core.service.MediaService;
import edu.uha.miage.projet.java.core.service.TagService;
import edu.uha.miage.projet.java.core.service.associations.DecritMediaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping()
public class RootController {
    @Autowired
    MediaService mediaService;
    
    
    @Autowired
    TagService tagService;
    
    @Autowired
    DecritMediaService decritMediaService;
    
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {     
        model.addAttribute("medias", mediaService.findAll());
        model.addAttribute("tags", tagService.findAll());
        return "home";
    }
    
    
    @GetMapping("/medias")
    public String home(@RequestParam(name = "tag") int id,Model model) {   
        
        Tag tag = tagService.findById(id).get();
        List<DecritMedia> listDecritMedia = decritMediaService.findByTag(tag);
        List<Media> listMedia = new ArrayList<>();
        for(DecritMedia decritMedia : listDecritMedia)
        {
            listMedia.add(decritMedia.getMedia());
        }
        model.addAttribute("medias", listMedia);
        model.addAttribute("tags", tagService.findAll());
        return "home";
    }
   
}
