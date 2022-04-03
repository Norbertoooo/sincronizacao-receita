package com.sicredi.sincronizao.receita.util;

import java.text.DecimalFormat;

public class ReceitaUtil {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public static String formataConta(String conta) {
        return new StringBuilder(conta).insert(5, '-').toString();
    }

    public static String formataSaldo(Double saldo) {
        return DECIMAL_FORMAT.format(saldo);
    }
}
