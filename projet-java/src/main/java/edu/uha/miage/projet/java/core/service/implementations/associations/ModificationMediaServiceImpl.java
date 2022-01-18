/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMedia;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMediaId;
import edu.uha.miage.projet.java.core.repository.associations.ModificationMediaRepository;
import edu.uha.miage.projet.java.core.service.associations.ModificationMediaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation de l'interface ModificationMediaService </br> Utiliser cette classe pour accéder aux données de la table "MODIFIE_MEDIA"
 * @author quentin
 */
@Service
public class ModificationMediaServiceImpl implements ModificationMediaService{

    /**
     * Champs modificationMediaRepository correspondant à l'interface ModificationMediaRepository
     */
    @Autowired
    ModificationMediaRepository modificationMediaRepository;
    
    /**
     * Fonction permettant de sauvegarder des données sur la table "MODIFIE_MEDIA"
     * @param entity l'entité de type ModificationMedia a sauvegarder dans la table
     * @return l'objet de type ModificationMedia qui a été enregistré
     */
    @Override
    public ModificationMedia save(ModificationMedia entity) {
        return modificationMediaRepository.save(entity);
    }

    /**
     * Fonction permettant de supprimer des données sur la table "MODIFIE_MEDIA"
     * @param id l'id de l'objet de type ModificationMedia qui est à supprimer de la table
     */
    @Override
    public void delete(ModificationMediaId id) {
        modificationMediaRepository.deleteById(id);
    }

    /**
     * Fonction permettant d'obtenir la liste de toutes les associations contenues dans la table "DECRIT_MEDIA"
     * @return une List contenant toutes les modifications de medias de la base de données
     */
    @Override
    public List<ModificationMedia> findAll() {
        return modificationMediaRepository.findAll();
    }

    /**
     * Fonction permettant d'obtenir un objet de type ModificationMedia dont les ids correspondent à ceux indiqués
     * @param id un objet de type ModificationMediaId qui contient les deux ids de l'objet ModificationMedia que l'on veut obtenir
     * @return un objet de type ModificationMedia si les deux ids correspond à une modification de média dans la table, null sinon
     */
    @Override
    public Optional<ModificationMedia> findById(ModificationMediaId id) {
        return modificationMediaRepository.findById(id);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type ModificationMedia dont l'utilisateur correspond à celui indiqué
     * @param utilisateur l'utilisateur qui est concerné par cette modification que l'on veut obtenir
     * @return Une List contenant toutes les modifications de médias qui ont été faites par cet utilisateur
     */
    @Override
    public List<ModificationMedia> findByUtilisateur(Utilisateur utilisateur) {
        return (List<ModificationMedia>) modificationMediaRepository.findByUtilisateur(utilisateur);
    }

     /**
     * Fonction permettant d'obtenir une liste d'objets de type ModificationMedia dont le media correspond à celui indiqué
     * @param media le média qui est concerné par les modifications que l'on veut obtenir
     * @return une List contenant toutes les modifications du média qui a été passé en paramètre
     */
    @Override
    public List<ModificationMedia> findByMedia(Media media) {
        return (List<ModificationMedia>) modificationMediaRepository.findByMedia(media);
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type ModificationMedia de la table "MODIFIE_MEDIA", rangés par date de modification dans l'ordre croissant
     * @return Une List contenant toutes les modifications de média rangés par date de modification dans l'ordre croissant
     */
    @Override
    public List<ModificationMedia> findAllByOrderByDateModification() {
        return (List<ModificationMedia>) modificationMediaRepository.findAllByOrderByDateModification();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type ModificationMedia de la table "MODIFIE_MEDIA", rangés par date de modification dans l'ordre décroissant
     * @return Une List contenant toutes les modifications de média rangés par date de modification dans l'ordre décroissant
     */
    @Override
    public List<ModificationMedia> findAllByOrderByDateModificationDesc() {
        return (List<ModificationMedia>) modificationMediaRepository.findAllByOrderByDateModificationDesc();
    }
    
}
