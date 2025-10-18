public class Producto {
    private String codigo;
    private String producto;
    private double precio;

    public Producto(){

    }

    public Producto(String codigo){
        // Se ejecuta al tener un new Producto(#)
        // Simulacion de la extraccion de datos de una BD
        switch (codigo){
            case "1":
                this.codigo = "1";
                this.producto = "Cuaderno";
                this.precio = 50;
                break;
            case "3":
                this.codigo = "3";
                this.producto = "Pluma";
                this.precio = 13;
                break;
            case "5":
                this.codigo = "5";
                this.producto = "Regla";
                this.precio = 16.50;
                break;
            case "8":
                this.codigo = "8";
                this.producto = "Goma";
                this.precio = 7;
                break;
            case "9":
                this.codigo = "9";
                this.producto = "Lapiz";
                this.precio = 7.50;
                break;
            case "11":
                this.codigo = "11";
                this.producto = "Carpeta";
                this.precio = 126;
                break;
            case "22":
                this.codigo = "22";
                this.producto = "Tinta";
                this.precio = 554;
                break;
            case "99":
                this.codigo = "99";
                this.producto = "Sobres";
                this.precio = 32;
                break;
            case "123":
                this.codigo = "123";
                this.producto = "Folder";
                this.precio = 5;
                break;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String nombre) {
        this.producto = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto: " + producto + " Precio: $" + precio;
    }
}
