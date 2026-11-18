package com.tcc.back_end.Repository;

import com.tcc.back_end.Model.Aluno;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AlunoRepository {

    private List<Aluno> listaDeAlunos = new ArrayList<>();



    public String CadastrarAluno(Aluno aluno){
        this.listaDeAlunos.add(aluno);

        return "Aluno cadastrado!!";
    }

    public List<Aluno> getListaDeAlunos(){
        return listaDeAlunos;
    }


    public Aluno buscarAlunoPorId(int id){
        for (Aluno a : listaDeAlunos){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    public Aluno buscarAlunoPorCpf(String cpf){

        for(Aluno a : listaDeAlunos){

            if(a.getCpf() != null && a.getCpf().equals(cpf)){
                return a;
            }
        }

        return null;
    }

    public Aluno buscarAlunoPorMatricula(String matricula){

        for(Aluno a : listaDeAlunos){

            if(a.getMatricula() != null && a.getMatricula().equals(matricula)){
                return a;
            }
        }

        return null;
    }

    public String updateAluno(int id,Aluno alunoUpdate){

        if(alunoUpdate == null){
            return "Os dados do aluno não foram informados!";
        }
        for (Aluno a : listaDeAlunos){
            if(a.getId() == id) {

                a.setNome(alunoUpdate.getNome());
                a.setMatricula(alunoUpdate.getMatricula());
                a.setDataNascimento(alunoUpdate.getDataNascimento());
                a.setCartao(alunoUpdate.getCartao());
                a.setCpf(alunoUpdate.getCpf());
                a.setTurma(alunoUpdate.getTurma());
                a.setTurno(alunoUpdate.getTurno());
                a.setResponsasvelNome(alunoUpdate.getResponsasvelNome());
                a.setParentesco(alunoUpdate.getParentesco());
                a.setResponsavelTelefone(alunoUpdate.getResponsavelTelefone());
                a.setResponsavelEmail(alunoUpdate.getResponsavelEmail());
                a.setEndereco(alunoUpdate.getEndereco());
                a.setDataMatricula(alunoUpdate.getDataMatricula());

                return "Dados do aluno atualizados com sucesso!";

            }
        }
        return "Aluno não encontrado!";
    }

    public String deleteAluno(int id){

        boolean removido = listaDeAlunos.removeIf(
                aluno -> aluno.getId() == id
        );

        if(removido){
            return "Aluno deletado com sucesso!";
        }

        return "Aluno não encontrado!";
    }




    public String identificarAlunoPeloCartao(String uid){

        for (Aluno a : listaDeAlunos) {

            if(a.getCartao() != null &&
                    Objects.equals(a.getCartao().getUid(), uid)){

                return a.getNome();
            }
        }

        return "Aluno não encontrado";
    }

    public Aluno buscarAlunoPeloCartao(String uid){

        for (Aluno a : listaDeAlunos) {

            if(a.getCartao() != null &&
                    Objects.equals(a.getCartao().getUid(), uid)){

                return a;
            }
        }

        return null;
    }

    public boolean verificarCartaoAtivo(String uid){

        for (Aluno a : listaDeAlunos) {

            if(a.getCartao() != null &&
                    Objects.equals(a.getCartao().getUid(), uid)){

                return a.getCartao().isAtivo();
            }
        }

        return false;
    }

}
