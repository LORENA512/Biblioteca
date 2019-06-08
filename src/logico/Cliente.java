package logico;

public class Cliente {
	private String codigo;
	private String nombre;
	private String direccion;
	private int cantPrestamos;
	
	public Cliente(String codigo, String nombre, String direccion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		cantPrestamos = 0;
	}
	
	public void aumentarPrestamosActivos() {
		cantPrestamos += 1;
	}
	
	public void disminuirPrestamosActivos() {
		cantPrestamos -= 1;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCantPrestamos() {
		return cantPrestamos;
	}

	public void setCantPrestamos(int cantPrestamos) {
		this.cantPrestamos = cantPrestamos;
	}
}
