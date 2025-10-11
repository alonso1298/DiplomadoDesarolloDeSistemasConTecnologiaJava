public class FinalAbstract {
    public static void main(String[] args) {
        System.out.println("Final");
        // Metodos y clases abstract
        Radio.mensaje(); // Ejecutamos el metodo estatico 0
        Radio objeto = new Radio();
        Radio.mensaje(); // 1
        objeto.subeVolumen();

        System.out.println("Final");
        double precio = 10;
        precio *= 1.13;
        System.out.println(precio);

        final double IVA = 0.16; // Constante
        System.out.println("IVA de " + IVA);

        objeto.bajaVolumen();

        // static
        System.out.println("Instancias = "+ objeto.instancias);
        objeto.instancias = 123;
        System.out.println("Instancais = " + objeto.instancias);

        Radio nuevo = new Radio(); // 2
        System.out.println("Instancias = " + nuevo.instancias);
        nuevo.instancias = 876;

        System.out.println("Instancias de objeto = " + objeto.instancias);
        System.out.println("Instancias de nuevo = " + nuevo.instancias);
        System.out.println("Instancias de Radio = " + Radio.instancias);

        Radio.mensaje();

        System.out.println("Pacientes Registrados \n\n" + Paciente.listaDePacientes());
    }
}
