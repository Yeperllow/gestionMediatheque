/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier.associations;

import java.io.Serializable;

/**
 * La classe EmprunteMediaId permet de créer un objet qui contient les deux clés primaires de la table "EMPRUNTE_MEDIA"
 * @author quentin
 */
public class EmprunteMediaId implements Serializable {
    
    /**
     * Correspond à l'id de l'objet utilisateur associé à cet emprunt
     */
    private int utilisateur;
    
    /**
     * Correspond à l'id de l'objet media associé à cet emprunt
     */
    private int media;

    /**
     * Getter de la variable utilisateur
     * @return l'id correspondant à l'objet utilisateur associé
     */
    public int getUtilisateur() {
        return utilisateur;
    }

    /**
     * Setter de la variable utilisateur
     * @param utilisateur le nouveau id correspondant à l'objet utilisateur associé
     */
    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Getter de la variable media
     * @return l'id correspondant à l'objet média associé
     */
    public int getMedia() {
        return media;
    }

    /**
     * Setter de la variable media
     * @param media le nouveau id correspondant à l'objet média associé
     */
    public void setMedia(int media) {
        this.media = media;
    }

    /**
     * Méthode toString de la classe EmprunteMediaId
     * @return 
     */
    @Override
    public String toString() {
        return "EmprunteMediaId{" + "utilisateur=" + utilisateur + ", media=" + media + '}';
    }

    /**
     * Méthode hashCode de la classe EmprunteMediaId
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.utilisateur;
        hash = 13 * hash + this.media;
        return hash;
    }

    /**
     * Méthode equals de la classe EmprunteMediaId
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmprunteMediaId other = (EmprunteMediaId) obj;
        if (this.utilisateur != other.utilisateur) {
            return false;
        }
        if (this.media != other.media) {
            return false;
        }
        return true;
    }

    
    
    
}
