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

    public String identificarAlunoPeloCartao(String uid){
        for (Aluno a : listaDeAlunos) {
            if (a.getCartao().getUid().equals(uid)) {
                return a.getNome();
            }

        }
        return "Aluno não encotrado";
    }
}
