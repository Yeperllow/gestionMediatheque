/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.associations;

import edu.uha.miage.projet.java.core.metier.associations.ModificationType;
import edu.uha.miage.projet.java.core.metier.associations.ModificationTypeId;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author quentin
 */
public interface ModificationTypeService {
    ModificationType save(ModificationType entity);
    void delete(ModificationTypeId id);
    List<ModificationType> findAll();
    Optional<ModificationType> findById(ModificationTypeId id);
}
