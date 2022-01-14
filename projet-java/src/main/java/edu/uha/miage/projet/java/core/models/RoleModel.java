/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.core.models;

import edu.uha.miage.projet.java.core.metier.Role;
import edu.uha.miage.projet.java.core.service.RoleService;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kangacedricmarshallfry
 */
public class RoleModel {
    public static boolean tryToSave(RoleService roleService, Role role, BindingResult br) {
        try {
            if(role.getNom() != "")
            {
                roleService.save(role);
                return true;
            }
            br.rejectValue("nom", "tag", "Le rôle ne doit pas être vide");
            return false;
            
        } catch (Exception ex) {
            if (roleService.findByNom(role.getNom()) != null) {         
                br.rejectValue("nom", "alreadythere", "Rôle déjà existant");
            } else {
                br.rejectValue("nom", "error", "Erreur");
            }
            return false;
        }
    }

    public static boolean tryToDelete(RoleService roleService, int id) {
        try {
            roleService.delete(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
