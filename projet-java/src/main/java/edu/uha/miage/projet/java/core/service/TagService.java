/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service;

import edu.uha.miage.projet.java.core.metier.Tag;
import java.util.List;
import java.util.Optional;

/**
 * Interface TagService permettant d'implémenter un service qui donne l'accès aux données de la table "TAG"
 * @author quentin
 */
public interface TagService {
    Tag save(Tag entity);
    void delete(int id);
    List<Tag> findAll();
    Optional<Tag> findById(int id);
    Optional<Tag> findByNom(String nom);
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
