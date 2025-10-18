public class PruebaGenericas {
    public static void main(String[] args) {
        System.out.println("Prueba clases genericas");

        ClaseGenerica<Integer> o1 = new ClaseGenerica<Integer>();
        // En o1 la edad sera Integer
        o1.edad = 14;
        o1.imprime(100);
        System.out.println(o1);

        ClaseGenerica<Double> o2 = new ClaseGenerica<Double>();
        o2.edad = 33.3;
        o2.imprime(200.0);
        System.out.println(o2);

        ClaseGenerica<String> o3 = new ClaseGenerica<String>();
        o3.edad = "33.3";
        o3.imprime("Hola");
        System.out.println(o3);

        ClaseGenerica<Paciente> o4 = new ClaseGenerica<>(); // En versiones "recientes"
        o4.edad = new Paciente();
        System.out.println(o4);
    }
}
