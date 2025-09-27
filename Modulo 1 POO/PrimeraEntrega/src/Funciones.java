public class Funciones {

    public static int siempre10(){
        return 10;
    }

    public static void main(String[] args) {
        System.out.println("Funciones");
        System.out.println(siempre10()); // Llamado a la funcion
        int variable = siempre10();
        System.out.println(variable);
    }
}
