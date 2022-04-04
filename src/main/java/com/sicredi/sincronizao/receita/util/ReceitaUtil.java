package com.sicredi.sincronizao.receita.util;

import java.text.DecimalFormat;

public class ReceitaUtil {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public static String adicionaTracoConta(String conta) {
        return new StringBuilder(conta).insert(5, '-').toString();
    }

    public static String removeTracoConta(String conta) {
        return conta.replace("-", "");
    }

    public static String formataSaldo(Double saldo) {
        return DECIMAL_FORMAT.format(saldo);
    }
}
