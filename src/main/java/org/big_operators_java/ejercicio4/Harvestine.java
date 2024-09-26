package org.big_operators_java.ejercicio4;

import java.math.BigDecimal;
import java.math.MathContext;

public class Harvestine {
    protected final BigDecimal EARTH_RADIUS = new BigDecimal("6371.0");
    protected final MathContext MC = MathContext.DECIMAL128;

    protected BigDecimal toRadians(BigDecimal degrees) {
        return degrees.multiply(new BigDecimal(Math.PI)).divide(new BigDecimal("180"), MC);
    }

    protected BigDecimal sin(BigDecimal n) {
        return new BigDecimal(Math.sin(n.doubleValue()), MC);
    }

    protected BigDecimal cos(BigDecimal n) {
        return new BigDecimal(Math.cos(n.doubleValue()), MC);
    }

    protected BigDecimal sqrt(BigDecimal n) {
        return n.sqrt(MC);
    }

    protected BigDecimal atan2(BigDecimal n1, BigDecimal n2) {
        return new BigDecimal(Math.atan2(n1.doubleValue(), n2.doubleValue()), MC);
    }
}
