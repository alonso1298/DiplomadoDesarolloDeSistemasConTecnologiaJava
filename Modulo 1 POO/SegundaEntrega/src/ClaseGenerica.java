public class ClaseGenerica {
    public String nombre;
    public double promedio;
    public int edad;

    public ClaseGenerica(){
        this.nombre = "Desconocido";
        this.edad = 5;
        this.edad = 18;
    }

    public void imprime(){
        System.out.println("En edad tengo " + edad);
    }

    @Override
    public String toString() {
        return "ClaseGenerica{" +
                "nombre='" + nombre + '\'' +
                ", promedio=" + promedio +
                ", edad=" + edad +
                '}';
    }
}
