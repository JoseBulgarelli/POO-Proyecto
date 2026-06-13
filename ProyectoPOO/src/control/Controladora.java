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
	
	public void crearItem(String nombre, int tipoIndex, String descripcion) throws Exception {
		if (tipos.isEmpty()) {
			throw new Exception("No se puede añadir un item sin un tipo para asignarle");
		}
		Item i = new Item(nombre, tipos.get(tipoIndex), descripcion, codigoItem);
		tipos.get(tipoIndex).agregarItem(i);
		items.add(i);
		codigoItem++;
	}
	
	public void modificarItem(int itemIndex, String nombre, int tipoIndex, String descripcion, ArrayList<Categoria> categorias) throws Exception {
		if (items.size() <= itemIndex) {  // Lo pongo por ponerlo porque en teoria ni puedes seleccionar uno erroneo (si funciona como yo creo que funciona)
			throw new Exception("Ese item no existe en el sistema");
		}
		Item viejoItem = items.get(itemIndex);
		Item nuevoItem = viejoItem;
		nuevoItem.modificarItem(nombre, categorias, tipos.get(tipoIndex), descripcion);// No tengo claro como vamos a obtener la lista de categorias though
		items.remove(itemIndex);
		items.add(itemIndex, nuevoItem);
		for (int i = 0; this.categorias.size() > i; i++) {
			if (this.categorias.get(i).getItems().contains(viejoItem)) {
				this.categorias.get(i).borrarItemDeLaCategoria(viejoItem);
				this.categorias.get(i).agregarItemALaCategoria(this.items.get(itemIndex));
			}
		}
		for (int i = 0; this.prestamos.size() > i; i++) {
			if (this.prestamos.get(i).getItemsPrestameados().contains(viejoItem)) {
				this.prestamos.get(i).eliminarItem(viejoItem);
				this.prestamos.get(i).agregarItem(this.items.get(itemIndex));
			}
		}
		for (int i = 0; this.tipos.size() > i; i++) {
			if (this.tipos.get(i).getItems().contains(viejoItem)) {
				this.tipos.get(i).eliminarItem(viejoItem);
				this.tipos.get(i).agregarItem(this.items.get(itemIndex));
			}
		}
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
		Cliente viejoCliente = clientes.get(clienteIndex);
		Cliente nuevoCliente = viejoCliente;
		nuevoCliente.modificarCliente(nombre, telefono, email);
		clientes.remove(clienteIndex);
		clientes.add(clienteIndex, nuevoCliente);
		for (int i = 0; prestamos.size() > i; i++) {
			if (prestamos.get(i).getClientePrestamo().equals(viejoCliente)) {
				prestamos.get(i).setClientePrestamo(nuevoCliente);
			}
		}
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
			throw new Exception("Ese cliente no existe en el sistema");
		}
		Categoria viejaCate = categorias.get(cateIndex);
		Categoria nuevaCate = viejaCate;
		nuevaCate.modificarCategoria(nombre);
		categorias.remove(cateIndex);
		categorias.add(cateIndex, nuevaCate);
		for (int i = 0; items.size() > i; i++) {
			if (items.get(i).getCategorias().contains(viejaCate)) {
				ArrayList<Categoria> soyUnVago = items.get(i).getCategorias();  // Talvez hacerle a CADA CLASE funciones para quitar elementos de sus listas, para no tener que hacer esta chapuceria
				soyUnVago.set(soyUnVago.indexOf(viejaCate), nuevaCate);
				items.get(i).setCategorias(soyUnVago);
			}
		}
	}
	
	public void borrarCategoria(int cateIndex) throws Exception {
		if (categorias.size() <= cateIndex) {
			throw new Exception("Ese cliente no existe en el sistema");
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
			throw new Exception("Ese cliente no existe en el sistema");
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
		Tipo viejoTipo = tipos.get(tipoIndex);
		Tipo nuevoTipo = viejoTipo;
		nuevoTipo.modificarTipo(nombre);
		tipos.remove(tipoIndex);
		tipos.add(tipoIndex, nuevoTipo);
		for (int i = 0; items.size() > i; i++) {
			if (items.get(i).getTipo().equals(viejoTipo)) {
				items.get(i).setTipo(nuevoTipo);
			}
		}
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
		if (items.isEmpty() || clientes.isEmpty()) {
			throw new Exception("Se necesita al menos un item y un cliente en el sistema para realizar un prestamo");
		}
		if (clientes.size() <= clienteIndex) {
			throw new Exception("Ese cliente no existe");
		}
		Cliente clienteP = clientes.get(clienteIndex);
		Prestamo p = new Prestamo(clienteP);
		prestamos.add(p);
		clienteP.hacerPrestamo();
		clientes.set(clienteIndex, clienteP);
	}
	
	public void agregarItemAPrestamo(int itemIndex, int prestamoIndex) throws Exception {
		Prestamo prestamoEC = prestamos.get(prestamoIndex);
		if (!prestamoEC.getEnCreacion()) {
			throw new Exception("El prestamo debe estar en proceso de creacion");
		}
		if (items.isEmpty()) {
			throw new Exception("No hay items en el sistema");
		}
		Item itemEC = items.get(itemIndex);
		if (itemEC.getPrestamo() != null) {
			throw new Exception("Ese item ya pertenece a un prestamo");
		}
		itemEC.setPrestamo(prestamoEC);
		prestamoEC.agregarItem(itemEC);
		items.set(itemIndex, itemEC);
		prestamos.set(prestamoIndex, prestamoEC);
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
		if (!prestamoEC.getEnCreacion()) {
			throw new Exception("El prestamo debe estar en proceso de creacion");
		}
		for (int i = 0; items.size() > i; i++) {
			if (items.get(i).getPrestamo().equals(prestamoEC)) {
				Item itemEC = items.get(i);
				itemEC.setPrestamo(null);
				items.set(i, itemEC);
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
	
}  // Necesito otro dia para terminar esto de fijo

// Lo obtuve, further changes seran para la interfaz!!
