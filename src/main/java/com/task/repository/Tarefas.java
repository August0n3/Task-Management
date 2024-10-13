package com.task.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import  javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import  com.task.model.Tarefa;
import com.task.model.ValorPrioridade;


public class Tarefas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public Tarefas() {

    }

    public Tarefas(EntityManager manager) {
        this.manager = manager;
    }

    public List<Tarefa> findById(Long id) {
        TypedQuery<Tarefa> query = manager
                .createQuery("from Tarefa where id = :id", Tarefa.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Tarefa> findByTitle(String title) {
        TypedQuery<Tarefa> query = manager
                .createQuery("from Tarefa where titulo like :title", Tarefa.class);
        query.setParameter("title", "%"+title+"%");
        return query.getResultList();
    }

    public List<Tarefa> findByPriority(ValorPrioridade priority) {
        TypedQuery<Tarefa> query = manager
                .createQuery("from Tarefa where prioridade = :priority and situacao = false", Tarefa.class);
        query.setParameter("priority", priority);
        return query.getResultList();
    }

    public List<Tarefa> findBySituation(boolean situation) {
        TypedQuery<Tarefa> query = manager
                .createQuery("from Tarefa where situacao = :situation", Tarefa.class);
        query.setParameter("situation", situation);
        return query.getResultList();
    }

    public List<Tarefa> findByFunc(String funcionarioId) {
        TypedQuery<Tarefa> query = manager
                .createQuery("from Tarefa  where funcionario = :funcionarioId and situacao = false", Tarefa.class);
        query.setParameter("funcionarioId", funcionarioId);
        return query.getResultList();
    }
    public List<Tarefa> findAll() {
        TypedQuery<Tarefa> tarefas = manager.createQuery("from Tarefa", Tarefa.class);
        return tarefas.getResultList();
    }

    public Tarefa save(Tarefa tarefa) {
        return manager.merge(tarefa);
    }

    public void delete(Tarefa tarefa) {
        tarefa = findById(tarefa.getId()).get(0);
        manager.remove(tarefa);
    }

    public Tarefa conclude(Tarefa tarefa){
        tarefa = findById(tarefa.getId()).get(0);
        tarefa.setSituacao(true);
        return manager.merge(tarefa);
    }

}
