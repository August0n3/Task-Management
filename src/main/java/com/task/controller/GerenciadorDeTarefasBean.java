package com.task.controller;

import com.task.model.ValorPrioridade;
import com.task.repository.Tarefas;
import com.task.model.Tarefa;
import com.task.service.CadastroTarefaService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class GerenciadorDeTarefasBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Tarefas tarefas;

    @Inject
    private CadastroTarefaService cadastroTarefaService;

    private List<String> listaFuncionarios = new ArrayList<>(Arrays.asList(
            "Augusto",
            "Alefe",
            "Cauan",
            "Francisco",
            "Maicon",
            "Dehon",
            "Samuel"
    ));



    private List<Tarefa> listaTarefas;

    private Tarefa tarefa;



    private boolean termoPesquisaSituacao;
    private String termoPesquisaTitulo;
    private ValorPrioridade termoPesquisaPrioridade;
    private Long termoPesquisaId;
    private String termoPesquisaFuncionario;


    public void prepararNovaTarefa() {
        tarefa = new Tarefa();
    }

    public void salvar(){
        cadastroTarefaService.salvar(tarefa);
        atualizarRegistros();
    }
    public void concluir(){
        cadastroTarefaService.concluir(tarefa);
    }

    public void excluir(){
        cadastroTarefaService.excluir(tarefa);
        tarefa = null;
        atualizarRegistros();

    }

    public void pesquisaTitulo(){

        listaTarefas = tarefas.findByTitle(termoPesquisaTitulo);
    }

    public void pesquisaFuncionario(){
        listaTarefas = tarefas.findByFunc(termoPesquisaFuncionario);
    }

    public void pesquisaPrioridade(){
        listaTarefas = tarefas.findByPriority(termoPesquisaPrioridade);
    }

    public void pesquisaSituacao(){
        listaTarefas = tarefas.findBySituation(termoPesquisaSituacao);

    }

    public void pesquisaId(){
        listaTarefas = tarefas.findById(termoPesquisaId);
    }

    public void todasTarefas() {
        listaTarefas = tarefas.findBySituation(false);
    }


    public List<Tarefa> getListaTarefas() {
        return listaTarefas;
    }

    public String getTermoPesquisaTitulo() {
        return termoPesquisaTitulo;
    }

    public void setTermoPesquisaTitulo(String termoPesquisaTitulo) {
        this.termoPesquisaTitulo = termoPesquisaTitulo;
    }

    public boolean getTermoPesquisaSituacao() {
        return termoPesquisaSituacao;
    }

    public void setTermoPesquisaSituacao(boolean termoPesquisaSituacao) {
        this.termoPesquisaSituacao = termoPesquisaSituacao;
    }

    public ValorPrioridade getTermoPesquisaPrioridade() {
        return termoPesquisaPrioridade;
    }

    public void setTermoPesquisaPrioridade(ValorPrioridade termoPesquisaPrioridade) {
        this.termoPesquisaPrioridade = termoPesquisaPrioridade;
    }

    public Long getTermoPesquisaId() {
        return termoPesquisaId;
    }

    public void setTermoPesquisaId(Long termoPesquisaId) {
        this.termoPesquisaId = termoPesquisaId;
    }

    public ValorPrioridade[] getPrioridades() {
        return ValorPrioridade.values();
    }


    public void setTarefa(Tarefa tarefa) {
        this.tarefa= tarefa;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public String  getTermoPesquisaFuncionario() {
        return termoPesquisaFuncionario;
    }

    public void setTermoPesquisaFuncionario(String termoPesquisaFuncionario) {
        this.termoPesquisaFuncionario = termoPesquisaFuncionario;
    }

    public boolean isTarefaSelecionada(){
        return tarefa !=null && tarefa.getId() !=null;
    }

    public void atualizarRegistros(){
        todasTarefas();
    }

    public List<String> getListaFuncionarios() {
        return listaFuncionarios;
    }

}

