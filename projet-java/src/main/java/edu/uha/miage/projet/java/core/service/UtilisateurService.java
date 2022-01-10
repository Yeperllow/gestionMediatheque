/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service;

import edu.uha.miage.projet.java.core.metier.Utilisateur;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author quentin
 */
public interface UtilisateurService {
    Utilisateur save(Utilisateur entity);
    void delete(int id);
    List<Utilisateur> findAll();
    Optional<Utilisateur> findById(int id);
    Optional<Utilisateur> findByLogin(String login);
    List<Utilisateur> findByNom(String nom);
    List<Utilisateur> findByPrenom(String prenom);
    List<Utilisateur> findByNomAndByPrenom(String nom, String prenom);
    List<Utilisateur> findByEtatTrue();
    List<Utilisateur> findByEtatFalse();
}