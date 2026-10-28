package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Sala;
import com.tcc.back_end.Repository.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private SalaRepository salaRepository;

    public SalaService(SalaRepository salaRepository) {
        this.salaRepository = salaRepository;
    }

    public String CadastrarSala(Sala sala){
        return salaRepository.CadrastarSala(sala);
    }

    public List<Sala> getListaDeSala(){
        return salaRepository.getListaDeSala();
    }

    public Sala BuscarSala(Integer numero){
        return salaRepository.BuscarSala(numero);
    }

    public String updateSala(Integer numero, Sala sala){
        return salaRepository.updateSala(numero,sala);
    }

    public String deleteSala(Integer numero){
        return salaRepository.deleteSala(numero);
    }
}
