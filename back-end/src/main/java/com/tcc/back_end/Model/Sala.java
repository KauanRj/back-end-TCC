package com.tcc.back_end.Model;

import com.tcc.back_end.Model.Enum.StatusSala;

import java.util.ArrayList;
import java.util.List;

public class Sala {
    private Integer numero;
    private Integer capacidade;
    private String andar;
    private StatusSala status;
    private List<Turma> turmas = new ArrayList<>();

    public Sala() {
    }

    public Sala(Integer numero, Integer capacidade, String andar, StatusSala status, List<Turma> turmas) {
        this.numero = numero;
        this.capacidade = capacidade;
        this.andar = andar;
        this.status = status;
        this.turmas = turmas;
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

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
