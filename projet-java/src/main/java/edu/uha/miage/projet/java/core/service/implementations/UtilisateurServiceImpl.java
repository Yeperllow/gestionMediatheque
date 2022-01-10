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
    public List<Utilisateur> findByEtatTrue() {
        return (List<Utilisateur>) utilisateurRepository.findByEtatTrue();
    }

    @Override
    public List<Utilisateur> findByEtatFalse() {
        return (List<Utilisateur>) utilisateurRepository.findByEtatFalse();
    }
    
    @Override
    public List<Utilisateur> findAllByOrderByLogin() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByLogin();
    }

    @Override
    public List<Utilisateur> findAllByOrderByNomAscPrenomAsc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByNomAscPrenomAsc();
    }

    @Override
    public List<Utilisateur> findAllByOrderByDateCreation() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByDateCreation();
    }

    @Override
    public List<Utilisateur> findAllByOrderByDateModification() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByDateModification();
    }
    
    @Override
    public List<Utilisateur> findAllByOrderByLoginDesc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByLoginDesc();
    }

    @Override
    public List<Utilisateur> findAllByOrderByNomDescPrenomDesc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByNomDescPrenomDesc();
    }

    @Override
    public List<Utilisateur> findAllByOrderByDateCreationDesc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByDateCreationDesc();
    }

    @Override
    public List<Utilisateur> findAllByOrderByDateModificationDesc() {
        return (List<Utilisateur>) utilisateurRepository.findAllByOrderByDateModificationDesc();
    }

    @Override
    public List<Utilisateur> findByLoginOrNomOrPrenomContaining(String str) {
        return (List<Utilisateur>) utilisateurRepository.findByLoginOrNomOrPrenomContaining(str);
    }
    
}
