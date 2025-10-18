import java.util.ArrayList;

public class ColeccionConArrayList {
    public static void main(String[] args) {
        System.out.println("Coleccion con ArrayList");
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(30);
        numeros.add(50);
        numeros.add(60);
        System.out.println(numeros + ": " + numeros.size());
        System.out.println(numeros.get(1)); // Extraccion de un elemento
        System.out.println(numeros.contains(50)); // Prueba de existencia
        System.out.println(numeros.indexOf(50)); // Ubica la posicion de un elemento

        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Hugo");
        nombres.add("Alonso");
        nombres.add("Paco");
        System.out.println(nombres);
        nombres.add(1, "Donald");
        System.out.println(nombres);
    }
}
