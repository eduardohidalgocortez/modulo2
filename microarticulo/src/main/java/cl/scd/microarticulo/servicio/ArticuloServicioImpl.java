package cl.scd.microarticulo.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.scd.microarticulo.modelo.Articulo;
import cl.scd.microarticulo.repositorio.ArticuloRepo;

@Service
public class ArticuloServicioImpl implements ArticuloServicio {

	@Autowired
	ArticuloRepo repo;
	
	@Override
	public List<Articulo> listarArticulos() {
		return repo.findAll();
	}

	@Override
	public Articulo agregarArticulo(Articulo a) {
		return repo.save(a);
	}

	@Override
	public Articulo buscarArticulo(Integer id) {
		return repo.findById(id).get();
	}

}
