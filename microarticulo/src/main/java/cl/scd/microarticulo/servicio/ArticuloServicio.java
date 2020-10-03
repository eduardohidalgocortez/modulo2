package cl.scd.microarticulo.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import cl.scd.microarticulo.modelo.Articulo;


public interface ArticuloServicio {

	List<Articulo> listarArticulos();	
	Articulo agregarArticulo(Articulo a);
	Articulo buscarArticulo(Integer id);
}
