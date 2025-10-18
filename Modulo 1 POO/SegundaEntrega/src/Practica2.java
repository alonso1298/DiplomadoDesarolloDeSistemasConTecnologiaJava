import java.util.Scanner;

public class Practica2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        boolean continuar = true;
        int contador = 0;          // Cantidad de productos
        double subtotal = 0;       // Suma de precios
        String detalles = "";      // Detalle de productos registrados

        System.out.println("Bienvenido a la tienda");

        while (continuar) {
            System.out.println("Ingresa el código del producto <Presiona 0 para finalizar la compra>:");
            String codigoProducto = teclado.nextLine();

            if (codigoProducto.equals("0")) {
                continuar = false;
                break;
            }

            // Generar el producto según el código
            Producto productoIngresado = new Producto(codigoProducto);

            // Mostrar producto registrado
            System.out.println("Producto registrado: " + productoIngresado);

            // Acumular información
            contador++;
            subtotal += productoIngresado.getPrecio();
            detalles += contador + ". " + productoIngresado + "\n";
        }

        if (contador > 0) {
            // Calcular IVA y total
            double iva = subtotal * 0.1648;
            double total = subtotal + iva;

            // Mostrar resumen
            System.out.println("\t RESUMEN DE VENTA ");
            System.out.println("Cantidad de productos: " + contador);
            System.out.println("Subtotal: $" + subtotal);
            System.out.println("IVA (16.48%): $" + iva);
            System.out.println("Total a pagar: $" + total);
            System.out.println("\nProductos registrados:\n" + detalles);
        } else {
            System.out.println("No se registraron productos.");
        }

        System.out.println("Gracias por su compra.");
    }
}
