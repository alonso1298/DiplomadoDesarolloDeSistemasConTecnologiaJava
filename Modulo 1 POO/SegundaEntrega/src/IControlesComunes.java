// interfaz que deberan implementar todos nuestros dispositivos electronicos
public interface IControlesComunes {
    // Atributos estaticos finales
    public static final int VOLUMENMAXIMO = 100;

    // Metodos abstractos
    public abstract void subirVolumen();
    public abstract void bajarVolumen();
    public abstract boolean encender();
    public abstract  boolean apagar();
}
