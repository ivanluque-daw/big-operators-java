package org.big_operators_java.ejercicio3;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {
    private static final String CLI_FORMATTER = "%-5s%-10s%-13s%-11s%-1s%n";

    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal("200000");
        BigDecimal tax = new BigDecimal("0.05");
        int years = 30;

        BigDecimal monthlyTax = tax.divide(new BigDecimal(12), 10, RoundingMode.HALF_EVEN);
        BigDecimal pmt = calculatePMT(amount, monthlyTax, years);

        System.out.println("Prestamo: " + amount + "€");
        System.out.println("Tasa: " + tax.multiply(new BigDecimal(100)) + "%");
        System.out.println("Pago mensual: " + format(pmt) + "€");

        System.out.println();

        System.out.println("Esquema de amortización");
        System.out.println("-----------------------");
        System.out.format(CLI_FORMATTER, new String[] { "Mes", "Pago", "Principal", "Interés", "Balance" });

        for (int i = 1; i <= years * 12; i++) {
            BigDecimal month = amount.multiply(monthlyTax);
            BigDecimal primary = pmt.subtract(month);
            amount = amount.subtract(primary);

            System.out.format(CLI_FORMATTER, new String[] { String.valueOf(i), format(pmt), format(primary), format(month), format(amount) });
        }
    }

    public static String format(BigDecimal amount) {
        return String.valueOf(amount.setScale(2, RoundingMode.HALF_EVEN));
    }

    public static BigDecimal calculatePMT(BigDecimal amount, BigDecimal monthlyTax, int years) {
        return amount.multiply(monthlyTax).divide(BigDecimal.ONE.subtract(BigDecimal.ONE.add(monthlyTax).pow(-(years * 12), new MathContext(10, RoundingMode.HALF_EVEN))), 10, RoundingMode.HALF_EVEN);
    }
}
