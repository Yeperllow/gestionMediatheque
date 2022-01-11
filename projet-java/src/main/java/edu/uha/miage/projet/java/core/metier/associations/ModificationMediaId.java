/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier.associations;

import java.io.Serializable;

/**
 * La classe ModificationMediaId permet de créer un objet qui contient les deux clés primaires de la table "MODIFIE_MEDIA"
 * @author quentin
 */
public class ModificationMediaId implements Serializable{
    
    /**
     * Correspond à l'id de l'objet utilisateur associé à cette modification
     */
    private int utilisateur;
    
    /**
     * Correspond à l'id de l'objet média associé à cette modification
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
     * @param utilisateur le nouvel id correspondant à l'objet utilisateur associé
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
     * @param media le nouvel id correspondant à l'objet media associé
     */
    public void setMedia(int media) {
        this.media = media;
    }

    /**
     * Méthode toString de la classe ModificationMediaId
     * @return 
     */
    @Override
    public String toString() {
        return "ModificationMediaId{" + "utilisateur=" + utilisateur + ", media=" + media + '}';
    }

    /**
     * Méthode hashCode de la classe ModificationMediaId
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.utilisateur;
        hash = 97 * hash + this.media;
        return hash;
    }

    /**
     * Méthode equals de la classe ModificationMediaId
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
        final ModificationMediaId other = (ModificationMediaId) obj;
        if (this.utilisateur != other.utilisateur) {
            return false;
        }
        if (this.media != other.media) {
            return false;
        }
        return true;
    }

    
    
    
}
