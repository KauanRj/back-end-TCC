package com.tcc.back_end.Repository;

import com.tcc.back_end.Model.RegistroPresença;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PresencaRepository {

    private List<RegistroPresença> listaRegistro = new ArrayList<>();



    public String RegistrarPresenca(RegistroPresença registroPresença){
        this.listaRegistro.add(registroPresença);

        return "Registro salvo com sucesso!!";
    }

    public List<RegistroPresença> getListaRegistro(){
        return listaRegistro;
    }

}
