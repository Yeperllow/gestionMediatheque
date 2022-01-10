/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations.associations;

import edu.uha.miage.projet.java.core.metier.Type;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.ModificationType;
import edu.uha.miage.projet.java.core.metier.associations.ModificationTypeId;
import edu.uha.miage.projet.java.core.repository.associations.ModificationTypeRepository;
import edu.uha.miage.projet.java.core.service.associations.ModificationTypeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author quentin
 */
public class ModificationTypeServiceImpl implements ModificationTypeService{

    @Autowired
    ModificationTypeRepository modificationTypeRepository;
    
    @Override
    public ModificationType save(ModificationType entity) {
        return modificationTypeRepository.save(entity);
    }

    @Override
    public void delete(ModificationTypeId id) {
        modificationTypeRepository.deleteById(id);
    }

    @Override
    public List<ModificationType> findAll() {
        return modificationTypeRepository.findAll();
    }

    @Override
    public Optional<ModificationType> findById(ModificationTypeId id) {
        return modificationTypeRepository.findById(id);
    }

    @Override
    public List<ModificationType> findByUtilisateur(Utilisateur utilisateur) {
        return (List<ModificationType>) modificationTypeRepository.findByUtilisateur(utilisateur);
    }

    @Override
    public List<ModificationType> findByType(Type type) {
        return (List<ModificationType>) modificationTypeRepository.findByType(type);
    }
    
}
