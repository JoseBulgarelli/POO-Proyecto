package control;

import java.util.ArrayList;

import logica.Categoria;
import logica.Cliente;
import logica.Item;
import logica.Prestamo;
import logica.Tipo;

public class Controladora {
	private static Controladora instance = null;
	private ArrayList<Categoria> categorias;
	private ArrayList<Tipo> tipos;
	private ArrayList<Item> items;
	private ArrayList<Prestamo> prestamos;
	private ArrayList<Cliente> clientes;
	
	private Controladora() {
		categorias = new ArrayList<Categoria>();
		tipos = new ArrayList<Tipo>();
		items = new ArrayList<Item>();
		prestamos = new ArrayList<Prestamo>();
		clientes = new ArrayList<Cliente>();
	}
	
	public static Controladora getInstance() {
		if (instance == null) {
			instance = new Controladora();
		}
		return instance;
	}

	public void crearItem(String nombre, ArrayList<Categoria> categorias, Tipo tipo) {
		
	}
	
	public void crearCliente(String nombre, String telefono, String email) {
		Cliente c = new Cliente(nombre, telefono, email);
		clientes.add(c);
	}
	
	public void crearCategoria(String nombre) {
		Categoria c = new Categoria(nombre);
		categorias.add(c);
	}
	
	public void crearTipo(String nombre) {
		Tipo t = new Tipo(nombre);
		tipos.add(t);
	}
	
	public void hacerPrestamo(Cliente clientePrestamo, ArrayList<Item> items) {
		Prestamo p = clientePrestamo.hacerPrestamo(clientePrestamo, items);
		prestamos.add(p);
	}
	
	public void agregarCategoria(Categoria categoria) {
		
	}
	
	public void agregarPrestamo(Prestamo prestamo) {
		
	}
	
	public void agregarItemAPrestamo(Item item, Prestamo prestamo) {
		
	}
	
	public void eliminarPrestamo(Prestamo prestamo, Cliente clientePrestamo) {
		clientePrestamo.eliminarPrestamo(prestamo);
	}
	
	public void eliminarItemDePrestamo(String nombre, Prestamo prestamo) {
		
	}
	
	public void eliminarCliente(String nombre) {
		
	}
	
	public void eliminarItemCategoria(Item item) {
		
	}
	
	public void eliminarCategoria(String nombre) {
		
	}
	
	public void eliminarItemTipo(Item item) {
		
	}
	
	public void eliminarTipo(String nombre) {
		
	}
	
	public void eliminarItem(Item item) {
		
	}
	
	public void modificarItem(String nombre, ArrayList<Categoria> categorias, Tipo tipo) {
		
	}
	
	public void modificarCliente(String cliente, ArrayList<Prestamo> prestamos) {
		
	}
	
	public void modificarCategoria(String nombre, ArrayList<Prestamo> prestamo) {
		
	}
	
	public void modificarTipo(String nombre, ArrayList<Item> items) {
		
	}
	
	public void finalizarPrestamo() {
		
	}
	
	public void devolverItemDePrestamo(Item item, Prestamo prestamo) {
		
	}
	
	public ArrayList<Tipo> getListaTipos() {
		return 
	}
	
	public ArrayList<Cliente> getListaClientes() {
		
	}
	
	public ArrayList<Item> getListaItems() {
		
	}
	
	public ArrayList<Categoria> getListaCategorias() {
		
	}
	
	public String consultarItem() {
		
	}
	
	public String consultarCliente() {
		
	}
	
	public String consultarCategoria() {
		
	}
	
	public String consultarTipo() {
		
	}
	
	public void reporteTipos() {
		
	}
	
	public void reporteCategorias() {
		
	}
	
	public void reporteItems() {
		
	}
	
	public void reporteClientes() {
		
	}
	
	public void guardarDatos() {
		
	}
	
	public void cargarDatos() {
		
	}
	
}
