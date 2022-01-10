/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Type;
import edu.uha.miage.projet.java.core.repository.TypeRepository;
import edu.uha.miage.projet.java.core.service.TypeService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author quentin
 */
public class TypeServiceImpl implements TypeService{

    @Autowired
    TypeRepository typeRepository;
    
    @Override
    public Type save(Type entity) {
        return typeRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        typeRepository.deleteById(id);
    }

    @Override
    public List<Type> findAll() {
        return (List<Type>) typeRepository.findAll();
    }

    @Override
    public Optional<Type> findById(int id) {
        return typeRepository.findById(id);
    }

    @Override
    public Optional<Type> findByType(String type) {
        return typeRepository.findByType(type);
    }

    @Override
    public List<Type> findByEtatTrue() {
        return (List<Type>) typeRepository.findByEtatTrue();
    }

    @Override
    public List<Type> findByEtatFalse() {
        return (List<Type>) typeRepository.findByEtatFalse();
    }
    
    @Override
    public List<Type> findAllByOrderByType() {
        return (List<Type>) typeRepository.findAllByOrderByType();
    }

    @Override
    public List<Type> findAllByOrderByDateCreation() {
        return (List<Type>) typeRepository.findAllByOrderByDateCreation();
    }
    
    @Override
    public List<Type> findAllByOrderByTypeDesc() {
        return (List<Type>) typeRepository.findAllByOrderByTypeDesc();
    }

    @Override
    public List<Type> findAllByOrderByDateCreationDesc() {
        return (List<Type>) typeRepository.findAllByOrderByDateCreationDesc();
    }

    @Override
    public List<Type> findByTypeContaining(String str) {
        return (List<Type>) typeRepository.findByTypeContaining(str);
    }

}
