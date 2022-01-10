/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Tag;
import edu.uha.miage.projet.java.core.metier.associations.DecritMedia;
import edu.uha.miage.projet.java.core.metier.associations.DecritMediaId;
import edu.uha.miage.projet.java.core.repository.associations.DecritMediaRepository;
import edu.uha.miage.projet.java.core.service.associations.DecritMediaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author quentin
 */
public class DecritMediaServiceImpl implements DecritMediaService{

    @Autowired
    DecritMediaRepository decritMediaRepository;
    
    @Override
    public DecritMedia save(DecritMedia entity) {
        return decritMediaRepository.save(entity);
    }

    @Override
    public void delete(DecritMediaId id) {
        decritMediaRepository.deleteById(id);
    }

    @Override
    public List<DecritMedia> findAll() {
        return (List<DecritMedia>) decritMediaRepository.findAll();
    }

    @Override
    public Optional<DecritMedia> findById(DecritMediaId id) {
        return decritMediaRepository.findById(id);
    }

    @Override
    public List<DecritMedia> findByEtat(boolean etat) {
        return (List<DecritMedia>) decritMediaRepository.findByEtat(etat);
    }

    @Override
    public List<DecritMedia> findByTag(Tag tag) {
        return (List<DecritMedia>) decritMediaRepository.findByTag(tag);
    }

    @Override
    public List<DecritMedia> findByMedia(Media media) {
        return (List<DecritMedia>) decritMediaRepository.findByMedia(media);
    }
    
}
