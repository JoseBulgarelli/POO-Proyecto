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
	
	public void modificarCliente(String nombre, String telefono, String email) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
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
	
	public Prestamo hacerPrestamo() {
		Prestamo p = new Prestamo(this);
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
	
	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}
	
}
