package cl.scd.microarticulo.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.scd.microarticulo.modelo.Articulo;
  
@Repository
public interface ArticuloRepo extends JpaRepository<Articulo, Integer> {

}
