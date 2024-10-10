package com.task.repository;

import com.task.model.Funcionario;
import com.task.model.Tarefa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.Calendar;

public class CamadaPersistencia {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TaskPU");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Declarando os reps para teste
        Funcionarios funcionarios = new Funcionarios(em); // Passando o EntityManager
        Tarefas tarefas = new Tarefas(em); // Passando o EntityManager

        // Criando um funcionario
        Funcionario funcionario = funcionarios.findById(3L);

        // Criando uma tarefa
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setTitulo("Tarefa 1");
        tarefa1.setDescricao("Tarefa 1");
        tarefa1.setFuncionario(funcionario);
        tarefa1.setPrioridade((short) 1);
        Calendar date = Calendar.getInstance();
        date.set(2024,Calendar.DECEMBER,12);
        tarefa1.setDeadLine(date);

        // Salvando funcionario
        tarefas.save(tarefa1);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
