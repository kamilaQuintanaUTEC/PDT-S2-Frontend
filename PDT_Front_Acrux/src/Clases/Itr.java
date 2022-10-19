package Clases;

public class Itr {

	private String nombre;
	private String estado;
	
	public Itr(String nombre, String estado) {
		super();
		this.nombre = nombre;
		this.estado = estado;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Itr [nombre=" + nombre + ", estado=" + estado + "]";
	}

}
