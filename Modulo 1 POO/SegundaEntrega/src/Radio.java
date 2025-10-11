public class Radio  extends AparatoElectronico {
    @Override
    public int bajaVolumen() { // Metodo que es abstract en la super clase
        this.volumen--;
        return this.volumen;
    }
}
