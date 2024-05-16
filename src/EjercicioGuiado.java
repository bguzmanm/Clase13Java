import java.util.ArrayList;

public class EjercicioGuiado {
  public static void main(String[] args) {

    agregarNumeroPar(2);

  }

  static void agregarNumeroPar(int numero){
    ArrayList<Integer> numeros = new ArrayList<Integer>();
    if (numero%2 == 0){
      numeros.add(numero);
    }

    System.out.println(numeros);
  }
}
