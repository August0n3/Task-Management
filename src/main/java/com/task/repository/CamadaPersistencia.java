package com.task.repository;

import com.task.model.Funcionario;
import com.task.model.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;

public class CamadaPersistencia {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TaskPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Declarando os reps para teste
        Funcionarios funcionarios = new Funcionarios(em); // Passando o EntityManager
        Tarefas tarefas = new Tarefas(em); // Passando o EntityManager

        // Criando um funcionario
        Funcionario augusto = new Funcionario();
        augusto.setNome("Augusto");

        // Criando uma tarefa
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setTitulo("Tarefa 1");
        tarefa1.setDescricao("Tarefa 1");
        tarefa1.setFuncionario(augusto);
        tarefa1.setPrioridade((short) 1);
        tarefa1.setDeadLine(new Date(20241212));

        // Salvando funcionario
        funcionarios.save(augusto);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
