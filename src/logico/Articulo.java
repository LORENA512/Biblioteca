package logico;

public class Articulo extends Publicacion{
	private String arbitro;
	private String autor;
	
	public Articulo(String codigo, String titulo, String materia, int cantEjemplares, String arbitro, String autor) {
		super(codigo, titulo, materia, cantEjemplares);
		this.arbitro = arbitro;
		this.autor = autor;
	}

	public String getArbitro() {
		return arbitro;
	}

	public void setArbitro(String arbitro) {
		this.arbitro = arbitro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
}
