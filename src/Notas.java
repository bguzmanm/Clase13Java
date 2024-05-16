import java.util.Scanner;

/**
 * Manejar un arreglo, que mantenga los nombres de los y las
 * estudiantas.
 * Otro arreglo (bidimensional, de nx3), donde cada fila, contiene las notas de cada estudiante.
 * Implementar un menú, que permita:
 * 1. Listar los estudiantes y sus notas.
 * 2. Determinar el mejor promedio.
 * 3. Determinar quienes aprueban (promedio > 4).
 * Utilice funciones y arreglos unidimensionales y bidimensionales.
 */

public class Notas {
  public static void main(String[] args) {
    int op;
    String[] nombres = null;
    float[][] notas = null;
    boolean dimensionados = false;
    do {
      op = mostrarMenu();
      if (op == 1){
        int n = leerValorInt("Ingresa el número de estudiantes que registrarás:\n");
        nombres = new String[n];
        notas = new float[n][3];
        llenarArreglos(nombres, notas);

        dimensionados = true;
      } else if (op == 2 && dimensionados) {
        mostrarArreglos(nombres, notas);
      } else if (op == 3 && dimensionados) {
        mostrarPromedioMasAlto(nombres, notas);
      } else if (op == 4 && dimensionados) {
        mostrarAprobados(nombres, notas, 4f);
      } else if (op == 0) {
        mensaje("Adio!\n");
      } else if (!dimensionados) {
        mensaje("Debes ingresar los estudiantes y sus notas: op = 1\n");
      }
    } while (op != 0);
  }

  static int mostrarMenu(){
    mensaje(" === MENÚ DE OPCIONES ===\n");
    mensaje(" 1. Agregar Estudiantes\n");
    mensaje(" 2. Listado de Estudiantes\n");
    mensaje(" 3. Mejor Promedio\n");
    mensaje(" 4. Aprobados\n");
    mensaje(" 0. Salir\n");
    return leerValorInt("\nElige una opción\n");
  }

  static void mostrarAprobados(String[] nombres, float[][] notas, float minimo){
    for (int i = 0; i < nombres.length; i++) {
      float prom = promedio(i, notas);
      if (prom >= minimo){
        mensaje(String.format("%s aprobó con un %.2f\n", nombres[i], prom));
      }
    }
  }

  static void mostrarPromedioMasAlto(String[] nombres, float[][] notas) {

    String estudiantePromedioMasAlto = nombres[0];
    float promedioMasAlto = promedio(0, notas);

    for (int i = 0; i < nombres.length; i++) {
      float prom = promedio(i, notas);
      if (promedioMasAlto < prom) {
        estudiantePromedioMasAlto = nombres[i];
        promedioMasAlto = prom;
      }
    }

    mensaje(String.format("El estudiante con el promedio más alto es %s con un promedio de %.2f\n",
            estudiantePromedioMasAlto, promedioMasAlto));

  }

  static float promedio(int n, float[][] notas) {
    float prom = 0;
    for (int i = 0; i < notas[n].length ; i++) {
      prom += notas[n][i];
    }
    return prom / notas[n].length;
  }


  static void llenarArreglos(String[] nombres, float[][] notas) {
    for (int i = 0; i < nombres.length ; i++) {
        mensaje("==========================================\n");
        nombres[i] = leerValorString(String.format("Ingresa el nombre del estudiante n° %d\n", i+1));
        notas[i][0] = leerValorFloat(String.format("Ingresa la nota n°1 de %s:\n", nombres[i]));
        notas[i][1] = leerValorFloat(String.format("Ingresa la nota n°2 de %s:\n", nombres[i]));
        notas[i][2] = leerValorFloat(String.format("Ingresa la nota n°3 de %s:\n", nombres[i]));
    }
  }

  static void mostrarArreglos(String[] nombres, float[][] notas) {
    for (int i = 0; i < nombres.length ; i++) {
      mensaje(String.format("%s : [%.2f] [%.2f] [%.2f]\n", nombres[i], notas[i][0],notas[i][1],notas[i][2]));
    }
  }

  static void mensaje(String mensaje){
    System.out.printf(mensaje);
  }

  static int leerValorInt(String mensaje) {
    Scanner sc = new Scanner(System.in);
    mensaje(mensaje);
    return sc.nextInt();
  }
  static float leerValorFloat(String mensaje) {
    Scanner sc = new Scanner(System.in);
    mensaje(mensaje);
    return sc.nextFloat();
  }
  static String leerValorString(String mensaje) {
    Scanner sc = new Scanner(System.in);
    mensaje(mensaje);
    return sc.nextLine();
  }


}