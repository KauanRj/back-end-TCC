package com.tcc.back_end.Model;

public class ConfiguracaoGeral {

    private String aparencia;
    private String idioma;

    public ConfiguracaoGeral() {
    }

    public ConfiguracaoGeral(String aparencia, String idioma) {
        this.aparencia = aparencia;
        this.idioma = idioma;
    }

    public String getAparencia() {
        return aparencia;
    }

    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}