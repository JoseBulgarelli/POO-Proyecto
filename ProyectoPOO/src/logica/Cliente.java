package logica;

import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private String telefono;
	private String email;
	
	private Boolean esTelefonoValido(String telefono) {
		return true;
	}
	
	private Boolean esEmailValido(String email) {
		return true;
	}
	
	public Cliente(String nombre, String telefono, String email) {
		
	}
	
	public void modificarCliente(String cliente, ArrayList<Prestamo> prestamos) {
		
	}
	
	public void consultarCliente() {
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre() {
		
	}
	
	public void agregarPrestamo(Prestamo prestamo) {
		
	}
	
	public void eliminarPrestamo(Prestamo prestamo) {
		
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		
	}
	
}
