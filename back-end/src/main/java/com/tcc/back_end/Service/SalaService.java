package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Sala;
import com.tcc.back_end.Model.Turma;
import com.tcc.back_end.Repository.SalaRepository;
import com.tcc.back_end.Repository.TurmaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaService {

    private SalaRepository salaRepository;
    private TurmaRepository turmaRepository;

    public SalaService(SalaRepository salaRepository, TurmaRepository turmaRepository) {
        this.salaRepository = salaRepository;
        this.turmaRepository = turmaRepository;
    }

    public String CadastrarSala(Sala sala){

        List<Turma> turmasValidas = validarTurmas(sala.getTurmas(), null, false);

        if(turmasValidas == null){
            return "Turmas inválidas ou já associadas a outra sala!";
        }

        sala.setTurmas(turmasValidas);

        return salaRepository.CadrastarSala(sala);
    }

    public List<Sala> getListaDeSala(){
        return salaRepository.getListaDeSala();
    }

    public Sala BuscarSala(Integer numero){
        return salaRepository.BuscarSala(numero);
    }


    public String updateSala(Integer numero, Sala sala){

        Sala salaAtual = salaRepository.BuscarSala(numero);

        if(salaAtual == null){
            return "Sala não encontrada!";
        }

        List<Turma> turmasValidas = validarTurmas(sala.getTurmas(), numero, true);

        if(turmasValidas == null){
            return "Turmas inválidas ou com turnos duplicados!";
        }

        sala.setTurmas(turmasValidas);

        String resultado = salaRepository.updateSala(numero, sala);

        if(!resultado.equals("Sala atualizada com sucesso!")){
            return resultado;
        }

        for(Sala salaExistente : salaRepository.getListaDeSala()){

            if(salaExistente.getNumero().equals(numero)){
                continue;
            }

            salaExistente.getTurmas().removeIf(turma ->
                    turmasValidas.stream().anyMatch(nova ->
                            nova.getId().equals(turma.getId())
                    )
            );
        }

        return resultado;
    }


    public String deleteSala(Integer numero){

        Sala sala = salaRepository.BuscarSala(numero);

        if(sala == null){
            return "Sala não encontrada!";
        }

        if(sala.getTurmas() != null && !sala.getTurmas().isEmpty()){
            return "Não é possível excluir uma sala que possui turmas associadas!";
        }

        return salaRepository.deleteSala(numero);
    }

    private List<Turma> validarTurmas(List<Turma> turmasInformadas, Integer numeroSala, boolean permitirTransferencia){

        if(turmasInformadas == null || turmasInformadas.isEmpty()){
            return new ArrayList<>();
        }

        List<Turma> turmasValidas = new ArrayList<>();

        for(Turma turmaInformada : turmasInformadas){

            if(turmaInformada.getId() == null){
                return null;
            }

            Turma turma = turmaRepository.BuscarTurma(turmaInformada.getId());

            if(turma == null || turma.getTurno() == null || turma.getTurno().isBlank()){
                return null;
            }

            for(Turma existente : turmasValidas){
                if(existente.getTurno().equalsIgnoreCase(turma.getTurno())){
                    return null;
                }

                if(existente.getId().equals(turma.getId())){
                    return null;
                }
            }

            if(!permitirTransferencia){

                for(Sala salaExistente : salaRepository.getListaDeSala()){

                    for(Turma turmaExistente : salaExistente.getTurmas()){

                        if(turmaExistente.getId().equals(turma.getId())){
                            return null;
                        }
                    }
                }
            }

            turmasValidas.add(turma);
        }

        return turmasValidas;
    }
}
