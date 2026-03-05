package practica2y3;

import practica1.Familia;
import practica1.Persona;

import java.util.ArrayList;
import java.util.List;

public class Rover {
    private int numeroDePersonas;
    private int unidadesOxigeno;
    private int unidadesReserva;

    List<Familia> cabinas = new ArrayList<>();
    List<Familia> familiasLanzadas = new ArrayList<>();
    public Rover() {
        this.numeroDePersonas = 0;
        this.unidadesOxigeno = 300;
        this.unidadesReserva = 20;
    }

    public void agregarFamilia(Familia familia){

        cabinas.add(familia);
    }

    public int getNumeroDePersonas() {
        return numeroDePersonas;
    }

    public void setNumeroDePersonas(int numeroDePersonas) {
        this.numeroDePersonas = numeroDePersonas;
    }

    public int getUnidadesOxigeno() {
        return unidadesOxigeno;
    }

    public void setUnidadesOxigeno(int unidadesOxigeno) {
        this.unidadesOxigeno = unidadesOxigeno;
    }

    public List<Familia> getCabinas() {
        return cabinas;
    }

    public void setCabinas(ArrayList<Familia> cabinas) {
        this.cabinas = cabinas;
    }

    @Override
    public String toString() {
        return "Rover{" +
                "cabinas=" + cabinas +
                '}';
    }

    public void tirarFamiliaABorda(int i){
        cabinas.get(0).asignarNodoMurieron(i);
        familiasLanzadas.add(cabinas.get(0));
        cabinas.remove(0);
    }

    public int getUnidadesReserva() {
        return unidadesReserva;
    }

    public void setUnidadesReserva(int unidadesReserva) {
        this.unidadesReserva = unidadesReserva;
    }

    public void setCabinas(List<Familia> cabinas) {
        this.cabinas = cabinas;
    }

    public List<Familia> getFamiliasLanzadas() {
        return familiasLanzadas;
    }

    public void setFamiliasLanzadas(List<Familia> familiasLanzadas) {
        this.familiasLanzadas = familiasLanzadas;
    }
}
