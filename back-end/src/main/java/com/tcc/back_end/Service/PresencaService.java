package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Model.CartãoRFID;
import com.tcc.back_end.Model.Enum.StatusPresenca;
import com.tcc.back_end.Model.RegistroPresença;
import com.tcc.back_end.Repository.AlunoRepository;
import com.tcc.back_end.Repository.PresencaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    public Aluno buscarAlunoPeloCartao(String uid){
        return alunorepository.buscarAlunoPeloCartao(uid);
    }

    public String registrarPresenca(String uid){
        Aluno aluno = buscarAlunoPeloCartao(uid);

        if (aluno == null){
            return "Aluno não encontrado";

        }

        if (!verificarCartaoAtivo(uid)) {
            return "Cartão inativo";
        }
        return "cartão ativo";

        LocalDate data = LocalDate.now();
        LocalTime horario = LocalTime.now();
        StatusPresenca status = definirStatusPresença(horario);


    }

    public String RegistrarPresença(RegistroPresença registroPresença){
        return presencarepository.RegistrarPresenca(registroPresença);
    }

    public List<RegistroPresença> getListaRegistro(){
        return presencarepository.getListaRegistro();
    }




}
