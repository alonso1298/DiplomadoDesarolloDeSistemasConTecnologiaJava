public class CuentaBancaria {
    // Atributos (titular, numero, saldo)
    private String titular;
    private int numero;
    private double saldo;

    // Metodos
    public  CuentaBancaria() { // El constructor inicializa las variables
        this.titular = "Por definir";
        this.numero = 0;
        this.saldo = 0;
    }

    public CuentaBancaria(int valor){
        // Simular que "Buscamos" en la BD la cuenta que llega de entrada
        /* 55123, Eligio, 100
           44123, Alonso, 1000
           22123, Luz, 1500
        */
        // this(); // Cuando se utiliza como nombre de funcion ejecuta el constructor sin parametros de entrada CuentaBancaria()
        switch (valor){
            case 55123:
                this.titular = "Eligio";
                this.numero = valor;
                this.saldo = 100;
                break;
            case 44123:
                this.titular = "Alonso";
                this.numero = valor;
                this.saldo = 1000;
                break;
            case 22123:
                this.titular = "Luz";
                this.numero = valor;
                this.saldo = 1500;
                break;
        }
    }

    public CuentaBancaria(String nombre){
        this(45); // Ejecuta el constructor que recibe un int
        // Lo demas..
    }

    // Metodos set (para modificar un atributo) y  get (para "ver un atributo)


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        if(titular.length() >= 5) // Si el nombre tiene al menos 5 caracteres, lo cambia
            this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero >= 100000) // De 5 digitos
            this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean depositar(double monto) {
        boolean resultado = false;
        if (monto > 0){
            this.saldo = this.saldo + monto;
            resultado = true;
            // Acceso a la base de datos para afectar el saldo
        }
        return resultado;
    }

    public boolean retirar(double monto) {
        boolean resultado = false;
        if (this.saldo >=  monto && monto > 0){
            this.saldo -= monto; // this.saldo = this.saldo - monto
            resultado = true;
        }
        return resultado;
    }

    public boolean transferir(CuentaBancaria destino, double monto){
        // trsnsferir se debe ejecutar en la cuenta de origen (this)

        boolean resultado = false;
        if (this.retirar(monto) && destino.depositar(monto))
            resultado = true; // Cuando pudo retirar en el origen y pudo depositar en el destino
        monto = monto * 100;
        return resultado;
    }

    @Override
    public String toString() {
        // Cuando Java necesita "convertir" el objeto a String (para imprimirlo, p. ej.) se ejecuta este metodo
        return "CuentaBancaria{" +
                "titular='" + titular + '\'' +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
