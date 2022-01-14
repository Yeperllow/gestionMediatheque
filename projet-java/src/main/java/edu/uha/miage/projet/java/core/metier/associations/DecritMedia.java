/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Tag;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * La classe DecritMedia permet de créer tout objet/ligne qui serait contenus dans la table "DECRIT_MEDIA" de la base de données
 * @author quentin
 */
@Entity
@Table(name = "Decrit_media")
@IdClass(DecritMediaId.class)
public class DecritMedia {
    
    /**
     * Le champs tag correspond à l'objet tag associé à cette description dans la base de données.
     * C'est la clé externe du tag qui forme la clé primaire de cette table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_tag", referencedColumnName = "id")
    private Tag tag;
    
    /**
     * Le champs media correspond à l'objet média associé à cette description dans la base de données.
     * C'est la clé externe du média qui forme la clé primaire de cette table
     */
    @Id
    @ManyToOne
    @JoinColumn(name = "id_media", referencedColumnName = "id")
    private Media media;
    
    /**
     * Le champs etat correspond à l'état de cette association. </br> À true, cette association est active, et à false, cette association est désactivée/indisponible.
     */
    private boolean etat;
    
    
    /**
     * Constructeur de la classe DecritMedia, permet de créer un objet de la table "DECRIT_MEDIA" avec un état précis donné en paramètre
     * @param etat 
     */
    public DecritMedia(boolean etat) {
        this.etat = etat;
    }
    
    /**
     * Constructeur vide de la classe DecritMedia, permet de créer un objet de la table DECRIT_MEDIA avec un état égal à TRUE
     */
    public DecritMedia() {
        this(true);
    }

    public Tag getTag() {
        return tag;
    }

    public Media getMedia() {
        return media;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setMedia(Media media) {
        this.media = media;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "DecritMedia{" + "tag=" + tag + ", media=" + media + ", etat=" + etat + '}';
    }
    
    
    
    
}
