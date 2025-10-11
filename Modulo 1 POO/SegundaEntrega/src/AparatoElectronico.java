public abstract class AparatoElectronico {
    public boolean prendido;
    public int volumen;

    public void subeVolumen(){
        this.volumen++;

    }
    public abstract void bajaVolumen(); // Solo se define que ba a existir
}
