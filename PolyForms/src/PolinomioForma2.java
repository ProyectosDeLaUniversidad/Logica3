
public class PolinomioForma2 {

    private Object vector[];

    public PolinomioForma2(int n){
        vector = new Object[n+2];
        vector[0] = 0;
        for (int i=1; i<=n+1; i++)
            vector[i]=null;
    }

    public Termino terminoEnPosicion(int pos){
        return (Termino) vector[pos];
    }

    public int numeroDeTerminos(){
        return (Integer) vector[0];
    }

    public void asignaTermino(Termino t, int pos){
        vector[pos]=t;
    }

    public void asignaNumeroTerminos(int i){
        vector[0]=Integer.valueOf(i);
    }

    public int grado(){
        return ((Termino) vector[1]).retornarExponencial();
    }
}
