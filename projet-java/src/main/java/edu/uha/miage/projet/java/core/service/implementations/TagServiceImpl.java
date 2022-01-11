/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Tag;
import edu.uha.miage.projet.java.core.repository.TagRepository;
import edu.uha.miage.projet.java.core.service.TagService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implémentation de l'interface TagService </br> Utiliser cette classe pour accéder aux données de la table "TAG"
 * @author quentin
 */
public class TagServiceImpl implements TagService{

    /**
     * Champs tagRepository correspondant à l'interface TagRepository
     */
    @Autowired
    TagRepository tagRepository;
    
    /**
     * Fonction permettant de sauvegarder des données sur la table "TAG"
     * @param entity l'entité de type Tag a sauvegarder dans la table
     * @return l'objet de type Tag qui a été enregistré
     */
    @Override
    public Tag save(Tag entity) {
        return tagRepository.save(entity);
    }

    /**
     * Fonction permettant de supprimer des données sur la table "TAG"
     * @param id l'id de l'objet de type Tag qui est à supprimer de la table
     */
    @Override
    public void delete(int id) {
        tagRepository.deleteById(id);
    }

    /**
     * Fonction permettant d'obtenir la liste de tout les tags contenus dans la table "TAG"
     * @return une List contenant tous les tags de la base de données
     */
    @Override
    public List<Tag> findAll() {
        return (List<Tag>) tagRepository.findAll();
    }

    /**
     * Fonction permettant d'obtenir un objet de type Tag dont l'id correspond à celui indiqué
     * @param id l'id du tag que l'on veut obtenir
     * @return un objet de type Tag si l'id correspond à un tag dans la table, null sinon
     */
    @Override
    public Optional<Tag> findById(int id) {
        return tagRepository.findById(id);
    }

    /**
     * Fonction permettant d'obtenir un objet de type Tag dont le nom de tag correspond à celui indiqué
     * @param tag le nom du tag que l'on veut obtenir
     * @return un objet de type tag dont le nom de tag correspond à celui indiqué, null sinon
     */
    @Override
    public Optional<Tag> findByTag(String tag) {
        return tagRepository.findByTag(tag);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Tag qui sont actifs dans la base de données
     * @return Une List contenant tous les tags dont l'état est à True
     */
    @Override
    public List<Tag> findByEtatTrue() {
        return (List<Tag>) tagRepository.findByEtatTrue();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Tag qui sont non-actifs dans la base de données
     * @return Une List contenant tous les tags dont l'état est à False
     */
    @Override
    public List<Tag> findByEtatFalse() {
        return (List<Tag>) tagRepository.findByEtatFalse();
    }
    
    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Tag de la table "TAG", rangés par nom de tag dans l'ordre croissant
     * @return Une List contenant tous les tags rangés par tag dans l'ordre croissant
     */
    @Override
    public List<Tag> findAllByOrderByTag() {
        return (List<Tag>) tagRepository.findAllByOrderByTag();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Tag de la table "TAG", rangés par date de création dans l'ordre croissant
     * @return Une List contenant tous les tags rangés par date de création dans l'ordre croissant
     */
    @Override
    public List<Tag> findAllByOrderByDateCreation() {
        return (List<Tag>) tagRepository.findAllByOrderByDateCreation();
    }
    
    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Tag de la table "TAG", rangés par nom de tag dans l'ordre décroissant
     * @return Une List contenant tous les tags rangés par tag dans l'ordre décroissant
     */
    @Override
    public List<Tag> findAllByOrderByTagDesc() {
        return (List<Tag>) tagRepository.findAllByOrderByTagDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Tag de la table "TAG", rangés par date de création dans l'ordre décroissant
     * @return Une List contenant tous les tags rangés par date de création dans l'ordre décroissant
     */
    @Override
    public List<Tag> findAllByOrderByDateCreationDesc() {
        return (List<Tag>) tagRepository.findAllByOrderByDateCreationDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Tag de la table "TAG", dont le nom de tag contient le String donné en paramètre
     * @param str String que l'on veut chercher dans les noms des tags de la base de données
     * @return Une List contenant tous les tags dont le tag contient le String donné en paramètre
     */
    @Override
    public List<Tag> findByTagContaining(String str) {
        return (List<Tag>) tagRepository.findByTagContaining(str);
    }
    
}
