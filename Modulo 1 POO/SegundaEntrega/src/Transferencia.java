import java.util.Scanner;

public class Transferencia {
    public static void main(String[] args) {
        System.out.println("Transferencia entre cuentas");
        Scanner teclado = new Scanner(System.in);
        System.out.println("Dame la cuenta de origen: ");
        int origen = teclado.nextInt();
        CuentaBancaria cuentaOrigen = new CuentaBancaria(origen);
        System.out.println(cuentaOrigen.getTitular() + " $" + cuentaOrigen.getSaldo());
        System.out.println(cuentaOrigen);

        System.out.println("Dame la cuenta destino: ");
        int destino = teclado.nextInt();
        CuentaBancaria cuentaDestino = new CuentaBancaria(destino);
        System.out.println(cuentaDestino.getTitular() + " $" + cuentaDestino.getSaldo());
        System.out.println(cuentaDestino);

        System.out.println("Cual es el monto que quieres transferir: ");
        double monto = teclado.nextDouble();

        // Como transferir de la cuenta de origen a la de destino?
        // A) Con los metodos de retirar y depositar:
        /* if(cuentaOrigen.retirar(monto) && cuentaDestino.depositar(monto))
            System.out.println("Transferencia realizada"); */

        // B) Con un nuevo metodo de transferir
        if(cuentaOrigen.transferir(cuentaDestino, monto))
            System.out.println("Transferencia Realizada");
        else
            System.out.println("Transferencia declinada");
        System.out.println("Monto de la transferencia: " + monto);
        System.out.println(cuentaOrigen);
        System.out.println(cuentaDestino);
    }
}
