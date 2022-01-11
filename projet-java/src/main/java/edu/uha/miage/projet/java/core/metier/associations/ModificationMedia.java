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
 * La classe ModificationMedia permet de créer tout objet/ligne qui serait contenus dans la table "MODIFIE_MEDIA" de la base de données
 * @author quentin
 */
@Entity
@Table(name = "Modifie_media")
@IdClass(ModificationMediaId.class)
public class ModificationMedia implements Serializable{
    
    /**
     * Le champs utilisateur correspond à l'objet utilisateur associé à cet modification d'un média dans la base de données.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;
    
    /**
     * Le champs media correspond à l'objet média associé à cette modification d'un média dans la base de données.
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_media", referencedColumnName = "id")
    private Media media;
    
    /**
     * Le champs dateModification correspond à la date de modification du media associé
     */
    @NotNull
    private Date dateModification;
    
    /**
     * Constructeur vide de la classe ModificationMedia
     * Les variables de l'objet ne sont pas initialisés
     */
    public ModificationMedia() {
    }
    
    /**
     * Constructeur de la classe ModificationMedia
     * @param date_modification Date de modification du media associé
     */
    public ModificationMedia(Date date_modification) {
        this.dateModification = date_modification;
    }

    /**
     * Getter de la variable utilisateur
     * @return l'objet utilisateur associé
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Setter de la variable utilisateur
     * @param utilisateur le nouveau objet utilisateur associé
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Getter de la variable media
     * @return l'objet media associé
     */
    public Media getMedia() {
        return media;
    }

    /**
     * Setter de la variable media
     * @param media le nouveau objet média associé
     */
    public void setMedia(Media media) {
        this.media = media;
    }

    /**
     * Getter de la date de modification
     * @return la date de modification du media associé
     */
    public Date getDateModification() {
        return dateModification;
    }

    /**
     * Setter de la date de modification
     * @param dateModification la nouvelle date de modification du media associé
     */
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    /**
     * Méthode toString de la classe ModificationMedia
     * @return 
     */
    @Override
    public String toString() {
        return "ModificationMedia{" + "utilisateur=" + utilisateur + ", media=" + media + ", dateModification=" + dateModification + '}';
    }
    
    
    
}
