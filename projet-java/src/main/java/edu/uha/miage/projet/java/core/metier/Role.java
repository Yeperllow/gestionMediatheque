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
    private String role;
    
    /**
     * le champs date_creation correspond à la date de création de cet objet
     */
    @NotNull
    private Date date_creation;
    
    /**
     * Le champs date_modification correspond à la dernière date de modification de cet objet de type Role
     */
    @NotNull
    private Date date_modification;
    
    /**
     * Constructeur de la classe Role
     * @param role le nom du role, de type String
     * @param date_creation la date de création de l'objet
     * @param date_modification la date de modification de l'objet (est égale à la date de création au départ)
     */
    public Role(String role, Date date_creation, Date date_modification) {
        this.role = role;
        this.date_creation = date_creation;
        this.date_modification = date_modification;
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
    public String getRole() {
        return role;
    }

    /**
     * Setter du champs role
     * @param role un nom de role, de type String
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Getter du champs date_creation
     * @return la date de création de l'objet
     */
    public Date getDate_creation() {
        return date_creation;
    }

    /**
     * Setter du champs date_creation - N'est utile uniquement pour la serialization
     * @param date_creation Un objet de type Date correspondant à la date de création de l'objet
     */
    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    /**
     * Getter du champs date_modification
     * @return Un objet de type Date correspondant à la date de la dernière modification de l'objet
     */
    public Date getDate_modification() {
        return date_modification;
    }

    /**
     * Setter du champs date_modification
     * @param date_modification Un objet de type Date correspondant à la date d'une nouvelle modification
     */
    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    /**
     * Fonction toString de la classe Role
     * @return un String contenant les informations de l'objet
     */
    @Override
    public String toString() {
        return "Role{" + "id=" + id + ", role=" + role + ", date_creation=" + date_creation + ", date_modification=" + date_modification + '}';
    }
    
    
}
