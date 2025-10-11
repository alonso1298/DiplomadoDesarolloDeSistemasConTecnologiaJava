public class Personaje {
    // Atributos
    private String nombre;
    private int vida;
    boolean escogido;
    boolean vivo;

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
                break;
            case 2:
                this.nombre = "Rugal";
                break;
            case 3:
                this.nombre = "Ryu";
                break;
            case 4:
                this.nombre = "Takuma";
                break;
        }
    }

    // setters y getters

    // golpear()

    // toString()

}
