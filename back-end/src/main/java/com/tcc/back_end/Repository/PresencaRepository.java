package com.tcc.back_end.Repository;

import com.tcc.back_end.Model.RegistroPresença;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PresencaRepository {

    private List<RegistroPresença> listaRegistro;

    public PresencaRepository(List<RegistroPresença> listaRegistro) {
        this.listaRegistro = listaRegistro;
    }

    public String RegistrarPresenca(RegistroPresença registroPresença){
        this.listaRegistro.add(registroPresença);

        return "Registro salvo!!";
    }

    public List<RegistroPresença> getListaRegistro(){
        return listaRegistro;
    }
}
