package com.tcc.back_end.Model;

import java.time.LocalDate;
import java.time.Period;

public class Aluno {

    private int id;
    private String nome;
    private String matricula;
    private LocalDate dataNascimento;
    private CartãoRFID cartao;


    public Aluno() {
    }

    public Aluno(int id, String nome, String matricula, LocalDate dataNascimento, CartãoRFID cartao) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.dataNascimento = dataNascimento;
        this.cartao = cartao;
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

    public CartãoRFID getCartao() {
        return cartao;
    }

    public void setCartao(CartãoRFID cartao) {
        this.cartao = cartao;
    }

    public int calcularIdade(){
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }
}
