/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.repository;

import edu.uha.miage.projet.java.core.metier.Media;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author quentin
 */
public interface MediaRepository extends JpaRepository<Media, Integer>{
    List<Media> findByNom(String nom);
    List<Media> findByEtatTrue();
    List<Media> findByEtatFalse();
}
