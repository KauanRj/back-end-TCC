package com.tcc.back_end.Model;

import com.tcc.back_end.Model.Enum.TipoAcesso;
import java.time.LocalDateTime;

public class Perfil {

    private Integer id;
    private String nome;
    private String email;
    private String cargo;
    private String telefone;
    private String fotoPerfil;
    private TipoAcesso tipoAcesso;
    private boolean acessoAtivo;
    private LocalDateTime ultimoAcesso;
    private LocalDateTime dataCriacaoConta;
    private LocalDateTime dataAlteracaoSenha;

    public Perfil() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
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

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public LocalDateTime getDataCriacaoConta() {
        return dataCriacaoConta;
    }

    public void setDataCriacaoConta(LocalDateTime dataCriacaoConta) {
        this.dataCriacaoConta = dataCriacaoConta;
    }

    public LocalDateTime getDataAlteracaoSenha() {
        return dataAlteracaoSenha;
    }

    public void setDataAlteracaoSenha(LocalDateTime dataAlteracaoSenha) {
        this.dataAlteracaoSenha = dataAlteracaoSenha;
    }
}