package com.tcc.back_end.Model;

public class CartãoRFID {

    private String uid;
    private boolean ativo;


    public CartãoRFID() {
    }

    public CartãoRFID(String uid, boolean ativo) {
        this.uid = uid;
        this.ativo = ativo;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public void ativar(){
        this.ativo = true;
    }

    public void desativar(){
        this.ativo = false;
    }
}
