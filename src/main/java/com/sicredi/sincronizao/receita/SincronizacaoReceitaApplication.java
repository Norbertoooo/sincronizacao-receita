package com.sicredi.sincronizao.receita;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SincronizacaoReceitaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SincronizacaoReceitaApplication.class, args);
    }

}
