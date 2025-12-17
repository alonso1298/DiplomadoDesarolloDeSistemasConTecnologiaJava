package unam.diplomado.pixup.colonia.test;

import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.repository.IColoniaReposritory;
import unam.diplomado.pixup.colonia.repository.JpaColoniaRepository;

import java.util.Collection;

public class ColoniaTest {

    public static void main(String[] args) {
        String cp = "06400";
        IColoniaReposritory coloniaReposritory = new JpaColoniaRepository();
        Collection<Colonia> colonias = coloniaReposritory.finByCp(cp);
        for (Colonia colonia : colonias)
            System.out.println("Colonia: " + colonia);
    }
}
