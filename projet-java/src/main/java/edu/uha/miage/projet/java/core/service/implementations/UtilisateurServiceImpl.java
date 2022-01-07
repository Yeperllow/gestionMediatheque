/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.repository.UtilisateurRepository;
import edu.uha.miage.projet.java.core.service.UtilisateurService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author quentin
 */
public class UtilisateurServiceImpl implements UtilisateurService{

    @Autowired
    UtilisateurRepository utilisateurRepository;
    
    @Override
    public Utilisateur save(Utilisateur entity) {
        return utilisateurRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Optional<Utilisateur> findById(int id) {
        return utilisateurRepository.findById(id);
    }

    @Override
    public Optional<Utilisateur> findByLogin(String login) {
        return utilisateurRepository.findByLogin(login);
    }

    @Override
    public List<Utilisateur> findByNom(String nom) {
        return utilisateurRepository.findByNom(nom);
    }

    @Override
    public List<Utilisateur> findByPrenom(String prenom) {
        return utilisateurRepository.findByPrenom(prenom);
    }

    @Override
    public List<Utilisateur> findByNomAndByPrenom(String nom, String prenom) {
        return utilisateurRepository.findByNomAndByPrenom(nom, prenom);
    }

    @Override
    public List<Utilisateur> findByEtat(boolean etat) {
        return utilisateurRepository.findByEtat(etat);
    }
    
}
