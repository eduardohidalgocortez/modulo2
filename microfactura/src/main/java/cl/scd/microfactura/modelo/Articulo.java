package cl.scd.microfactura.modelo;

public class Articulo {
	
	private Integer id;
	private String nombre;
	private int precio;
	
	public Articulo() {  }

	public Articulo(Integer id, String nombre, int precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}
