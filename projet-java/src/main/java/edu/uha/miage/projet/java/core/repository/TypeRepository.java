/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.repository;

import edu.uha.miage.projet.java.core.metier.Type;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface TypeRepository permettant d'ajouter des requêtes pour la table "TYPE"
 * @author quentin
 */
public interface TypeRepository extends JpaRepository<Type, Integer>{
    Optional<Type> findByNom(String type);
    List<Type> findByEtatTrue();
    List<Type> findByEtatFalse();
    
    //Par ordre croissant
    List<Type> findAllByOrderByNom();
    List<Type> findAllByOrderByDateCreation();
    //Par ordre décroissant
    List<Type> findAllByOrderByNomDesc();
    List<Type> findAllByOrderByDateCreationDesc();
    
    List<Type> findByNomContaining(String str);
}
