/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.core.models;

import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kangacedricmarshallfry
 */
public class UtilisateurModel {

    public static boolean tryToSave(UtilisateurService utilisateurService, BCryptPasswordEncoder bCryptPasswordEncoder,Utilisateur utilisateur, BindingResult br) {
        try {
            if (utilisateurService.findAll().size() != 0) {
                if (utilisateurService.findByLogin(utilisateur.getLogin()).get() != null) {
                    br.rejectValue("login", "alreadythere", "Login déjà existant");
                    return false;
                }
            }
            utilisateur.setMotDePasse(bCryptPasswordEncoder.encode(utilisateur.getMotDePasse()));
            utilisateurService.save(utilisateur);
            return true;
        } catch (Exception ex) {

            br.rejectValue("nom", "error", "Erreur");
            return false;
        }

    }

    public static boolean tryToUpdate(UtilisateurService utilisateurService, Utilisateur utilisateur, BindingResult br) {
        try {

            utilisateurService.save(utilisateur);
            return true;
        } catch (Exception ex) {

            br.rejectValue("utilisateur", "error", "Erreur");
            return false;
        }
    }

    public static boolean tryToDelete(UtilisateurService utilisateurService, int id) {
        try {
            utilisateurService.delete(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
