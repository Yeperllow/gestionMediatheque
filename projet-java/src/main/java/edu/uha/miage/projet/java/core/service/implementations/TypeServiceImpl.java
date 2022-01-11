/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Type;
import edu.uha.miage.projet.java.core.repository.TypeRepository;
import edu.uha.miage.projet.java.core.service.TypeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implémentation de l'interface TypeService </br> Utiliser cette classe pour accéder aux données de la table "TYPE"
 * @author quentin
 */
public class TypeServiceImpl implements TypeService{

    /**
     * Champs typeRepository correspondant à l'interface TypeRepository
     */
    @Autowired
    TypeRepository typeRepository;
    
    /**
     * Fonction permettant de sauvegarder des données sur la table "TYPE"
     * @param entity l'entité de type Type a sauvegarder dans la table
     * @return l'objet de type Type qui a été enregistré
     */
    @Override
    public Type save(Type entity) {
        return typeRepository.save(entity);
    }

    /**
     * Fonction permettant de supprimer des données sur la table "TYPE"
     * @param id l'id de l'objet de type Type qui est à supprimer de la table
     */
    @Override
    public void delete(int id) {
        typeRepository.deleteById(id);
    }

    /**
     * Fonction permettant d'obtenir la liste de tout les types contenus dans la table "TYPE"
     * @return une List contenant tous les types de la base de données
     */
    @Override
    public List<Type> findAll() {
        return (List<Type>) typeRepository.findAll();
    }

    /**
     * Fonction permettant d'obtenir un objet de type Type dont l'id correspond à celui indiqué
     * @param id l'id du type que l'on veut obtenir
     * @return un objet de type Type si l'id correspond à un type dans la table, null sinon
     */
    @Override
    public Optional<Type> findById(int id) {
        return typeRepository.findById(id);
    }

    /**
     * Fonction permettant d'obtenir un objet de type Type dont le nom de type correspond à celui indiqué
     * @param tag le nom du type que l'on veut obtenir
     * @return Un objet de type Type dont le nom de type correspond à celui indiqué, null sinon
     */
    @Override
    public Optional<Type> findByType(String type) {
        return typeRepository.findByType(type);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Type qui sont actifs dans la base de données
     * @return Une List contenant tous les types dont l'état est à True
     */
    @Override
    public List<Type> findByEtatTrue() {
        return (List<Type>) typeRepository.findByEtatTrue();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Type qui sont non-actifs dans la base de données
     * @return Une List contenant tous les types dont l'état est à False
     */
    @Override
    public List<Type> findByEtatFalse() {
        return (List<Type>) typeRepository.findByEtatFalse();
    }
    
    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Type de la table "TYPE", rangés par nom de type dans l'ordre croissant
     * @return Une List contenant tous les types rangés par type dans l'ordre croissant
     */
    @Override
    public List<Type> findAllByOrderByType() {
        return (List<Type>) typeRepository.findAllByOrderByType();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Type de la table "TYPE", rangés par date de création dans l'ordre croissant
     * @return Une List contenant tous les types rangés par date de création dans l'ordre croissant
     */
    @Override
    public List<Type> findAllByOrderByDateCreation() {
        return (List<Type>) typeRepository.findAllByOrderByDateCreation();
    }
    
    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Type de la table "TYPE", rangés par nom de type dans l'ordre décroissant
     * @return Une List contenant tous les types rangés par type dans l'ordre décroissant
     */
    @Override
    public List<Type> findAllByOrderByTypeDesc() {
        return (List<Type>) typeRepository.findAllByOrderByTypeDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Type de la table "TYPE", rangés par date de création dans l'ordre décroissant
     * @return Une List contenant tous les types rangés par date de création dans l'ordre décroissant
     */
    @Override
    public List<Type> findAllByOrderByDateCreationDesc() {
        return (List<Type>) typeRepository.findAllByOrderByDateCreationDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Type de la table "TYPE", dont le nom de type contient le String donné en paramètre
     * @param str String que l'on veut chercher dans les noms des types de la base de données
     * @return Une List contenant tous les types dont le type contient le String donné en paramètre
     */
    @Override
    public List<Type> findByTypeContaining(String str) {
        return (List<Type>) typeRepository.findByTypeContaining(str);
    }

}
