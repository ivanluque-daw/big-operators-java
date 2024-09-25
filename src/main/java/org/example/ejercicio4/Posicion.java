package org.example.ejercicio4;

import java.math.BigDecimal;

public class Posicion extends Harvestine {
    BigDecimal latitud, longitud;

    public BigDecimal distanciaKm(Posicion destino) {
        BigDecimal diffLatitud = toRadians(destino.getLatitud().subtract(this.latitud));
        BigDecimal diffLongitud = toRadians(destino.getLongitud().subtract(this.longitud));

        BigDecimal diffLatitudDivided = sin(diffLatitud.divide(new BigDecimal("2"), MC)).pow(2);
        BigDecimal diffLongitudDivided = sin(diffLongitud.divide(new BigDecimal("2"), MC)).pow(2);

        BigDecimal a = diffLatitudDivided.add(cos(toRadians(this.latitud)).multiply(cos(toRadians(destino.getLatitud()))).multiply(diffLongitudDivided));
        BigDecimal c = atan2(sqrt(a), sqrt(BigDecimal.ONE.subtract(a))).multiply(new BigDecimal("2"));

        return EARTH_RADIUS.multiply(c);
    }

    public Posicion(BigDecimal latitud, BigDecimal longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }
}
