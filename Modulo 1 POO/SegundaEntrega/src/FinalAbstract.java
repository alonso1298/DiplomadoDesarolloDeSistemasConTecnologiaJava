public class FinalAbstract {
    public static void main(String[] args) {
        System.out.println("Final");
        // Metodos y clases abstract
        Radio objeto = new Radio();
        objeto.subeVolumen();

        System.out.println("Final");
        double precio = 10;
        precio *= 1.13;
        System.out.println(precio);

        final double IVA = 0.16; // Constante
        System.out.println("IVA de " + IVA);

        objeto.bajaVolumen();
    }
}
