package com.tcc.back_end.Model;

import com.tcc.back_end.Model.Enum.StatusSala;

public class Sala {
    private Integer numero;
    private Integer capacidade;
    private String andar;
    private StatusSala status;
    private Turma turma;

    public Sala() {
    }

    public Sala(Integer numero, Integer capacidade, String andar, StatusSala status, Turma turma) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.andar = andar;
        this.status = status;
        this.turma = turma;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public StatusSala getStatus() {
        return status;
    }

    public void setStatus(StatusSala status) {
        this.status = status;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }
}
