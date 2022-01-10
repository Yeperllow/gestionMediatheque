/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMedia;
import edu.uha.miage.projet.java.core.metier.associations.ModificationMediaId;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author quentin
 */
public interface ModificationMediaService {
    ModificationMedia save(ModificationMedia entity);
    void delete(ModificationMediaId id);
    List<ModificationMedia> findAll();
    Optional<ModificationMedia> findById(ModificationMediaId id);
    
    List<ModificationMedia> findByUtilisateur(Utilisateur utilisateur);
    List<ModificationMedia> findByMedia(Media media);
}
