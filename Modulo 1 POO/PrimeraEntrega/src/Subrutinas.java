public class Subrutinas {
    public static void hola () {
        int variable = 10;
        variable++;
        System.out.println("Hola");
        //saluda("Mundo");
    }

    public static void saluda (String nombre){
        System.out.println("Hola " + nombre);
    }

    public static void despedida (String nombre, int veces){
        for (int i = 0; i < veces; i++) {
            System.out.println("Hasta luego " + nombre );
        }
    }

    public static void main(String[] args) {
        System.out.println("Subrutinas");
        hola(); // Llamado/Ejecucion de un procedimiento
        System.out.println("...mas codigo...");
        hola();
        saluda("Alonso");
        saluda("Juan");
        despedida("Alex", 5);
    }
}
