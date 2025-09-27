public class TiposDeDatos {
    public static void main(String[] args) {

        // Booleanos
        boolean asistio = true;
        boolean reprobo = false;
        System.out.println("Valor boolean: " + asistio);

        // Numeros
        // Enteros (byte, short, int, long)
        byte edas; // Un byte (8 bits) -128 +128
        short peso; //Dos bytes (16b bits)
        int precio; // Cuatro bytes (32 bits)
        long distancia; // Ocho bytes (64 bits)
        // Reales (float, double)
        float costo = 156.98F;
        double temperatura = -98.32; // 8 bytes

        // Caracter (char)
        char inicial = 'E';
        char letra = 'j';

        /* Este es un ejemplo de
        comentario que ocupa mas
        de una linea
        */

        /* Secuencias de escape */
        // \n \r \t
        System.out.println("Universidad Nacional \nAutonoma De Mexico");
    }
}
