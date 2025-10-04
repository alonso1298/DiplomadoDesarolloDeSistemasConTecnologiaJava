public class Casa {
    // Atrubutos (Variables)
    // Tamaño del terrno, metros de construccion, material, numero de pisos, numero de cuartos, color, direccion, precio, dueño
    public double precio;
    public String propietario;
    public String color;
    public int pisos;
    int ventanas;

    // Metodos (Procedimientos y Funciones)
    public void pintar (String nuevoColor){
        this.color = nuevoColor;
    }
    public void vender(String nuevoPropietario){
        this.propietario = nuevoPropietario;
        this.precio = -1; // Significa que no esta a la venta
    }
}
