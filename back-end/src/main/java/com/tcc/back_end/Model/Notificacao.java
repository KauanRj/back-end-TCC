package com.tcc.back_end.Model;

public class Notificacao {

    private boolean notificacoesSistema;
    private boolean faltasAtrasos;
    private boolean alunosEmRisco;
    private boolean novosAlunos;
    private boolean professoresAusentes;
    private boolean relatoriosEmail;

    public Notificacao() {
    }

    public Notificacao(boolean notificacoesSistema, boolean faltasAtrasos,
                       boolean alunosEmRisco, boolean novosAlunos,
                       boolean professoresAusentes, boolean relatoriosEmail) {

        this.notificacoesSistema = notificacoesSistema;
        this.faltasAtrasos = faltasAtrasos;
        this.alunosEmRisco = alunosEmRisco;
        this.novosAlunos = novosAlunos;
        this.professoresAusentes = professoresAusentes;
        this.relatoriosEmail = relatoriosEmail;
    }

    public boolean isNotificacoesSistema() {
        return notificacoesSistema;
    }

    public void setNotificacoesSistema(boolean notificacoesSistema) {
        this.notificacoesSistema = notificacoesSistema;
    }

    public boolean isFaltasAtrasos() {
        return faltasAtrasos;
    }

    public void setFaltasAtrasos(boolean faltasAtrasos) {
        this.faltasAtrasos = faltasAtrasos;
    }

    public boolean isAlunosEmRisco() {
        return alunosEmRisco;
    }

    public void setAlunosEmRisco(boolean alunosEmRisco) {
        this.alunosEmRisco = alunosEmRisco;
    }

    public boolean isNovosAlunos() {
        return novosAlunos;
    }

    public void setNovosAlunos(boolean novosAlunos) {
        this.novosAlunos = novosAlunos;
    }

    public boolean isProfessoresAusentes() {
        return professoresAusentes;
    }

    public void setProfessoresAusentes(boolean professoresAusentes) {
        this.professoresAusentes = professoresAusentes;
    }

    public boolean isRelatoriosEmail() {
        return relatoriosEmail;
    }

    public void setRelatoriosEmail(boolean relatoriosEmail) {
        this.relatoriosEmail = relatoriosEmail;
    }
}