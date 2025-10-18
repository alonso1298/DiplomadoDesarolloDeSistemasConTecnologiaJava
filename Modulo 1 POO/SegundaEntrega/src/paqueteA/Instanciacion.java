package paqueteA;

public class Instanciacion {
    public static void main(String[] args) {
        ClaseA objetoAA = new ClaseA();

        objetoAA.aPublico = 111;
        // objetoAA.aPrivado = 222; La instancia no tiene acceso a lo privado
        objetoAA.aProtegido = 333;
        objetoAA.aLibre = 444;

        SubClaseAA hijoAA = new SubClaseAA();
        hijoAA.aPublico = 1111;
        // hijoAA.aPrivado = 222; la instancia no tiene acceso a lo privado
        hijoAA.aProtegido = 333;
        hijoAA.aLibre = 4444;
    }
}
