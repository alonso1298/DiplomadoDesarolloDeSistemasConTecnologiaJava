public class Funciones {

    // Funcion llamada sumatoria que reciba un entero n y calcule y regrese la sumatoria de 1 a n
    // sumatoria(5) --> 1+2+3+4+5 = 5

    public static int sumatoria(int n) {
        int resultado = 0;
        for (int i = 1; i <= n; i++) {
            resultado += i; // acumulamos
        }
        return resultado;
    }

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

        System.out.println(sumatoria(5));
    }
}
