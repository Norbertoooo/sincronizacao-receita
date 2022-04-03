package com.sicredi.sincronizao.receita.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReceitaUtilTest {

    @Test
    void formataConta() {
        String conta = ReceitaUtil.formataConta("122256");
        Assertions.assertEquals("12225-6", conta);
    }

    @Test
    void formataSaldo() {
        String saldo = ReceitaUtil.formataSaldo(100.0);
        Assertions.assertEquals("100,00", saldo);
    }
}