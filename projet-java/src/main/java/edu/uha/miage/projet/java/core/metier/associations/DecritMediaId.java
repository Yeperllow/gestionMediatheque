/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier.associations;

import java.io.Serializable;

/**
 * La classe DecritMediaId permet de créer un objet qui contient les deux clés primaires de la table "DECRIT_MEDIA"
 * @author quentin
 */
public class DecritMediaId implements Serializable {
    
    /**
     * Le champs tag correspond à l'id de l'objet tag associé
     */
    private int tag;
    /**
     * Le champs media correspond à l'id de l'objet média associé
     */
    private int media;

    /**
     * Getter de la variable tag
     * @return l'id correspondant à l'objet tag associé
     */
    public int getTag() {
        return tag;
    }

    /**
     * Setter de la variable tag
     * @param tag - un int correspondant à l'id du nouvel objet tag associé
     */
    public void setTag(int tag) {
        this.tag = tag;
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
     * @param media - un int correspondant à l'id du nouvel objet média associé
     */
    public void setMedia(int media) {
        this.media = media;
    }

    /**
     * Méthode toString de la classe DecritMediaId
     * @return 
     */
    @Override
    public String toString() {
        return "DecritMediaId{" + "tag=" + tag + ", media=" + media + '}';
    }

    /**
     * Méthode hashCode de la classe DecritMediaId
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.tag;
        hash = 29 * hash + this.media;
        return hash;
    }

    /**
     * Méthode equals de la classe DecritMediaId
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
        final DecritMediaId other = (DecritMediaId) obj;
        if (this.tag != other.tag) {
            return false;
        }
        if (this.media != other.media) {
            return false;
        }
        return true;
    }
    
    
}
