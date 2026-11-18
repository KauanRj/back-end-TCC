package com.tcc.back_end.Repository;

import com.tcc.back_end.Model.Enum.TipoMarcacao;
import com.tcc.back_end.Model.RegistroPresença;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class PresencaRepository {

    private List<RegistroPresença> listaRegistro = new ArrayList<>();



    public String RegistrarPresenca(RegistroPresença registroPresença){

        if(registroPresença == null){
            return "O registro de presença não foi informado!";
        }

        if(registroPresença.getAluno() == null){
            return "É necessário informar o aluno!";
        }

        if(registroPresença.getData() == null ||
                registroPresença.getHorario() == null ||
                registroPresença.getTipo() == null ||
                registroPresença.getStatus() == null){

            return "Existem dados obrigatórios ausentes no registro!";
        }

        this.listaRegistro.add(registroPresença);

        return "Registro salvo com sucesso!!";
    }

    public List<RegistroPresença> getListaRegistro(){
        return new ArrayList<>(listaRegistro);
    }


    public boolean verificarEntradaHoje(Integer idAluno, LocalDate data){

        if(idAluno == null || data == null){
            return false;
        }

        for(RegistroPresença registro : listaRegistro){

            if(registro == null || registro.getAluno() == null){
                continue;
            }

            if(registro.getData() == null || registro.getTipo() == null){
                continue;
            }

            if(registro.getAluno().getId() == idAluno
                    && registro.getData().equals(data)
                    && registro.getTipo() == TipoMarcacao.ENTRADA){

                return true;
            }
        }

        return false;
    }


}
