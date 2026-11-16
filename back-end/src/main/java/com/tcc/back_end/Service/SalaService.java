package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Sala;
import com.tcc.back_end.Model.Turma;
import com.tcc.back_end.Repository.SalaRepository;
import com.tcc.back_end.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private SalaRepository salaRepository;
    private TurmaRepository turmaRepository;

    public SalaService(SalaRepository salaRepository, TurmaRepository turmaRepository) {
        this.salaRepository = salaRepository;
        this.turmaRepository = turmaRepository;
    }

    public String CadastrarSala(Sala sala){

        if( sala.getTurma() == null || sala.getTurma().getId() == null){
            return "É necessário informar uma turma!";
        }

        Turma turma = turmaRepository.BuscarTurma(sala.getTurma().getId());

        if(turma == null){
            return "turma não encontrada!";
        }

       sala.setTurma(turma);


        return salaRepository.CadrastarSala(sala);
    }

    public List<Sala> getListaDeSala(){
        return salaRepository.getListaDeSala();
    }

    public Sala BuscarSala(Integer numero){
        return salaRepository.BuscarSala(numero);
    }

    public String updateSala(Integer numero, Sala sala){
        return salaRepository.updateSala(numero,sala);
    }

    public String deleteSala(Integer numero){
        return salaRepository.deleteSala(numero);
    }
}
