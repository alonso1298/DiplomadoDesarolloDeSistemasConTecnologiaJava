enum Estatus {
    CONFIRMADO,
    ARMANDO,
    ENVIADO,
    RECIBIDO
}
public class Enumeraciones {
    public static void main(String[] args) {
        System.out.println("Enumeraciones");
        Estatus objeto = Estatus.CONFIRMADO;
        System.out.println("Tu pedido esta en " + objeto);
        // ....
        objeto = Estatus.ARMANDO;
        System.out.println("Tu pedido esta en " + objeto);
        // ....
        objeto = Estatus.RECIBIDO;
        System.out.println("Finalmente, tu pedido esta " + objeto);

        // Uso de la enumeración Nivel
        Nivel nivelAlonso = Nivel.PLATA;
        System.out.println("Nivel de Alonso " + nivelAlonso);
        System.out.println("\tDebe pagar anualmente: $" + nivelAlonso.getAnualidad());
        System.out.println("\tSus compras tiene el descuento de: " + nivelAlonso.getDescuento() + "%");
    }
}
