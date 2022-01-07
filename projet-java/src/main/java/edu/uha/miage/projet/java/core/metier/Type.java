/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier;

import edu.uha.miage.projet.java.core.metier.associations.ModificationType;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * La classe Type permet de créer tout objet/ligne qui serait contenus dans la table "TYPE" de la base de données
 * @author quentin
 */
@Entity
public class Type implements Serializable{
    
    /**
     * Le champs Id correspond à l'id de l'objet dans la base de données. Cet id est incrémenté automatiquement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    /**
     * Le champ type correspond au nom du type
     */
    @Size(min=2, max=50)
    @NotNull
    private String type;
    
    /**
     * Le champs etat correspond à l'état du type. </br> À true, le type est actif, et à false, le type est désactivé/indisponible.
     */
    @NotNull
    private boolean etat;
    
    /**
     * Le champs date_creation correspond à la date de création de l'objet
     */
    @NotNull
    private Date date_creation;
    
    /**
     * Le champ createur de type Utilisateur permet de savoir qui à ajouté ce type dans la base de données.
     */
    @ManyToOne
    private Utilisateur createur;
    
    /**
     * Cette liste permet de savoir quand des modifications sur ce type ont été effectuées, ainsi que l'utilisateur qui en est responsable.
     */
    @OneToMany(mappedBy = "utilisateur")
    private List<ModificationType> modificationTypeEffectuee;
    
    /**
     * Constructeur de la classe Type
     * @param type un String correspondant au nom du type
     * @param etat l'état du type - true pour actif, false pour désactivé
     * @param date_creation Un objet de type Date correspondant à la date de création de l'objet
     */
    public Type(String type, boolean etat, Date date_creation) {
        this.type = type;
        this.etat = etat;
        this.date_creation = date_creation;
    }
    
    /**
     * Constructeur par défaut de la classe Type - construit un objet de type Type ayant pour nom une chaine vide, un état à true, et la date de création à la date d'aujourd'hui
     */
    public Type() {
        this("", true, new Date(System.currentTimeMillis()));
    }
    
    /**
     * Constructeur de la classe Type, mais initialise automatiquement la date
     * @param type Un String correspondant au nom du type
     * @param etat L'état du type - true pour actif, false pour désactivé
     */
    public Type(String type, boolean etat) {
        this(type, etat, new Date(System.currentTimeMillis()));
    }

    /**
     * Getter du champs id
     * @return un int correspond à l'id de l'objet
     */
    public int getId() {
        return id;
    }

    /**
     * Setter du champs id - N'est utile que pour la serialization
     * @param id un int correspondant à l'id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter du champs type
     * @return un String correspondant au nom du type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter du champs type
     * @param type Un String correspondant au nouveau nom du type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter du champs etat
     * @return l'état de l'objet de type Type
     */
    public boolean isEtat() {
        return etat;
    }

    /**
     * Setter du champs etat - Permet d'activer/désactiver le type en question
     * @param etat le nouvel état du type
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     * Getter du champs date_creation
     * @return la date de création de l'objet de type Type
     */
    public Date getDate_creation() {
        return date_creation;
    }

    /**
     * Setter du champs date_creation - N'est utile que pour l'aspect Serializable de la classe Type
     * @param date_creation Une nouvelle date de création
     */
    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    /**
     * Fonction permettant d'afficher le contenus de l'objet de type Type - N'est utile que pour la Serialization
     * @return un String contenant les informations de l'objet
     */
    @Override
    public String toString() {
        return "Type{" + "id=" + id + ", type=" + type + ", etat=" + etat + ", date_creation=" + date_creation + '}';
    }

    /**
     * Getter du champ createur
     * @return Un objet de type Utilisateur correspondant au createur du type
     */
    public Utilisateur getCreateur() {
        return createur;
    }

    /**
     * Setter du champ createur
     * @param createur Un objet de type Utilisateur
     */
    public void setCreateur(Utilisateur createur) {
        this.createur = createur;
    }

    /**
     * Getter du champ modificationTypeEffectuee
     * @return une liste de type List<ModificationType>
     */
    public List<ModificationType> getModificationTypeEffectuee() {
        return modificationTypeEffectuee;
    }

    /**
     * Setter du champ modificationTypeEffectuee
     * @param modificationTypeEffectuee Une liste de type List<ModificationType>
     */
    public void setModificationTypeEffectuee(List<ModificationType> modificationTypeEffectuee) {
        this.modificationTypeEffectuee = modificationTypeEffectuee;
    }
    
    
}
