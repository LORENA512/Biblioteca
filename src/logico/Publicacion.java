package logico;

public class Publicacion {
	protected String codigo;
	protected String titulo;
	protected String materia;
	protected int cantEjemplares;
	
	public Publicacion(String codigo, String titulo, String materia, int cantEjemplares) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.materia = materia;
		this.cantEjemplares = cantEjemplares;
	}
	
	public void prestamoRealizado() {
		cantEjemplares -= 1;
		if(cantEjemplares < 0) {
			cantEjemplares = 0;
		}
	}
	
	public void prestamoEntregado() {
		cantEjemplares += 1;
	}
	
	protected boolean ejemplaresDisponibles() {
		return cantEjemplares > 0;
	}

	protected String getCodigo() {
		return codigo;
	}

	protected void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	protected String getTitulo() {
		return titulo;
	}

	protected void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	protected String getMateria() {
		return materia;
	}

	protected void setMateria(String materia) {
		this.materia = materia;
	}

	protected int getCantEjemplares() {
		return cantEjemplares;
	}

	protected void setCantEjemplares(int cantEjemplares) {
		this.cantEjemplares = cantEjemplares;
	}
}
