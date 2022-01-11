/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier.associations;

import edu.uha.miage.projet.java.core.metier.Type;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * La classe ModificationType permet de créer tout objet/ligne qui serait contenus dans la table "MODIFIE_TYPE" de la base de données
 * @author quentin
 */
@Entity
@Table(name = "Modifie_type")
@IdClass(ModificationTypeId.class)
public class ModificationType implements Serializable {
    
    /**
     * Le champs utilisateur correspond à l'objet utilisateur associé à cette modification dans la base de données.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;
    
    /**
     * Le champs type correspond à l'objet type associé à cette modification dans la base de données.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private Type type;
    
    /**
     * Le champs dateModification correspondant à la date de modification de l'objet type associé
     */
    @NotNull
    private Date dateModification;
    
    /**
     * Constructeur vide de la classe ModificationType
     * Les variables de l'objet créé ne sont pas initialisés
     */
    public ModificationType() {
    }
    
    /**
     * Constructeur de la classe ModificationType
     * @param dateModification 
     */
    public ModificationType(Date dateModification) {
        this.dateModification = dateModification;
    }

    /**
     * Getter de la variable utilisateur
     * @return l'objet correspondant à l'utilisateur associé
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Setter de la variable utilisateur
     * @param utilisateur Le nouvel objet correspondant à l'utilisateur associé
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Getter de la variable type
     * @return l'objet correspondant au type associé
     */
    public Type getType() {
        return type;
    }

    /**
     * Setter de la variable type
     * @param type Le nouvel objet correspondant au type associé
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * Getter de la variable dateModification
     * @return la date de modification de l'objet type associé
     */
    public Date getDateModification() {
        return dateModification;
    }

    /**
     * Setter de la variable dateModification
     * @param dateModification la nouvelle date de modification de l'objet type associé
     */
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    /**
     * Méthode toString de la classe ModificationType
     * @return 
     */
    @Override
    public String toString() {
        return "ModificationType{" + "utilisateur=" + utilisateur + ", type=" + type + ", dateModification=" + dateModification + '}';
    }
    
    
    
}
