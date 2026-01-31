package dgtic.core.modelo;

public class Telefono {
    private String marca;
    private String numero;

    public Telefono(){

    }

    public Telefono(String marca, String numero) {
        this.marca = marca;
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "marca='" + marca + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
