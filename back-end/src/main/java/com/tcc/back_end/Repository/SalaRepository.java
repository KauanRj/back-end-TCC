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
        for(Sala s : listaDeSala){
            if (s.getNumero().equals(numero)){
                return s;
            }

        }
        return null;
    }

    public String updateSala(Integer numero, Sala salaUpdate){
        for(Sala s : listaDeSala){
            if(s.getNumero().equals(numero)) {

                s.setNumero(salaUpdate.getNumero());
                s.setCapacidade(salaUpdate.getCapacidade());
                s.setAndar(salaUpdate.getAndar());
                s.setStatus(salaUpdate.getStatus());
                s.setTurma(salaUpdate.getTurma());

                return "Sala atualizada com sucesso!";

            }
        }
        return "Sala não encontrada.";
    }

    public String deleteSala(Integer numero){
        for( Sala s : listaDeSala){
            if(s.getNumero().equals(numero)){
                listaDeSala.remove(s);

                return "Sala deletada com sucesso!";
            }
        }
        return "Sala não encontrada.";
    }


}
