package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Model.RegistroPresença;
import com.tcc.back_end.Repository.AlunoRepository;
import com.tcc.back_end.Repository.PresencaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class PresencaService {

    private PresencaRepository presencarepository;
    private AlunoRepository alunorepository;

    public PresencaService(PresencaRepository presencarepository, AlunoRepository alunorepository) {
        this.presencarepository = presencarepository;
        this.alunorepository = alunorepository;
    }

    public String RegistrarPresença(RegistroPresença registroPresença){
        return presencarepository.RegistrarPresenca(registroPresença);
    }

    public List<RegistroPresença> getListaRegistro(){
        return presencarepository.getListaRegistro();
   }

   public String identificarAlunoPeloCartao(String uid){
        return alunorepository.identificarAlunoPeloCartao(uid);
   }


}
