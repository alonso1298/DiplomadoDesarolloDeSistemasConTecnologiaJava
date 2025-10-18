public class Persona implements ICrud {
    // Será la superclase para otras dos subclases
    //  padre/madre hijos/hijas

    // Atributos
    private String nombre;
    private int edad;
    private char genero;

    // Métodos
    public Persona() {
        this.nombre = "Indefinido";
        this.genero = 'F';
        this.edad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.length() > 2)
            this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0 && edad <=150)
            this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        if (genero == 'F' || genero == 'M' || genero == 'N')
            this.genero = genero;
    }

    @Override
    public String toString() {
        return this.nombre + " (" + this.genero + "). " + this.edad + " años";
    }

    // IControles Comunes
    @Override
    public boolean create() {
        // INSERT INTO ...
        return false;
    }

    @Override
    public boolean read() {
        // SELECT * FROM
        return false;
    }

    @Override
    public int update() {
        // UPDATE
        return 0;
    }

    @Override
    public int delete() {
        // DELETE/UPDATE  WHERE....
        return 0;
    }
}
