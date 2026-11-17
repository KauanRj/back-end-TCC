package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Sala;
import com.tcc.back_end.Model.Turma;
import com.tcc.back_end.Repository.SalaRepository;
import com.tcc.back_end.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    private TurmaRepository turmaRepository;
    private SalaRepository salaRepository;

    public TurmaService(TurmaRepository turmaRepository, SalaRepository salaRepository) {
        this.turmaRepository = turmaRepository;
        this.salaRepository = salaRepository;
    }

    public String CadastrarTurma(Turma turma){
        return turmaRepository.CadastrarTurma(turma);
    }

    public List<Turma> getListaDeTurma(){
        return turmaRepository.getListaDeTurma();
    }

    public Turma BuscarTurma(Integer id){
        return turmaRepository.BuscarTurma(id);
    }

    public String updateTurma(Integer id, Turma turma){

        Turma turmaAtual = turmaRepository.BuscarTurma(id);

        if(turmaAtual == null){
            return "Turma não encontrada!";
        }

        if(turma.getTurno() == null || turma.getTurno().isBlank()){
            return "É necessário informar o turno!";
        }

        for(Sala sala : salaRepository.getListaDeSala()){

            for(Turma turmaSala : sala.getTurmas()){

                if(turmaSala.getId().equals(id)){
                    continue;
                }

                if(turmaSala.getTurno() != null &&
                        turmaSala.getTurno().equalsIgnoreCase(turma.getTurno())){

                    return "Já existe outra turma nesse turno nesta sala!";
                }
            }
        }

        return turmaRepository.updateTurma(id, turma);
    }

    public String deleteTurma(Integer id){
        return turmaRepository.deleteTurma(id);
    }
}
