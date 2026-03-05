public class Termino {

    private int coeficiente, exponencial;

    public void asignarCoeficiente(int coeficiente){
        this.coeficiente = coeficiente;
    }

    public void asignarExponencial(int exponencial) {
        this.exponencial = exponencial;
    }

    public int retornarCoeficiente() {
        return coeficiente;
    }

    public int retornarExponencial() {
        return exponencial;
    }
}
