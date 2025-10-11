public class Radio  extends AparatoElectronico {
    @Override
    public final int bajaVolumen() { // Metodo que es abstract en la super clase AparatoElectronico
        this.volumen--;
        return this.volumen;
    }
}
