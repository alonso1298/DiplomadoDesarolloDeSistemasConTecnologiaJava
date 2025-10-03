public class Sobrecarga {

    // La sobrecarga permite la definicion de dos o mas metodos (funciones/procedimientos)
    // Con el MISMO NOMBRE pero con diferentes parametros de entrada
    // Diferente numero de paramatros de entrada o, si tiene el mismo numero
    // de parametros de entrada con que uno de ellos tenga un tipo de dato diferente

    public static String suma (String palabra1, String palabra2){
        return palabra1 + palabra2;
    }

    public static double suma (int parametro){
        return parametro + 1;
    }

    public static double suma (int primerP, int segundoP){
        double resultado = 0;
        resultado = primerP + segundoP;
        return resultado;
    }

    public static double suma (double par1, double par2){
        double resultado = 0;
        resultado = par1 + par2;
        return resultado;
    }

    public static void main(String[] args) {
        System.out.println("Sobrecarga de metodos (funciones/procedimientos)");

        System.out.println("Suma enteros: " + suma(9, 2));
        System.out.println("Suma doubles: " + suma(9.5, 2.4));
        System.out.println("Suma de un entero: " + suma(9));

        System.out.println(suma(4.5, 9)); // suma de (double, double) double [promocion]

        System.out.println(suma(4.5, '9')); // suma de (double, double) double [promocion]

        System.out.println(suma("Hola ", "Mundo")); // suma de (String + String)
    }
}
