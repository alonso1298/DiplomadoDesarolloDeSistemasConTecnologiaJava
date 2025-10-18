// Son los niveles de mis clientes (Oro, Plata, Bronce)
public enum Nivel {
    // Lista de posibles valores y atributos asociados (costo de anualidad)

    ORO (500, 5),
    PLATA (300, 3),
    BRONCE (0, 1);
    private double anualidad;
    private int descuento;

    // Métodos
    // Constructor
    Nivel (double costo, int descuento){ // Los atributos asociados
        this.anualidad = costo;
        this.descuento = descuento;
    }

    public double getAnualidad() {
        return anualidad;
    }

    public double getDescuento() {
        return descuento;
    }
}
