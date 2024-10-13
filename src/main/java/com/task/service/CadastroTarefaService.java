package com.task.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.task.model.Tarefa;
import com.task.repository.Tarefas;
import com.task.util.Transacional;

public class CadastroTarefaService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Tarefas tarefas;

    @Transacional
    public void salvar(Tarefa tarefa) {
        tarefas.save(tarefa);
    }
    @Transacional
    public void excluir(Tarefa tarefa) {
        tarefas.delete(tarefa);
    }

    @Transacional
    public void concluir(Tarefa tarefa) {
        tarefas.conclude(tarefa);
    }

}