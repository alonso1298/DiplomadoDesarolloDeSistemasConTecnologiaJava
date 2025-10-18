package paqueteA;

public class SubClaseAA extends ClaseA{
    public void metodo(){
        aPublico = 111;
        // aPrivado = 222; No tiene acceso a lo privado de la Superclase
        aProtegido = 3333;
        aLibre = 4444;
    }
}
