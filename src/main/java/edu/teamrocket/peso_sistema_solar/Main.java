package edu.teamrocket.peso_sistema_solar;

import java.util.Optional;

public class Main {
	public static void main(String[] args) {

        Optional<Double> masa = Optional.empty();
        Optional<Planeta> planeta = Optional.empty();
        
        if (args.length == 0) {
            salidaPorDefecto(masaPorDefecto);
        }

        try {
            masa = Optional.of(Double.parseDouble(args[0]));
        }
        catch (IllegalArgumentException exception) {
            textoExcepcion();
        }

        try {
            planeta = Optional.of(Planeta.valueOf(args[1].toUpperCase()));
        }
        catch (IllegalArgumentException exception) {
            textoExcepcion();
        }
        catch (ArrayIndexOutOfBoundsException exception) {
        };
        textoCorrecto(masa, planeta);
    }
    
    //Valores por defecto
    static Double masaPorDefecto = 1.0;
    static Planeta planetaPorDefecto = Planeta.TIERRA;

    private static void textoExcepcion() {
        System.out.println("\nLos datos introducidos no son correctos \nLos argumentos de entrada válidos son MASA(en kg) y nombre de un PLANETA \nEn el caso de no introducirse valores saltará el caso por defecto");
    }

    private static void textoCorrecto(Optional<Double> masa, Optional<Planeta> planeta) {
        System.out.printf("El peso de un objeto de %f Kg en %s es %f N%n",  masa.orElse(masaPorDefecto), 
                                                                            planeta.orElse(Planeta.TIERRA).name(), 
                                                                            planeta.orElse(Planeta.TIERRA).pesoSuperficie(masa.orElse(masaPorDefecto)));
    }

    private static void salidaPorDefecto(Double masa) {

        for(Planeta planeta : Planeta.values()){
                textoCorrecto(Optional.of(masa), Optional.of(planeta));
            }
            
            System.out.println("\nPeso en los planetas Terrestres: ");
            for(Planeta planeta: Planeta.getPlanetasTerrestres()){
                textoCorrecto(Optional.of(masa), Optional.of(planeta));
            }
            
            System.out.println("\nPeso en los planetas Gigantes Gaseosos: ");
            for(Planeta planeta: Planeta.getGigantesGaseosos()){
                textoCorrecto(Optional.of(masa), Optional.of(planeta));
            }

            System.out.println("\nPeso en los planetas Gigantes Helados: ");
            for(Planeta planeta: Planeta.getGigantesHelados()){
                textoCorrecto(Optional.of(masa), Optional.of(planeta));
            }
    }
}