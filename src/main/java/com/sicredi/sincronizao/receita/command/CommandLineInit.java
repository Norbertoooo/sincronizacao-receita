package com.sicredi.sincronizao.receita.command;

import com.sicredi.sincronizao.receita.domain.Conta;
import com.sicredi.sincronizao.receita.service.ReceitaService;
import com.sicredi.sincronizao.receita.util.CsvUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CommandLineInit {

    private final ReceitaService receitaService;

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext applicationContext) {
        return args -> {
            List<String> argumentos = List.of(args);
            log.info("Iniciando sincronização");
            log.info("Argumentos: {}", argumentos);
            if (Boolean.FALSE.equals(argumentos.isEmpty())) {
                for (String argumento : argumentos) {

                    List<Conta> contas = CsvUtil.converteCsvParaContas(argumento);

                    contas.forEach(conta -> {
                        try {
                            log.info("Atualizando conta: {}", conta.getConta());
                            boolean resultado = receitaService.atualizarConta(conta.getAgencia(), conta.getConta(),
                                    conta.getSaldo(), conta.getStatus());
                            conta.setSincronizado(resultado);
                        } catch (InterruptedException | RuntimeException e) {
                            log.error("Erro ao atualizar conta -> {}", e.getMessage());
                            conta.setSincronizado(false);
                        }
                    });

                    CsvUtil.criaCsv(contas);

                }
            }
            log.info("Finalizando sincronização");
            SpringApplication.exit(applicationContext);
        };

    }
}
