/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.repository.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMedia;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMediaId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author quentin
 */
public interface EmprunteMediaRepository extends JpaRepository<EmprunteMedia, EmprunteMediaId>{
    List<EmprunteMedia> findByEtatTrue();
    List<EmprunteMedia> findByEtatFalse();
    List<EmprunteMedia> findByUtilisateur(Utilisateur utilisateur);
    List<EmprunteMedia> findByMedia(Media media);
    
    //Par ordre croissant
    List<EmprunteMedia> findAllByOrderByDateDebut();
    List<EmprunteMedia> findAllByOrderByDateFin();
    List<EmprunteMedia> findAllByOrderByDateCreation();
    List<EmprunteMedia> findAllByOrderByDateModification();
    //Par ordre décroissant
    List<EmprunteMedia> findAllByOrderByDateDebutDesc();
    List<EmprunteMedia> findAllByOrderByDateFinDesc();
    List<EmprunteMedia> findAllByOrderByDateCreationDesc();
    List<EmprunteMedia> findAllByOrderByDateModificationDesc();
}
