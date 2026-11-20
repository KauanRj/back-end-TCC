package com.tcc.back_end.Service;

import com.tcc.back_end.Model.ConfiguracaoGeral;
import com.tcc.back_end.Model.ConfiguracaoRFID;
import com.tcc.back_end.Model.Notificacao;
import com.tcc.back_end.Model.RegrasEscola;
import com.tcc.back_end.Repository.ConfiguracaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class ConfiguracaoService {

    private final ConfiguracaoRepository configuracaoRepository;

    public ConfiguracaoService(ConfiguracaoRepository configuracaoRepository) {
        this.configuracaoRepository = configuracaoRepository;
    }


    // REGRAS DA ESCOLA

    public RegrasEscola buscarRegrasEscola() {
        return configuracaoRepository.getRegrasEscola();
    }

    public String salvarRegrasEscola(RegrasEscola regras) {

        if (regras == null) {
            return "Configurações não informadas.";
        }

        if (regras.getHorarioLimite() == null) {
            return "O horário limite é obrigatório.";
        }

        if (regras.getAnoLetivo() == null || regras.getAnoLetivo() < 2000) {
            return "Ano letivo inválido.";
        }

        if (regras.getTurno() == null || regras.getTurno().isBlank()) {
            return "O turno é obrigatório.";
        }

        configuracaoRepository.salvarRegrasEscola(regras);

        return "Regras da escola atualizadas com sucesso.";
    }


    // CONFIGURAÇÃO GERAL

    public ConfiguracaoGeral buscarConfiguracaoGeral() {
        return configuracaoRepository.getConfiguracaoGeral();
    }

    public String salvarConfiguracaoGeral(ConfiguracaoGeral config) {

        if (config == null) {
            return "Configuração não informada.";
        }

        if (config.getAparencia() == null || config.getAparencia().isBlank()) {
            return "A aparência é obrigatória.";
        }

        if (config.getIdioma() == null || config.getIdioma().isBlank()) {
            return "O idioma é obrigatório.";
        }

        configuracaoRepository.salvarConfiguracaoGeral(config);

        return "Configurações gerais atualizadas com sucesso.";
    }


    // NOTIFICAÇÕES

    public Notificacao buscarNotificacoes() {
        return configuracaoRepository.getNotificacao();
    }

    public String salvarNotificacoes(Notificacao notificacao) {

        if (notificacao == null) {
            return "Notificações não informadas.";
        }

        configuracaoRepository.salvarNotificacao(notificacao);

        return "Notificações atualizadas com sucesso.";
    }


    // RFID

    public ConfiguracaoRFID buscarConfiguracaoRFID() {
        return configuracaoRepository.getConfiguracaoRFID();
    }

    public String salvarConfiguracaoRFID(ConfiguracaoRFID rfid) {

        if (rfid == null) {
            return "Configuração RFID não informada.";
        }

        configuracaoRepository.salvarConfiguracaoRFID(rfid);

        return "Configuração RFID atualizada com sucesso.";
    }
}