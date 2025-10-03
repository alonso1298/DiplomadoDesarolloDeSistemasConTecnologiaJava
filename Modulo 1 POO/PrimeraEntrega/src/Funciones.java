public class Funciones {

    public static int siempre10(){
        return 10;
    }

    public static double suma (int num1, int num2) {
        double resultado = 0;
        return resultado = num1 + num2;
    }

    public static void main(String[] args) {
        System.out.println("Funciones");
        System.out.println(siempre10()); // Llamado a la funcion
        int variable = siempre10();
        System.out.println(variable);

        System.out.println("Resultado de llamar a suma: " + suma(5,4));
    }
}
