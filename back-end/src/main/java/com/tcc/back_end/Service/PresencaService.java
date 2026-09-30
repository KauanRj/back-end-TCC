package com.tcc.back_end.Service;

import com.tcc.back_end.Model.RegistroPresença;
import com.tcc.back_end.Repository.PresencaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PresencaService {

    private PresencaRepository presencarepository;

    public PresencaService(PresencaRepository presencarepository){
        this.presencarepository = presencarepository;
    }

    public String RegistrarPresença(RegistroPresença registroPresença){
        return presencarepository.RegistrarPresenca(registroPresença);
    }

    public List<RegistroPresença> getListaRegistro(){
        return presencarepository.getListaRegistro();
   }

}
