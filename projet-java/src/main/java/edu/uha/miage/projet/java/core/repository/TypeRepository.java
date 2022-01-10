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
 *
 * @author quentin
 */
public interface TypeRepository extends JpaRepository<Type, Integer>{
    Optional<Type> findByType(String type);
    List<Type> findByEtatTrue();
    List<Type> findByEtatFalse();
    
    //Par ordre croissant
    List<Type> findAllByOrderByType();
    List<Type> findAllByOrderByDateCreation();
    //Par ordre décroissant
    List<Type> findAllByOrderByTypeDesc();
    List<Type> findAllByOrderByDateCreationDesc();
}
