package com.sicredi.sincronizao.receita.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Conta {

    private String agencia;
    private String conta;
    private Double saldo;
    private String status;
    private Boolean sincronizado;

}
