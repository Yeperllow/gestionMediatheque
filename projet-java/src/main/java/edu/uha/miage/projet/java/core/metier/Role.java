/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * La classe Role permet de créer tout objet/ligne qui serait contenus dans la table "ROLE" de la base de données
 * @author quentin
 */
@Entity
public class Role implements Serializable{
    
    /**
     * Le champs Id correspond à l'id de l'objet dans la base de données. Cet id est incrémenté automatiquement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    /**
     * Le champs role correspond au nom du role
     */
    @NotNull
    private String nom;
    
    /**
     * le champs dateCreation correspond à la date de création de cet objet
     */
    @NotNull
    private Date dateCreation;
    
    /**
     * Le champs dateModification correspond à la dernière date de modification de cet objet de type Role
     */
    @NotNull
    private Date dateModification;
    
    /**
     * Constructeur de la classe Role
     * @param role le nom du role, de type String
     * @param dateCreation la date de création de l'objet
     * @param dateModification la date de modification de l'objet (est égale à la date de création au départ)
     */
    public Role(String role, Date dateCreation, Date dateModification) {
        this.nom = nom;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }
    
    /**
     * Constructeur vide de la classe Role. Initialise un nom vide
     */
    public Role() {
        this("", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
    }
    
    /**
     * Constructeur de la classe Role, et permet d'initialiser automatiquement les dates de création et de modification
     * @param role le nom du role, de type String
     */
    public Role(String role) {
        this(role, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
    }

    /**
     * Getter du champs id
     * @return un int correspond à l'id de l'objet
     */
    public int getId() {
        return id;
    }

    /**
     * Setter du champs id - N'est utile que pour la serialization
     * @param id un int correspondant à l'id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter du champs role
     * @return un String correspondant au nom du role
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du champs role
     * @param role un nom de role, de type String
     */
    public void setNom(String role) {
        this.nom = role;
    }

    /**
     * Getter du champs dateCreation
     * @return la date de création de l'objet
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Setter du champs dateCreation - N'est utile uniquement pour la serialization
     * @param dateCreation Un objet de type Date correspondant à la date de création de l'objet
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Getter du champs dateModification
     * @return Un objet de type Date correspondant à la date de la dernière modification de l'objet
     */
    public Date getDateModification() {
        return dateModification;
    }

    /**
     * Setter du champs dateModification
     * @param dateModification Un objet de type Date correspondant à la date d'une nouvelle modification
     */
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    /**
     * Fonction toString de la classe Role
     * @return un String contenant les informations de l'objet
     */
    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", nom=" + nom + ", dateCreation=" + dateCreation + ", dateModification=" + dateModification + '}';
    }
    
    
}
