/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier;

import edu.uha.miage.projet.java.core.metier.associations.DecritMedia;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

/**
 * La classe Tag permet de créer tout objet/ligne qui serait contenus dans la table "TAG" de la base de données
 * @author quentin
 */
@Entity
public class Tag {
    
    /**
     * Le champs Id correspond à l'id de l'objet dans la base de données. Cet id est incrémenté automatiquement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    /**
     * Le champs tag correspond au nom du tag
     */
    @NotNull
    private String tag;
    
    /**
     * Le champs etat correspond à l'état du tag. </br> À true, le tag est actif, et à false, le tag est désactivé/indisponible.
     */
    @NotNull
    private boolean etat;
    
    /**
     * Le champs dateCreation correspond à la date de création de l'objet
     */
    @NotNull
    private Date dateCreation;
    
    /**
     * Le champs listMedia correspond à la liste des objets de type Media qui sont concernés par ce tag
     */
    @OneToMany(mappedBy = "tag")
    private List<DecritMedia> listMedia;
    
    /**
     * Constructeur de la classe Tag
     * @param tag un String correspondant au nom du tag
     * @param etat un boolean correspondant à l'état du tag (true pour actif, false pour désactivé)
     * @param dateCreation Un objet de type Date correspondant à la date de création de l'objet
     */
    public Tag(String tag, boolean etat, Date dateCreation) {
        this.tag = tag;
        this.etat = true;
        this.dateCreation = dateCreation;
    }
    
    /**
     * Constructeur vide de la classe Tag, initialise avec un nom vide, la date de création à la date d'aujourd'hui,et l'état à true
     */
    public Tag() {
        this("", true, new Date(System.currentTimeMillis()));
    }
    
    /**
     * Constructeur de la classe Tag, initialise automatiquement la date de création à la date d'aujourd'hui
     * @param tag un String correspondant au nom du tag
     * @param etat un boolean correspondant à l'état du tag (true pour actif, false pour désactivé)
     */
    public Tag(String tag, boolean etat) {
        this(tag, etat, new Date(System.currentTimeMillis()));
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
     * Getter du champs tag
     * @return un String correspondant au nom du tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Setter du champs tag
     * @param tag un String correspondant au nouveau nom du tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Getter du champs etat
     * @return l'état de l'objet de type Tag
     */
    public boolean isEtat() {
        return etat;
    }

    /**
     * Setter du champs etat - Permet d'activer/désactiver le tag en question
     * @param etat le nouvel état du tag
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
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
     * Fonction toString de la classe Tag
     * @return un String contenant les informations de l'objet
     */
    @Override
    public String toString() {
        return "Tag{" + "id=" + id + ", tag=" + tag + ", etat=" + etat + ", dateCreation=" + dateCreation + '}';
    }
    
    
}
