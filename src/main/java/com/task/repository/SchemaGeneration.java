package com.task.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import  com.task.model.Tarefa;


public class SchemaGeneration {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TaskPU");
        EntityManager em = emf.createEntityManager();

        List<Tarefa> lista = em.createQuery("from Tarefa", Tarefa.class)
                .getResultList();

        System.out.println(lista);

        em.close();
        emf.close();
    }
}
