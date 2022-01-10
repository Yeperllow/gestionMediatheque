/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service;

import edu.uha.miage.projet.java.core.metier.Media;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author quentin
 */
public interface MediaService {
    Media save(Media entity);
    void delete(int id);
    List<Media> findAll();
    Optional<Media> findById(int id);
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
