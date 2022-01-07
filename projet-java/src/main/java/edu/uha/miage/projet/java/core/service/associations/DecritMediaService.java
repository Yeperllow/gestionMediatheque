/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.associations;

import edu.uha.miage.projet.java.core.metier.associations.DecritMedia;
import edu.uha.miage.projet.java.core.metier.associations.DecritMediaId;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author quentin
 */
public interface DecritMediaService {
    DecritMedia save(DecritMedia entity);
    void delete(DecritMediaId id);
    List<DecritMedia> findAll();
    Optional<DecritMedia> findById(DecritMediaId id);
    List<DecritMedia> findByEtat(boolean etat);
}
