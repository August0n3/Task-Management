package com.task.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.inject.Inject;
import javax.persistence.TypedQuery;

import com.task.model.Funcionario;

public class Funcionarios implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Funcionarios() {
    }

    public Funcionarios(EntityManager manager) {
        this.manager = manager;
    }

    public Funcionario findById(Long id) {
        return manager.find(Funcionario.class, id);
    }

    public List<Funcionario> findAll() {
        TypedQuery<Funcionario> funcionarios = manager.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
        return funcionarios.getResultList();
    }

    public void save(Funcionario funcionario) {
        manager.merge(funcionario);
    }

    public void delete(Funcionario funcionario) {
        funcionario = findById(funcionario.getId());
        manager.remove(funcionario);
    }
}