
package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Team;
import com.tcc.back_end.Model.Enum.TipoAcesso;
import com.tcc.back_end.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    public String cadastrarTeam(Team team){

        if(team == null){
            return "Os dados do profissional não foram informados!";
        }

        if(team.getId() == null || team.getId() <= 0){
            return "É necessário informar um ID válido!";
        }

        if(teamRepository.buscarTeamPorId(team.getId()) != null){
            return "Já existe um profissional com esse ID!";
        }

        if(team.getMatricula() == null || team.getMatricula().isBlank()){
            return "É necessário informar a matrícula!";
        }

        if(teamRepository.buscarTeamPorMatricula(team.getMatricula()) != null){
            return "Essa matrícula já está cadastrada!";
        }

        if(team.getCpf() == null || team.getCpf().isBlank()){
            return "É necessário informar o CPF!";
        }

        if(teamRepository.buscarTeamPorCpf(team.getCpf()) != null){
            return "Esse CPF já está cadastrado!";
        }

        if(team.getEmail() == null || team.getEmail().isBlank()){
            return "É necessário informar o e-mail!";
        }

        if(teamRepository.buscarTeamPorEmail(team.getEmail()) != null) {
            return "Esse e-mail já está cadastrado!";
        }

        if(team.getTipoAcesso() == null){
            return "É necessário definir o tipo de acesso!";
        }

        if(team.getSenha() == null || team.getSenha().isBlank()){
            return "É necessário informar a senha!";
        }

        team.setAcessoAtivo(true);

        return teamRepository.cadastrarTeam(team);
    }

    public List<Team> getListaTeam(){
        return teamRepository.getListaTeam();
    }

    public Team buscarTeamPorId(Integer id){
        return teamRepository.buscarTeamPorId(id);
    }

    public Team buscarTeamPorMatricula(String matricula){
        return teamRepository.buscarTeamPorMatricula(matricula);
    }

    public Team buscarTeamPorCpf(String cpf){
        return teamRepository.buscarTeamPorCpf(cpf);
    }

    public String updateTeam(Integer id, Team teamUpdate){

        if(id == null || teamUpdate == null){
            return "É necessário informar os dados do profissional!";
        }

        Team teamAtual = teamRepository.buscarTeamPorId(id);

        if(teamAtual == null){
            return "Profissional não encontrado!";
        }

        if(teamUpdate.getMatricula() == null || teamUpdate.getMatricula().isBlank()){
            return "É necessário informar a matrícula!";
        }

        Team teamMatricula = teamRepository.buscarTeamPorMatricula(teamUpdate.getMatricula());

        if(teamMatricula != null && !teamMatricula.getId().equals(id)){
            return "Essa matrícula já está cadastrada para outro profissional!";
        }

        if(teamUpdate.getCpf() == null || teamUpdate.getCpf().isBlank()){
            return "É necessário informar o CPF!";
        }

        Team teamCpf = teamRepository.buscarTeamPorCpf(teamUpdate.getCpf());

        if(teamCpf != null && !teamCpf.getId().equals(id)){
            return "Esse CPF já está cadastrado para outro profissional!";
        }

        if(teamUpdate.getEmail() == null || teamUpdate.getEmail().isBlank()){
            return "É necessário informar o e-mail!";
        }

        Team teamEmail = teamRepository.buscarTeamPorEmail(teamUpdate.getEmail());

        if(teamEmail != null && !teamEmail.getId().equals(id)){
            return "Esse e-mail já está cadastrado para outro profissional!";
        }

        if(teamUpdate.getTipoAcesso() == null){
            return "É necessário informar o tipo de acesso!";
        }

        return teamRepository.updateTeam(id, teamUpdate);
    }

    public String deleteTeam(Integer id){
        if(id == null){
            return "É necessário informar o ID do profissional!";
        }

        if(teamRepository.buscarTeamPorId(id) == null){
            return "Profissional não encontrado!";
        }

        return teamRepository.deleteTeam(id);
    }

    public String alterarAcesso(Integer id, boolean acessoAtivo){

        Team team = teamRepository.buscarTeamPorId(id);

        if(team == null){
            return "Profissional não encontrado!";
        }

        team.setAcessoAtivo(acessoAtivo);

        if(acessoAtivo){
            return "Acesso do profissional ativado!";
        }

        return "Acesso do profissional desativado!";
    }
}
