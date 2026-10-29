package com.tcc.back_end.Controller;

import com.tcc.back_end.Model.Sala;
import com.tcc.back_end.Model.Turma;
import com.tcc.back_end.Service.TurmaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edu")
public class TurmaController {

    private TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @PostMapping("/cadturma")
    public String CadastrarTurma(@RequestBody Turma turma){
        return turmaService.CadastrarTurma(turma);
    }

    @GetMapping("/listturma")
    public List<Turma> getListaDeTurma(){
        return turmaService.getListaDeTurma();
    }

    @GetMapping("/encturma/{id}")
    public Turma BuscarTurma(@PathVariable Integer id){
        return turmaService.BuscarTurma(id);
    }

    @PutMapping("/updateturma/{id}")
    public String updateTurma(@PathVariable Integer id,@RequestBody Turma turma){
        return turmaService.updateTurma(id, turma);
    }

    @DeleteMapping("/deleteturma/{id}")
    public String deleteTurma(@PathVariable Integer id){
        return turmaService.deleteTurma(id);
    }
}
