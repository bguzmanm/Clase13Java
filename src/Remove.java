import java.util.ArrayList;

public class Remove {
  public static void main(String[] args) {
    ArrayList<String> estudiantes = new ArrayList<String>();

    estudiantes.add("Jacinto");
    estudiantes.add("Eulalia");
    estudiantes.add("Eulalia");
    estudiantes.add("Eulalia");
    estudiantes.add("Eulalia");
    estudiantes.add("Demetrio");
    System.out.println(estudiantes);

    //estudiantes.clear(); <- elimina a todos los elementos de la colección

    estudiantes.remove("Eulalia");
    //estudiantes.remove(2);
    //estudiantes.remove("Eustaquio");

    System.out.println(estudiantes);


    ArrayList<String> estudiantesAPurgar = new ArrayList<String>();
    estudiantesAPurgar.add("Eulalia");
    estudiantesAPurgar.add("Jacinto");

    estudiantes.removeAll(estudiantesAPurgar);
    System.out.println(estudiantes);

  }
}
