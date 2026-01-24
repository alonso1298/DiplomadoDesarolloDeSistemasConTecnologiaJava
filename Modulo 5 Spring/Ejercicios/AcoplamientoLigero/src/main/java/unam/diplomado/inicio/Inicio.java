package unam.diplomado.inicio;

import unam.diplomado.modelo.Calificar;
import unam.diplomado.modelo.ExplicarClases;
import unam.diplomado.modelo.Profesor;
import unam.diplomado.modelo.Reportes;

public class Inicio {
    public static void main(String[] args) {
        Profesor profesor = new Profesor();
        Calificar calificar = new Calificar();
        profesor.getResponsabilidades().add(calificar);

        Profesor profesor1 = new Profesor();
        ExplicarClases explicarClases = new ExplicarClases();
        Reportes reportes = new Reportes();
        profesor1.getResponsabilidades().add(explicarClases);
        profesor1.getResponsabilidades().add(reportes);

        //---------------------NO HACER----------------------
        profesor1.getResponsabilidades().add(calificar); // Se pasa el mismo objeto de Profesor
        //-------------------SI HACER-----------------------
        profesor1.getResponsabilidades().add(new Calificar());
        profesor1.getResponsabilidades().remove(0); // Se elimina una respondabilidad del profesor


    }
}
