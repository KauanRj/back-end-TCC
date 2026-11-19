package com.tcc.back_end.Model;

import com.tcc.back_end.Model.Enum.TipoAcesso;

import java.time.LocalDate;

public class Team {

    private Integer id;
    private String matricula;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private String status;
    private String tipoVinculo;
    private String cargo;
    private String setor;
    private LocalDate dataAdmissao;
    private int jornadaSemanal;
    private String telefone;
    private String email;
    private String endereco;
    private String senha;
    private TipoAcesso tipoAcesso;
    private boolean acessoAtivo;

    public Team() {
    }

    public Team(Integer id, String matricula, String nome, LocalDate dataNascimento, String cpf, String status, String cargo, String tipoVinculo, String setor, LocalDate dataAdmissao, String telefone, int jornadaSemanal, String email, String endereco, String senha, TipoAcesso tipoAcesso, boolean acessoAtivo) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.status = status;
        this.cargo = cargo;
        this.tipoVinculo = tipoVinculo;
        this.setor = setor;
        this.dataAdmissao = dataAdmissao;
        this.telefone = telefone;
        this.jornadaSemanal = jornadaSemanal;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
        this.tipoAcesso = tipoAcesso;
        this.acessoAtivo = acessoAtivo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoVinculo() {
        return tipoVinculo;
    }

    public void setTipoVinculo(String tipoVinculo) {
        this.tipoVinculo = tipoVinculo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public int getJornadaSemanal() {
        return jornadaSemanal;
    }

    public void setJornadaSemanal(int jornadaSemanal) {
        this.jornadaSemanal = jornadaSemanal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoAcesso getTipoAcesso() {
        return tipoAcesso;
    }

    public void setTipoAcesso(TipoAcesso tipoAcesso) {
        this.tipoAcesso = tipoAcesso;
    }

    public boolean isAcessoAtivo() {
        return acessoAtivo;
    }

    public void setAcessoAtivo(boolean acessoAtivo) {
        this.acessoAtivo = acessoAtivo;
    }
}
