package Ejercicio1.repository;

import Ejercicio1.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IProductoRepository extends JpaRepository<Producto, Integer> {

    //    1. Obtener todos los productos que no tengan marca registrada
    List<Producto> findByMarcaIsNull();
    // 2. Obtener productos que sí tengan marca, ordenados por precio de mayor a menor
    List<Producto> findByMarcaIsNotNullOrderByPrecioDesc();
    // 3. Contar cuántos productos no tienen marca
    long countByMarcaIsNull();
    // 4. Obtener productos cuyo nombre contenga Teclado
    List<Producto> findByNombreContaining(String nombre);
    // 5. Obtener productos cuyo nombre y marca coincidan con valores dados
    List<Producto> findByNombreAndMarca(String nombre, String marca);
    // 6. Obtener productos cuyo precio sea mayor o igual a un valor y que tengan marca registrada
    List<Producto> findByPrecioGreaterThanEqualAndMarcaIsNotNull(Double precio);
    // 7. Listar los tres productos más caros
    List<Producto> findTop3ByOrderByPrecioDesc();
    // 8. Obtener los primeros 5 productos cuyo precio sea menor a un valor
    List<Producto> findTop5ByPrecioLessThan(Double precio);
    // 9. Obtener productos dados de alta después de una fecha y cuyo precio sea mayor a un valor
    List<Producto> findByFechaAltaAfterAndPrecioGreaterThan(LocalDate fecha, Double precio);
    // 10. Verificar si existe al menos un producto cuyo nombre contenga una cadena (Disco, Memoria, etc.) y tenga marca registrada
    boolean existsByNombreContainingAndMarcaIsNotNull(String cadena);

}
