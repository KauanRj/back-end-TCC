package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Model.CartãoRFID;
import com.tcc.back_end.Model.Enum.StatusPresenca;
import com.tcc.back_end.Model.Enum.TipoMarcacao;
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
    private int proximoId = 1;


    public PresencaService(PresencaRepository presencarepository, AlunoRepository alunorepository) {
        this.presencarepository = presencarepository;
        this.alunorepository = alunorepository;
    }


    public String identificarAlunoPeloCartao(String uid){

        if(uid == null || uid.isBlank()){
            return "UID do cartão não informado!";
        }

        return alunorepository.identificarAlunoPeloCartao(uid);
    }

    public boolean verificarCartaoAtivo(String uid){

        if(uid == null || uid.isBlank()){
            return false;
        }

        return alunorepository.verificarCartaoAtivo(uid);
    }

    public Aluno buscarAlunoPeloCartao(String uid){

        if(uid == null || uid.isBlank()){
            return null;
        }

        return alunorepository.buscarAlunoPeloCartao(uid);
    }

    public StatusPresenca definirStatusPresença(LocalTime horario){

        if(horario == null){
            return null;
        }

        LocalTime limite = LocalTime.of(7,10);

        if(horario.isAfter(limite)){
            return StatusPresenca.ATRASADO;
        }

        return StatusPresenca.PRESENTE;
    }



    public String registrarPresenca(String uid){

        if(uid == null || uid.isBlank()){
            return "UID do cartão não informado!";
        }

        Aluno aluno = buscarAlunoPeloCartao(uid);

        if(aluno == null){
            return "Aluno não encontrado";
        }

        if(!verificarCartaoAtivo(uid)){
            return "Cartão inativo";
        }

        LocalDate data = LocalDate.now();

        if(presencarepository.verificarEntradaHoje(aluno.getId(), data)){
            return "Aluno já possui uma entrada registrada hoje!";
        }

        LocalTime horario = LocalTime.now();

        StatusPresenca status = definirStatusPresença(horario);

        RegistroPresença registro = new RegistroPresença(
                proximoId,
                data,
                horario,
                status,
                TipoMarcacao.ENTRADA,
                aluno
        );
        String resultado = RegistrarPresença(registro);

        if(resultado.equals("Registro salvo com sucesso!!")){
            proximoId++;
        }

        return resultado;
    }

    public String RegistrarPresença(RegistroPresença registroPresença){
        return presencarepository.RegistrarPresenca(registroPresença);
    }

    public List<RegistroPresença> getListaRegistro(){
        return presencarepository.getListaRegistro();
    }




}
