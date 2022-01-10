/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.repository.MediaRepository;
import edu.uha.miage.projet.java.core.service.MediaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author quentin
 */
public class MediaServiceImpl implements MediaService {

    @Autowired
    MediaRepository mediaRepository;
    
    @Override
    public Media save(Media entity) {
        return mediaRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        mediaRepository.deleteById(id);
    }

    @Override
    public List<Media> findAll() {
        return (List<Media>) mediaRepository.findAll();
    }

    @Override
    public Optional<Media> findById(int id) {
        return mediaRepository.findById(id);
    }

    @Override
    public List<Media> findByNom(String nom) {
        return mediaRepository.findByNom(nom);
    }

    @Override
    public List<Media> findByEtatTrue() {
        return (List<Media>) mediaRepository.findByEtatTrue();
    }

    @Override
    public List<Media> findByEtatFalse() {
        return (List<Media>) mediaRepository.findByEtatFalse();
    }

    @Override
    public List<Media> findAllByOrderByNom() {
        return (List<Media>) mediaRepository.findAllByOrderByNom();
    }

    @Override
    public List<Media> findAllByOrderByDateCreation() {
        return (List<Media>) mediaRepository.findAllByOrderByDateCreation();
    }

    @Override
    public List<Media> findAllByOrderByNomDesc() {
        return (List<Media>) mediaRepository.findAllByOrderByNomDesc();
    }

    @Override
    public List<Media> findAllByOrderByDateCreationDesc() {
        return (List<Media>) mediaRepository.findAllByOrderByDateCreationDesc();
    }

    @Override
    public List<Media> findByNomContaining(String str) {
        return (List<Media>) mediaRepository.findByNomContaining(str);
    }
            
}
