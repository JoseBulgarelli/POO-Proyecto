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
	private static int codigoItem = 100;
	
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
	
	public void crearItem(String nombre, Tipo tipo, String descripcion) throws Exception {
		if (tipos.isEmpty()) {
			throw new Exception("No se puede añadir un item sin un tipo para asignarle");
		}
		Item i = new Item(nombre, tipo, descripcion, codigoItem);
		tipo.agregarItem(i);
		items.add(i);
	}
	
	public void modificarItem(Item item) throws Exception {
		if (!items.contains(item)) {
			throw new Exception("Ese item no existe en el sistema");
		}
	}
	
	public void borrarItem(Item item) throws Exception {
		if (!items.contains(item)) {
			throw new Exception("Ese item no existe en el sistema");
		}
		items.remove(item);
		item.getTipo().eliminarItem(item);  // No entiendo si ya no se puede usar desde ese punto en adelante o si se tiene que borrar toda mencion del item
	}
	
	public String consultarItem(Item item) throws Exception {
		if (!items.contains(item)) {
			throw new Exception("Ese item no existe en el sistema")
		}
		return item.consultarItem();
	}
	
	public void crearCliente(String nombre, String telefono, String email) {
		Cliente c = new Cliente(nombre, telefono, email);
		clientes.add(c);
	}
	
	public void modificarCliente(Cliente cliente) throws Exception {
		if (!clientes.contains(cliente)) {
			throw new Exception("Ese cliente no existe en el sistema");
		}
	}
	
	public void borrarCliente(Cliente cliente) throws Exception {
		if (!clientes.contains(cliente)) {
			throw new Exception("Ese cliente no existe en el sistema");
		}
		clientes.remove(cliente);
	}
	
	public String consultarCliente(Cliente cliente) throws Exception {
		if (!clientes.contains(cliente)) {
			throw new Exception("Ese cliente no existe en el sistema");
		}
		return cliente.consultarCliente();
	}
	
	public void crearCategoria(String nombre) {
		Categoria c = new Categoria(nombre);
		categorias.add(c);
	}
	
	public void modificarCategoria(Categoria categoria) throws Exception {
		if (!categorias.contains(categoria)) {
			throw new Exception("Esa categoria no existe en el sistema");
		}
	}
	
	public void borrarCategoria(Categoria categoria) throws Exception {
		if (!categorias.contains(categoria)) {
			throw new Exception("Esa categoria no existe en el sistema");
		}
		categorias.remove(categoria);
	}
	
	public String consultarCategoria(Categoria categoria) throws Exception {
		if (!categorias.contains(categoria)) {
			throw new Exception("Esa categoria no existe en el sistema");
		}
		return categoria.consultarCategoria();
	}
	
	public void crearTipo(String nombre) {
		Tipo t = new Tipo(nombre);
		tipos.add(t);
	}
	
	public void modificarTipo(Tipo tipo) throws Exception {
		if (!tipos.contains(tipo)) {
			throw new Exception("Ese tipo no existe en el sistema");
		}
	}
	
	public void borrarTipo(Tipo tipo) throws Exception {
		if (!tipos.contains(tipo)) {
			throw new Exception("Ese tipo no existe en el sistema");
		}
		tipos.remove(tipo);
	}
	
	public String consultarTipo(Tipo tipo) throws Exception {
		if (!tipos.contains(tipo)) {
			throw new Exception("Ese tipo no existe en el sistema");
		}
		return tipo.consultarTipo();
	}
	
	public void hacerPrestamo(Cliente cliente, ArrayList<Item> itemsPrestamear) throws Exception {
		if (items.isEmpty() || clientes.isEmpty()) {
			throw new Exception("Se necesita al menos un item y un cliente en el sistema para realizar un prestamo");
		}
		Prestamo p = new Prestamo(cliente, itemsPrestamear);
		prestamos.add(p);
	}
	
	public void agregaerItemAPrestamo(Item item, Prestamo prestamo) throws Exception {
		if (!items.contains(item)) {
			throw new Exception("Ese item no existe en el sistema");
		}
		prestamo.agregarItem(item);
	}
	
	public void eliminarItemDePrestamo(Item item, Prestamo prestamo) throws Exception {
		if (prestamo.getItemsPrestameados().isEmpty()) {
			throw new Exception("El prestamo no tiene items para eliminar");
		}
		prestamo.eliminarItem(item);
	}
	
	public void retornarItemDePrestamo(Item item, Prestamo prestamo) throws Exception {
		if (!prestamos.contains(prestamo)) {
			throw new Exception("El prestamo no existe en el sistema");
		}
		prestamo.eliminarItem(item);
	}
	
	public void finalizarPrestamo(Prestamo prestamo) throws Exception {
		if (!prestamos.contains(prestamo)) {
			throw new Exception("El prestamo no existe en el sistema");
		}
		prestamos.remove(prestamo);
	}
	
	public String reporteClientes() {
		return clientes.toString();
	}
	
	public String reporteItems() {
		return items.toString();
	}
	
	public String reporteCategorias() {
		return categorias.toString();
	}
	
	public String reporteTipos() {
		return tipos.toString();
	}
	
}  // Necesito otro dia para terminar esto de fijo
