package com.task.model;

public enum ValorPrioridade {
    BAIXA("Baixa"),
    MEDIA( "Média"),
    ALTA( "Alta");


    private String descricao;

    ValorPrioridade(String descricao) {

        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }


}
