package com.mycompany.parcial4;
import java.util.ArrayList;
import java.util.List;

public class Maleta {
    private List<Elemento> elementos;
    private double capacidadMaxima;

    public Maleta(double capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.elementos = new ArrayList<>();
    }

    public void agregarElemento(Elemento elemento) {
        elementos.add(elemento);
    }

    public List<Elemento> mejorCombinacion() {
        int n = elementos.size();
        double[][] tabla = new double[n + 1][(int) (capacidadMaxima * 10) + 1];

        for (int i = 1; i <= n; i++) {
            Elemento elemento = elementos.get(i - 1);
            for (int j = 0; j <= capacidadMaxima * 10; j++) {
                double pesoActual = j / 10.0;
                if (elemento.getPeso() > pesoActual) {
                    tabla[i][j] = tabla[i - 1][j];
                } else {
                    tabla[i][j]=Math.max(tabla[i - 1][j], tabla[i - 1][(int) ((pesoActual - elemento.getPeso()) * 10)] + elemento.getBeneficio());
                }
            }
        }

        List<Elemento> mejorCombinacion = new ArrayList<>();
        int i = n;
        int j = (int) (capacidadMaxima * 10);
        while (i > 0 && j > 0) {
            if (tabla[i][j] != tabla[i - 1][j]) {
                Elemento elemento = elementos.get(i - 1);
                mejorCombinacion.add(0, elemento);
                j -= elemento.getPeso() * 10;
            }
            i--;
        }

        return mejorCombinacion;
    }

    public double calcularBeneficioTotal(List<Elemento> elementos) {
        double beneficioTotal = 0;
        for (Elemento elemento : elementos) {
            beneficioTotal += elemento.getBeneficio();
        }
        return beneficioTotal;
    }
    
    public double calcularPesoTotal(List<Elemento> elementos) {
        double pesoTotal = 0;
        for (Elemento elemento : elementos) {
            pesoTotal += elemento.getPeso();
        }
        return pesoTotal;
    }
}