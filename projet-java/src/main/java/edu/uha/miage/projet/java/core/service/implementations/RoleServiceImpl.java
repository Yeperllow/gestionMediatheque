/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Role;
import edu.uha.miage.projet.java.core.repository.RoleRepository;
import edu.uha.miage.projet.java.core.service.RoleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation de l'interface RoleService </br> Utiliser cette classe pour accéder aux données de la table "ROLE"
 * @author quentin
 */
@Service
public class RoleServiceImpl implements RoleService{

    /**
     * Champs roleRepository correspondant à l'interface RoleRepository
     */
    @Autowired
    RoleRepository roleRepository;
    
    /**
     * Fonction permettant de sauvegarder des données sur la table "ROLE"
     * @param entity l'entité de type Role à sauvegarder dans la table
     * @return l'objet de type Role qui a été enregistré
     */
    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    /**
     * Fonction permettant de supprimer des données sur la table "ROLE"
     * @param id l'id de l'objet de type Role qui est à supprimer de la table
     */
    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }

    /**
     * Fonction permettant d'obtenir la liste de tout les roles contenus dans la table "ROLE"
     * @return une List contenant tous les roles de la base de données
     */
    @Override
    public List<Role> findAll() {
        
        return (List<Role>) roleRepository.findAll();
    }

    /**
     * Fonction permettant d'obtenir un objet de type Role dont l'id correspond à celui indiqué
     * @param id l'id du role que l'on veut obtenir
     * @return un objet de type Role si l'id correspond à un role dans la table, null sinon
     */
    @Override
    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    /**
     * Fonction permettant d'obtenir un objet de type Role dont le nom de role correspond à celui indiqué
     * @param role le nom du role que l'on veut obtenir
     * @return un objet de type Role si le nom du role correspond à celui indiqué, null sinon
     */
    @Override
    public Optional<Role> findByNom(String role) {
        return roleRepository.findByNom(role);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Role, rangé par role dans l'ordre croissant
     * @return Une List contenant tous les roles, rangé par role dans l'ordre croissant
     */
    @Override
    public List<Role> findAllByOrderByNom() {
        return (List<Role>) roleRepository.findAllByOrderByNom();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Role, rangé par date de création dans l'ordre croissant
     * @return Une List contenant tous les roles, rangé par date de création dans l'ordre croissant
     */
    @Override
    public List<Role> findAllByOrderByDateCreation() {
        return (List<Role>) roleRepository.findAllByOrderByDateCreation();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Role, rangé par date de modification dans l'ordre croissant
     * @return Une List contenant tous les roles, rangé par date de modification dans l'ordre croissant
     */
    @Override
    public List<Role> findAllByOrderByDateModification() {
        return (List<Role>) roleRepository.findAllByOrderByDateModification();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Role, rangé par role dans l'ordre décroissant
     * @return Une List contenant tous les roles, rangé par role dans l'ordre décroissant
     */
    @Override
    public List<Role> findAllByOrderByNomDesc() {
        return (List<Role>) roleRepository.findAllByOrderByNomDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Role, rangé par date de création dans l'ordre décroissant
     * @return Une List contenant tous les roles, rangé par date de création dans l'ordre décroissant
     */
    @Override
    public List<Role> findAllByOrderByDateCreationDesc() {
        return (List<Role>) roleRepository.findAllByOrderByDateCreationDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Role, rangé par date de modification dans l'ordre décroissant
     * @return Une List contenant tous les roles, rangé par date de modification dans l'ordre décroissant
     */
    @Override
    public List<Role> findAllByOrderByDateModificationDesc() {
        return (List<Role>) roleRepository.findAllByOrderByDateModificationDesc();
    }
    
}
