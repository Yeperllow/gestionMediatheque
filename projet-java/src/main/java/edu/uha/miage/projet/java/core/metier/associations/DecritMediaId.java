/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier.associations;

import java.io.Serializable;

/**
 *
 * @author quentin
 */
public class DecritMediaId implements Serializable {
    
    private int tag;
    private int media;

    public int getTag() {
        return tag;
    }

    public void setTag(int tag) {
        this.tag = tag;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return "DecritMediaId{" + "tag=" + tag + ", media=" + media + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.tag;
        hash = 29 * hash + this.media;
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
