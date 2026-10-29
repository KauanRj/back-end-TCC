package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Sala;
import com.tcc.back_end.Model.Turma;
import com.tcc.back_end.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    private TurmaRepository turmaRepository;

    public TurmaService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
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
        return turmaRepository.updateTurma(id, turma);
    }

    public String deleteTurma(Integer id){
        return turmaRepository.deleteTurma(id);
    }
}
