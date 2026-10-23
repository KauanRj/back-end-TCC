package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Model.CartãoRFID;
import com.tcc.back_end.Model.Enum.StatusPresenca;
import com.tcc.back_end.Model.RegistroPresença;
import com.tcc.back_end.Repository.AlunoRepository;
import com.tcc.back_end.Repository.PresencaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
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


    public boolean verificarCartaoAtivo(String uid){
        return alunorepository.verificarCartaoAtivo(uid);
    }

    public StatusPresenca definirStatusPresença(LocalTime horario){
        LocalTime limite = LocalTime.of(7,10);

        if(horario.isAfter(limite)){
            return StatusPresenca.ATRASADO;
        }

        return StatusPresenca.PRESENTE;
    }

}
