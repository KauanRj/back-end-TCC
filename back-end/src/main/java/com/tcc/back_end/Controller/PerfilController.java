package com.tcc.back_end.Controller;

import com.tcc.back_end.Model.Perfil;
import com.tcc.back_end.Service.PerfilService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edu/perfil")
public class PerfilController {

    private final PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    // BUSCAR PERFIL
    @GetMapping("/{id}")
    public Perfil buscarPerfil(@PathVariable Integer id) {
        return perfilService.buscarPerfil(id);
    }

    // ATUALIZAR PERFIL
    @PutMapping("/{id}")
    public String atualizarPerfil(@PathVariable Integer id,
                                  @RequestBody Perfil perfil) {
        return perfilService.atualizarPerfil(id, perfil);
    }

    // REGISTRAR ÚLTIMO ACESSO
    @PutMapping("/acesso/{id}")
    public String registrarUltimoAcesso(@PathVariable Integer id) {
        return perfilService.registrarUltimoAcesso(id);
    }
}