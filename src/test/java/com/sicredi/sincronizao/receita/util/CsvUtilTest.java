package com.sicredi.sincronizao.receita.util;

import com.sicredi.sincronizao.receita.domain.Conta;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class CsvUtilTest {

    @Test
    void converteCsvParaContas() {

        String fileName = "src/test/resources/static/contas.csv";
        Conta contaA = Conta.builder().agencia("0101").conta("122256").saldo(100.00).status("A").build();
        Conta contaP = Conta.builder().agencia("0203").conta("122278").saldo(3200.50).status("P").build();
        List<Conta> contasEsperadas = List.of(contaA, contaP);

        List<Conta> contas = CsvUtil.converteCsvParaContas(fileName);

        Assertions.assertNotNull(contas);
        assertEquals(2, contas.size());
        assertEquals(contasEsperadas, contas);

    }

    @Test
    void criaCsv() {
        Conta contaA = Conta.builder().agencia("0101").conta("122256").saldo(100.00).status("A").sincronizado(true).build();
        Conta contaP = Conta.builder().agencia("0203").conta("122278").saldo(3200.50).status("P").sincronizado(true).build();
        List<Conta> contas = List.of(contaA, contaP);
        CsvUtil.criaCsv(contas);
        File file = new File("./sincronizacao-resultado.csv");
        Assertions.assertTrue(file.exists());
        boolean delete = file.delete();
        log.info("Excluindo arquivo csv de teste: {}", delete);
    }
}