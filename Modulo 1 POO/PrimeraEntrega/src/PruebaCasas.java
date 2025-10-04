public class PruebaCasas {
    public static void main(String[] args) {
        System.out.println("Uso de casas");

        Casa casaFernando = new Casa();
        Casa casaFabiola = new Casa();

        System.out.println("Casa de Fernando " + casaFernando);
        // Para ejecutar o llamar un metodo de un objeto
        // nombredelObjeto.nombreDelMetodo(parametros de entrada);
        casaFernando.pintar("Amarillo canario");
        System.out.println("\t" + casaFernando.color);

        System.out.println("Casa de Fabiola " + casaFabiola);
        casaFabiola.pintar("Rojo Sangre");
        System.out.println("\t" + casaFabiola.color);
        casaFabiola.vender("Fabiola Moreno");
        System.out.println("\t" + casaFabiola.propietario);

    }
}
