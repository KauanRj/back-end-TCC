package com.tcc.back_end.Controller;


import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/edu")
public class AlunoController {

    private AlunoService alunoservice;

    public AlunoController(AlunoService alunoservice) {
        this.alunoservice = alunoservice;
    }

    @PostMapping("/cads")
    public String CadastrarAluno(@RequestBody Aluno aluno){
        return alunoservice.CadastrarAluno(aluno);
    }

    @GetMapping("/listaln")
    public List<Aluno> getListaDeAlunos(){
        return alunoservice.getListaDeAlunos();
    }
}
