package com.tcc.back_end.Controller;


import com.tcc.back_end.Model.Aluno;
import com.tcc.back_end.Service.AlunoService;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/edu")
public class AlunoController {

    private AlunoService alunoservice;

    public AlunoController(AlunoService alunoservice) {
        this.alunoservice = alunoservice;
    }

    @PostMapping("/cadsaln")
    public String CadastrarAluno(@RequestBody Aluno aluno){
        return alunoservice.CadastrarAluno(aluno);
    }

    @GetMapping("/listaln")
    public List<Aluno> getListaDeAlunos(){
        return alunoservice.getListaDeAlunos();
    }


    @GetMapping("/encaln/{id}")
    public Aluno buscarAlunoPorId(@PathVariable int id){
        return alunoservice.buscarAlunoPorId(id);
    }

    @PutMapping("/updatealn/{id}")
    public String updateAluno(@PathVariable int id,@RequestBody Aluno aluno){
        return alunoservice.updateAluno(id, aluno);
    }

    @DeleteMapping("/deletealn/{id}")
    public String deleteAluno(@PathVariable int id){
        return alunoservice.deleteAluno(id);
    }






}
