package control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import logica.Categoria;
import logica.Cliente;
import logica.Item;
import logica.Prestamo;
import logica.Tipo;

public class Controladora implements Serializable {
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
	
	public void crearItem(String nombre, int tipoIndex, String descripcion) throws Exception {
		if (tipos.isEmpty()) {
			throw new Exception("No se puede añadir un item sin un tipo para asignarle");
		}
		Item i = new Item(nombre, tipos.get(tipoIndex), descripcion, codigoItem);
		items.add(i);
		tipos.get(tipoIndex).agregarItem(i);
		codigoItem++;
	}
	
	public void modificarItem(int itemIndex, String nombre, int tipoIndex, String descripcion) throws Exception {
		if (items.size() <= itemIndex) {  // Lo pongo por ponerlo porque en teoria ni puedes seleccionar uno erroneo (si funciona como yo creo que funciona)
			throw new Exception("Ese item no existe en el sistema");
		}
		items.get(itemIndex).modificarItem(nombre, tipos.get(tipoIndex), descripcion);
	}
	
	public void borrarItem(int itemIndex) throws Exception {
		if (items.size() <= itemIndex) {
			throw new Exception("Ese item no existe en el sistema");
		}
		Item itemEC = this.items.get(itemIndex);
		for (int i = 0; this.prestamos.size() > i; i++) {
			if (this.prestamos.get(i).getItemsPrestameados().contains(itemEC)) {
				throw new Exception("No se puede borrar un item que esta en prestamo");
			}
		}
		this.items.remove(itemEC);
		for (int i = 0; this.tipos.size() > i; i++) {
			if (this.tipos.get(i).getItems().contains(itemEC)) {
				this.tipos.get(i).eliminarItem(itemEC);
			}
		}
		for (int i = 0; this.categorias.size() > i; i++) {
			if (this.categorias.get(i).getItems().contains(itemEC)) {
				this.categorias.get(i).borrarItemDeLaCategoria(itemEC);
			}
		}
	}
	
	public String consultarItem(int itemIndex) throws Exception {
		if (items.size() <= itemIndex) {
			throw new Exception("Ese item no existe en el sistema");
		}
		return items.get(itemIndex).consultarItem();  // Este no sabria hacerlo hasta tener la interfaz la verdad
	}
	
	public void crearCliente(String nombre, String telefono, String email) {
		Cliente c = new Cliente(nombre, telefono, email);
		clientes.add(c);
	}
	
	public void modificarCliente(int clienteIndex, String nombre, String telefono, String email) throws Exception {
		if (clientes.size() <= clienteIndex) {
			throw new Exception("Ese cliente no existe en el sistema");
		}
		clientes.get(clienteIndex).modificarCliente(nombre, telefono, email);
	}
	
	public void borrarCliente(int clienteIndex) throws Exception {
		if (clientes.size() <= clienteIndex) {
			throw new Exception("Ese cliente no existe en el sistema");
		}
		Cliente clienteEC = this.clientes.get(clienteIndex);
		if (!clienteEC.getPrestamos().isEmpty()) {
			throw new Exception("No se puede borrar un cliente que tenga prestamos activos");
		}
		clientes.remove(clienteIndex);
	}
	
	public String consultarCliente(int clienteIndex) throws Exception {
		if (clientes.size() <= clienteIndex) {
			throw new Exception("Ese cliente no existe en el sistema");
		}
		return clientes.get(clienteIndex).consultarCliente();
	}
	
	public void crearCategoria(String nombre) {
		Categoria c = new Categoria(nombre);
		categorias.add(c);
	}
	
	public void modificarCategoria(int cateIndex, String nombre) throws Exception {
		if (categorias.size() <= cateIndex) {
			throw new Exception("Ese categoria no existe en el sistema");
		}
		categorias.get(cateIndex).modificarCategoria(nombre);
	}
	
	public void borrarCategoria(int cateIndex) throws Exception {
		if (categorias.size() <= cateIndex) {
			throw new Exception("Ese categoria no existe en el sistema");
		}
		Categoria cateEC = categorias.get(cateIndex);
		categorias.remove(cateEC);
		for (int i = 0; items.size() > i; i++) {
			if (items.get(i).getCategorias().contains(cateEC)) {
				ArrayList<Categoria> soyMUYVago = items.get(i).getCategorias();
				soyMUYVago.remove(cateEC);
				items.get(i).setCategorias(soyMUYVago);
			}
		}
	}
	
	public String consultarCategoria(int cateIndex) throws Exception {
		if (categorias.size() <= cateIndex) {
			throw new Exception("Ese categoria no existe en el sistema");
		}
		return categorias.get(cateIndex).consultarCategoria();  // Tengo que pensarme bien estos
	}
	
	public void crearTipo(String nombre) {
		Tipo t = new Tipo(nombre);
		tipos.add(t);
	}
	
	public void modificarTipo(int tipoIndex, String nombre) throws Exception {
		if (tipos.size() <= tipoIndex) {
			throw new Exception("Ese tipo no existe en el sistema");
		}
		tipos.get(tipoIndex).modificarTipo(nombre);
	}
	
	public void borrarTipo(int tipoIndex) throws Exception {
		if (tipos.size() <= tipoIndex) {
			throw new Exception("Ese tipo no existe en el sistema");
		}
		Tipo tipoEC = tipos.get(tipoIndex);
		tipos.remove(tipoEC);  // Aca no tengo muy claro que tengo que hacer, probablemente tenga algo que ver con eso de "tipo generico", lo pensare mas cuando sea hora de hacer la interfaz
	}
	
	public String consultarTipo(int tipoIndex) throws Exception {
		if (tipos.size() <= tipoIndex) {
			throw new Exception("Ese tipo no existe en el sistema");
		}
		return tipos.get(tipoIndex).consultarTipo();
	}
	
	public void hacerPrestamo(int clienteIndex) throws Exception {
		if (clientes.isEmpty()) {
			throw new Exception("Se necesita al menos un cliente en el sistema para realizar un prestamo");
		}
		if (clientes.size() <= clienteIndex) {
			throw new Exception("Ese cliente no existe");
		}
		prestamos.add(clientes.get(clienteIndex).hacerPrestamo());
	}
	
	public void agregarItemAPrestamo(int itemIndex, int prestamoIndex) throws Exception {
		if (!prestamos.get(prestamoIndex).getEnCreacion()) {
			throw new Exception("El prestamo debe estar en proceso de creacion");
		}
		if (items.isEmpty()) {
			throw new Exception("No hay items en el sistema");
		}
		prestamos.get(prestamoIndex).agregarItem(items.get(itemIndex));
	}
	
	public void eliminarItemDePrestamo(int itemIndex, int prestamoIndex) throws Exception {
		Prestamo prestamoEC = prestamos.get(prestamoIndex);
		if (!prestamoEC.getEnCreacion()) {
			throw new Exception("El prestamo debe estar en proceso de creacion");
		}
		if (prestamoEC.getItemsPrestameados().isEmpty()) {
			throw new Exception("El prestamo no tiene items en el");
		}
		Item itemEC = items.get(itemIndex);
		if (itemEC.getPrestamo() != prestamoEC) {
			throw new Exception("Ese item ya pertenece a un prestamo");
		}
		prestamoEC.eliminarItem(itemEC);
		itemEC.setPrestamo(null);
		items.set(itemIndex, itemEC);
		prestamos.set(prestamoIndex, prestamoEC);
	}
	
	public void retornarItemDePrestamo(int itemIndex, int prestamoIndex) throws Exception {
		Prestamo prestamoEC = prestamos.get(prestamoIndex);
		if (!prestamoEC.getEnCreacion()) {
			throw new Exception("El prestamo debe estar en proceso de creacion");
		}
		if (prestamoEC.getItemsPrestameados().isEmpty()) {
			throw new Exception("El prestamo no tiene items en el");
		}
		Item itemEC = items.get(itemIndex);
		if (itemEC.getPrestamo() != prestamoEC) {
			throw new Exception("Ese item ya pertenece a un prestamo");
		}
		prestamoEC.eliminarItem(itemEC);
		itemEC.setPrestamo(null);
		items.set(itemIndex, itemEC);
		prestamos.set(prestamoIndex, prestamoEC);
	}
	
	public void finalizarPrestamo(int prestamoIndex) throws Exception {
		Prestamo prestamoEC = prestamos.get(prestamoIndex);
		for (int i = 0; items.size() > i; i++) {
			if (items.get(i).getPrestamo().equals(prestamoEC)) {
				items.get(i).setPrestamo(null);
			}
		}
		for (int i = 0; clientes.size() > i; i++) {
			if (clientes.get(i) == prestamoEC.getClientePrestamo()) {
				clientes.get(i).eliminarPrestamo(prestamoEC);
			}
		}
		prestamos.remove(prestamoEC);
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

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public ArrayList<Tipo> getTipos() {
		return tipos;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	
	public static void guardarDatos() throws IOException {
		FileOutputStream file = new FileOutputStream("DatosPrestamos.bin");
		ObjectOutputStream stream = new ObjectOutputStream(file);
		stream.writeObject(instance);
		stream.close();
		file.close();
	}
	
	public static void cargarDatos() throws IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream("DatosPrestamos.bin");
		ObjectInputStream stream = new ObjectInputStream(file);
		instance = (Controladora) stream.readObject();
		stream.close();
		file.close();
	}
	
	
}  // Necesito otro dia para terminar esto de fijo

// Lo obtuve, further changes seran para la interfaz!!


// Importante encontrar una forma de que todos siempre se refieran al mismo objeto, porque si por algo que exista hay que hacerlo y modificarlo 3 veces en todo lado sera molesto
