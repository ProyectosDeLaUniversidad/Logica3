package practica2y3;

import practica1.Familia;
import practica1.Nave;
import practica1.Persona;
import practica1.PersonaMuerta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    //Variables para almacenar datos de las personas en la función generadora
    String nombre, genero;
    int edad;

    //Arreglo que guardará la información de cada persona fallecida durante el viaje
    List<PersonaMuerta> personasMuertas = new ArrayList<>();

    //Variable que nos permitirá manejar más adelante qué evento se ejecutará
    int eventoAnillo;

    //Arreglos de nombres para la función generadora
    String[] nombresHombres = {"Juan", "Pedro", "Manuel", "Luis", "Carlos", "Jorge", "Miguel", "José", "David", "Francisco", "Alejandro", "Mario", "Rafael", "Daniel", "Sergio", "Fernando", "Gabriel", "Antonio", "Ernesto", "Andrés", "Javier", "Adrián", "Diego", "Pablo", "Alfredo", "Eduardo", "Héctor", "Ignacio", "Gustavo", "Roberto", "Raúl", "Óscar", "Tomás", "César", "Abel", "Benjamín", "Emilio", "Hugo", "Israel", "Jaime", "Josué", "Julio", "Leo", "Marco", "Max", "Nicolás", "Ramiro", "Ricardo", "Sebastián", "Víctor"};
    String[] nombresMujeres = {"María", "Ana", "Sofía", "Luisa", "Carmen", "Lucía", "Marta", "Isabel", "Laura", "Patricia", "Paula", "Adriana", "Valeria", "Fernanda", "Valentina", "Camila", "Mónica", "Daniela", "Gabriela", "Carolina", "Liliana", "Claudia", "Rosa", "Elena", "Silvia", "Verónica", "Lorena", "Esther", "Natalia", "Pilar", "Alicia", "Beatriz", "Sara", "Diana", "Emily", "Gloria", "Aurora", "Julia", "Jimena", "Regina", "Miriam", "Ximena", "Irene", "Olga", "Rosario", "Vanessa", "Cecilia", "Angélica", "Elvira", "Rocío"};

    //Arreglo de familias. Acá se guardan las 100 personas de la nave divididas por familias
    Familia[] familias = new Familia[25];

    //Arreglo de personas
    Persona[] personas = new Persona[100];

    //Objeto nave
    Nave nave = new Nave();


    //Función que nos permite generar personas aleatorias con nombres aleatorios del arreglo y edad en
    Random rand = new Random();
    for (int i = 0; i < 100; i++) {

      if (rand.nextInt() % 2 == 0) {
        nombre = nombresHombres[rand.nextInt(50)];
        genero = "masculino";
      } else {
        nombre = nombresMujeres[rand.nextInt(50)];
        genero = "femenino";
      }

      edad = rand.nextInt(81);
      personas[i] = new Persona(nombre, genero, edad);
    }

    //Variable auxiliar para dividir las personas por familias
    int j = 0;

    //Ciclo for que nos permite almacenar el valor de personas dividido por familias
    for (int i = 0; i<25; i++){
        familias[i] = new Familia(personas[j], personas[j+1], personas[j+2], personas[j+3]);
        j=j+4;
    }

    //Usamos la misma variable j en 0 para pasar cada familia a una cabina de la nave
    j = 0;
    for (int i = 0; i < 5; i++){
      for (int k = 0; k < 5; k++){
        nave.ingresarFamilia(i, k, familias[j]);
        j++;
      }
    }

    //Generamos un número random entre 0 a 100 para conocer que evento será el que se ejecutará

    eventoAnillo = rand.nextInt(101);

    System.out.println("\n-----Resumen inicial de la nave-----\n");

    nave.mostrarNave();

    System.out.println("********************************************************************************");
    System.out.println("               Salida de la nave del planeta Gamma(planeta origen) ");
    System.out.println("********************************************************************************\n");

    System.out.println("En el anillo de Gama, están asociados: Evento 1, Evento 4, Evento 7\n");


    //Si el número random se encuentra entre 0 y 20 ocurre el choque con meteorito. 20% de probabilidad
    if(eventoAnillo <= 20){
      nave.colisionarConAsteroide("Saliendo de Gamma hacia Sigma");

      //Si el número random se encuentra entre 20 y 50 ocurre una tormenta solar. 30% de probabilidad
    }else if(eventoAnillo > 20 && eventoAnillo <= 50){
      nave.tormentaSolar();

      //Si el número se encuentra entre 50 y 80 ocurre un ataque de piratas con un 30% de probabilidad
    }else if(eventoAnillo >50 && eventoAnillo <= 80){
      nave.secuestrasMenoresDiagonales();
      System.out.println("Todos los menores de edad de las 2 diagonales fueron secuestrados por esclavistas");

      //Sino, si se encuentra entre 80 y 100, no pasa nada. 20% de probabilidad.
    }else{
      System.out.println("La nave salió de Gamma sana y salva");
    }


    //Generamos otro entero random para escoger el evento que pasará entrando a Sigma
    eventoAnillo = rand.nextInt(101);
    System.out.println();
    System.out.println("********************************************************************************");
    System.out.println("               Entrada de la nave al planeta Sigma(planeta destino) ");
    System.out.println("********************************************************************************\n");
    System.out.println("En el anillo de Sigma, están asociados: Evento 1, Evento 3, Evento 5\n");

    //Si el número está entre 0 y 15 puede ocurrir un choque con un asteroide. 15% de probabilidad
    if(eventoAnillo <= 15){
      nave.colisionarConAsteroide("Entrando a Sigma");

      //Si se encuentra entre 15 y 45 puede ocurrir la fuga de aire. 30% de probabilidad
    }else if(eventoAnillo > 15 && eventoAnillo <= 45){
      nave.fugaDeAire();

      //Si se encuentra entre 45 y 48 puede ocurrir el araque de piratas que secuestra a las mujeres. 40% de probabilida
    }else if(eventoAnillo > 45 && eventoAnillo <= 85){
      nave.secuestrarMujeresDiagonalPpal();
      System.out.println("Todas las mujeres de la diagonal principal han sido secuestradas por piratas");

      //Si no, está entre 85 y 100, no ocurre nada. 15% de probabilidad
    }else{
      System.out.println("La nave entró a Sigma sana y salva");
    }



    System.out.println("\n-----Resumen final personas fallecidas-----\n");
    int i = 0;
    personasMuertas=nave.getPersonasFallecidas();
    for ( PersonaMuerta p : personasMuertas) {
      System.out.println((i+1) +" "+ p.toString());
      i++;
    }

    System.out.println("\n\n-----Resumen final de personas que quedan en la nave-----");
    nave.mostrarNave();

    List<Lado> lados = Arrays.asList(
            new Lado(1, 2, 1), new Lado(1, 8, 2), new Lado(2, 3, 4),
            new Lado(2, 4, 1), new Lado(2, 7, 3), new Lado(3, 5, 3),
            new Lado(3, 6, 3), new Lado(4, 9, 3), new Lado(5, 4, 6),
            new Lado(5, 6, 2), new Lado(7, 8, 1), new Lado(9, 6, 2),
            new Lado(9, 10, 5));

    Grafo grafo = new Grafo(lados);

    Grafo.printGraph(grafo);

    personasMuertas.clear();
    Rover rover = new Rover();

    for (int k = 0; k < 5; k++) {
      for (int l = 0; l < 5; l++) {
        if((nave.getNave()[k][l].familiaViva()) && (rover.getCabinas().size()<9)){
          rover.agregarFamilia(nave.getNave()[k][l]);
        }
      }
    }

    int nodoAViajar = 0;
    int cantidadAdyacentes = 0;
    int nodoActual = rand.nextInt(10)+1;

    System.out.println("El rover ha aterrizado en el nodo " + nodoActual);

    int cantidadDePersonas = 0;

    for (Familia familia : rover.getCabinas()) {
      cantidadDePersonas += familia.numeroDePersonasVivas();
    }

    System.out.println("cantidad de personas " + cantidadDePersonas);
    int peso;
    int consumoDeOxígeno;
    //Instrucciones para realizar el recorrido
    while((nodoActual != 8) && (nodoActual != 10) && (nodoActual != 6) && (rover.getUnidadesReserva() != 0)){

      cantidadAdyacentes = grafo.getAdjList().get(nodoActual).size();
      nodoAViajar = rand.nextInt(cantidadAdyacentes);

      peso = grafo.getAdjList().get(nodoActual).get(nodoAViajar).peso;
      nodoActual = grafo.getAdjList().get(nodoActual).get(nodoAViajar).valor;

      System.out.println("El rover está viajando al nodo " + nodoActual);



      consumoDeOxígeno = peso * cantidadDePersonas;
      System.out.println("Unidades de oxígeno en rover: " + rover.getUnidadesOxigeno());
      System.out.println("Unidades de reserva en rover: " + rover.getUnidadesReserva());
      System.out.println("El consumo de oxígeno en este trayecto es: " + consumoDeOxígeno);

      if((rover.getUnidadesOxigeno()-consumoDeOxígeno)<0){
        rover.setUnidadesReserva(rover.getUnidadesOxigeno()-consumoDeOxígeno + rover.getUnidadesReserva());
        rover.setUnidadesOxigeno(0);
        System.out.println("¡Han tirado a la primera familia por la borda!");
        rover.tirarFamiliaABorda(nodoActual);
        if(rover.getUnidadesReserva() < 0){
          rover.setUnidadesReserva(0);
          System.out.println("El rover comienza su viaje al nodo " + nodoActual + "...");
          System.out.println("El rover no ha llegado al nodo " + nodoActual + "...");
        }else{
          System.out.println("El rover ha llegado al nodo "+nodoActual +" con "+rover.getUnidadesOxigeno() + " unidades de oxigeno y " + rover.getUnidadesReserva() + " unidades de reserva");
        }

      }else{
        rover.setUnidadesOxigeno(rover.getUnidadesOxigeno()-consumoDeOxígeno);
      }

    }

    System.out.println("\n\n***********Estado final del Rover*********\n");



    //Estado final del rover

    int sizeCabinas;
    if((nodoActual == 8) || (nodoActual == 10) && ((rover.getUnidadesReserva() != 0) || (rover.getUnidadesOxigeno()!= 0)) ){
      System.out.println("\nEl rover quedó atrapado en el valle del nodo " + nodoActual);
       sizeCabinas = rover.getCabinas().size();
      for (int k = 0; k < sizeCabinas; k++) {
        rover.tirarFamiliaABorda(nodoActual);
      }
    }else if((nodoActual == 8) || (nodoActual == 10) && ((rover.getUnidadesReserva() == 0)) ){
      System.out.println("El rover se quedó sin oxígeno momentos antes de quedar atrapado en el valle del nodo " + nodoActual);sizeCabinas = rover.getCabinas().size();
      sizeCabinas = rover.getCabinas().size();
      for (int k = 0; k < sizeCabinas; k++) {
        rover.tirarFamiliaABorda(nodoActual);
      }
    } else if ((nodoActual == 6) && (rover.getUnidadesReserva()!=0)) {
      System.out.println("El rover llegó a la base");
    }else if(nodoActual == 6){
      System.out.println("El rover se quedó sin oxígeno momentos antes de llegar a la base");
      sizeCabinas = rover.getCabinas().size();
      for (int k = 0; k < sizeCabinas; k++) {
        rover.tirarFamiliaABorda(nodoActual);
      }
    }else{
      System.out.println("El rover se quedó sin oxígeno momentos antes de llegar al nodo " + nodoActual);
      sizeCabinas = rover.getCabinas().size();
      for (int k = 0; k < sizeCabinas; k++) {
        rover.tirarFamiliaABorda(nodoActual);
      }
    }

    cantidadDePersonas = 0;

    for (Familia familia : rover.getCabinas()) {
      cantidadDePersonas += familia.numeroDePersonasVivas();
    }

    System.out.println("Cantidad de personas final " + cantidadDePersonas);

    for (Familia f: rover.getFamiliasLanzadas()
         ) {
      f.mostrarFamiliaLanzada();
    }

    //Implementación árbol

    List<LadoArbol> ladosArbol = Arrays.asList(new LadoArbol(1, 2), new LadoArbol(2, 5),
            new LadoArbol(5, 18), new LadoArbol(2, 6), new LadoArbol(6, 11),
            new LadoArbol(2, 7), new LadoArbol(7, 17), new LadoArbol(1, 3),
            new LadoArbol(3, 8), new LadoArbol(8, 12), new LadoArbol(8, 13),
            new LadoArbol(1, 4), new LadoArbol(4, 9), new LadoArbol(9, 16),
            new LadoArbol(4, 10), new LadoArbol(10, 14));

    Arbol arbol = new Arbol(ladosArbol);

    Arbol.mostrarArbol(arbol);

    Ruta ruta1 = new Ruta(0, 0, 0);
    Ruta ruta2 = new Ruta(0, 1, 0);
    Ruta ruta3 = new Ruta(0, 2, 0);
    Ruta ruta4 = new Ruta(1, 0, 0);
    Ruta ruta5 = new Ruta(1, 0, 1);
    Ruta ruta6 = new Ruta(2, 0, 0);
    Ruta ruta7 = new Ruta(2, 1, 0);



    float[] promedios = new float[7];

    float promedioActual;

    promedioActual = calcularPromedioRuta(ruta1, 18, arbol, rover);
    System.out.println("El promedio de factores de ganancia para la ruta 1 es: " + promedioActual +"\n");
    promedios[0] = promedioActual;

    promedioActual = calcularPromedioRuta(ruta2, 11, arbol, rover);
    System.out.println("El promedio de factores de ganancia para la ruta 2 es: " + promedioActual +"\n");
    promedios[1] = promedioActual;

    promedioActual = calcularPromedioRuta(ruta3, 17, arbol, rover);
    System.out.println("El promedio de factores de ganancia para la ruta 3 es: " + promedioActual +"\n");
    promedios[2] = promedioActual;

    promedioActual = calcularPromedioRuta(ruta4, 12, arbol, rover);
    System.out.println("El promedio de factores de ganancia para la ruta 4 es: " + promedioActual +"\n");
    promedios[3] = promedioActual;

    promedioActual = calcularPromedioRuta(ruta5, 13, arbol, rover);
    System.out.println("El promedio de factores de ganancia para la ruta 5 es: " + promedioActual +"\n");
    promedios[4] = promedioActual;

    promedioActual = calcularPromedioRuta(ruta6, 16, arbol, rover);
    System.out.println("El promedio de factores de ganancia para la ruta 6 es: " + promedioActual +"\n");
    promedios[5] = promedioActual;

    promedioActual = calcularPromedioRuta(ruta7, 14, arbol, rover);
    System.out.println("El promedio de factores de ganancia para la ruta 7 es: " + promedioActual +"\n");
    promedios[6] = promedioActual;

    float mayorPromedio = 0;
    int ruta = 0;

    for (int k = 0; k < promedios.length; k++) {
      if(promedios[k] > mayorPromedio){
        mayorPromedio = promedios[k];
        ruta = k+1;
      }
    }

    System.out.println("El mayor promedio de los índices de ganancia para todas las rutas es el de la ruta "+ ruta + " con un promedio de factor de ganancia de "+mayorPromedio);
  }

  static float calcularPromedioRuta(Ruta ruta, float factorGanancia, Arbol arbol, Rover rover) {
    float acumuladoFactores = 0.0f;
    int nodoActual;
    int nodoAViajar;
    float promedio = 0.0f;
    Random rand = new Random();
    boolean randomArbol = rand.nextBoolean();

    for (int k = 0; k < 100; k++) {
      nodoActual = 1;
      float contadorMuertos = 0.0F;

      nodoAViajar = arbol.adjList.get(nodoActual).get(ruta.getPaso1());
      nodoActual = nodoAViajar;

      contadorMuertos += calcularMuertosPorNodo(nodoActual, rover);

      nodoAViajar = arbol.adjList.get(nodoActual).get(ruta.getPaso2());
      nodoActual = nodoAViajar;

      contadorMuertos += calcularMuertosPorNodo(nodoActual, rover);

      nodoAViajar = arbol.adjList.get(nodoActual).get(ruta.getPaso3());
      nodoActual = nodoAViajar;

      if(contadorMuertos == 0){
        contadorMuertos++;
      }
      acumuladoFactores += (factorGanancia/contadorMuertos);
    }

    promedio = acumuladoFactores/100;
    return promedio;
  }
  static int calcularMuertosPorNodo(int nodoActual, Rover rover){
    int contadorMuertos = 0;
    Random rand = new Random();
    boolean randomArbol;
    for (Familia f : rover.getCabinas()
    ) {
      for (Persona p : f.getFamily()
      ) {
        if ((p.getEdad() % nodoActual == 0)) {
          randomArbol = rand.nextBoolean();
          if (randomArbol) {
            contadorMuertos++;
          }
        }
      }
    }
    return contadorMuertos;
  }
}