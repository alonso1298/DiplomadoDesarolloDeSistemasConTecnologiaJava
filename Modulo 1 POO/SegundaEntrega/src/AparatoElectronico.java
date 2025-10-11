public abstract class AparatoElectronico {
    public boolean prendido;
    public int volumen;
    public final int VOLUMEN_MAXIMO = 100;
    public static int instancias = 0;
    public static int contador = 0;

    public AparatoElectronico(){
        contador++;
    }

    public int subeVolumen(){
        this.volumen++;
        if (volumen > VOLUMEN_MAXIMO)
            this.volumen = VOLUMEN_MAXIMO;
        return this.volumen;

    }
    public abstract int bajaVolumen(); // Solo se define que ba a existir

    public static void mensaje(){
        System.out.println("Mensaje desde metodo estatico " + contador);
    }
}
