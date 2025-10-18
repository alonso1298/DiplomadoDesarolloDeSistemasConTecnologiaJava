public class PruebaGenericas {
    public static void main(String[] args) {
        System.out.println("Prueba clases genericas");

        ClaseGenerica<Integer> o1 = new ClaseGenerica<Integer>();
        o1.imprime();
        System.out.println(o1);
    }
}
