/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.metiers.associations;

import java.io.Serializable;

/**
 *
 * @author quentin
 */
public class ModificationTypeId implements Serializable{
    
    private int utilisateur;
    private int type;

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ModificationTypeId{" + "utilisateur=" + utilisateur + ", type=" + type + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.utilisateur;
        hash = 59 * hash + this.type;
        return hash;
    }

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
