package logico;

import java.time.LocalDate;
import java.util.ArrayList;

//	TODO: Insertar un libro.
//	TODO: Devolver el t�tulo de una publicaci�n cualquiera, dado su Id.
//	TODO: Calcular la cantidad de documentos de una materia dada.
//	TODO: Realizar un pr�stamo de un documento.
//	TODO: Realizar la devoluci�n de un documento.
//	TODO: Conocer la cantidad de documentos de cada tipo que se le ha prestado a un cliente.
//	TODO: Determinar la cantidad de revistas de una materia dada que posee la biblioteca.
//	TODO: Dado un libro o un art�culo determinar si quedan ejemplares disponibles en la biblioteca.

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
	
	public ArrayList<Prestamo> prestamosCodigoCliente(String codcliente) {
		ArrayList<Prestamo> p = new ArrayList<Prestamo>();
		for(Prestamo e : misPrestamos) {
			if(e.getMiCliente().getCodigo().equalsIgnoreCase(codcliente)) {
				p.add(e);
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
		
		if(cliente != null && publicacion != null) {
			if(cliente.getCantPrestamos() < 5 && publicacion.ejemplaresDisponibles()) {
				Prestamo nuevo = new Prestamo(cliente, publicacion, devol);
				agregarPrestamo(nuevo);
				cliente.aumentarPrestamosActivos();
				publicacion.prestamoRealizado();
				realizar = true;
			}
		}
		return realizar;
	}
	
	public boolean devolverDocumento(String codCliente, String codDocumento) {
		boolean devolver = false;
		Prestamo prestamo = buscarPrestamoPorClienteDoc(codCliente, codDocumento);
		if(prestamo != null) {
			if(prestamo.getMiEstado() != EstadoPrestamo.DEVUELTO) {
				prestamo.setMiEstado(EstadoPrestamo.DEVUELTO);
				prestamo.getMiCliente().disminuirPrestamosActivos();
				prestamo.getMiPublicacion().prestamoEntregado();
				devolver = true;
			}
		}
		return devolver;
	}
	
	public int[] cantTipoDocPretadoCliente(String codcliente) {
		int[] cant = new int[3];
		ArrayList<Prestamo> prestamos = prestamosCodigoCliente(codcliente);
		for(Prestamo e : prestamos) {
			if(e.getMiPublicacion() instanceof Libro)   
				cant[0] += 1;
			if(e.getMiPublicacion() instanceof Revista) 
				cant[1] += 1;
			if(e.getMiPublicacion() instanceof Articulo)
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
