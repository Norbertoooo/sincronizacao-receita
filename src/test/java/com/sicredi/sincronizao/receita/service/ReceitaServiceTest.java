package com.sicredi.sincronizao.receita.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReceitaServiceTest {

    ReceitaService receitaService;

    @BeforeEach
    void setUp() {
        receitaService = new ReceitaService();
    }

    @Test
    void DeveRetornarVerdadeiroAoAtualizarContaValidaComStatusA() throws InterruptedException {
        boolean retorno = receitaService.atualizarConta("1234", "123456", 100.20, "A");
        Assertions.assertTrue(retorno);
    }

    @Test
    void DeveRetornarVerdadeiroAoAtualizarContaValidaComStatuI() throws InterruptedException {
        boolean retorno = receitaService.atualizarConta("1234", "123456", 100.20, "I");
        Assertions.assertTrue(retorno);
    }

    @Test
    void DeveRetornarVerdadeiroAoAtualizarContaValidaComStatuB() throws InterruptedException {
        boolean retorno = receitaService.atualizarConta("1234", "123456", 100.20, "B");
        Assertions.assertTrue(retorno);
    }

    @Test
    void DeveRetornarVerdadeiroAoAtualizarContaValidaComStatuP() throws InterruptedException {
        boolean retorno = receitaService.atualizarConta("1234", "123456", 100.20, "P");
        Assertions.assertTrue(retorno);
    }

    @Test
    void DeveRetornarFalsoAoAtualizarContaComAgenciaInvalida() throws InterruptedException {
        boolean retorno = receitaService.atualizarConta("123", "123456", 100.20, "A");
        Assertions.assertFalse(retorno);
    }

    @Test
    void DeveRetornarFalsoAoAtualizarContaComContaNula() throws InterruptedException {
        boolean retorno = receitaService.atualizarConta("1234", null, 100.20, "A");
        Assertions.assertFalse(retorno);
    }

    @Test
    void DeveRetornarFalsoAoAtualizarContaComContaInvalida() throws InterruptedException {
        boolean retorno = receitaService.atualizarConta("123", "12345", 100.20, "A");
        Assertions.assertFalse(retorno);
    }

    @Test
    void DeveRetornarFalsoAoAtualizarContaComStatusInvalido() throws InterruptedException {
        boolean retorno = receitaService.atualizarConta("1234", "123456", 100.20, "V");
        Assertions.assertFalse(retorno);
    }

    @Test
    void DeveRetornarFalsoAoAtualizarContaComStatusNulo() throws InterruptedException {
        boolean retorno = receitaService.atualizarConta("1234", "123456", 100.20, null);
        Assertions.assertFalse(retorno);
    }
}