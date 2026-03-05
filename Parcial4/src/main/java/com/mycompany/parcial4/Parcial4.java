package com.mycompany.parcial4;
import java.util.List;

public class Parcial4 {
    public static void main(String[] args) {
        Maleta maleta = new Maleta(10);

        maleta.agregarElemento(new Elemento("Lapiz", 0.5, 5));
        maleta.agregarElemento(new Elemento("Paraguas", 2, 12));
        maleta.agregarElemento(new Elemento("Chocolatina", 0.3, 4));
        maleta.agregarElemento(new Elemento("Cuadernos", 1, 6));
        maleta.agregarElemento(new Elemento("Aguardiente", 1, 5));
        maleta.agregarElemento(new Elemento("Vodka", 1.5, 6.5));
        maleta.agregarElemento(new Elemento("Tequila", 1.8, 8));
        maleta.agregarElemento(new Elemento("Computador", 3, 15));
        maleta.agregarElemento(new Elemento("Desodorante", 0.5, 5));
        maleta.agregarElemento(new Elemento("Cepillo", 0.3, 2));
        maleta.agregarElemento(new Elemento("Manzanas", 1, 4));
        maleta.agregarElemento(new Elemento("Bananos", 2, 7));

        List<Elemento> mejorCombinacion = maleta.mejorCombinacion();
        double beneficioTotal = maleta.calcularBeneficioTotal(mejorCombinacion);
        double pesoTotal = maleta.calcularPesoTotal(mejorCombinacion);

        System.out.println("La mejor combinación de elementos es:");
        for (Elemento elemento : mejorCombinacion) {
            System.out.println(elemento.getNombre() + " con peso: " + elemento.getPeso() + " y beneficio: " + elemento.getBeneficio());
        }
        
        System.out.println("\nPeso total: " + pesoTotal);
        System.out.println("Beneficio total: " + beneficioTotal);
        
    }
}
