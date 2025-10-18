public class Television extends Radio implements IControlesComunes, ICrud{
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

    // IControles Comunes
    @Override
    public boolean create() {
        // INSERT INTO televisiones...
        return false;
    }

    @Override
    public boolean read() {
        // SELECT * FROM televisiones
        return false;
    }

    @Override
    public int update() {
        // UPDATE televisiones
        return 0;
    }

    @Override
    public int delete() {
        // DELETE/UPDATE televisiones WHERE....
        return 0;
    }
}
