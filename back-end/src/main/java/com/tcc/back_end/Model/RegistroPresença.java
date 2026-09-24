package com.tcc.back_end.Model;

import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroPresença {
    private int id;
    private LocalDate data;
    private LocalTime horario;
    private StatusPresenca status;
    private TipoMarcacao tipo;
    private Aluno aluno;

    public RegistroPresença(int id, LocalDate data, LocalTime horario, StatusPresenca status, TipoMarcacao tipo, Aluno aluno) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.status = status;
        this.tipo = tipo;
        this.aluno = aluno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public StatusPresenca getStatus() {
        return status;
    }

    public void setStatus(StatusPresenca status) {
        this.status = status;
    }

    public TipoMarcacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoMarcacao tipo) {
        this.tipo = tipo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public StatusPresenca calcularStatus(){
        LocalTime limite = LocalTime.of(7,10);

        if(horario.isAfter(limite)){
            return StatusPresenca.ATRASADO;
        }

        return StatusPresenca.PRESENTE;
    }
}
