public class OperadorTernario {
    public static void main(String[] args) {
        System.out.println("Ejemplo de operadores lógicos");
        int edad = 17;
        char genero = 'M';
        String resultado;
        // Condicion ? expresion1 : espresion 2 -->
        // Esta obligado a realizar el servicio militar nacional?
        resultado = ( edad >= 18) && (genero == 'M') ? "Esta obligado" : "Felicidades, no tienes que hacer el SMN";
        System.out.println(resultado);

        // El proximo año estara obligado?
        resultado = ( ++edad >= 18) && (genero == 'M') ? "Esta obligado" : "Felicidades, no tienes que hacer el SMN";
        System.out.println(resultado);
    }
}
