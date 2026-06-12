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
	
	public void crearItem() throws Exception {
		throw new Exception("Sussus mogus");
	}
}
