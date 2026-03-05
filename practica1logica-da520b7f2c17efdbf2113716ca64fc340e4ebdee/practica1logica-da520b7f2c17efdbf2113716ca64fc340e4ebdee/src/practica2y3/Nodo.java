package practica2y3;

public class Nodo {
    int valor, peso;

    Nodo(int valor, int peso)
    {
        this.valor = valor;
        this.peso = peso;
    }

    @Override
    public String toString() {
        return this.valor + " (" + this.peso + ")";
    }
}
