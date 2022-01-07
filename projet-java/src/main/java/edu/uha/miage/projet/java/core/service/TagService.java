/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service;

import edu.uha.miage.projet.java.core.metier.Tag;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author quentin
 */
public interface TagService {
    Tag save(Tag entity);
    void delete(int id);
    List<Tag> findAll();
    Optional<Tag> findById(int id);
    Optional<Tag> findByTag(String tag);
    List<Tag> findByEtat(boolean etat);
}
