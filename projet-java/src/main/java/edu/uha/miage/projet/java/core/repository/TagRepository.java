/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.repository;

import edu.uha.miage.projet.java.core.metier.Tag;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface TagRepository permettant d'ajouter des requêtes pour la table "TAG"
 * @author quentin
 */
public interface TagRepository extends JpaRepository<Tag, Integer>{
    Optional<Tag> findByNom(String tag);
    List<Tag> findByEtatTrue();
    List<Tag> findByEtatFalse();
    
    //Par ordre croissant
    List<Tag> findAllByOrderByNom();
    List<Tag> findAllByOrderByDateCreation();
    //Par ordre décroissant
    List<Tag> findAllByOrderByNomDesc();
    List<Tag> findAllByOrderByDateCreationDesc();
    
    List<Tag> findByNomContaining(String str);
}
