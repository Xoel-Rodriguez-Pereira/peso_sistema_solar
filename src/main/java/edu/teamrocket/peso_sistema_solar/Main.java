package edu.teamrocket.peso_sistema_solar;

public class Main {
	
	public static void main(String[] args) {
        
        double peso = 1.0; // kg
        
        for(Planeta planeta : Planeta.values()){
            System.out.printf("Tu peso en %s es %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }
         
        System.out.println("\nTu peso en los planetas Terrestres: ");
        for(Planeta planeta: Planeta.getPlanetasTerrestres()){
            System.out.printf("Tu peso en %s es %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }
         
        System.out.println("\nTu peso en los planetas Gigantes Gaseosos: ");
        for(Planeta planeta: Planeta.getGigantesGaseosos()){
            System.out.printf("Tu peso en %s es %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }

        System.out.println("\nTu peso en los planetas Gigantes Helados: ");
        for(Planeta planeta: Planeta.getGigantesHelados()){
            System.out.printf("Tu peso en %s es %f N%n", planeta.name(), planeta.pesoSuperficie(peso));
        }
    }

}