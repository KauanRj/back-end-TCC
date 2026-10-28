package com.tcc.back_end.Controller;

import com.tcc.back_end.Model.Sala;
import com.tcc.back_end.Service.SalaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edu")
public class SalaController {

    private SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping("/cadsala")
    public String CadastrarSala(@RequestBody Sala sala){
        return salaService.CadastrarSala(sala);
    }

    @GetMapping("/listsala")
    public List<Sala> getListaDeSala(){
        return salaService.getListaDeSala();
    }

    @GetMapping("/encsala/{numero}")
    public Sala BuscarSala(@PathVariable Integer numero){
        return salaService.BuscarSala(numero);
    }

    @PutMapping("/update/{numero}")
    public String updateSala(@PathVariable Integer numero,@RequestBody Sala sala){
        return salaService.updateSala(numero, sala);
    }

    @DeleteMapping("/delete/{numero}")
    public String deleteSala(@PathVariable Integer numero){
        return salaService.deleteSala(numero);
    }

}
