/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.repository;

import edu.uha.miage.projet.java.core.metier.Media;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface MediaRepository permettant d'ajouter des requêtes pour la table "MEDIA"
 * @author quentin
 */
public interface MediaRepository extends JpaRepository<Media, Integer>{
    List<Media> findByNom(String nom);
    List<Media> findByEtatTrue();
    List<Media> findByEtatFalse();
    
    //Par ordre croissant
    List<Media> findAllByOrderByNom();
    List<Media> findAllByOrderByDateCreation();
    //Par ordre décroissant
    List<Media> findAllByOrderByNomDesc();
    List<Media> findAllByOrderByDateCreationDesc();
    
    List<Media> findByNomContaining(String str);
}
