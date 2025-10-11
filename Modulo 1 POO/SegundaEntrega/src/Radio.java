public class Radio  extends AparatoElectronico {
    @Override
    public int bajaVolumen() { // Metodo que es abstract en la super clase AparatoElectronico
        this.volumen--;
        return this.volumen;
    }
}
