package com.task.repository;

import java.io.Serializable;
import java.util.List;

import  javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import  com.task.model.Tarefa;


public class Tarefas implements Serializable {

    private static final long serialVersionUID = 1L;

    private EntityManager manager;

    public Tarefas() {

    }

    public Tarefas(EntityManager manager) {
        this.manager = manager;
    }

    public  Tarefa findById(Long id) {
        return manager.find(Tarefa.class, id);
    }

    public List<Tarefa> findByTitle(String title) {
        TypedQuery<Tarefa> query = manager
                .createQuery("from Tarefa where titulo like :title", Tarefa.class);
        query.setParameter("title", "%"+title+"%");
        return query.getResultList();
    }

    public List<Tarefa> findByPriority(String priority) {
        TypedQuery<Tarefa> query = manager
                .createQuery("from Tarefa where  prioridade = :priority", Tarefa.class);
        query.setParameter("priority", priority);
        return query.getResultList();
    }

    public List<Tarefa> findAll() {
        TypedQuery<Tarefa> tarefas = manager.createQuery("SELECT f FROM Tarefa f", Tarefa.class);
        return tarefas.getResultList();
    }

    public Tarefa save(Tarefa tarefa) {
        return manager.merge(tarefa);
    }

    public void delete(Tarefa tarefa) {
        tarefa = findById(tarefa.getId());
        manager.remove(tarefa);
    }

}
