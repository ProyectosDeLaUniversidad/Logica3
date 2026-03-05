//Creamos esta clase para simbolizar a cada tripulante de la nave, con los atributos necesarios para el ejercicio

package practica1;

public class Persona {
  private String nombre;
  private String genero;
  private int edad;

  public Persona(String name, String gender, int edad) {
    this.nombre = name;
    this.genero = gender;
    this.edad = edad;
  }

  public Persona() {
    nombre = "";
    genero = "";
    edad = -1;
  }

  public String getName() {
    return nombre;
  }

  public void setName(String name) {
    this.nombre = name;
  }

  public String getGender() {
    return genero;
  }

  public void setGender(String gender) {
    this.genero = gender;
  }

  public int getEdad() {
    return edad;
  }

  public void setEdad(int edad) {
    this.edad = edad;
  }

  @Override
  public String toString() {
    return "Persona{" +
            "name='" + nombre + '\'' +
            ", gender='" + genero + '\'' +
            ", edad=" + edad +
            '}';
  }
}
