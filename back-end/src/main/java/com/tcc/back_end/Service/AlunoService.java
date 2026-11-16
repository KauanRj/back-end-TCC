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
        Aluno alunoatual = alunorepository.buscarAlunoPorId(id);

        if(alunoatual == null){
            return "Aluno não encontrado! ";

        }

        if(aluno.getTurma() == null || aluno.getTurma().getId() == null){
            return "É necessário informar uma turma! ";

        }

        Turma turmaNova = turmaRepository.BuscarTurma(aluno.getTurma().getId());

        if(turmaNova == null){
            return "Turma não encontra !";

        }

        Turma turmaAntiga = alunoatual.getTurma();

        aluno.setTurma(turmaNova);

        String resultado = alunorepository.updateAluno(id, aluno);

        if(turmaAntiga == null || ! Objects.equals(turmaAntiga.getId(),turmaNova.getId())){
            if(turmaAntiga != null) {
                turmaAntiga.getAlunos().remove(alunoatual);


            }


             turmaNova.getAlunos().add(alunoatual);

        }

        return resultado;
    }

    public String deleteAluno(int id){

        Aluno aluno= alunorepository.buscarAlunoPorId(id);

        if(aluno == null){
            return "Aluno não encontrado !";
        }

        Turma turma = aluno.getTurma();

        if(turma != null){
            turma.getAlunos().remove(aluno);
        }
        return alunorepository.deleteAluno(id);
    }
}
