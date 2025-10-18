public class Television extends Radio implements IControlesComunes{
    public boolean encendido;
    public double volumen;
    public double canal;

    @Override
    public void subirVolumen() { // Establecido en la interfaz
        this.volumen+=2;
    }
    // Se permite la sobrecarga
    public void subirVolumen (double cuanto){
        this.volumen += cuanto;
        if (this.volumen > VOLUMEN_MAXIMO){
            this.volumen = VOLUMEN_MAXIMO;
        }
    }

    @Override
    public void bajarVolumen() {
        this.volumen-=2;
    }

    @Override
    public boolean encender() {
        this.encendido = true;
        return this.encendido;
    }

    @Override
    public boolean apagar() {
        this.encendido = false;
        return this.encendido;
    }
}
