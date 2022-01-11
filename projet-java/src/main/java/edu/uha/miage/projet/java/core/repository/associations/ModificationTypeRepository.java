/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.repository.associations;

import edu.uha.miage.projet.java.core.metier.Type;
import edu.uha.miage.projet.java.core.metier.Utilisateur;
import edu.uha.miage.projet.java.core.metier.associations.ModificationType;
import edu.uha.miage.projet.java.core.metier.associations.ModificationTypeId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface ModificationTypeRepository permettant d'ajouter des requêtes pour la table "MODIFIE_TYPE"
 * @author quentin
 */
public interface ModificationTypeRepository extends JpaRepository<ModificationType, ModificationTypeId>{
    List<ModificationType> findByUtilisateur(Utilisateur utilisateur);
    List<ModificationType> findByType(Type type);
    
    //Par ordre croissant
    List<ModificationType> findAllByOrderByDateModification();
    //Par ordre décroissant
    List<ModificationType> findAllByOrderByDateModificationDesc();
}
