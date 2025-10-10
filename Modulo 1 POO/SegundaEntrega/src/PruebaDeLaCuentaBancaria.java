public class PruebaDeLaCuentaBancaria {
    public static void main(String[] args) {
        System.out.println("Prueba de la cuenta bancaria");
        // Instancia a centa bamcaria
        // clase objeto = new Clase();
        CuentaBancaria objeto1 = new CuentaBancaria();
        System.out.println("Titular: " + objeto1.getTitular());

        //Para tener un acceso a un atributo publico de un objeto
        // objeto.atributo
        objeto1.setTitular ("Alonso");// Cambio del atributo por medio del set()
        objeto1.setNumero (555123);
        // objeto1.saldo = 100;

        // Para ejecutar un metodo de un objeto
        // objeto.metodo (parametros de entrada)
        /* Deposito */
        System.out.println("Saldo: " + objeto1.getSaldo());
        if (objeto1.depositar(300)){
            System.out.println("Deposito reealizado. Saldo final: " + objeto1.getSaldo());
        }else {
            System.out.println("Operacion rechazada");
        }

        /* Retiro */
        // objeto1.saldo = 1000; //???
        if (objeto1.retirar (50)){
            System.out.println("Retiro reealizado. Saldo final: " + objeto1.getSaldo());
        }else {
            System.out.println("Operacion rechazada");
        }
    }
}
