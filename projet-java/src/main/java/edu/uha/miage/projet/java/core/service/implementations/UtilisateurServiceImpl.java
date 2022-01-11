/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.repository.UtilisateurRepository;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Implémentation de l'interface UtilisaateurService </br> Utiliser cette classe pour accéder aux données de la table "UTILISATEUR"
 * @author quentin
 */
public class UtilisateurServiceImpl implements UtilisateurService{

    /**
     * Champs utilisateurRepository correspondant à l'interface UtilisateurRepository
     */
    @Autowired
    UtilisateurRepository utilisateurRepository;
    
    /**
     * Fonction permettant de sauvegarder des données sur la table "UTILISATEUR"
     * @param entity l'entité de type Utilisateur a sauvegarder dans la table
     * @return l'objet de type Utilisateur qui a été enregistré
     */
    @Override
    public Utilisateur save(Utilisateur entity) {
        return utilisateurRepository.save(entity);
    }

    /**
     * Fonction permettant de supprimer des données sur la table "UTILISATEUR"
     * @param id l'id de l'objet de type Utilisateur qui est à supprimer de la table
     */
    @Override
    public void delete(int id) {
        utilisateurRepository.deleteById(id);
    }

    /**
     * Fonction permettant d'obtenir la liste de tout les utilisateurs contenus dans la table "UTILISATEUR"
     * @return une List contenant tous les utilisateurs de la base de données
     */
    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    /**
     * Fonction permettant d'obtenir un objet de type Utilisateur dont l'id correspond à celui indiqué
     * @param id l'id de l'utilisateur que l'on veut obtenir
     * @return un objet de type Utilisateur si l'id correspond à un utilisateur dans la table, null sinon
     */
    @Override
    public Optional<Utilisateur> findById(int id) {
        return utilisateurRepository.findById(id);
    }

    /**
     * Fonction permettant d'obtenir un objet de type Utilisateur dont le login correspond à celui indiqué
     * @param login le login de l'utilisateur que l'on veut obtenir
     * @return un objet de type Utilisateur dont le login correspond à celui donné en paramètre (Peut être null)
     */
    @Override
    public Optional<Utilisateur> findByLogin(String login) {
        return utilisateurRepository.findByLogin(login);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Utilisateur dont les noms correspondent à celui indiqué
     * @param nom le nom des utilisateurs que l'on veut obtenir
     * @return une List contenant tous les utilisateurs dont le nom correspond à celui indiqué (La List peut être vide)
     */
    @Override
    public List<Utilisateur> findByNom(String nom) {
        return utilisateurRepository.findByNom(nom);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Utilisateur dont les prénoms correspondent à celui indiqué
     * @param prenom le prenom des utilisateurs que l'on veut obtenir
     * @return une List contenant tous les utilisateurs dont le prenom correspond à celui indiqué (La List peut être vide)
     */
    @Override
    public List<Utilisateur> findByPrenom(String prenom) {
        return utilisateurRepository.findByPrenom(prenom);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Utilisateur dont les noms et prénoms correspondent à ceux indiqués
     * @param nom le nom des utilisateurs que l'on veut obtenir
     * @param prenom le prenom des utilisateurs que l'on veut obtenir
     * @return une List contenant tous les utilisateurs dont le nom et le prenom correspondent à ceux indiqués (La List peut être vide)
     */
    @Override
    public List<Utilisateur> findByNomAndPrenom(String nom, String prenom) {
        return utilisateurRepository.findByNomAndPrenom(nom, prenom);
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Utilisateur qui sont actifs dans la base de données
     * @return Une List contenant tous les utilisateurs dont l'état est à True
     */
    @Override
    public List<Utilisateur> findByEtatTrue() {
        return (List<Utilisateur>) utilisateurRepository.findByEtatTrue();
    }

    /**
     * Fonction permettant d'obtenir une liste d'objets de type Utilisateur qui sont non-actifs dans la base de données
     * @return Une List contenant tous les utilisateurs dont l'état est à False
     */
    @Override
    public List<Utilisateur> findByEtatFalse() {
        return (List<Utilisateur>) utilisateurRepository.findByEtatFalse();
    }
    
    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Utilisateur de la table "UTILISATEUR", rangés par login dans l'ordre croissant
     * @return Une List contenant tous les utilisateurs rangés par login dans l'ordre croissant
     */
    @Override
    public List<Utilisateur> findAllByOrderByLogin() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByLogin();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Utilisateur de la table "UTILISATEUR", rangés par nom et prénom dans l'ordre croissant
     * @return Une List contenant tous les utilisateurs rangés par nom et prénom dans l'ordre croissant
     */
    @Override
    public List<Utilisateur> findAllByOrderByNomAscPrenomAsc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByNomAscPrenomAsc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Utilisateur de la table "UTILISATEUR", rangés par date de création dans l'ordre croissant
     * @return Une List contenant tous les utilisateur rangés par date de création dans l'ordre croissant
     */
    @Override
    public List<Utilisateur> findAllByOrderByDateCreation() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByDateCreation();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Utilisateur de la table "UTILISATEUR", rangés par date de modification dans l'ordre croissant
     * @return Une List contenant tous les utilisateur rangés par date de modification dans l'ordre croissant
     */
    @Override
    public List<Utilisateur> findAllByOrderByDateModification() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByDateModification();
    }
    
    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Utilisateur de la table "UTILISATEUR", rangés par login dans l'ordre décroissant
     * @return Une List contenant tous les utilisateurs rangés par login dans l'ordre décroissant
     */
    @Override
    public List<Utilisateur> findAllByOrderByLoginDesc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByLoginDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Utilisateur de la table "UTILISATEUR", rangés par nom et prénom dans l'ordre décroissant
     * @return Une List contenant tous les utilisateurs rangés par nom et prénom dans l'ordre décroissant
     */
    @Override
    public List<Utilisateur> findAllByOrderByNomDescPrenomDesc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByNomDescPrenomDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Utilisateur de la table "UTILISATEUR", rangés par date de création dans l'ordre décroissant
     * @return Une List contenant tous les utilisateur rangés par date de création dans l'ordre décroissant
     */
    @Override
    public List<Utilisateur> findAllByOrderByDateCreationDesc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByDateCreationDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Utilisateur de la table "UTILISATEUR", rangés par date de modification dans l'ordre décroissant
     * @return Une List contenant tous les utilisateur rangés par date de modification dans l'ordre décroissant
     */
    @Override
    public List<Utilisateur> findAllByOrderByDateModificationDesc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByDateModificationDesc();
    }

    /**
     * Fonction permettant d'obtenir une liste de tous les objets de type Utilisateur de la table "UTILISATEUR", dont le login, le nom ou le prénom contient respectivement les Strings donnés en paramètre
     * @param login String que l'on veut chercher dans les logins des utilisateurs de la base de données
     * @param nom String que l'on veut chercher dans les noms des utilisateurs de la base de données
     * @param prenomString que l'on veut chercher dans les prénoms des utilisateurs de la base de données
     * @return Une List contenant tous les utilisateurs dont le login, le nom ou le prénom contient respectivement les Strings donnés en paramètre
     */
    @Override
    public List<Utilisateur> findByLoginContainingOrNomContainingOrPrenomContaining(String login, String nom, String prenom) {
        return (List<Utilisateur>) utilisateurRepository.findByLoginContainingOrNomContainingOrPrenomContaining(login, nom, prenom);
    }
    
}
