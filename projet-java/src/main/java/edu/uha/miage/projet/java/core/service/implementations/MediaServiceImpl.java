/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.repository.MediaRepository;
import edu.uha.miage.projet.java.core.service.MediaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implémentation de l'interface MediaService </br> Utiliser cette classe pour accéder aux données de la table "MEDIA"
 * @author quentin
 */
public class MediaServiceImpl implements MediaService {

    /**
     * Champs mediaRepository correspondant à l'interface MediaRepository
     */
    @Autowired
    MediaRepository mediaRepository;
    
    /**
     * Fonction permettant de sauvegarder des données sur la table "MEDIA"
     * @param entity l'entité de type Media à sauvegarder dans la table
     * @return l'objet de type Media qui a été enregistré
     */
    @Override
    public Media save(Media entity) {
        return mediaRepository.save(entity);
    }

    /**
     * Fonction permettant de supprimer des données sur la table "MEDIA"
     * @param id l'id de l'objet de type Media qui est à supprimer de la table
     */
    @Override
    public void delete(int id) {
        mediaRepository.deleteById(id);
    }

    /**
     * Fonction permettant d'obtenir la liste de tout les médias contenus dans la table "MEDIA"
     * @return une List contenant tous les médias de la base de données
     */
    @Override
    public List<Media> findAll() {
        return (List<Media>) mediaRepository.findAll();
    }

    /**
     * Fonction permettant d'obtenir un objet de type Media dont l'id correspond à celui indiqué
     * @param id l'id du média que l'on veut obtenir
     * @return un objet de type Media si l'id correspond à un media dans la table, null sinon
     */
    @Override
    public Optional<Media> findById(int id) {
        return mediaRepository.findById(id);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Media dont les nom correspondent à celui indiqué
     * @param nom le nom du média que l'on veut obtenir
     * @return une List contenant tous les médias dont le nom correspondent à celui indiqué (La List peut être vide)
     */
    @Override
    public List<Media> findByNom(String nom) {
        return mediaRepository.findByNom(nom);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Media qui sont actifs dans la base de données
     * @return Une List contenant tous les médias dont l'état est à True
     */
    @Override
    public List<Media> findByEtatTrue() {
        return (List<Media>) mediaRepository.findByEtatTrue();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Media qui sont non-actifs dans la base de données
     * @return Une List contenant tous les médias dont l'état est à False
     */
    @Override
    public List<Media> findByEtatFalse() {
        return (List<Media>) mediaRepository.findByEtatFalse();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Media de la table "MEDIA", rangés par nom dans l'ordre croissant
     * @return Une List contenant tous les médias rangés par nom dans l'ordre croissant
     */
    @Override
    public List<Media> findAllByOrderByNom() {
        return (List<Media>) mediaRepository.findAllByOrderByNom();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Media de la table "MEDIA", rangés par date de création dans l'ordre croissant
     * @return Une List contenant tous les médias rangés par date de création dans l'ordre croissant
     */
    @Override
    public List<Media> findAllByOrderByDateCreation() {
        return (List<Media>) mediaRepository.findAllByOrderByDateCreation();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Media de la table "MEDIA", rangés par nom dans l'ordre décroissant
     * @return Une List contenant tous les médias rangés par nom dans l'ordre décroissant
     */
    @Override
    public List<Media> findAllByOrderByNomDesc() {
        return (List<Media>) mediaRepository.findAllByOrderByNomDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Media de la table "MEDIA", rangés par date de création dans l'ordre décroissant
     * @return Une List contenant tous les médias rangés par date de création dans l'ordre décroissant
     */
    @Override
    public List<Media> findAllByOrderByDateCreationDesc() {
        return (List<Media>) mediaRepository.findAllByOrderByDateCreationDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Media de la table "MEDIA", dont le nom contient le String donné en paramètre
     * @param str String que l'on veut chercher dans les noms des médias de la base de données
     * @return Une List contenant tous les médias dont le nom contient le String donné en paramètre
     */
    @Override
    public List<Media> findByNomContaining(String str) {
        return (List<Media>) mediaRepository.findByNomContaining(str);
    }
            
}
