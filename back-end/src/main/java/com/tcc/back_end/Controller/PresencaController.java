package com.tcc.back_end.Controller;


import com.tcc.back_end.Model.RegistroPresença;
import com.tcc.back_end.Service.PresencaService;
import org.springframework.web.bind.annotation.*;

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



}
