/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uha.miage.projet.java.core.service.implementations;

import edu.uha.miage.projet.java.core.metier.Role;
import edu.uha.miage.projet.java.core.repository.RoleRepository;
import edu.uha.miage.projet.java.core.service.RoleService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author quentin
 */
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;
    
    @Override
    public Role save(Role entity) {
        return roleRepository.save(entity);
    }

    @Override
    public void delete(int id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> findAll() {
        
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Optional<Role> findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Optional<Role> findByRole(String role) {
        return roleRepository.findByRole(role);
    }

    @Override
    public List<Role> findAllByOrderByRole() {
        return (List<Role>) roleRepository.findAllByOrderByRole();
    }

    @Override
    public List<Role> findAllByOrderByDateCreation() {
        return (List<Role>) roleRepository.findAllByOrderByDateCreation();
    }

    @Override
    public List<Role> findAllByOrderByDateModification() {
        return (List<Role>) roleRepository.findAllByOrderByDateModification();
    }

    @Override
    public List<Role> findAllByOrderByRoleDesc() {
        return (List<Role>) roleRepository.findAllByOrderByRoleDesc();
    }

    @Override
    public List<Role> findAllByOrderByDateCreationDesc() {
        return (List<Role>) roleRepository.findAllByOrderByDateCreationDesc();
    }

    @Override
    public List<Role> findAllByOrderByDateModificationDesc() {
        return (List<Role>) roleRepository.findAllByOrderByDateModificationDesc();
    }
    
}
