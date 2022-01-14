/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier;

import edu.uha.miage.projet.java.core.metier.associations.DecritMedia;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMedia;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMedia;
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
 * La classe Media permet de créer tout objet/ligne qui serait contenus dans la table "MEDIA" de la base de données
 * @author quentin
 */
@Entity
public class Media implements Serializable{
    
    /**
     * Le champs Id correspond à l'id de l'objet dans la base de données. Cet id est incrémenté automatiquement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    /**
     * Le champs nom correspond au nom du media.
     */
    @NotNull
    @Size(min=2, max=255, message="Le nom doit contenir entre 2 et 50 caractères")
    private String nom;
    
    /**
     * Le champs etat correspond à l'état du media. </br> À true, le media est actif, et à false, le média est désactivé/indisponible.
     */
    @NotNull
    private boolean etat;
    
    /**
     * Le champs dateCreation permet de savoir quand l'objet de type Media a été créer.
     */
    @NotNull
    private Date dateCreation;
    
    /**
     * Le champ createur de type Utilisateur permet de savoir qui à ajouté ce media dans la base de données.
     */
    @ManyToOne
    private Utilisateur createur;
    
    
    /**
     * Le champ type permet de savoir le type de ce media dans la base de données.
     */
    @ManyToOne
    private Type type;
    
    /**
     * Cette liste permet de savoir quand des modifications sur ce media ont été effectuées, ainsi que l'utilisateur qui en est responsable.
     */
    @OneToMany(mappedBy = "media")
    private List<ModificationMedia> modificationMediaEffectuee;
    
    /**
     * Cette liste permet de savoir quels emprunts concerne ce media en particulier.
     */
    @OneToMany(mappedBy = "media")
    private List<EmprunteMedia> empruntsDuMedia;
    
    /**
     * Cette liste permet d'obtenir la liste des tags de ce media.
     */
    @OneToMany(mappedBy = "media")
    private List<DecritMedia> listTag;
    
    /**
     * Constructeur de la classe Media, permettant de créer un objet de type Media avec un nom, un etat et une date de création.
     * @param nom Nom du média
     * @param etat Etat du media : true si le média est actif, false si le média est désactivé
     * @param dateCreation Date de création de l'objet
     */
    public Media(String nom, boolean etat, Date dateCreation) {
        this.nom = nom;
        this.etat = etat;
        this.dateCreation = dateCreation;
    }
    
    /**
     * Constructeur vide de la classe Media. Créer un objet contenant un nom vide, d'état actif.
     */
    public Media() {
        this("", true, new Date(System.currentTimeMillis()));
    }
    
    /**
     * Constructeur de la classe Media, permettant de construire un objet de type Media sans avoir à créer une date pour la date de création.
     * @param nom Nom du média
     * @param etat Etat du media : true si le média est actif, false si le média est désactivé
     */
    public Media(String nom, boolean etat) {
        this(nom, etat, new Date(System.currentTimeMillis()));
    }
    
    /**
     * Getter du champs id
     * @return l'id de l'objet de type Media
     */
    public int getId() {
        return id;
    }

    /**
     * Setter du champs id - Sert principalement pour l'aspect Serializable, car l'id est généré automatiquement
     * @param id un id de type int
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter du champs nom
     * @return le nom du média
     */
    public String getNom() {
        return nom;
    }
    

    /**
     * Setter du champs nom
     * @param nom le nouveau nom du média
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter du champs etat
     * @return l'état de l'objet de type Media
     */
    public boolean isEtat() {
        return etat;
    }

    /**
     * Setter du champs etat - Permet d'activer/désactiver le média en question
     * @param etat le nouvel état du média
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     * Getter du champs dateCreation
     * @return la date de création de l'objet de type Media
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Setter du champs dateCreation - N'est utile que pour l'aspect Serializable de la classe Media
     * @param dateCreation Une nouvelle date de création
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Fonction permettant d'afficher le contenus de l'objet de type Media - N'est utile que pour la Serialization
     * @return un String contenant les informations de l'objet
     */
    @Override
    public String toString() {
        return "Media{" + "id=" + id + ", nom=" + nom + ", etat=" + etat + ", dateCreation=" + dateCreation + '}';
    }
    
    /**
     * Getter du champ createur
     * @return Un objet de type Utilisateur correspondant au createur du média
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
     * Getter du champ modificationMediaEffectuee
     * @return une liste de type List<ModificationMedia>
     */
    public List<ModificationMedia> getModificationMediaEffectuee() {
        return modificationMediaEffectuee;
    }

    /**
     * Setter du champ modificationMediaEffectuee
     * @param modificationMediaEffectuee Une liste de type List<ModificationMedia>
     */
    public void setModificationMidediaEffectuee(List<ModificationMedia> modificationMediaEffectuee) {
        this.modificationMediaEffectuee = modificationMediaEffectuee;
    }

    /**
     * Getter du champ empruntsDuMedia
     * @return une liste des emprunts de ce media de type List<EmprunteMedia>
     */
    public List<EmprunteMedia> getEmpruntsDuMedia() {
        return empruntsDuMedia;
    }

    public List<DecritMedia> getListTag() {
        return listTag;
    }

    public void setListTag(List<DecritMedia> listTag) {
        this.listTag = listTag;
    }
    
    

    /**
     * Setter du champ empruntsDuMedia
     * @param empruntsDuMedia une liste de type List<EmprunteMedia>
     */
    public void setEmpruntsDuMedia(List<EmprunteMedia> empruntsDuMedia) {
        this.empruntsDuMedia = empruntsDuMedia;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
    
    
    
}
