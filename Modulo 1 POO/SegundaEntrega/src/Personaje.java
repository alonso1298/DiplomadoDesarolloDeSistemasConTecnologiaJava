public class Personaje {
    // Atributos
    private String nombre;
    private int vida;
    boolean escogido;
    boolean vivo;
    private int fuerza;

    // Metodos

    // Constructores
    public Personaje (){
        // Valores por default cuando se ejecute un new Personaje()
        this.nombre = "N";
        this.vida = 100;
        this.escogido = false;
        this.vivo = true;
    }

    public Personaje (int id){
        // Se ejecuta al tener un new Persona(#)
        this(); // Personaje();
        // Simulacion de la extraccion de datos de una BD
        switch (id){
            case 1:
                this.nombre = "ChunLin";
                this.fuerza = 5;
                break;
            case 2:
                this.nombre = "Rugal";
                this.fuerza = 8;
                break;
            case 3:
                this.nombre = "Ryu";
                this.fuerza = 5;
                break;
            case 4:
                this.nombre = "Takuma";
                this.fuerza = 7;
                break;
        }
    }

    // setters y getters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
        if (vida <= 0)
            this.vivo = false;
    }

    public boolean isEscogido() {
        return escogido;
    }

    public void setEscogido(boolean escogido) {
        this.escogido = escogido;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setVivo(boolean vivo) {
        this.vivo = vivo;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    // golpear()
    public void golpear(Personaje oponente){
        oponente.setVida(oponente.getVida() - this.getFuerza());
    }

    public void patear(Personaje oponente){
        oponente.setVida(oponente.getVida() - this.getFuerza());
    }

    // toString()
    @Override
    public String toString() {
        return nombre.toUpperCase() + "["+vida+"]";
    }
}
