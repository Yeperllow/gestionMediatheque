/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMedia;
import edu.uha.miage.projet.java.core.metier.associations.EmprunteMediaId;
import edu.uha.miage.projet.java.core.repository.associations.EmprunteMediaRepository;
import edu.uha.miage.projet.java.core.service.associations.EmprunteMediaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author quentin
 */
public class EmprunteMediaServiceImpl implements EmprunteMediaService{

    @Autowired
    EmprunteMediaRepository emprunteMediaRepository;
    
    @Override
    public EmprunteMedia save(EmprunteMedia entity) {
        return emprunteMediaRepository.save(entity);
    }

    @Override
    public void delete(EmprunteMediaId id) {
        emprunteMediaRepository.deleteById(id);
    }

    @Override
    public List<EmprunteMedia> findAll() {
        return emprunteMediaRepository.findAll();
    }

    @Override
    public Optional<EmprunteMedia> findById(EmprunteMediaId id) {
        return emprunteMediaRepository.findById(id);
    }

    @Override
    public List<EmprunteMedia> findByEtatTrue() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findByEtatTrue();
    }

    @Override
    public List<EmprunteMedia> findByEtatFalse() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findByEtatFalse();
    }

    @Override
    public List<EmprunteMedia> findByUtilisateur(Utilisateur utilisateur) {
        return (List<EmprunteMedia>) emprunteMediaRepository.findByUtilisateur(utilisateur);
    }

    @Override
    public List<EmprunteMedia> findByMedia(Media media) {
        return (List<EmprunteMedia>) emprunteMediaRepository.findByMedia(media);
    }

    @Override
    public List<EmprunteMedia> findAllByOrderByDateDebut() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateDebut();
    }

    @Override
    public List<EmprunteMedia> findAllByOrderByDateFin() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateFin();
    }

    @Override
    public List<EmprunteMedia> findAllByOrderByDateCreation() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateCreation();
    }

    @Override
    public List<EmprunteMedia> findAllByOrderByDateModification() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateModification();
    }

    @Override
    public List<EmprunteMedia> findAllByOrderByDateDebutDesc() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateDebutDesc();
    }

    @Override
    public List<EmprunteMedia> findAllByOrderByDateFinDesc() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateFinDesc();
    }

    @Override
    public List<EmprunteMedia> findAllByOrderByDateCreationDesc() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateCreationDesc();
    }

    @Override
    public List<EmprunteMedia> findAllByOrderByDateModificationDesc() {
        return (List<EmprunteMedia>) emprunteMediaRepository.findAllByOrderByDateModificationDesc();
    }
    
}
