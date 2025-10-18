package paqueteB;

import paqueteA.ClaseA;

// Subclase de una clase definida en otro paquete
public class SubClaseAB extends ClaseA {
    public void metodo(){
        aPublico = -11;
        // aPrivado = -22; Inaccesible desde una subclase
        aProtegido = -22;
        // aLibre = -44; Inaccesible desde una subclase
    }
}
