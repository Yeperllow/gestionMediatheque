/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.repository.associations;

import edu.uha.miage.projet.java.core.metier.Media;
import edu.uha.miage.projet.java.core.metier.Tag;
import edu.uha.miage.projet.java.core.metier.associations.DecritMedia;
import edu.uha.miage.projet.java.core.metier.associations.DecritMediaId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface DecritMediaRepository permettant d'ajouter des requêtes pour la table "DECRIT_MEDIA"
 * @author quentin
 */
public interface DecritMediaRepository extends JpaRepository<DecritMedia, DecritMediaId>{
    List<DecritMedia> findByEtatTrue();
    List<DecritMedia> findByEtatFalse();
    List<DecritMedia> findByTag(Tag tag);
    List<DecritMedia> findByMedia(Media media);
}
