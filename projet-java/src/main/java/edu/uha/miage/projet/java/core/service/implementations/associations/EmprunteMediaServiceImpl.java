/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMedia;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMediaId;
import edu.uha.miage.projet.java.core.repository.associations.EmprunteMediaRepository;
import edu.uha.miage.projet.java.core.service.associations.EmprunteMediaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation de l'interface EmprunteMediaService </br> Utiliser cette classe pour accéder aux données de la table "EMPRUNTE_MEDIA"
 * @author quentin
 */
@Service
public class EmprunteMediaServiceImpl implements EmprunteMediaService{

    /**
     * Champs emprunteMediaRepository correspondant à l'interface EmprunteMediaServiceRepository
     */
    @Autowired
    EmprunteMediaRepository emprunteMediaRepository;
    
    /**
     * Fonction permettant de sauvegarder des données sur la table "EMPRUNTE_MEDIA"
     * @param entity l'entité de type EmprunteMedia a sauvegarder dans la table
     * @return l'objet de type EmprunteMedia qui a été enregistré
     */
    @Override
    public EmprunteMedia save(EmprunteMedia entity) {
        return emprunteMediaRepository.save(entity);
    }

    /**
     * Fonction permettant de supprimer des données sur la table "EMPRUNTE_MEDIA"
     * @param id l'id de l'objet de type EmprunteMedia qui est à supprimer de la table
     */
    @Override
    public void delete(EmprunteMediaId id) {
        emprunteMediaRepository.deleteById(id);
    }

    /**
     * Fonction permettant d'obtenir la liste de toutes les associations contenues dans la table "DECRIT_MEDIA"
     * @return une List contenant toutes les descriptions de medias de la base de données
     */
    @Override
    public List<EmprunteMedia> findAll() {
        return emprunteMediaRepository.findAll();
    }

    /**
     * Fonction permettant d'obtenir un objet de type EmprunteMedia dont les ids correspondent à ceux indiqués
     * @param id un objet de type EmprunteMediaId qui contient les deux ids de l'objet EmprunteMedia que l'on veut obtenir
     * @return un objet de type EmprunteMedia si les deux ids correspond à un emprunt de média dans la table, null sinon
     */
    @Override
    public Optional<EmprunteMedia> findById(EmprunteMediaId id) {
        return emprunteMediaRepository.findById(id);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type EmprunteMedia qui sont actifs dans la base de données
     * @return Une List contenant toutes les emprunts de media dont l'état est à True
     */
    @Override
    public List<EmprunteMedia> findByEtatTrue() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findByEtatTrue();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type EmprunteMedia qui sont non-actifs dans la base de données
     * @return Une List contenant toutes les emprunts de media dont l'état est à False
     */
    @Override
    public List<EmprunteMedia> findByEtatFalse() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findByEtatFalse();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type EmprunteMedia dont l'utilisateur correspond à celui indiqué
     * @param utilisateur l'utilisateur qui est concerné par cet emprunt que l'on veut obtenir
     * @return Une List contenant tous les emprunts qui ont été fait par cet utilisateur
     */
    @Override
    public List<EmprunteMedia> findByUtilisateur(Utilisateur utilisateur) {
        return (List<EmprunteMedia>) emprunteMediaRepository.findByUtilisateur(utilisateur);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type EmprunteMedia dont le media correspond à celui indiqué
     * @param media le média qui est concerné par les emprunts que l'on veut obtenir
     * @return une List contenant tous les emprunts du média qui a été passé en paramètre
     */
    @Override
    public List<EmprunteMedia> findByMedia(Media media) {
        return (List<EmprunteMedia>) emprunteMediaRepository.findByMedia(media);
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type EmprunteMedia de la table "EMPRUNTE_MEDIA", rangés par date de début dans l'ordre croissant
     * @return Une List contenant tous les emprunts de média rangés par date de début dans l'ordre croissant
     */
    @Override
    public List<EmprunteMedia> findAllByOrderByDateDebut() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateDebut();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type EmprunteMedia de la table "EMPRUNTE_MEDIA", rangés par date de fin dans l'ordre croissant
     * @return Une List contenant tous les emprunts de média rangés par date de fin dans l'ordre croissant
     */
    @Override
    public List<EmprunteMedia> findAllByOrderByDateFin() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateFin();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type EmprunteMedia de la table "EMPRUNTE_MEDIA", rangés par date de création dans l'ordre croissant
     * @return Une List contenant tous les emprunts de média rangés par date de création dans l'ordre croissant
     */
    @Override
    public List<EmprunteMedia> findAllByOrderByDateCreation() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateCreation();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type EmprunteMedia de la table "EMPRUNTE_MEDIA", rangés par date de modification dans l'ordre croissant
     * @return Une List contenant tous les emprunts de média rangés par date de modification dans l'ordre croissant
     */
    @Override
    public List<EmprunteMedia> findAllByOrderByDateModification() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateModification();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type EmprunteMedia de la table "EMPRUNTE_MEDIA", rangés par date de début dans l'ordre décroissant
     * @return Une List contenant tous les emprunts de média rangés par date de début dans l'ordre décroissant
     */
    @Override
    public List<EmprunteMedia> findAllByOrderByDateDebutDesc() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateDebutDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type EmprunteMedia de la table "EMPRUNTE_MEDIA", rangés par date de fin dans l'ordre décroissant
     * @return Une List contenant tous les emprunts de média rangés par date de fin dans l'ordre décroissant
     */
    @Override
    public List<EmprunteMedia> findAllByOrderByDateFinDesc() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateFinDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type EmprunteMedia de la table "EMPRUNTE_MEDIA", rangés par date de création dans l'ordre décroissant
     * @return Une List contenant tous les emprunts de média rangés par date de création dans l'ordre décroissant
     */
    @Override
    public List<EmprunteMedia> findAllByOrderByDateCreationDesc() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateCreationDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type EmprunteMedia de la table "EMPRUNTE_MEDIA", rangés par date de modification dans l'ordre décroissant
     * @return Une List contenant tous les emprunts de média rangés par date de modification dans l'ordre décroissant
     */
    @Override
    public List<EmprunteMedia> findAllByOrderByDateModificationDesc() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateModificationDesc();
    }
    
}
