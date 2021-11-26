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
public class ModificationMediaId implements Serializable{
    
    private int utilisateur;
    private int media;

    public int getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(int utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "ModificationMediaId{" + "utilisateur=" + utilisateur + ", media=" + media + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.utilisateur;
        hash = 97 * hash + this.media;
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
