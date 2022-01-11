/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.repository;

import edu.uha.miage.projet.java.core.metier.Role;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface RoleRepository permettant d'ajouter des requêtes pour la table "ROLE"
 * @author quentin
 */
public interface RoleRepository extends JpaRepository<Role, Integer>{
    Optional<Role> findByRole(String role);
    
    //Par ordre croissant
    List<Role> findAllByOrderByRole();
    List<Role> findAllByOrderByDateCreation();
    List<Role> findAllByOrderByDateModification();
    //Par ordre décroissant
    List<Role> findAllByOrderByRoleDesc();
    List<Role> findAllByOrderByDateCreationDesc();
    List<Role> findAllByOrderByDateModificationDesc();
}
