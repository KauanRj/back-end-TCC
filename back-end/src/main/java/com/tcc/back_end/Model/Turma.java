package com.tcc.back_end.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private Integer id;
    private String nome;
    private String curso;
    @JsonManagedReference
    private List<Aluno> alunos = new ArrayList<>();
    private String  turno;


    public Turma() {
    }

    public Turma(Integer id, String turno, String curso, String nome, List<Aluno> alunos) {
        this.id = id;
        this.turno = turno;
        this.curso = curso;
        this.nome = nome;
        this.alunos = alunos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
