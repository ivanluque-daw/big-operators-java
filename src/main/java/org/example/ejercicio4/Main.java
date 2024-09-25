package org.example.ejercicio4;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {
        Posicion igualada = new Posicion(new BigDecimal("41.57879"), new BigDecimal("1.617221"));
        Posicion granada = new Posicion(new BigDecimal("37.176487"), new BigDecimal("-3.597929"));

        BigDecimal distancia = igualada.distanciaKm(granada);
        System.out.println("Distancia entre ambos: " + distancia.setScale(2, RoundingMode.HALF_UP));
    }
}
