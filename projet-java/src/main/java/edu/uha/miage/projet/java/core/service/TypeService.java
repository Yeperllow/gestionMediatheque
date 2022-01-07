/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.uha.miage.projet.java.core.service;

import edu.uha.miage.projet.java.core.metier.Type;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author quentin
 */
public interface TypeService {
    Type save(Type entity);
    void delete(int id);
    List<Type> findAll();
    Optional<Type> findById(int id);
    Optional<Type> findByType(String type);
    List<Type> findByEtat(boolean etat);
}
