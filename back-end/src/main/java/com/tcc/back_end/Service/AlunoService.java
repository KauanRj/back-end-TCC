package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlunoService {

    private AlunoRepository alunorepository;

    public AlunoService(AlunoRepository alunorepository) {
        this.alunorepository = alunorepository;
    }

    public String CadastrarAluno(Aluno aluno){
        return alunorepository.CadastrarAluno(aluno);
    }

    public List<Aluno> getListaDeAlunos(){
        return alunorepository.getListaDeAlunos();
    }
}
