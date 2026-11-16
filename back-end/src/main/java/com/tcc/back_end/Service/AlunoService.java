package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Model.Turma;
import com.tcc.back_end.Repository.AlunoRepository;
import com.tcc.back_end.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlunoService {

    private AlunoRepository alunorepository;
    private TurmaRepository turmaRepository;

    public AlunoService(AlunoRepository alunorepository, TurmaRepository turmaRepository) {
        this.alunorepository = alunorepository;
        this.turmaRepository = turmaRepository;
    }

    public String CadastrarAluno(Aluno aluno){

        if (aluno.getTurma() == null || aluno.getTurma().getId() == null){
            return "É necessario informar uma turma!";
        }

        Turma turma = turmaRepository.BuscarTurma(aluno.getTurma().getId());

        if(turma == null){
            return "turma não encontrada!";
        }

        aluno.setTurma(turma);

        turma.getAlunos().add(aluno);

        return alunorepository.CadastrarAluno(aluno);
    }

    public List<Aluno> getListaDeAlunos(){
        return alunorepository.getListaDeAlunos();
    }

    public Aluno buscarAlunoPorId(int id){
        return alunorepository.buscarAlunoPorId(id);
    }

    public String updateAluno(int id, Aluno aluno){


        return alunorepository.updateAluno(id, aluno);
    }

    public String deleteAluno(int id){
        return alunorepository.deleteAluno(id);
    }
}
