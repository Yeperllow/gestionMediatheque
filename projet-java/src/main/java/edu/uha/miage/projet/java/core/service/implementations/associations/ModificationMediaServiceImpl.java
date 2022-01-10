/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMedia;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMediaId;
import edu.uha.miage.projet.java.core.repository.associations.ModificationMediaRepository;
import edu.uha.miage.projet.java.core.service.associations.ModificationMediaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author quentin
 */
public class ModificationMediaServiceImpl implements ModificationMediaService{

    @Autowired
    ModificationMediaRepository modificationMediaRepository;
    
    @Override
    public ModificationMedia save(ModificationMedia entity) {
        return modificationMediaRepository.save(entity);
    }

    @Override
    public void delete(ModificationMediaId id) {
        modificationMediaRepository.deleteById(id);
    }

    @Override
    public List<ModificationMedia> findAll() {
        return modificationMediaRepository.findAll();
    }

    @Override
    public Optional<ModificationMedia> findById(ModificationMediaId id) {
        return modificationMediaRepository.findById(id);
    }

    @Override
    public List<ModificationMedia> findByUtilisateur(Utilisateur utilisateur) {
        return (List<ModificationMedia>) modificationMediaRepository.findByUtilisateur(utilisateur);
    }

    @Override
    public List<ModificationMedia> findByMedia(Media media) {
        return (List<ModificationMedia>) modificationMediaRepository.findByMedia(media);
    }
    
}
