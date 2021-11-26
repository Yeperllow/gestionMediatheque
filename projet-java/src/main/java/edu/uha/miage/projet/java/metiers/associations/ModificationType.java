/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.metiers.associations;

import edu.uha.miage.projet.java.metiers.Type;
import edu.uha.miage.projet.java.metiers.Utilisateur;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author quentin
 */
@Entity
@Table(name = "Modifie_type")
@IdClass(ModificationTypeId.class)
public class ModificationType implements Serializable {
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id")
    private Utilisateur utilisateur;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "id_type", referencedColumnName = "id")
    private Type type;
    
    @NotNull
    private Date date_modification;
    
    public ModificationType() {
    }
    
    public ModificationType(Date date_modification) {
        this.date_modification = date_modification;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Date getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(Date date_modification) {
        this.date_modification = date_modification;
    }

    @Override
    public String toString() {
        return "ModificationType{" + "utilisateur=" + utilisateur + ", type=" + type + ", date_modification=" + date_modification + '}';
    }
    
    
    
}
