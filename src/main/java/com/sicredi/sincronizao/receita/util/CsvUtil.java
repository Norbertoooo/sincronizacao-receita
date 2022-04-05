package com.sicredi.sincronizao.receita.util;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import com.sicredi.sincronizao.receita.domain.Conta;
import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CsvUtil {

    public static void criaCsv(List<Conta> contas) {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get("./sincronizacao-resultado.csv"))
        ) {

            CSVWriter csvWriter = new CSVWriter(writer, ';',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            String[] headerRecord = {"agencia", "conta", "saldo", "status", "sincronizado"};
            csvWriter.writeNext(headerRecord);

            contas.forEach(conta -> {
                String contaFormatada = ReceitaUtil.adicionaTracoConta(conta.getConta());
                String saldoFormatado = ReceitaUtil.formataSaldo(conta.getSaldo());
                csvWriter.writeNext(new String[]{conta.getAgencia(), contaFormatada, saldoFormatado,
                        conta.getStatus(), conta.getSincronizado().toString()});
            });

        } catch (IOException e) {
            log.error("Erro ao criar sincronizacao-resultado.csv -> {} ", e.getMessage());
        }
    }

    public static List<Conta> converteCsvParaContas(String caminhoArquivo) {

        try {
            Reader reader = new FileReader(caminhoArquivo);

            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                    .withSkipLines(1)
                    .build();

            List<Conta> contas = new ArrayList<>();
            for (String[] row : csvReader.readAll()) {
                for (String cell : row) {
                    log.info(cell);
                    String[] split = cell.split(";");
                    Conta conta = Conta.builder()
                            .agencia(split[0])
                            .conta(ReceitaUtil.removeTracoConta(split[1]))
                            .saldo(Double.parseDouble(split[2].replace(",", ".")))
                            .status(split[3])
                            .build();
                    contas.add(conta);
                }
            }
            log.info(contas.toString());
            return contas;
        } catch (IOException | CsvException exception) {
            log.info(exception.getMessage());
            throw new RuntimeException(exception.getMessage());
        }

    }
}
