/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier.associations;

import java.io.Serializable;

/**
 * La classe ModificationTypeId permet de créer un objet qui contient les deux clés primaires de la table "MODIFIE_TYPE"
 * @author quentin
 */
public class ModificationTypeId implements Serializable{
    
    /**
     * Correspond à l'id de l'objet utilisateur associé
     */
    private int utilisateur;
    
    /**
     * Correspond à l'id de l'objet type associé
     */
    private int type;

    /**
     * Getter de la variable utilisateur
     * @return l'id correspondant à l'objet utilisateur associé
     */
    public int getUtilisateur() {
        return utilisateur;
    }

    /**
     * Setter de la variable utilisateur
     * @param utilisateur le nouvel id correspondant à l'utilisateur associé
     */
    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Getter de la variable type
     * @return l'id correspondant à l'objet type associé
     */
    public int getType() {
        return type;
    }

    /**
     * Setter de la variable type
     * @param type le nouvel id correspondant à l'objet type associé
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Méthode toString de la classe ModificationTypeId
     * @return 
     */
    @Override
    public String toString() {
        return "ModificationTypeId{" + "utilisateur=" + utilisateur + ", type=" + type + '}';
    }

    /**
     * Méthode hashCode de la classe ModificationTypeId
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.utilisateur;
        hash = 59 * hash + this.type;
        return hash;
    }

    /**
     * Méthode equals de la classe ModificationTypeId
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
        final ModificationTypeId other = (ModificationTypeId) obj;
        if (this.utilisateur != other.utilisateur) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

}
