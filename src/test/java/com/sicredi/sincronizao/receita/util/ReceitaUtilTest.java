package com.sicredi.sincronizao.receita.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReceitaUtilTest {

    @Test
    void adicionaTracoConta() {
        String conta = ReceitaUtil.adicionaTracoConta("122256");
        Assertions.assertEquals("12225-6", conta);
    }

    @Test
    void removeTracoConta() {
        String conta = ReceitaUtil.removeTracoConta("12225-6");
        Assertions.assertEquals("122256", conta);
    }

    @Test
    void formataSaldo() {
        String saldo = ReceitaUtil.formataSaldo(100.0);
        Assertions.assertEquals("100,00", saldo);
    }
}