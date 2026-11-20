package com.tcc.back_end.Model;

public class ConfiguracaoRFID {

    private boolean leitorAtivo;

    public ConfiguracaoRFID() {
    }

    public ConfiguracaoRFID(boolean leitorAtivo) {
        this.leitorAtivo = leitorAtivo;
    }

    public boolean isLeitorAtivo() {
        return leitorAtivo;
    }

    public void setLeitorAtivo(boolean leitorAtivo) {
        this.leitorAtivo = leitorAtivo;
    }
}