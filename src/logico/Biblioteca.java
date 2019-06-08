package logico;

import java.time.LocalDate;
import java.util.ArrayList;

//	TODO: Insertar un libro.
//	TODO: Devolver el título de una publicación cualquiera, dado su Id.
//	TODO: Calcular la cantidad de documentos de una materia dada.
//	TODO: Realizar un préstamo de un documento.
//	TODO: Realizar la devolución de un documento.
//	TODO: Conocer la cantidad de documentos de cada tipo que se le ha prestado a un cliente.
//	TODO: Determinar la cantidad de revistas de una materia dada que posee la biblioteca.
//	TODO: Dado un libro o un artículo determinar si quedan ejemplares disponibles en la biblioteca.

public class Biblioteca {
	private ArrayList<Cliente> misClientes;
	private ArrayList<Prestamo> misPrestamos;
	private ArrayList<Publicacion> misPublicaciones;
	
	public Biblioteca() {
		misClientes = new ArrayList<Cliente>();
		misPrestamos = new ArrayList<Prestamo>();
		misPublicaciones = new ArrayList<Publicacion>();
	}
	
	public void agregarPublicacion(Publicacion nueva) {
		misPublicaciones.add(nueva);
	}
	
	public void agregarPrestamo(Prestamo nuevo) {
		misPrestamos.add(nuevo);
	}
	
	public void agregarCliente(Cliente nuevo) {
		misClientes.add(nuevo);
	}
	
	public Publicacion buscarPublicacionPorCodigo(String codigo) {
		for(Publicacion e : misPublicaciones) {
			if(e.getCodigo().equalsIgnoreCase(codigo)) {
				return e;
			}
		}
		return null;
	}
	
	public Cliente buscarClientePorCodigo(String codigo) {
		for(Cliente e : misClientes) {
			if(e.getCodigo().equalsIgnoreCase(codigo)) {
				return e;
			}
		}
		return null;
	}
	
	public Prestamo buscarPrestamoPorClienteDoc(String codcliente, String coddoc) {
		for(Prestamo e : misPrestamos) {
			if(e.getMiCliente().getCodigo().equalsIgnoreCase(codcliente) 
					&& e.getMiPublicacion().getCodigo().equalsIgnoreCase(coddoc)) {
				return e;
			}
		}
		return null;
	}
	
	public ArrayList<Publicacion> documentosPrestadosClientePorCodigo(String codcliente) {
		ArrayList<Publicacion> p = new ArrayList<Publicacion>();
		for(Prestamo e : misPrestamos) {
			if(e.getMiCliente().getCodigo().equalsIgnoreCase(codcliente)) {
				p.add(e.getMiPublicacion());
			}
		}
		return p;
	}
	
	public int cantDocumentosPorMateria(String materia) {
		int cant = 0;
		for(Publicacion e : misPublicaciones) {
			if(e.getMateria().equalsIgnoreCase(materia)) {
				cant += 1;
			}
		}
		return cant;
	}
	
	public boolean realizarPrestamo(String codCliente, String codDocumento, LocalDate devol) {
		boolean realizar = false;
		Cliente cliente = buscarClientePorCodigo(codCliente);
		Publicacion publicacion = buscarPublicacionPorCodigo(codDocumento);
		
		if(cliente.getCantPrestamos() < 5) {
			Prestamo nuevo = new Prestamo(cliente, publicacion, EstadoPrestamo.PRESTADO, LocalDate.now(), devol);
			agregarPrestamo(nuevo);
			cliente.aumentarPrestamosActivos();
			realizar = true;
		}
		
		return realizar;
	}
	
	public boolean devolverDocumento(String codCliente, String codDocumento) {
		boolean devolver = false;
		Prestamo prestamo = buscarPrestamoPorClienteDoc(codCliente, codDocumento);
		if(prestamo != null && prestamo.getMiEstado() != EstadoPrestamo.DEVUELTO) {
			prestamo.setMiEstado(EstadoPrestamo.DEVUELTO);
			prestamo.getMiCliente().disminuirPrestamosActivos();
			devolver = true;
		}
		return devolver;
	}
	
	public int[] cantTipoDocPretadoCliente(String codcliente) {
		int[] cant = new int[3];
		ArrayList<Publicacion> libros = documentosPrestadosClientePorCodigo(codcliente);
		for(Publicacion e : libros) {
			if(e instanceof Libro)   
				cant[0] += 1;
			if(e instanceof Revista) 
				cant[1] += 1;
			if(e instanceof Articulo)
				cant[2] += 1;
		}
		return cant;
	} 
	
	public int cantRevistasPorMateria(String materia) {
		int cant = 0;
		for(Publicacion e : misPublicaciones) {
			if(e instanceof Revista && e.getMateria().equalsIgnoreCase(materia)) {
				cant += 1;
			}
		}
		return cant;
	}
	
	public boolean existenEjemplaresDisponibles(Libro l) {
		return l.ejemplaresDisponibles();
	}
	
	public boolean existenEjemplaresDisponibles(Articulo a) {
		return a.ejemplaresDisponibles();
	}
	
	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public ArrayList<Prestamo> getMisPrestamos() {
		return misPrestamos;
	}

	public ArrayList<Publicacion> getMisPublicaciones() {
		return misPublicaciones;
	}
}
