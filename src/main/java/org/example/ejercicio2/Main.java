package org.example.ejercicio2;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        BigDecimal finalAmount = calculateCompoundInterest(new BigDecimal("2000"), new BigDecimal("0.02"), 10);
        System.out.println("Cantidad final: " + finalAmount);
    }

    public static BigDecimal calculateCompoundInterest(BigDecimal amount, BigDecimal tax, int years) {
        BigDecimal total = amount.multiply(BigDecimal.ONE.add(tax).pow(years));
        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
