package cl.scd.microfactura.controlador;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cl.scd.microfactura.cliente.EurekaClient;
import cl.scd.microfactura.modelo.Articulo;
import cl.scd.microfactura.repositorio.FacturaRepositorio;

@RestController
@CrossOrigin(origins = "*")
public class FacturaController {

	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private FacturaRepositorio facturaRepositorio;
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@GetMapping("/articulo/{id}")
	@HystrixCommand(fallbackMethod = "servicioFallback")
	public Articulo getProducto(@PathVariable Integer id)
	{
		URI catalogoURI = eurekaClient.getUri("SERVICIO.ARTICULO");
		Articulo prod = restTemplate.getForObject(catalogoURI.resolve("/articulo/"+ id ), Articulo.class);
		return prod;
	}
	
	public Articulo servicioFallback(Integer id) {
		return null ;
	}
	
	
	
	
	
}
