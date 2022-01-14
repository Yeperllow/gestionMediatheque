/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * La classe EmprunteMedia permet de créer tout objet/ligne qui serait contenus dans la table "EMPRUNTE_MEDIA" de la base de données
 * @author quentin
 */
@Entity
@Table(name = "Emprunte_media")
@IdClass(EmprunteMediaId.class)
public class EmprunteMedia implements Serializable{
    
    /**
     * Le champs utilisateur correspond à l'objet utilisateur associé à cet emprunt dans la base de données
     * C'est la clé externe de l'utilisateur qui forme la clé primaire de cette table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;
    
    /**
     * Le champs media correspond à l'objet média associé à cet emprunt dans la base de données
     * C'est la clé externe du média qui forme la clé primaire de cette table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_media", referencedColumnName = "id")
    private Media media;
    
    /**
     * Le champs dateDebut correspond à la date de début de l'emprunt du média concerné
     */
    @NotNull
    private Date dateDebut;
    
    /**
     * Le champs dateFin correspond à la date de fin de l'emprunt du média concerné
     */
    @NotNull(message="Veuillez entrer une date de fin")
    private Date dateFin;
    
    /**
     * Le champs dateCreation correspond à la date de création de cet objet de type EmprunteMedia
     */
    @NotNull
    private Date dateCreation;
    
    /**
     * Le champs dateModification correspond à la dernière date de modification de cet objet de type EmprunteMedia
     */
    @NotNull
    private Date dateModification;
    
    /**
     * Le champs etat correspond à l'état de cet objet. </br> À true, cette association est active, et à false, cette association est désactivée/indisponible.
     */
    @NotNull
    private boolean etat;
    
    /**
     * Constructeur vide de la classe EmprunteMedia </br> La date de création et la date de modification sont mises au jour d'aujourd'hui
     * Les dates de début et de fin ne sont pas initialisées
     */
    public EmprunteMedia() {
        this.dateCreation = new Date(System.currentTimeMillis());
        this.dateModification = new Date(System.currentTimeMillis());
    }
    
    /**
     * Constructeur de la classe EmprunteMedia </br> La date de création et la date de modification sont mises au jour d'aujourd'hui
     * @param dateDebut Date de début de l'emprunt
     * @param dateFin Date de fin de l'emprunt
     */
    public EmprunteMedia(Date dateDebut, Date dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.dateCreation = new Date(System.currentTimeMillis());
        this.dateModification = new Date(System.currentTimeMillis());
    }

    /**
     * Getter de la variable utilisateur
     * @return l'utilisateur concerné par cet emprunt
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Setter de la variable utilisateur
     * @param utilisateur le nouveau utilisateur concerné par cet emprunt
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Getter de la variable media
     * @return le media concerné par cet emprunt
     */
    public Media getMedia() {
        return media;
    }

    /**
     * Setter de la variable media
     * @param media le nouveau media concerné par cet emprunt
     */
    public void setMedia(Media media) {
        this.media = media;
    }

    /**
     * Getter de la variable dateDebut
     * @return la date de début de cet emprunt
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * Setter de la variable dateDebut
     * @param dateDebut la nouvelle date de début de cet emprunt
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Getter de la variable dateFin
     * @return la date de fin de cet emprunt
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Setter de la variable dateFin
     * @param dateFin la nouvelle date de fin de cet emprunt
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Getter de la variable dateCreation
     * @return la date de creation de cet emprunt
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Setter de la variable dateCreation
     * @param dateCreation la nouvelle date de creation de cet emprunt
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Getter de la variable dateModification
     * @return la date de modification de cet emprunt
     */
    public Date getDateModification() {
        return dateModification;
    }

    /**
     * Setter de la variable dateModification
     * @param dateModification la nouvelle date de modification de cet emprunt
     */
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    /**
     * Getter de la variable etat
     * @return l'etat de cet emprunt
     */
    public boolean isEtat() {
        return etat;
    }

    /**
     * Setter de la variable etat
     * @param etat le nouveau etat de cet emprunt
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     * Méthode toString de la classe EmprunteMedia
     * @return 
     */
    @Override
    public String toString() {
        return "EmprunteMedia{" + "utilisateur=" + utilisateur + ", media=" + media + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", dateCreation=" + dateCreation + ", dateModification=" + dateModification + ", etat=" + etat + '}';
    }
    
    
    
}
