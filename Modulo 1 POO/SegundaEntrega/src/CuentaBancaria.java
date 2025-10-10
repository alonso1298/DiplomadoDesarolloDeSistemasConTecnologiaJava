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


}
