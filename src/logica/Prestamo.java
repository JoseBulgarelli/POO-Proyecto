package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Prestamo {
	private int tipoDeAlerta;
	private LocalDateTime alerta;
	private int intervalo;
	private LocalDateTime fechaDeCreacion;
	private Cliente clientePrestamo;
	private ArrayList<Item> itemsPrestameados;
	private Boolean enCreacion;
	
	public Prestamo(Cliente clientePrestamo) {
		this.clientePrestamo = clientePrestamo;
		fechaDeCreacion = LocalDateTime.now();
		enCreacion = true;
		itemsPrestameados = new ArrayList<>();
	}
	
	public void alertaRecurrente() {
		
	}
	
	public void alertaUnica() {
		
	}
	
	public void agregarItem(Item item) {
		itemsPrestameados.add(item);
		item.agregarAPrestamo(this);
	}
	
	public void eliminarItem(Item item) {
		itemsPrestameados.remove(item);
	}
	
	public Cliente getClientePrestamo() {
		return clientePrestamo;
	}
	
	public void setClientePrestamo(Cliente clientePrestamo) {
		this.clientePrestamo = clientePrestamo;
	}
	
	public int getIntervalo() {
		return intervalo;
	}
	
	public void setIntervalo(int intervalo) {
		this.intervalo = intervalo;
	}
	
	public LocalDateTime getFechaDeCreacion() {
		return fechaDeCreacion;
	}
	
	public void setFechaDeCreacion(LocalDateTime fechaDeCreacion) {
		this.fechaDeCreacion = fechaDeCreacion;
	}
	
	public ArrayList<Item> getItemsPrestameados() {
		return itemsPrestameados;
	}
	
	public void finalizarPrestamo() {
		enCreacion = false;
	}
	
	public Boolean getEnCreacion() {
		return enCreacion;
	}
}
