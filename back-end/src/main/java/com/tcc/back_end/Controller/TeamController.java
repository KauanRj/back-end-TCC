package com.tcc.back_end.Controller;

import com.tcc.back_end.Model.Team;
import com.tcc.back_end.Service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/edu")
public class TeamController {

    private TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @PostMapping("/cadteam")
    public String CadastrarTeam(@RequestBody Team team){
        return teamService.cadastrarTeam(team);
    }

    @GetMapping("/listteam")
    public List<Team> ListarTeam(){
        return teamService.getListaTeam();
    }

    @GetMapping("/team/{id}")
    public Team BuscarTeamPorId(@PathVariable Integer id){
        return teamService.buscarTeamPorId(id);
    }

    @PutMapping("/upteam/{id}")
    public String AtualizarTeam(@PathVariable Integer id, @RequestBody Team team){
        return teamService.updateTeam(id, team);
    }

    @PutMapping("/acesso/{id}/{ativo}")
    public String AlterarAcesso(@PathVariable Integer id, @PathVariable boolean ativo){
        return teamService.alterarAcesso(id, ativo);
    }

    @DeleteMapping("/delteam/{id}")
    public String DeletarTeam(@PathVariable Integer id){
        return teamService.deleteTeam(id);
    }
}