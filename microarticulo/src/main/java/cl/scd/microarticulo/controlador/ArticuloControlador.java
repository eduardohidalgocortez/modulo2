package cl.scd.microarticulo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.scd.microarticulo.modelo.Articulo;
import cl.scd.microarticulo.servicio.ArticuloServicio;

@RestController
public class ArticuloControlador {
	
	@Autowired
	ArticuloServicio articuloServicio;
	
	@GetMapping(value="/articulo")
	public List<Articulo> getArticulo(){
		return articuloServicio.listarArticulos();
	}
	
	@GetMapping(value="/articulo/{id}")
	public Articulo getArticuloById( @PathVariable Integer id ) {
		return this.articuloServicio.buscarArticulo(id);
	}
	
	@PostMapping(value="/articulo")
	public Articulo agregarArticulo( @RequestBody Articulo articulo) {
		return articuloServicio.agregarArticulo(articulo);
	}
	
	
	
}
