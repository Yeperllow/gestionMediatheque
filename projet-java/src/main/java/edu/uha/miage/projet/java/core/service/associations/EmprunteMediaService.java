/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMedia;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMediaId;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author quentin
 */
public interface EmprunteMediaService {
    EmprunteMedia save(EmprunteMedia entity);
    void delete(EmprunteMediaId id);
    List<EmprunteMedia> findAll();
    Optional<EmprunteMedia> findById(EmprunteMediaId id);
    List<EmprunteMedia> findByEtatTrue();
    List<EmprunteMedia> findByEtatFalse();
    
    List<EmprunteMedia> findByUtilisateur(Utilisateur utilisateur);
    List<EmprunteMedia> findByMedia(Media media);
}