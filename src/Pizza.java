import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
  public static void main(String[] args) {
    ArrayList<String> ingredientes = new ArrayList<String>();

    ingredientes.add("Piña");
    ingredientes.add("Jamón");
    ingredientes.add("Salsa de tomates");
    ingredientes.add("Queso");

    Scanner sc = new Scanner(System.in);
    System.out.printf("Ingresa el nuevo ingrediente\n");
    String nuevoIngrediente = sc.nextLine();

    if (ingredientes.contains(nuevoIngrediente)) {
      System.out.printf("El ingrediente %s ya existe\n", nuevoIngrediente);
    } else {
      ingredientes.add(nuevoIngrediente);
      System.out.printf("Agregamos el ingrediente %s\n", nuevoIngrediente);
    }

    System.out.println(ingredientes);


  }
}
