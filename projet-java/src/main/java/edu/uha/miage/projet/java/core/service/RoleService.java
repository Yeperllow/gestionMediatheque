/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service;

import edu.uha.miage.projet.java.core.metier.Role;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author quentin
 */
public interface RoleService {
    Role save(Role entity);
    void delete(int id);
    List<Role> findAll();
    Optional<Role> findById(int id);
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
