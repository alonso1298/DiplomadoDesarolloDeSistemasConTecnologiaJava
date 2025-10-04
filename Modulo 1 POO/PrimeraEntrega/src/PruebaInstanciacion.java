public class PruebaInstanciacion {
    public static void main(String[] args) {
        System.out.println("Ejemplo de creacion de objetos (instanciacion)");

        // Creacion de objetos
        // Clase objeto = new Clase();
        // Si quiero crear un objeto llamado casaMauricio
        Casa casaMauricio = new Casa();
        Casa nuevaCasa = new Casa();

        // Para hecer uso de un atributo de un objeto usaremos:
        // nombre del objeto.nombre del atruibuto
        casaMauricio.pisos = 3;
        casaMauricio.ventanas = 10;
        casaMauricio.precio = 100;
        casaMauricio.color = "Rojo";

        System.out.println("Casa de Mauricio pisos: " + casaMauricio.pisos);
        System.out.println("Casa de Mauricio precio: $ " + casaMauricio.precio);
        System.out.println("Casa de Mauricio ventanas: " + casaMauricio.ventanas);
        System.out.println("Casa de Mauricio color: " + casaMauricio.color);

        System.out.println("\n");

        nuevaCasa = casaMauricio;
        System.out.println("Casa de Nueva pisos: " + nuevaCasa.pisos);
        System.out.println("Casa de Nueva precio: $ " + nuevaCasa.precio);
        System.out.println("Casa de Nueva ventanas: " + nuevaCasa.ventanas);
        System.out.println("Casa de Nueva color: " + nuevaCasa.color);

        Casa unaCasa = new Casa();
        Casa otraCasa = new Casa();

        System.out.println(unaCasa == otraCasa);  // false porque son referencias diferentes
        System.out.println(casaMauricio == nuevaCasa); // true porque es la misma casa
    }
}
