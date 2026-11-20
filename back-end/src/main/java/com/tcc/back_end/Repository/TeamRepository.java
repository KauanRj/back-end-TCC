
package com.tcc.back_end.Repository;

import com.tcc.back_end.Model.Team;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TeamRepository {

    private List<Team> listaTeam = new ArrayList<>();

    public String cadastrarTeam(Team team){
        listaTeam.add(team);
        return "Profissional cadastrado com sucesso!";
    }

    public List<Team> getListaTeam(){
        return new ArrayList<>(listaTeam);
    }

    public Team buscarTeamPorId(Integer id){
        if(id == null){
            return null;
        }

        for(Team t : listaTeam){
            if(t.getId() != null && t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }

    public Team buscarTeamPorMatricula(String matricula){
        if(matricula == null){
            return null;
        }

        for(Team t : listaTeam){
            if(t.getMatricula() != null && t.getMatricula().equals(matricula)){
                return t;
            }
        }
        return null;
    }

    public Team buscarTeamPorCpf(String cpf){
        if(cpf == null){
            return null;
        }

        for(Team t : listaTeam){
            if(t.getCpf() != null && t.getCpf().equals(cpf)){
                return t;
            }
        }
        return null;
    }

    public Team buscarTeamPorEmail(String email){
        if(email == null) return null;

        for(Team t : listaTeam){
            if(t.getEmail() != null && t.getEmail().equalsIgnoreCase(email)){
                return t;
            }
        }

        return null;
    }

    public String updateTeam(Integer id, Team teamUpdate){
        if(id == null || teamUpdate == null){
            return "É necessário informar os dados do profissional!";
        }

        for(Team t : listaTeam){
            if(t.getId() != null && t.getId().equals(id)){
                t.setMatricula(teamUpdate.getMatricula());
                t.setNome(teamUpdate.getNome());
                t.setDataNascimento(teamUpdate.getDataNascimento());
                t.setCpf(teamUpdate.getCpf());
                t.setStatus(teamUpdate.getStatus());
                t.setTipoVinculo(teamUpdate.getTipoVinculo());
                t.setCargo(teamUpdate.getCargo());
                t.setSetor(teamUpdate.getSetor());
                t.setDataAdmissao(teamUpdate.getDataAdmissao());
                t.setJornadaSemanal(teamUpdate.getJornadaSemanal());
                t.setTelefone(teamUpdate.getTelefone());
                t.setEmail(teamUpdate.getEmail());
                t.setEndereco(teamUpdate.getEndereco());
                t.setSenha(teamUpdate.getSenha());
                t.setTipoAcesso(teamUpdate.getTipoAcesso());
                t.setAcessoAtivo(teamUpdate.isAcessoAtivo());
                t.setFotoPerfil(teamUpdate.getFotoPerfil());
                t.setUltimoAcesso(teamUpdate.getUltimoAcesso());
                t.setDataCriacaoConta(teamUpdate.getDataCriacaoConta());
                t.setDataAlteracaoSenha(teamUpdate.getDataAlteracaoSenha());

                return "Profissional atualizado com sucesso!";
            }
        }
        return "Profissional não encontrado!";
    }

    public String deleteTeam(Integer id){
        if(id == null){
            return "É necessário informar o ID do profissional!";
        }

        boolean removido = listaTeam.removeIf(
                t -> t.getId() != null && t.getId().equals(id)
        );

        if(removido){
            return "Profissional deletado com sucesso!";
        }

        return "Profissional não encontrado!";
    }

    public String atualizarDadosPerfil(Integer id, String nome,
                                       String email, String telefone,
                                       String fotoPerfil) {

        Team team = buscarTeamPorId(id);

        if (team == null) {
            return "Profissional não encontrado!";
        }

        team.setNome(nome);
        team.setEmail(email);
        team.setTelefone(telefone);
        team.setFotoPerfil(fotoPerfil);

        return "Perfil atualizado com sucesso!";
    }
}
