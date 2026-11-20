package com.tcc.back_end.Controller;

import com.tcc.back_end.Model.ConfiguracaoGeral;
import com.tcc.back_end.Model.ConfiguracaoRFID;
import com.tcc.back_end.Model.Notificacao;
import com.tcc.back_end.Model.RegrasEscola;
import com.tcc.back_end.Service.ConfiguracaoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/edu/config")
public class ConfiguracaoController {

    private final ConfiguracaoService configuracaoService;

    public ConfiguracaoController(ConfiguracaoService configuracaoService) {
        this.configuracaoService = configuracaoService;
    }


    // REGRAS DA ESCOLA

    @GetMapping("/regras")
    public RegrasEscola buscarRegrasEscola() {
        return configuracaoService.buscarRegrasEscola();
    }

    @PutMapping("/regras")
    public String salvarRegrasEscola(@RequestBody RegrasEscola regras) {
        return configuracaoService.salvarRegrasEscola(regras);
    }


    // CONFIGURAÇÃO GERAL

    @GetMapping("/geral")
    public ConfiguracaoGeral buscarConfiguracaoGeral() {
        return configuracaoService.buscarConfiguracaoGeral();
    }

    @PutMapping("/geral")
    public String salvarConfiguracaoGeral(@RequestBody ConfiguracaoGeral config) {
        return configuracaoService.salvarConfiguracaoGeral(config);
    }


    // NOTIFICAÇÕES

    @GetMapping("/notificacoes")
    public Notificacao buscarNotificacoes() {
        return configuracaoService.buscarNotificacoes();
    }

    @PutMapping("/notificacoes")
    public String salvarNotificacoes(@RequestBody Notificacao notificacao) {
        return configuracaoService.salvarNotificacoes(notificacao);
    }


    // RFID

    @GetMapping("/rfid")
    public ConfiguracaoRFID buscarConfiguracaoRFID() {
        return configuracaoService.buscarConfiguracaoRFID();
    }

    @PutMapping("/rfid")
    public String salvarConfiguracaoRFID(@RequestBody ConfiguracaoRFID rfid) {
        return configuracaoService.salvarConfiguracaoRFID(rfid);
    }
}