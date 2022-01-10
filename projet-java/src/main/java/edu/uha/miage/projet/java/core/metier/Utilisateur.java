/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.metier;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * La classe Utilisateur permet de créer tout objet/ligne qui serait contenus dans la table "UTILISATEUR" de la base de données
 * @author quentin
 */
@Entity
public class Utilisateur implements Serializable{
    
    /**
     * Le champs Id correspond à l'id de l'objet dans la base de données. Cet id est incrémenté automatiquement.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    /**
     * Le champs login correspond au login/pseudo/identifiant de l'utilisateur
     */
    @NotNull
    @Size(min=2, max=25)
    private String login;
    
    /**
     * Le champs nom correspond au nom de l'utilisateur
     */
    @NotNull
    @Size(min=2, max=50)
    private String nom;
    
    /**
     * le champs prenom correspond au prenom de l'utilisateur
     */
    @NotNull
    @Size(min=2, max=50)
    private String prenom;
    
    /**
     * Le champs motDePasse correspond au mot de passe de cet utilisateur
     */
    @NotNull
    @Size(min=2, max=50)
    @Pattern(regexp="^[a-zA-Z0-9]*&")
    private String motDePasse;
    
    /**
     * Le champs etat correspond à l'état de l'utilisateur. </br> À true, l'utilisateur est actif, et à false, l'utilisateur est désactivé/indisponible.
     */
    @NotNull
    private boolean etat;
    
    /**
     * Le champs dateCreation permet de savoir quand l'objet de type Media a été créer.
     */
    @NotNull
    private Date dateCreation;
    
    /**
     * Le champs dateModification permet de savoir quand l'objet de type Utilisateur a été modifié pour la dernière fois
     */
    @NotNull
    private Date dateModification;
    
    /**
     * Le champs role permet de savoir le role de l'utilisateur, par exemple : administrateur, utilisateur, ...
     */
    @ManyToOne
    private Role role;
    
    /**
     * Le champs modificationTypeEffectuee permet d'obtenir la liste des modifications de types que l'utilisateur a effectuées
     */
    @OneToMany(mappedBy = "utilisateur")
    private List<ModificationType> modificationTypeEffectuee;
    
    /**
     * Le champs modificationMediaEffectuee permet d'obtenir la liste des modifications de medias que l'utilisateur a effectuées
     */
    @OneToMany(mappedBy = "utilisateur")
    private List<ModificationMedia> modificationMediaEffectuee;
    
    /**
     * Le champs empruntsDeMedia permet d'obtenir la liste des emprunts que l'utilisateur a fait
     */
    @OneToMany(mappedBy = "utilisateur")
    private List<EmprunteMedia> empruntsDeMedia;
    
    /**
     * Constructeur de la classe Utilisateur
     * @param login un String correspondant au login/pseudo/identifiant de l'utilisateur
     * @param nom un String correspondant au nom de l'utilisateur
     * @param prenom un String correspondant au prenom de l'utilisateur
     * @param motDePasse un String correspondant au mot de passe de l'utilisateur
     * @param etat un boolean correspond à l'état de l'utilisateur - true pour activé, false pour désactivé
     * @param dateCreation un objet de type Date correspondant à la date de création de l'objet
     * @param dateModification un objet de type Date correspondant à la dernière date de modification
     */
    public Utilisateur(String login, String nom, String prenom, String motDePasse, boolean etat, Date dateCreation, Date dateModification) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.etat = etat;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }
    
    /**
     * Constructeur par défaut de la classe Utilisateur - Initialise tous les string à "", l'état à true, et les dates à la date d'aujourd'hui
     */
    public Utilisateur() {
        this("", "", "", "", true, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
    }
    
    /**
     * Constructeur de la classe Utilisateur - Initialise automatiquement les dates à la date d'aujoud'hui
     * @param login un String correspondant au login/pseudo/identifiant de l'utilisateur
     * @param nom un String correspondant au nom de l'utilisateur
     * @param prenom un String correspondant au prenom de l'utilisateur
     * @param motDePasse un String correspondant au mot de passe de l'utilisateur
     * @param etat un boolean correspond à l'état de l'utilisateur - true pour activé, false pour désactivé 
     */
    public Utilisateur(String login, String nom, String prenom, String motDePasse, boolean etat) {
        this(login, nom, prenom, motDePasse, etat, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()));
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
     * Getter du champs login
     * @return un String correspondant au login de l'utilisateur
     */
    public String getLogin() {
        return login;
    }

    /**
     * Setter du champs login
     * @param login un String correspondant au nouveau login de l'utilisateur
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Getter du champs nom
     * @return un String correspondant au nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter du champs nom
     * @param nom un String correspondant au nom de l'utilisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter du champs prenom
     * @return un String correspondant au prenom de l'utilisateur
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Setter du champs prenom
     * @param prenom un String correspondant au prenom de l'utilisateur
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Getter du champs motDePasse
     * @return un String correspondant au mot de passe de l'utilisateur
     */
    public String getMotDePasse() {
        return motDePasse;
    }
    
    /**
     * Setter du champs motDePasse
     * @param motDePasse un String correspondant au nouveau mot de passe de l'utilisateur
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * Getter du champs etat
     * @return l'état de l'objet de type Utilisateur
     */
    public boolean isEtat() {
        return etat;
    }

    /**
     * Setter du champs etat - Permet d'activer/désactiver l'utilisateur en question
     * @param etat le nouvel état de l'utilisateur
     */
    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    /**
     * Getter du champs dateCreation
     * @return la date de création de l'objet de type Utilisateur
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Setter du champs dateCreation - N'est utile que pour l'aspect Serializable de la classe Utilisateur
     * @param dateCreation Une nouvelle date de création
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Getter du champs dateModification
     * @return Un objet de type Date correspondant à la date de la dernière modification de l'objet
     */
    public Date getDateModification() {
        return dateModification;
    }

    /**
     * Setter du champs dateModification
     * @param dateModification Un objet de type Date correspondant à la date d'une nouvelle modification
     */
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    /**
     * Fonction permettant d'afficher le contenus de l'objet de type Utilisateur - N'est utile que pour la Serialization
     * @return un String contenant les informations de l'objet
     */
    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", login=" + login + ", nom=" + nom + ", prenom=" + prenom + ", motDePasse=" + motDePasse + ", etat=" + etat + ", dateCreation=" + dateCreation + ", dateModification=" + dateModification + '}';
    }
    
    
    /**
     * Getter du champs role
     * @return Un objet de type Role correspondant au role de l'utilisateur
     */
    public Role getRole() {
        return role;
    }

    /**
     * Setter du champs role
     * @param role un objet de type Role correspondant au nouveau role de l'utilisateur
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Getter du champs modificationTypeEffectuee
     * @return une liste de type List<ModificationType>
     */
    public List<ModificationType> getModificationTypeEffectuee() {
        return modificationTypeEffectuee;
    }

    /**
     * Setter du champs modificationTypeEffectuee
     * @param modificationTypeEffectuee une list de type List<ModificationType>
     */
    public void setModificationTypeEffectuee(List<ModificationType> modificationTypeEffectuee) {
        this.modificationTypeEffectuee = modificationTypeEffectuee;
    }

    /**
     * Getter du champs modificationMediaEffectuee
     * @return une list de type List<ModificationMedia>
     */
    public List<ModificationMedia> getModificationMediaEffectuee() {
        return modificationMediaEffectuee;
    }

    /**
     * Setter du champs modificationMediaEffectuee
     * @param modificationMediaEffectuee une liste de type List<ModificationMedia>
     */
    public void setModificationMediaEffectuee(List<ModificationMedia> modificationMediaEffectuee) {
        this.modificationMediaEffectuee = modificationMediaEffectuee;
    }

    /**
     * Getter du champs empruntsDeMedia
     * @return une liste de type List<EmprunteMedia>
     */
    public List<EmprunteMedia> getEmpruntsDeMedia() {
        return empruntsDeMedia;
    }

    /**
     * Setter du champs empruntsDeMedia
     * @param empruntsDeMedia une liste de type List<EmprunteMedia>
     */
    public void setEmpruntsDeMedia(List<EmprunteMedia> empruntsDeMedia) {
        this.empruntsDeMedia = empruntsDeMedia;
    }
    
}
