package com.tcc.back_end.Model;

import java.util.List;

public class Turma {
    private Integer id;
    private String nome;
    private String curso;
    private List<Aluno> alunos;

    public Turma() {
    }

    public Turma(Integer id, String nome, String curso, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
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
}
