/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Tag;
import edu.uha.miage.projet.java.core.metier.associations.DecritMedia;
import edu.uha.miage.projet.java.core.metier.associations.DecritMediaId;
import edu.uha.miage.projet.java.core.repository.associations.DecritMediaRepository;
import edu.uha.miage.projet.java.core.service.associations.DecritMediaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation de l'interface DecritMediaService </br> Utiliser cette classe pour accéder aux données de la table "DECRIT_MEDIA"
 * @author quentin
 */
@Service
public class DecritMediaServiceImpl implements DecritMediaService{

    /**
     * Champs decritMediaRepository correspondant à l'interface DecritMediaRepository
     */
    @Autowired
    DecritMediaRepository decritMediaRepository;
    
    /**
     * Fonction permettant de sauvegarder des données sur la table "DECRIT_MEDIA"
     * @param entity l'entité de type DecritMedia a sauvegarder dans la table
     * @return l'objet de type DecritMedia qui a été enregistré
     */
    @Override
    public DecritMedia save(DecritMedia entity) {
        return decritMediaRepository.save(entity);
    }

    /**
     * Fonction permettant de supprimer des données sur la table "DECRIT_MEDIA"
     * @param id l'id de l'objet de type DecritMedia qui est à supprimer de la table
     */
    @Override
    public void delete(DecritMediaId id) {
        decritMediaRepository.deleteById(id);
    }

    /**
     * Fonction permettant d'obtenir la liste de toutes les associations contenues dans la table "DECRIT_MEDIA"
     * @return une List contenant toutes les descriptions de medias de la base de données
     */
    @Override
    public List<DecritMedia> findAll() {
        return (List<DecritMedia>) decritMediaRepository.findAll();
    }

    /**
     * Fonction permettant d'obtenir un objet de type DecritMedia dont les ids correspondent à ceux indiqués
     * @param id un objet de type DecritMediaId qui contient les deux ids de l'objet DecritMedia que l'on veut obtenir
     * @return un objet de type Utilisateur si l'id correspond à une description de media dans la table, null sinon
     */
    @Override
    public Optional<DecritMedia> findById(DecritMediaId id) {
        return decritMediaRepository.findById(id);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type DecritMedia qui sont actifs dans la base de données
     * @return Une List contenant toutes les descriptions de media dont l'état est à True
     */
    @Override
    public List<DecritMedia> findByEtatTrue() {
        return (List<DecritMedia>) decritMediaRepository.findByEtatTrue();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type DecritMedia qui sont non-actifs dans la base de données
     * @return Une List contenant toutes les descriptions de media dont l'état est à False
     */
    @Override
    public List<DecritMedia> findByEtatFalse() {
        return (List<DecritMedia>) decritMediaRepository.findByEtatFalse();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type DecritMedia dont le tag correspond à celui indiqué
     * @param tag le tag qui est utilisé par les descriptions que l'on veut obtenir
     * @return une List contenant toutes les descriptions de médias dont le tag correspond à celui qui a été passé en paramètre
     */
    @Override
    public List<DecritMedia> findByTag(Tag tag) {
        return (List<DecritMedia>) decritMediaRepository.findByTag(tag);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type DecritMedia dont le média correspond à celui indiqué
     * @param media le media qui est concerné par les descriptions que l'on veut obtenir
     * @return une List contenant toutes les descriptions de médias qui concernent le média qui a été passé en paramètre
     */
    @Override
    public List<DecritMedia> findByMedia(Media media) {
        return (List<DecritMedia>) decritMediaRepository.findByMedia(media);
    }
    
}
