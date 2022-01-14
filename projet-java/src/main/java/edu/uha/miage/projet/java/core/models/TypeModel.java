/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.core.models;

import edu.uha.miage.projet.java.core.metier.Type;
import edu.uha.miage.projet.java.core.service.TagService;
import edu.uha.miage.projet.java.core.service.TypeService;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kangacedricmarshallfry
 */
public class TypeModel {
    public static boolean tryToSave(TypeService typeService, Type type, BindingResult br) {
        try {
            typeService.save(type);
            return true;
        } catch (Exception ex) {
            if (typeService.findByNom(type.getNom()) != null) {         
                br.rejectValue("tag", "alreadythere", "Tag déjà existant");
            } else {
                br.rejectValue("tag", "error", "Erreur");
            }
            return false;
        }
    }

    public static boolean tryToDelete(TagService typeService, int id) {
        try {
            typeService.delete(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
