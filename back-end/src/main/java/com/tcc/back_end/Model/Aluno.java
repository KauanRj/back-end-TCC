package com.tcc.back_end.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.time.LocalDate;
import java.time.Period;

public class Aluno {

    private int id;
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;
    private CartãoRFID cartao;
    private String cpf;
    @JsonBackReference
    private Turma turma;
    private String turno;
    private String responsasvelNome;
    private String parentesco;
    private String responsavelTelefone;
    private String responsavelEmail;
    private String endereco;
    private LocalDate dataMatricula;



    public Aluno() {
    }

    public Aluno(int id, String nome, String matricula, LocalDate dataNascimento, CartãoRFID cartao, String cpf, Turma turma, String turno, String responsasvelNome, String parentesco, String responsavelEmail, String responsavelTelefone, String endereco, LocalDate dataMatricula) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.cartao = cartao;
        this.cpf = cpf;
        this.turma = turma;
        this.turno = turno;
        this.responsasvelNome = responsasvelNome;
        this.parentesco = parentesco;
        this.responsavelEmail = responsavelEmail;
        this.responsavelTelefone = responsavelTelefone;
        this.endereco = endereco;
        this.dataMatricula = dataMatricula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public CartãoRFID getCartao() {
        return cartao;
    }

    public void setCartao(CartãoRFID cartao) {
        this.cartao = cartao;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getResponsasvelNome() {
        return responsasvelNome;
    }

    public void setResponsasvelNome(String responsasvelNome) {
        this.responsasvelNome = responsasvelNome;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getResponsavelTelefone() {
        return responsavelTelefone;
    }

    public void setResponsavelTelefone(String responsavelTelefone) {
        this.responsavelTelefone = responsavelTelefone;
    }

    public String getResponsavelEmail() {
        return responsavelEmail;
    }

    public void setResponsavelEmail(String responsavelEmail) {
        this.responsavelEmail = responsavelEmail;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public int calcularIdade(){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
