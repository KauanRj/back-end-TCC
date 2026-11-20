package com.tcc.back_end.Service;

import com.tcc.back_end.Model.Perfil;
import com.tcc.back_end.Model.Team;
import com.tcc.back_end.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PerfilService {

    private final TeamRepository teamRepository;

    public PerfilService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    // BUSCAR PERFIL

    public Perfil buscarPerfil(Integer id) {

        Team team = teamRepository.buscarTeamPorId(id);

        if (team == null) {
            return null;
        }

        Perfil perfil = new Perfil();

        perfil.setId(team.getId());
        perfil.setNome(team.getNome());
        perfil.setEmail(team.getEmail());
        perfil.setCargo(team.getCargo());
        perfil.setTelefone(team.getTelefone());
        perfil.setFotoPerfil(team.getFotoPerfil());
        perfil.setTipoAcesso(team.getTipoAcesso());
        perfil.setAcessoAtivo(team.isAcessoAtivo());
        perfil.setUltimoAcesso(team.getUltimoAcesso());
        perfil.setDataCriacaoConta(team.getDataCriacaoConta());
        perfil.setDataAlteracaoSenha(team.getDataAlteracaoSenha());

        return perfil;
    }

    // ATUALIZAR PERFIL

    public String atualizarPerfil(Integer id, Perfil perfilUpdate) {

        if (id == null || perfilUpdate == null) {
            return "Dados do perfil não informados!";
        }

        Team teamAtual = teamRepository.buscarTeamPorId(id);

        if (teamAtual == null) {
            return "Perfil não encontrado!";
        }

        if (perfilUpdate.getNome() == null || perfilUpdate.getNome().isBlank()) {
            return "O nome é obrigatório!";
        }

        if (perfilUpdate.getEmail() == null || perfilUpdate.getEmail().isBlank()) {
            return "O e-mail é obrigatório!";
        }

        Team teamEmail = teamRepository.buscarTeamPorEmail(perfilUpdate.getEmail());

        if (teamEmail != null && !teamEmail.getId().equals(id)) {
            return "Esse e-mail já está cadastrado para outro profissional!";
        }

        return teamRepository.atualizarDadosPerfil(
                id,
                perfilUpdate.getNome(),
                perfilUpdate.getEmail(),
                perfilUpdate.getTelefone(),
                perfilUpdate.getFotoPerfil()
        );
    }

    // REGISTRAR ÚLTIMO ACESSO

    public String registrarUltimoAcesso(Integer id) {

        Team team = teamRepository.buscarTeamPorId(id);

        if (team == null) {
            return "Profissional não encontrado!";
        }

        team.setUltimoAcesso(LocalDateTime.now());

        return "Último acesso atualizado!";
    }
}