package logico;

public class Revista extends Publicacion{
	private int year;
	private int numero;
	
	public Revista(String codigo, String titulo, String materia, int cantEjemplares, int year, int numero) {
		super(codigo, titulo, materia, cantEjemplares);
		this.year = year;
		this.numero = numero;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int anualidad) {
		this.year = anualidad;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
}
