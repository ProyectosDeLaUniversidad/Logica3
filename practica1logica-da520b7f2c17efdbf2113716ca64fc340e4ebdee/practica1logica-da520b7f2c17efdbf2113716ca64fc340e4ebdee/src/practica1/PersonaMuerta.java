package practica1;

public class PersonaMuerta {
    private String nombre;
    private int edad;
    private String genero;

    private String causaDeMuerte;
    private String ruta;

    public PersonaMuerta(Persona persona, String causa, String ruta) {
        this.nombre = persona.getName();
        this.edad = persona.getEdad();
        this.genero = persona.getGender();
        this.causaDeMuerte = causa;
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCausaDeMuerte() {
        return causaDeMuerte;
    }

    public void setCausaDeMuerte(String causaDeMuerte) {
        this.causaDeMuerte = causaDeMuerte;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Persona fallecida : " +
                "Nombre=" + nombre +
                ", Edad=" + edad +
                ", Genero=" + genero +
                ", Causa de muerte=" + causaDeMuerte +
                ", Ruta=" + ruta + ".";
    }
}
