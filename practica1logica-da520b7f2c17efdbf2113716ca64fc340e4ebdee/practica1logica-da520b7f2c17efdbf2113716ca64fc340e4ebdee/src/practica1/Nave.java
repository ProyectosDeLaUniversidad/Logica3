package practica1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Nave {
  private Familia[][] nave = new Familia[5][5];
  private List<PersonaMuerta> personasFallecidas = new ArrayList<>();


  public Nave() {

  }

  public void setNave(Familia[][] nave) {
    this.nave = nave;
  }

  public Familia[][] getNave() {
    return nave;
  }


  public void ingresarFamilia(int i, int j, Familia familia) {
    this.nave[i][j] = familia;
  }


  public void mostrarNave() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
          System.out.println("Familia en la posición " + i + ", " + j);
          nave[i][j].mostrarFamilia();
          System.out.println("----------------------------------------\n");
      }
    }
  }

  //Evento #1 (Colisión con asteroide)***********************************************************************
  public void colisionarConAsteroide(String ruta) {
    Random rand = new Random();

    int cuadrante = rand.nextInt(4);
    if (cuadrante == 0) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (i < j) {
            for (int k = 0; k < 4; k++) {
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 1", ruta);
                personasFallecidas.add(personaMuerta);
              }
            }
            nave[i][j] = new Familia(new Persona(), new Persona(), new Persona(), new Persona());
          }
        }
      }
      System.out.println("La nave colisionó con un asteroide. Impactó a todo el cuadrante 1. No queda nadie allí");
    } else if (cuadrante == 1) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (i > j) {
            for (int k = 0; k < 4; k++) {
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 1", ruta);
                personasFallecidas.add(personaMuerta);
              }
            }
            nave[i][j] = new Familia(new Persona(), new Persona(), new Persona(), new Persona());
          }
        }
      }
      System.out.println("La nave colisionó con un asteroide. Impactó a todo el cuadrante 2. No queda nadie allí");
    } else if (cuadrante == 2) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if ((i + j) < 4) {
            for (int k = 0; k < 4; k++) {
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 1", ruta);
                personasFallecidas.add(personaMuerta);
              }
            }
            nave[i][j] = new Familia(new Persona(), new Persona(), new Persona(), new Persona());
          }
        }
      }System.out.println("La nave colisionó con un asteroide. Impactó a todo el cuadrante 3. No queda nadie allí");

    } else if (cuadrante == 3) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if ((i + j) > 4) {
            for (int k = 0; k < 4; k++) {
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 1", ruta);
                personasFallecidas.add(personaMuerta);
              }
            }
            nave[i][j] = new Familia(new Persona(), new Persona(), new Persona(), new Persona());
          }
        }
      }
      System.out.println("La nave colisionó con un asteroide. Impactó a todo el cuadrante 4. No queda nadie allí");
    }
  }


  //Evento 3 (Fuga de aire)************************************************************************************
  public Persona[] fugaDeAire() {
    Persona[] personas = new Persona[10];
    int edadActual;
    int[] edades = new int[10];
    Persona viejoActual = new Persona();
    for (int i = 0; i < 10; i++) {
      edades[i] = 0;
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 4; k++) {
          edadActual = nave[i][j].getFamily().get(k).getEdad();
          for (int l = 0; l < 10; l++) {
            if (edadActual > edades[l]) {
              for (int m = edades.length - 1; m > l; m--) {
                edades[m] = edades[m - 1];
                personas[m] = personas[m - 1];
              }
              edades[l] = edadActual;
              personas[l] = nave[i][j].getFamily().get(k);
              break;
            }
          }
        }
      }
    }

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        for (int k = 0; k < 4; k++) {
          for (int l = 0; l < 10; l++) {
            if (personas[l] == nave[i][j].getFamily().get(k)){
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 3", "Entrando a Sigma");
                personasFallecidas.add(personaMuerta);

                nave[i][j].getFamily().remove(k);
                nave[i][j].getFamily().add(new Persona("", "", -1));
              }

            }
          }
        }

      }
    }
    System.out.println("Hay una fuga de aire en la nave. Se expulsan las 10 personas más viejas para ahorrar oxígeno");
    return personas;
  }


  //Evento #4 (tormenta solar)*********************************************************************************
  public void tormentaSolar() {
    Random rand = new Random();

    boolean bandera = rand.nextBoolean();
    if (bandera == false) {
      tormentaSolarFila();
    } else {
      tormentaSolarColumna();
    }
  }

  //Metodo implementado en el evento #4
  public void tormentaSolarFila() {
    Random rand = new Random();

    boolean fila = rand.nextBoolean();
    if (fila == false) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (i == 0) {
            for (int k = 0; k < 4; k++) {
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 4", "Saliendo de Gamma");
                personasFallecidas.add(personaMuerta);
              }
            }
            nave[i][j] = new Familia(new Persona(), new Persona(), new Persona(), new Persona());
          }
        }
      }
      System.out.println("Una tormenta solar ha alcanzado la nave. Han muerto todos los del la primera fila");
    } else {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (i == 4) {
            for (int k = 0; k < 4; k++) {
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 4", "Saliendo de Gamma");
                personasFallecidas.add(personaMuerta);
              }
            }
            nave[i][j] =  new Familia(new Persona(), new Persona(), new Persona(), new Persona());
          }
        }
      }
      System.out.println("Una tormenta solar ha alcanzado la nave. Han muerto todos los del la última fila");
    }
  }

  //Metodo implementado en el evento #4
  public void tormentaSolarColumna() {
    Random rand = new Random();

    boolean columna = rand.nextBoolean();
    if (columna == false) {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (j == 0) {
            for (int k = 0; k < 4; k++) {
              PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 4", "Saliendo de Gamma");
              personasFallecidas.add(personaMuerta);
            }
            nave[i][j] =  new Familia(new Persona(), new Persona(), new Persona(), new Persona());
          }
        }
      }
      System.out.println("Una tormenta solar ha alcanzado la nave. Han muerto todos los del la primera columna");
    } else {
      for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
          if (j == 4) {
            for (int k = 0; k < 4; k++) {
              PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 4", "Saliendo de Gamma");
              personasFallecidas.add(personaMuerta);
            }
            nave[i][j] = new Familia(new Persona(), new Persona(), new Persona(), new Persona());
          }
        }
      }
    }
    System.out.println("Una tormenta solar ha alcanzado la nave. Han muerto todos los del la última columna");
  }

  //Evento #5 (Ataque de piratas)*******************************************************************************
  public void secuestrarMujeresDiagonalPpal() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i == j) {
          for (int k = 0; k < 4; k++) {
            if (nave[i][j].getFamily().get(k).getGender().equalsIgnoreCase("femenino")) {
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 5", "Entrando a Sigma");
                personasFallecidas.add(personaMuerta);

                nave[i][j].getFamily().remove(k);
                nave[i][j].getFamily().add(new Persona("", "", -1));
              }

            }
          }
        }
      }
    }
  }

  //Metodo no implementado - Evento #6************************************************************************
  public void secuestrarHombresDiagonalSecundaria() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i + j == 4) {
          for (int k = 0; k < 4; k++) {
            if (nave[i][j].getFamily().get(k).getGender().equalsIgnoreCase("masculino")) {
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 6", "Saliendo de Gamma");
                personasFallecidas.add(personaMuerta);

                nave[i][j].getFamily().remove(k);
                nave[i][j].getFamily().add(new Persona("", "", -1));
              }

            }
          }
        }
      }
    }
  }

  //Evento #7 (Esclavistas)****************************************************************************************
  public void secuestrasMenoresDiagonales() {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if ((i + j == 4) || (i == j)) {
          for (int k = 0; k < 4; k++) {
            if (nave[i][j].getFamily().get(k).getEdad() < 18) {
              if (nave[i][j].getFamily().get(k).getEdad() != -1){
                PersonaMuerta personaMuerta = new PersonaMuerta(nave[i][j].getFamily().get(k), "Evento 7", "Saliendo de Gamma");
                personasFallecidas.add(personaMuerta);

                nave[i][j].getFamily().remove(k);
                nave[i][j].getFamily().add(new Persona("", "", -1));
              }

            }
          }
        }
      }
    }
  }

  public List<PersonaMuerta> getPersonasFallecidas() {
    return personasFallecidas;
  }
}
