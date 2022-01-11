/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.repository.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMedia;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMediaId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface ModificationMediaRepository permettant d'ajouter des requêtes pour la table "MODIFIE_MEDIA"
 * @author quentin
 */
public interface ModificationMediaRepository extends JpaRepository<ModificationMedia, ModificationMediaId>{
    List<ModificationMedia> findByUtilisateur(Utilisateur utilisateur);
    List<ModificationMedia> findByMedia(Media media);
    
    //Par ordre croissant
    List<ModificationMedia> findAllByOrderByDateModification();
    //Par ordre décroissant
    List<ModificationMedia> findAllByOrderByDateModificationDesc();
}
