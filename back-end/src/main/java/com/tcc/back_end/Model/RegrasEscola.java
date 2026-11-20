package com.tcc.back_end.Model;

import java.time.LocalTime;

public class RegrasEscola {

    private LocalTime horarioLimite;
    private Integer anoLetivo;
    private String turno;

    public RegrasEscola() {
    }

    public RegrasEscola(LocalTime horarioLimite, Integer anoLetivo, String turno) {
        this.horarioLimite = horarioLimite;
        this.anoLetivo = anoLetivo;
        this.turno = turno;
    }

    public LocalTime getHorarioLimite() {
        return horarioLimite;
    }

    public void setHorarioLimite(LocalTime horarioLimite) {
        this.horarioLimite = horarioLimite;
    }

    public Integer getAnoLetivo() {
        return anoLetivo;
    }

    public void setAnoLetivo(Integer anoLetivo) {
        this.anoLetivo = anoLetivo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}