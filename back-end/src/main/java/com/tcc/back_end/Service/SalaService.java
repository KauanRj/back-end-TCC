package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Sala;
import com.tcc.back_end.Model.Turma;
import com.tcc.back_end.Repository.SalaRepository;
import com.tcc.back_end.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

        if( sala.getTurmas() == null  || sala.getTurmas().isEmpty()){
            return "É necessário informar uma turma!";
        }

        List<Turma> turmasValidas = new ArrayList<>();

        for (Turma turmaInformada : sala.getTurmas()){
            if (turmaInformada.getId() == null){
                return "É necessário informa o id da turma! ";
            }

            Turma turma = turmaRepository.BuscarTurma(turmaInformada.getId());

            if (turma == null ){
                return "Turma não encontrada";
            }

            for(Turma turmaExistente : turmasValidas){
                if (turmaExistente.getTurno().equalsIgnoreCase(turma.getTurno())){
                    return "Já existe turma cadastrada nesse turno";
                }
            }

            for(Sala salaExistente : salaRepository.getListaDeSala()){
                for (Turma turmaExistente : salaExistente.getTurmas()){
                    if (turmaExistente.getId().equals(turma.getId())){
                        return "Essa turma ja esta associada a outra sala";
                    }
                }
            }
            turmasValidas.add(turma);
        }

       sala.setTurmas(turmasValidas);


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
