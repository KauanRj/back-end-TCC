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

        if(aluno.getId() == 0){
            return "É necessário informar o ID do aluno!";
        }

        if(alunorepository.buscarAlunoPorId(aluno.getId()) != null){
            return "Já existe um aluno com esse ID!";
        }

        if(aluno.getCpf() == null || aluno.getCpf().isBlank()){
            return "É necessário informar o CPF!";
        }

        if(alunorepository.buscarAlunoPorCpf(aluno.getCpf()) != null){
            return "Esse CPF já está cadastrado para outro aluno!";
        }

        if(aluno.getMatricula() == null || aluno.getMatricula().isBlank()){
            return "É necessário informar a matrícula!";
        }

        if(alunorepository.buscarAlunoPorMatricula(aluno.getMatricula()) != null){
            return "Essa matrícula já está cadastrada para outro aluno!";
        }

        if(aluno.getCartao() == null || aluno.getCartao().getUid() == null || aluno.getCartao().getUid().isBlank()){
            return "É necessário informar um cartão RFID válido!";
        }

        if(alunorepository.buscarAlunoPeloCartao(aluno.getCartao().getUid()) != null){
            return "Esse cartão RFID já está cadastrado para outro aluno!";
        }

        if (aluno.getTurma() == null || aluno.getTurma().getId() == null){
            return "É necessário informar uma turma!";
        }

        Turma turma = turmaRepository.BuscarTurma(aluno.getTurma().getId());

        if(turma == null){
            return "Turma não encontrada!";
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
            return "Aluno não encontrado!";
        }

        if(aluno.getCpf() == null || aluno.getCpf().isBlank()){
            return "É necessário informar o CPF!";
        }

        Aluno alunoCpf = alunorepository.buscarAlunoPorCpf(aluno.getCpf());

        if(alunoCpf != null && alunoCpf.getId() != id){
            return "Esse CPF já está cadastrado para outro aluno!";
        }

        if(aluno.getMatricula() == null || aluno.getMatricula().isBlank()){
            return "É necessário informar a matrícula!";
        }

        Aluno alunoMatricula = alunorepository.buscarAlunoPorMatricula(aluno.getMatricula());

        if(alunoMatricula != null && alunoMatricula.getId() != id){
            return "Essa matrícula já está cadastrada para outro aluno!";
        }

        if(aluno.getCartao() == null || aluno.getCartao().getUid() == null || aluno.getCartao().getUid().isBlank()){
            return "É necessário informar um cartão RFID válido!";
        }

        Aluno alunoCartao = alunorepository.buscarAlunoPeloCartao(aluno.getCartao().getUid());

        if(alunoCartao != null && alunoCartao.getId() != id){
            return "Esse cartão RFID já está cadastrado para outro aluno!";
        }

        if(aluno.getTurma() == null || aluno.getTurma().getId() == null){
            return "É necessário informar uma turma!";
        }

        Turma turmaNova = turmaRepository.BuscarTurma(aluno.getTurma().getId());

        if(turmaNova == null){
            return "Turma não encontrada!";
        }

        Turma turmaAntiga = alunoatual.getTurma();

        aluno.setTurma(turmaNova);

        String resultado = alunorepository.updateAluno(id, aluno);

        if(turmaAntiga == null || !Objects.equals(turmaAntiga.getId(), turmaNova.getId())){

            if(turmaAntiga != null){
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
