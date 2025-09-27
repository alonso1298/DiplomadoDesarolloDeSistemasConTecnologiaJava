public class Variables {
    public static void main(String[] args) {
        // Definicion de variables
        int numero;

        // Definicion e inicializar variables
        int edad = 99;
        int otorNumero = numero = 100; // En java 8 no funciona

        // Uso de variable
        System.out.println(edad);
        System.out.println(numero);
        System.out.println(otorNumero);

        System.out.println(edad=edad+10);
    }
}
