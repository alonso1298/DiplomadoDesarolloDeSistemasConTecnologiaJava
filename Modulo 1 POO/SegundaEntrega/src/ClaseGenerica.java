public class ClaseGenerica<T> {
    // El parametro de tipo siempre debe ser una clase
    public String nombre;
    public double promedio;
    public T edad;

    public ClaseGenerica(){
        this.nombre = "Desconocido";
        this.promedio = 5;
        // this.edad = 18; Ya no es posible asignar un int a edad
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
