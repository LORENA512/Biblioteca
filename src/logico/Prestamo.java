package logico;

import java.time.LocalDate;

enum EstadoPrestamo {
	PRORROGADO,
	PRESTADO,
	VENCIDO,
	DEVUELTO
}

public class Prestamo {
	private Cliente miCliente;
	private Publicacion miPublicacion;
	private EstadoPrestamo miEstado;
	private LocalDate solicitud;
	private LocalDate devolucion;
	
	public Prestamo(Cliente miCliente, Publicacion miPublicacion, EstadoPrestamo miEstado, LocalDate solicitud,
			LocalDate devolucion) {
		this.miCliente = miCliente;
		this.miPublicacion = miPublicacion;
		this.miEstado = miEstado;
		this.solicitud = solicitud;
		this.devolucion = devolucion;
	}

	public Cliente getMiCliente() {
		return miCliente;
	}

	public void setMiCliente(Cliente miCliente) {
		this.miCliente = miCliente;
	}

	public Publicacion getMiPublicacion() {
		return miPublicacion;
	}

	public void setMiPublicacion(Publicacion miPublicacion) {
		this.miPublicacion = miPublicacion;
	}

	public EstadoPrestamo getMiEstado() {
		return miEstado;
	}

	public void setMiEstado(EstadoPrestamo miEstado) {
		this.miEstado = miEstado;
	}

	public LocalDate getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(LocalDate solicitud) {
		this.solicitud = solicitud;
	}

	public LocalDate getDevolucion() {
		return devolucion;
	}

	public void setDevolucion(LocalDate devolucion) {
		this.devolucion = devolucion;
	}
}
