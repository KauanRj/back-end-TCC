package com.tcc.back_end.Repository;

import com.tcc.back_end.Model.Turma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TurmaRepository {

    private List<Turma> listaDeTurma = new ArrayList<>();

    public List<Turma> getListaDeTurma() {
        return listaDeTurma;
    }

    public String CadastrarTurma(Turma turma){
        this.listaDeTurma.add(turma);

        return "Turma cadastrada com sucesso!";
    }


    public Turma BuscarTurma(Integer id){

        if(id == null){
            return null;
        }

        for (Turma t : listaDeTurma){

            if(t.getId() != null && t.getId().equals(id)){
                return t;
            }
        }

        return null;
    }


    public String updateTurma(Integer id, Turma turmaUpdate){

        if(id == null || turmaUpdate == null){
            return "É necessário informar os dados da turma!";
        }

        for(Turma t: listaDeTurma){
            if (t.getId().equals(id)){

                t.setCurso(turmaUpdate.getCurso());
                t.setNome(turmaUpdate.getNome());
                t.setTurno(turmaUpdate.getTurno());

                return "Dados da turma atualizados!";
            }
        }
        return "Turma não encontrada.";
    }

    public String deleteTurma(Integer id){

        if(id == null){
            return "É necessário informar o ID da turma!";
        }

        boolean removida = listaDeTurma.removeIf(
                turma -> turma.getId() != null &&
                        turma.getId().equals(id)
        );

        if(removida){
            return "Turma deletada com sucesso!";
        }

        return "Turma não encontrada!";
    }
}
