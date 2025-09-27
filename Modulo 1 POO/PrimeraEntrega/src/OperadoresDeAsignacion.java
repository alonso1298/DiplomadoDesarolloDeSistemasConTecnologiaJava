public class OperadoresDeAsignacion {
    public static void main(String[] args) {
        System.out.println("Operadores de asignacion");
        int numero = 100;
        int otro = 11;

        // Asignacion simple (=)
        // variable = nuevo valor
        numero = otro + 3;

        //Asignacion compuesta (op=)
        // variable op = valor;
        numero += 5; // numero = numero + 5
        numero *= 5; // numero = numero * 5
        numero += 1; // numero = numero + 1

        // ++   y   --
        numero++; // numero += 1 // numero = numero + 1
        numero--; // numero -= 1 // numero = numero - 1

        numero = 100;
        System.out.println(numero++); // 100
        // numero vale 101 en este punto
        System.out.println(++numero);
    }
}
