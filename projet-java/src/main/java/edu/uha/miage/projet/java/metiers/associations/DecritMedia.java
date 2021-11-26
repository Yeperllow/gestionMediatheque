/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.metiers.associations;

import edu.uha.miage.projet.java.metiers.Media;
import edu.uha.miage.projet.java.metiers.Tag;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author quentin
 */
@Entity
@Table(name = "Decrit_media")
@IdClass(DecritMediaId.class)
public class DecritMedia {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_tag", referencedColumnName = "id")
    private Tag tag;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_media", referencedColumnName = "id")
    private Media media;
    
    private boolean etat;
    
    public DecritMedia(boolean etat) {
        this.etat = etat;
    }
    
    public DecritMedia() {
        this(true);
    }
    
}
