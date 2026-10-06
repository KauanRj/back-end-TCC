package com.tcc.back_end.Repository;

import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Model.RegistroPresença;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AlunoRepository {

    private List<Aluno> listaDeAlunos;

    public AlunoRepository(List<Aluno> listaDeAlunos) {
        this.listaDeAlunos = listaDeAlunos;
    }

    public String CadastrarAluno(Aluno aluno){
        this.listaDeAlunos.add(aluno);

        return "Aluno cadastrado!!";
    }

    public List<Aluno> getListaDeAlunos(){
        return listaDeAlunos;
    }
}
