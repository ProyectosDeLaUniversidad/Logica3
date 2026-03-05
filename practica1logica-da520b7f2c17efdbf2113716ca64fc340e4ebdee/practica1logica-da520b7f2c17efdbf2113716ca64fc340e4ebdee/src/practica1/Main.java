package practica1;

import practica2y3.Rover;

import java.util.ArrayList;
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
  }
}


