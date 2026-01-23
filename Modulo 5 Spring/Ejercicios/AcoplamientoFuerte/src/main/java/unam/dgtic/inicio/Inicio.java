package unam.dgtic.inicio;

import unam.dgtic.modelo.Profesor;
import unam.dgtic.modelo.Reponsabilidades;

public class Inicio {
    public static void main(String[] args) {
        Profesor profesor = new Profesor();
        Reponsabilidades reponsabilidades = new Reponsabilidades();
        profesor.setResponsabilidades(reponsabilidades);
        profesor.getResponsabilidades().calificar();
    }
}
