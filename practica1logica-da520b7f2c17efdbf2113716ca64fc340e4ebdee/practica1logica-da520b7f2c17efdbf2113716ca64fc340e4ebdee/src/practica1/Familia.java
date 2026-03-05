package practica1;

import java.util.ArrayList;
import java.util.List;

public class Familia {
  private List<Persona> family= new ArrayList<>();
  private int nodoMurio;

  public Familia(Persona persona1, Persona persona2, Persona persona3, Persona persona4 ) {
    family.add(persona1);
    family.add(persona2);
    family.add(persona3);
    family.add(persona4);
  }



  public List<Persona> getFamily() {
    return family;
  }

  public void setFamily(List<Persona> family) {
    this.family = family;
  }

  public void mostrarFamilia() {
    for (int i = 0; i < 4; i++)
      if (!family.get(i).getName().equals("")) {
        System.out.println(family.get(i).toString());
      }
  }

  public void mostrarFamiliaLanzada() {
    for (int i = 0; i < 4; i++)
      if (!family.get(i).getName().equals("")) {
        System.out.println(family.get(i).toString() + ", Nodo murieron: "+nodoMurio);
      }
  }


  public int numeroDePersonasVivas(){
    int numeroDePersonas=0;
    for (Persona p : family) {
      if (p.getEdad()!=-1){
        numeroDePersonas++;
      }
    }
    return numeroDePersonas;
  }

  public boolean familiaViva(){
    boolean viva = false;
    for (Persona p : family) {
      if(p.getEdad()!=-1){
        viva=true;
      }
    }
    return viva;
  }

  public void asignarNodoMurieron(int i){
    nodoMurio = i;
  }

  public int getNodoMurio() {
    return nodoMurio;
  }

  public void setNodoMurio(int nodoMurio) {
    this.nodoMurio = nodoMurio;
  }
}
