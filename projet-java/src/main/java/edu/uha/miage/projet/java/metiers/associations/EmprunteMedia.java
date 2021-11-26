/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.metiers.associations;

import edu.uha.miage.projet.java.metiers.Media;
import edu.uha.miage.projet.java.metiers.Utilisateur;
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
 *
 * @author quentin
 */
@Entity
@Table(name = "Emprunte_media")
@IdClass(EmprunteMediaId.class)
public class EmprunteMedia implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_media", referencedColumnName = "id")
    private Media media;
    
    @NotNull
    private Date date_debut;
    
    @NotNull
    private Date date_fin;
    
    @NotNull
    private Date date_creation;
    
    @NotNull
    private Date date_modification;
    
    @NotNull
    private boolean etat;
    
    public EmprunteMedia() {
        this.date_creation = new Date(System.currentTimeMillis());
        this.date_modification = new Date(System.currentTimeMillis());
    }
    
    public EmprunteMedia(Date date_debut, Date date_fin) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.date_creation = new Date(System.currentTimeMillis());
        this.date_modification = new Date(System.currentTimeMillis());
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Media getMedia() {
        return media;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "EmprunteMedia{" + "utilisateur=" + utilisateur + ", media=" + media + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", date_creation=" + date_creation + ", date_modification=" + date_modification + ", etat=" + etat + '}';
    }
    
    
    
}
