/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations.associations;

import edu.uha.miage.projet.java.core.metier.Type;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.ModificationType;
import edu.uha.miage.projet.java.core.metier.associations.ModificationTypeId;
import edu.uha.miage.projet.java.core.repository.associations.ModificationTypeRepository;
import edu.uha.miage.projet.java.core.service.associations.ModificationTypeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implémentation de l'interface ModificationTypeService </br> Utiliser cette classe pour accéder aux données de la table "MODIFIE_TYPE"
 * @author quentin
 */
@Service
public class ModificationTypeServiceImpl implements ModificationTypeService{

    /**
     * Champs modificationTypeRepository correspondant à l'interface ModificationTypeRepository
     */
    @Autowired
    ModificationTypeRepository modificationTypeRepository;
    
    /**
     * Fonction permettant de sauvegarder des données sur la table "MODIFIE_TYPE"
     * @param entity l'entité de type ModificationType a sauvegarder dans la table
     * @return l'objet de type ModificationType qui a été enregistré
     */
    @Override
    public ModificationType save(ModificationType entity) {
        return modificationTypeRepository.save(entity);
    }

    /**
     * Fonction permettant de supprimer des données sur la table "MODIFIE_TYPE"
     * @param id l'id de l'objet de type ModificationType qui est à supprimer de la table
     */
    @Override
    public void delete(ModificationTypeId id) {
        modificationTypeRepository.deleteById(id);
    }

    /**
     * Fonction permettant d'obtenir la liste de toutes les associations contenues dans la table "DECRIT_TYPE"
     * @return une List contenant toutes les modifications de types de la base de données
     */
    @Override
    public List<ModificationType> findAll() {
        return modificationTypeRepository.findAll();
    }

    /**
     * Fonction permettant d'obtenir un objet de type ModificationType dont les ids correspondent à ceux indiqués
     * @param id un objet de type ModificationTypeId qui contient les deux ids de l'objet ModificationType que l'on veut obtenir
     * @return un objet de type ModificationType si les deux ids correspond à une modification de type dans la table, null sinon
     */
    @Override
    public Optional<ModificationType> findById(ModificationTypeId id) {
        return modificationTypeRepository.findById(id);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type ModificationType dont l'utilisateur correspond à celui indiqué
     * @param utilisateur l'utilisateur qui est concerné par cette modification que l'on veut obtenir
     * @return Une List contenant toutes les modifications de types qui ont été faites par cet utilisateur
     */
    @Override
    public List<ModificationType> findByUtilisateur(Utilisateur utilisateur) {
        return (List<ModificationType>) modificationTypeRepository.findByUtilisateur(utilisateur);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type ModificationType dont le type correspond à celui indiqué
     * @param type le type qui est concerné par les modifications que l'on veut obtenir
     * @return une List contenant toutes les modifications du type qui a été passé en paramètre
     */
    @Override
    public List<ModificationType> findByType(Type type) {
        return (List<ModificationType>) modificationTypeRepository.findByType(type);
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type ModificationType de la table "MODIFIE_TYPE", rangés par date de modification dans l'ordre croissant
     * @return Une List contenant toutes les modifications de type rangés par date de modification dans l'ordre croissant
     */
    @Override
    public List<ModificationType> findAllByOrderByDateModification() {
        return (List<ModificationType>) modificationTypeRepository.findAllByOrderByDateModification();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type ModificationType de la table "MODIFIE_TYPE", rangés par date de modification dans l'ordre décroissant
     * @return Une List contenant toutes les modifications de type rangés par date de modification dans l'ordre décroissant
     */
    @Override
    public List<ModificationType> findAllByOrderByDateModificationDesc() {
        return (List<ModificationType>) modificationTypeRepository.findAllByOrderByDateModificationDesc();
    }
    
}
