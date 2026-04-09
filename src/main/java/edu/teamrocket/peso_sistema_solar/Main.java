package edu.teamrocket.peso_sistema_solar;

public class Main {
	
	public static void main(String[] args) {
        
        // Valores por defecto
        Double masa = 1.0; // kg
        Planeta planeta = Planeta.TIERRA;

        if (args.length == 2) {
            try {
                masa = Double.parseDouble(args[0]);
                planeta = Planeta.valueOf(args[1].toUpperCase());

                textoCorrecto(masa, planeta);
            }

            catch (IllegalArgumentException exception) {
                textoExcepcion();
            }

        } else if (args.length == 1) {

            try {
                masa = Double.parseDouble(args[0]);
                textoCorrecto(masa, planeta);
            }

            catch (IllegalArgumentException exception) {
                textoExcepcion();
            }

        } else {
            salidaPorDefecto(masa);
        }
        
    }

    private static void textoExcepcion() {
        System.out.println("\nLos datos introducidos no son correctos \nLos argumentos de entrada válidos son MASA(en kg) y nombre de un PLANETA \nEn el caso de no introducirse valores saltará el caso por defecto");
    }

    private static void textoCorrecto(Double masa, Planeta planeta) {
        System.out.printf("El peso de un objeto de %f Kg en %s es %f N%n", masa, planeta.name(), planeta.pesoSuperficie(masa));
    }

    private static void salidaPorDefecto(Double masa) {

        for(Planeta planeta : Planeta.values()){
                textoCorrecto(masa, planeta);
            }
            
            System.out.println("\nPeso en los planetas Terrestres: ");
            for(Planeta planeta: Planeta.getPlanetasTerrestres()){
                textoCorrecto(masa, planeta);
            }
            
            System.out.println("\nPeso en los planetas Gigantes Gaseosos: ");
            for(Planeta planeta: Planeta.getGigantesGaseosos()){
                textoCorrecto(masa, planeta);
            }

            System.out.println("\nPeso en los planetas Gigantes Helados: ");
            for(Planeta planeta: Planeta.getGigantesHelados()){
                textoCorrecto(masa, planeta);
            }
    }
}