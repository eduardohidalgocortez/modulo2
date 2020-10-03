package cl.scd.microfactura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.scd.microfactura.modelo.Factura;

public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {

}
