package com.tcc.back_end.Repository;

import com.tcc.back_end.Model.Sala;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SalaRepository {

    private List<Sala> listaDeSala = new ArrayList<>();

    public String CadrastarSala(Sala sala){
        this.listaDeSala.add(sala);

        return "Sala cadastrada";
    }

    public List<Sala> getListaDeSala() {
        return listaDeSala;
    }

    public Sala BuscarSala(Integer numero){

        if(numero == null){
            return null;
        }

        for(Sala s : listaDeSala){

            if(s.getNumero() != null && s.getNumero().equals(numero)){
                return s;
            }
        }

        return null;
    }

    public String updateSala(Integer numero, Sala salaUpdate){

        if(numero == null || salaUpdate == null){
            return "É necessário informar os dados da sala!";
        }

        for(Sala s : listaDeSala){

            if(s.getNumero() != null && s.getNumero().equals(numero)){

                s.setCapacidade(salaUpdate.getCapacidade());
                s.setAndar(salaUpdate.getAndar());
                s.setStatus(salaUpdate.getStatus());
                s.setTurmas(salaUpdate.getTurmas());

                return "Sala atualizada com sucesso!";
            }
        }

        return "Sala não encontrada.";
    }

    public String deleteSala(Integer numero){

        if(numero == null){
            return "É necessário informar o número da sala!";
        }

        boolean removida = listaDeSala.removeIf(
                sala -> sala.getNumero() != null &&
                        sala.getNumero().equals(numero)
        );

        if(removida){
            return "Sala deletada com sucesso!";
        }

        return "Sala não encontrada.";
    }


}
