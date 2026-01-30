package dgtic.core.modelo;

public class GestionProyectos implements IActividades{
    private int cantidad = 0;

    @Override
    public void realizar() {
        System.out.println("Gestion Proyectos");
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
