
package com.mycompany.parcial4;
public class Elemento {
    String nombre;
    double peso;
    double beneficio;

    public Elemento(String nombre, double peso, double beneficio) {
        this.nombre = nombre;
        this.peso = peso;
        this.beneficio = beneficio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(double beneficio) {
        this.beneficio = beneficio;
    }
}
