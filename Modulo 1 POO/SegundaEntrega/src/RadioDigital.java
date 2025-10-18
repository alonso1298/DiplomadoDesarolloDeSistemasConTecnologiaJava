public final class RadioDigital extends Radio implements IControlesComunes{
    private String tipo;
    public int volumenActual;
    public boolean estatus;

    @Override
    public void subirVolumen() { // Establecido en la interfaz
        this.volumenActual += 3;
        if (this.volumenActual > VOLUMENMAXIMO){
            this.volumenActual = VOLUMEN_MAXIMO;
        }
    }

    @Override
    public void bajarVolumen() { // Establecido en la interfaz
        this.volumenActual -= 3;
    }

    @Override
    public boolean encender() {
        this.estatus = true;
        return this.estatus;
    }

    @Override
    public boolean apagar() {
        this.estatus = false;
        return this.estatus;
    }

    /* public int bajaVolumen() { // Metodo que es abstract en la super clase AparatoElectronico
        this.volumen -+ 3;
        return this.volumen;
    }*/
}
