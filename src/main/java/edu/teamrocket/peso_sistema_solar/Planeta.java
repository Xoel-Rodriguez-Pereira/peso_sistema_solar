package edu.teamrocket.peso_sistema_solar;

import java.util.EnumSet;

public enum Planeta {

    MERCURIO(3.303e+23, 2.4397e6),     
    VENUS(4.869e+24, 6.0518e6),    
    TIERRA(5.976e+24, 6.37814e6),     
    MARTE(6.421e+23, 3.3972e6),     
    JUPITER(1.9e+27,   7.1492e7),   
    SATURNO(5.688e+26, 6.0268e7),     
    URANO(8.686e+25, 2.5559e7),    
    NEPTUNO(1.024e+26, 2.4746e7);
    
    public double masa;
    public double radio;
    private final double G = 6.67300e-11;

    Planeta(double masa, double radio) {
        this.masa = masa;
        this.radio = radio;
    }

    public double getMasa() {
        return this.masa;
    }

    public double getRadio() {
        return this.radio;
    }

    private double gravedadSuperficie() {
        return G * this.masa / Math.pow(this.radio, 2);
    }
    
    private double masaHumano(double pesoHumano) {
        return pesoHumano / Planeta.TIERRA.gravedadSuperficie();
    }

    public double pesoSuperficie(double peso) {
        return masaHumano(peso) * this.gravedadSuperficie();
    }


    public static  EnumSet<Planeta> getPlanetasTerrestres() {
        return EnumSet.range(MERCURIO, MARTE);
    }

    public static  EnumSet<Planeta> getGigantesGaseosos() {
        return EnumSet.range(JUPITER, SATURNO);
    }

    public static  EnumSet<Planeta> getGigantesHelados() {
        return EnumSet.range(URANO, NEPTUNO);
    }
}
