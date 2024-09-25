package org.example.ejercicio1;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        BigInteger numeroFactorial = factorial(new BigInteger(String.valueOf(n)));

        System.out.println("Factorial de " + n + ": " + numeroFactorial);
    }

    public static BigInteger factorial(BigInteger n)  {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }
}