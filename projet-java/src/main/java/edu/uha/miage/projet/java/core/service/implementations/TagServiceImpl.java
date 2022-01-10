/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Tag;
import edu.uha.miage.projet.java.core.repository.TagRepository;
import edu.uha.miage.projet.java.core.service.TagService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author quentin
 */
public class TagServiceImpl implements TagService{

    @Autowired
    TagRepository tagRepository;
    
    @Override
    public Tag save(Tag entity) {
        return tagRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        tagRepository.deleteById(id);
    }

    @Override
    public List<Tag> findAll() {
        return (List<Tag>) tagRepository.findAll();
    }

    @Override
    public Optional<Tag> findById(int id) {
        return tagRepository.findById(id);
    }

    @Override
    public Optional<Tag> findByTag(String tag) {
        return tagRepository.findByTag(tag);
    }

    @Override
    public List<Tag> findByEtatTrue() {
        return (List<Tag>) tagRepository.findByEtatTrue();
    }

    @Override
    public List<Tag> findByEtatFalse() {
        return (List<Tag>) tagRepository.findByEtatFalse();
    }
    
    @Override
    public List<Tag> findAllByOrderByTag() {
        return (List<Tag>) tagRepository.findAllByOrderByTag();
    }

    @Override
    public List<Tag> findAllByOrderByDateCreation() {
        return (List<Tag>) tagRepository.findAllByOrderByDateCreation();
    }
    
    @Override
    public List<Tag> findAllByOrderByTagDesc() {
        return (List<Tag>) tagRepository.findAllByOrderByTagDesc();
    }

    @Override
    public List<Tag> findAllByOrderByDateCreationDesc() {
        return (List<Tag>) tagRepository.findAllByOrderByDateCreationDesc();
    }
    
}
