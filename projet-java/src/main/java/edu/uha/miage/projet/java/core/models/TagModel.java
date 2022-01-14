/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.core.models;

import edu.uha.miage.projet.java.core.metier.Tag;
import edu.uha.miage.projet.java.core.service.TagService;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kangacedricmarshallfry
 */
public class TagModel {
    public static boolean tryToSave(TagService tagService, Tag tag, BindingResult br) {
        try {
            if(tag.getNom() != "")
            {
                tagService.save(tag);
                return true;
            }
            br.rejectValue("nom", "tag", "Le tag ne doit pas être vide");
            return false;
            
        } catch (Exception ex) {
            if (tagService.findByNom(tag.getNom()) != null) {         
                br.rejectValue("nom", "alreadythere", "Tag déjà existant");
            } else {
                br.rejectValue("nom", "error", "Erreur");
            }
            return false;
        }
    }

    public static boolean tryToDelete(TagService tagService, int id) {
        try {
            tagService.delete(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
