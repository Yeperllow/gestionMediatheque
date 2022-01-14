/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uha.miage.projet.java.core.models;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.service.MediaService;
import org.springframework.validation.BindingResult;

/**
 *
 * @author kangacedricmarshallfry
 */
public class MediaModel {
    public static boolean tryToSave(MediaService mediaService, Media media, BindingResult br) {
        try {
            mediaService.save(media);
            return true;
        } catch (Exception ex) {
            br.rejectValue("nom", "error", "Erreur");
            return false;
        }
    }

    public static boolean tryToDelete(MediaService mediaService, int id) {
        try {
            mediaService.delete(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
