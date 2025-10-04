public class Recursividad {
    public static void main(String[] args) {
        System.out.println("Ejemplos de recursividad");
        System.out.println("Sumatoria de 1 a 10: " + sumatoria(10));

        System.out.println(factorial(5));
    }

    public static int sumatoria (int n) {
        int resultado = 0;
        // Condicion de finalizacion/parada
        if (n == 1)
            resultado = 1; // Por definicion sumatoria(1) = 1;
        else
            resultado = n + sumatoria(n - 1);
        System.out.println("Sali de calcular cumatoria ("+n+")");
        return resultado;
    }

    public static int factorial (int numero) {
        // *n! = n x (n-1)!
        // Donde por definicioncion:
        // 0! = 1
        return (numero == 0) ? 1 : numero * factorial(numero -1 );
    }

    public static int fibonacci(int numero) {
        return numero;
    }
}
