package dgtic.core.modelo;

public class IntercambioConocimientos implements IActividades{
    int cantidad = 0;
    @Override
    public void realizar() {
        System.out.println("Intercambio de conocimientos");
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
