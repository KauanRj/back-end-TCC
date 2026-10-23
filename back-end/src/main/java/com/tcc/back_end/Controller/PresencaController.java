package com.tcc.back_end.Controller;


import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Model.Enum.StatusPresenca;
import com.tcc.back_end.Model.RegistroPresença;
import com.tcc.back_end.Service.PresencaService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.*;
@RestController
@RequestMapping("/edu")
public class PresencaController {

    private PresencaService presencaService;

    public PresencaController(PresencaService presencaService){
        this.presencaService = presencaService;
    }

    @PostMapping("/reg")
    public String RegistrarPresenca(@RequestBody RegistroPresença registroPresença){
        return presencaService.RegistrarPresença(registroPresença);
    }

    @GetMapping("/listpres")
    public List<RegistroPresença> getListaRegistro(){ return presencaService.getListaRegistro();}

    @GetMapping("/enc/{uid}")
    public String identificarAlunoPeloCartao(@PathVariable String uid){
        return presencaService.identificarAlunoPeloCartao(uid);
    }

    @GetMapping("/verificar/{uid}")
    public boolean verificarCartaoAtivo(@PathVariable String uid){
        return presencaService.verificarCartaoAtivo(uid);
    }

    @GetMapping("/hr/{horario}")
    public StatusPresenca definirStatusPresença(@PathVariable LocalTime horario){
        return presencaService.definirStatusPresença(horario);
    }




}
