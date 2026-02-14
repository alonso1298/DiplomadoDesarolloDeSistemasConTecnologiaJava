package Ejercicio1;

import Ejercicio1.entity.Producto;
import Ejercicio1.repository.IProductoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@SpringBootTest
public class ProductoTest {

    private static final String NOMBRE = "ALONSO SAGRERO GRANADOS";

    @Autowired
    IProductoRepository productoRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void insertarDatos(){
        System.out.println(NOMBRE);
        productoRepository.save(new Producto(null,"Laptop","Dell",
                new Double("18500.00"),
                LocalDate.of(2023,1,10)));

        productoRepository.save(new Producto(null,"Mouse","Logitech",
                new Double("450.00"),
                LocalDate.of(2023,2,15)));

        productoRepository.save(new Producto(null,"Teclado",null,
                new Double("800.00"),
                LocalDate.of(2023,3,1)));

        productoRepository.save(new Producto(null,"Tablet",null,
                new Double("5200.00"),
                LocalDate.of(2023,4,25)));

        productoRepository.save(new Producto(null,"Disco Duro","Seagate",
                new Double("1500.00"),
                LocalDate.of(2023,5,12)));

        productoRepository.save(new Producto(null,"Memoria USB",null,
                new Double("250.00"),
                LocalDate.of(2023,5,20)));

        System.out.println("Datos insertados correctamente");
    }

    @Test
    void productosSinMarca(){
        System.out.println(NOMBRE);
        System.out.println("Obtener todos los productos que no tengan marca registrada");

        productoRepository.findByMarcaIsNull()
                .forEach(System.out::println);
    }

    @Test
    void productosConMarcaOrdenados(){
        System.out.println(NOMBRE);
        System.out.println("Obtener productos que sí tengan marca, ordenados por precio de mayor a menor");

        productoRepository.findByMarcaIsNotNullOrderByPrecioDesc()
                .forEach(System.out::println);
    }

    @Test
    void contarSinMarca(){
        System.out.println(NOMBRE);
        System.out.println("Contar cuántos productos no tienen marca");

        System.out.println(
                productoRepository.countByMarcaIsNull()
        );
    }

    @Test
    void nombreContenga(){
        System.out.println(NOMBRE);
        System.out.println("Obtener productos cuyo nombre contenga Teclado");

        productoRepository.findByNombreContaining("Teclado")
                .forEach(System.out::println);
    }

    @Test
    void nombreYMarca(){
        System.out.println(NOMBRE);
        System.out.println("Obtener productos cuyo nombre y marca coincidan con valores dados");

        productoRepository.findByNombreAndMarca("Laptop","Dell")
                .forEach(System.out::println);
    }

    @Test
    void precioMayor(){
        System.out.println(NOMBRE);
        System.out.println("Obtener productos cuyo precio sea mayor o igual a un valor y que tengan marca registrada");

        productoRepository
                .findByPrecioGreaterThanEqualAndMarcaIsNotNull(new Double("1000"))
                .forEach(System.out::println);
    }

    @Test
    void top3Caros(){
        System.out.println(NOMBRE);
        System.out.println("Listar los tres productos más caros");

        productoRepository.findTop3ByOrderByPrecioDesc()
                .forEach(System.out::println);
    }

    @Test
    void top5Menores(){
        System.out.println(NOMBRE);
        System.out.println("Obtener los primeros 5 productos cuyo precio sea menor a un valor");

        productoRepository.findTop5ByPrecioLessThan(new Double("5000"))
                .forEach(System.out::println);
    }

    @Test
    void fechaYPrecio(){
        System.out.println(NOMBRE);
        System.out.println("Obtener productos dados de alta después de una fecha y cuyo precio sea mayor a un valor");

        productoRepository
                .findByFechaAltaAfterAndPrecioGreaterThan(
                        LocalDate.of(2023,3,1),
                        new Double("1000"))
                .forEach(System.out::println);
    }

    @Test
    void existeProducto(){
        System.out.println(NOMBRE);
        System.out.println("Verificar si existe al menos un producto cuyo nombre contenga una cadena " +
                "(Disco, Memoria, etc.) y tenga marca registrada");

        System.out.println(
                productoRepository
                        .existsByNombreContainingAndMarcaIsNotNull("Disco")
        );
    }


}
