package logica;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String telefono;
	private String email;
	private ArrayList<Prestamo> prestamos;
	
	private Boolean esTelefonoValido(String telefono) {
		return true;
	}
	
	private Boolean esEmailValido(String email) {
		return true;
	}
	
	public Cliente(String nombre, String telefono, String email) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
	}
	
	public void modificarCliente(String nombre, String telefono, String email, ArrayList<Prestamo> prestamos) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.prestamos = prestamos;
	}
	
	public String consultarCliente() {
		return "Nombre del cliente: " + nombre +
				"\nTelefono del cliente: " + telefono +
				"\nEmail del cliente: " + email +
				"\nPrestamos del cliente: " + prestamos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Prestamo hacerPrestamo(Cliente clientePrestamo, ArrayList<Item> items) {
		Prestamo p = new Prestamo(clientePrestamo, items);
		prestamos.add(p);
		return p;
	}
	
	public void eliminarPrestamo(Prestamo prestamo) {
		prestamos.remove(prestamo);
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
}
