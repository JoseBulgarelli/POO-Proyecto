package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.List;

import control.Controladora;
import logica.Categoria;
import logica.Cliente;
import logica.Item;
import logica.Tipo;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Principal {

	private JFrame frame;
	private JTable itemsTabla;
	private JTable tiposTabla;
	private JTable clientesTabla;
	private JTable categoriasTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	private void vNuevoPrestamo() {
		NuevoPrestamo ventanaNuevoPrestamo = new NuevoPrestamo();
		ventanaNuevoPrestamo.setVisible(true);
	}
	
	private void vModificarPrestamo() {
		ModificarPrestamo ventanaModificarPrestamo = new ModificarPrestamo();
		ventanaModificarPrestamo.setVisible(true);
	}
	
	private void vFinalizarPrestamo() {
		FinalizarPrestamo ventanaFinalizarPrestamo = new FinalizarPrestamo();
		ventanaFinalizarPrestamo.setVisible(true);
	}
	
	private void vReporteItems() {
		ReporteItems ventanaReporteItems = new ReporteItems();
		ventanaReporteItems.setVisible(true);
	}
	
	private void vReporteClientes() {
		ReporteClientes ventanaReporteClientes = new ReporteClientes();
		ventanaReporteClientes.setVisible(true);
	}
	
	private void vReporteCategorias() {
		ReporteCategorias ventanaReporteCategorias = new ReporteCategorias();
		ventanaReporteCategorias.setVisible(true);
	}
	
	private void vReporteTipos() {
		ReporteTipos ventanaReporteTipos = new ReporteTipos();
		ventanaReporteTipos.setVisible(true);
	}
	
	private void showearItems() {
		Controladora control = Controladora.getInstance();
		DefaultTableModel model = (DefaultTableModel) itemsTabla.getModel();
		model.setRowCount(0);
		List<Item> listaItems = control.getItems();
		for (Item item : listaItems) {
			String nombrePrestamo;
			if (item.getPrestamo() == null) {
				nombrePrestamo = "No esta en un prestamo.";
			}
			else {
				nombrePrestamo = item.getPrestamo().getClientePrestamo().getNombre();
			}
			Object[] fila = new Object[] {item.getNombre(), item.getCodigo(), item.getTipo().getNombre(), nombrePrestamo};
			model.addRow(fila);
		}
	}
	
	private void vCrearItem() {
		CrearItem ventanaCrearItem = new CrearItem();
		ventanaCrearItem.setVisible(true);
	}
	
	private void vModificarItem() {
		ModificarItem ventanaModificarItem = new ModificarItem();
		ventanaModificarItem.setVisible(true);
	}
	
	private void vBorrarItem() {
		BorrarItem ventanaBorrarItem = new BorrarItem();
		ventanaBorrarItem.setVisible(true);
	}
	
	private void vConsultarItem() {
		ConsultarItem ventanaConsultarItem = new ConsultarItem();
		ventanaConsultarItem.setVisible(true);
	}
	
	private void showearClientes() {
		Controladora control = Controladora.getInstance();
		DefaultTableModel model = (DefaultTableModel) clientesTabla.getModel();
		model.setRowCount(0);
		List<Cliente> listaClientes = control.getClientes();
		for (Cliente cliente : listaClientes) {
			int cantidadPrestamos;
			if (cliente.getPrestamos() == null) {
				cantidadPrestamos = 0;
			} else {
				cantidadPrestamos = cliente.getPrestamos().size();
			}
			Object[] fila = new Object[] {cliente.getNombre(), cliente.getEmail(), cliente.getTelefono(), cantidadPrestamos};
			model.addRow(fila);
		}
	}
	
	private void showearCategorias() {
		Controladora control = Controladora.getInstance();
		DefaultTableModel model = (DefaultTableModel) categoriasTabla.getModel();
		model.setRowCount(0);
		List<Categoria> listaCategorias = control.getCategorias();
		for (Categoria categoria : listaCategorias) {
			int cantidadItems;
			if (categoria.getItems() == null) {
				cantidadItems = 0;
			} else {
				cantidadItems = categoria.getItems().size();
			}
			Object[] fila = new Object[] {categoria.getNombre(), cantidadItems};
			model.addRow(fila);
		}
	}
	
	private void showearTipos() {
		Controladora control = Controladora.getInstance();
		DefaultTableModel model = (DefaultTableModel) tiposTabla.getModel();
		model.setRowCount(0);
		List<Tipo> listaTipos = control.getTipos();
		for (Tipo tipo : listaTipos) {
			int cantidadItems;
			if (tipo.getItems() == null) {
				cantidadItems = 0;
			} else {
				cantidadItems = tipo.getItems().size();
			}
			Object[] fila = new Object[] {tipo.getNombre(), cantidadItems};
			model.addRow(fila);
		}
	}
	
	private void vCrearTipo() {
		CrearTipo ventanaCrearTipo = new CrearTipo();
		ventanaCrearTipo.setVisible(true);
	}
	
	private void vModificarTipo() {
		ModificarTipo ventanaModificarTipo = new ModificarTipo();
		ventanaModificarTipo.setVisible(true);
	}
	
	private void vBorrarTipo() {
		BorrarTipo ventanaBorrarTipo = new BorrarTipo();
		ventanaBorrarTipo.setVisible(true);
	}
	
	private void vConsultarTipo() {
		ConsultarTipo ventanaConsultarTipo = new ConsultarTipo();
		ventanaConsultarTipo.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 513, 344);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel administracionP = new JPanel();
		tabbedPane.addTab("Administración", null, administracionP, null);
		administracionP.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		administracionP.add(tabbedPane_1, BorderLayout.CENTER);
		
		JPanel ItemsPanel = new JPanel();
		ItemsPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				showearItems();
			}
		});
		tabbedPane_1.addTab("Items", null, ItemsPanel, null);
		ItemsPanel.setLayout(null);
		
		JButton btnCrearItem = new JButton("Crear");
		btnCrearItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vCrearItem();
				showearItems();
			}
		});
		btnCrearItem.setBounds(376, 10, 103, 20);
		ItemsPanel.add(btnCrearItem);
		
		JButton btnModificarItem = new JButton("Modificar");
		btnModificarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vModificarItem();
				showearItems();
			}
		});
		btnModificarItem.setBounds(376, 40, 103, 20);
		ItemsPanel.add(btnModificarItem);
		
		JButton btnBorrarItem = new JButton("Borrar");
		btnBorrarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vBorrarItem();
				showearItems();
			}
		});
		btnBorrarItem.setBounds(376, 70, 103, 20);
		ItemsPanel.add(btnBorrarItem);
		
		JButton btnConsultarItem = new JButton("Consultar");
		btnConsultarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vConsultarItem();
				showearItems();
			}
		});
		btnConsultarItem.setBounds(376, 100, 103, 20);
		ItemsPanel.add(btnConsultarItem);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 13, 356, 230);
		ItemsPanel.add(scrollPane);
		
		itemsTabla = new JTable();
		itemsTabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Codigo", "Tipo", "Prestamo"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		itemsTabla.getColumnModel().getColumn(0).setPreferredWidth(105);
		itemsTabla.getColumnModel().getColumn(3).setPreferredWidth(137);
		scrollPane.setViewportView(itemsTabla);
		
		JPanel ClientesPanel = new JPanel();
		ClientesPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				showearClientes();
			}
		});
		tabbedPane_1.addTab("Clientes", null, ClientesPanel, null);
		ClientesPanel.setLayout(null);
		
		JButton btnCrearCliente = new JButton("Crear");
		btnCrearCliente.setBounds(376, 10, 103, 20);
		ClientesPanel.add(btnCrearCliente);
		
		JButton btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.setBounds(376, 40, 103, 20);
		ClientesPanel.add(btnModificarCliente);
		
		JButton btnBorrarCliente = new JButton("Borrar");
		btnBorrarCliente.setBounds(376, 70, 103, 20);
		ClientesPanel.add(btnBorrarCliente);
		
		JButton btnConsultarCliente = new JButton("Consultar");
		btnConsultarCliente.setBounds(376, 100, 103, 20);
		ClientesPanel.add(btnConsultarCliente);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 13, 356, 230);
		ClientesPanel.add(scrollPane_2);
		
		clientesTabla = new JTable();
		clientesTabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Email", "Telefono", "Prestamos"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		clientesTabla.getColumnModel().getColumn(3).setPreferredWidth(110);
		scrollPane_2.setViewportView(clientesTabla);
		
		JPanel CategoriasPanel = new JPanel();
		CategoriasPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				showearCategorias();
			}
		});
		tabbedPane_1.addTab("Categorias", null, CategoriasPanel, null);
		CategoriasPanel.setLayout(null);
		
		JButton btnCrearCategoria = new JButton("Crear");
		btnCrearCategoria.setBounds(376, 10, 103, 20);
		CategoriasPanel.add(btnCrearCategoria);
		
		JButton btnModificarCategoria = new JButton("Modificar");
		btnModificarCategoria.setBounds(376, 40, 103, 20);
		CategoriasPanel.add(btnModificarCategoria);
		
		JButton btnBorrarCategoria = new JButton("Borrar");
		btnBorrarCategoria.setBounds(376, 70, 103, 20);
		CategoriasPanel.add(btnBorrarCategoria);
		
		JButton btnConsultarCategoria = new JButton("Consultar");
		btnConsultarCategoria.setBounds(376, 100, 103, 20);
		CategoriasPanel.add(btnConsultarCategoria);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 13, 356, 230);
		CategoriasPanel.add(scrollPane_3);
		
		categoriasTabla = new JTable();
		categoriasTabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Cant. Items"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		categoriasTabla.getColumnModel().getColumn(0).setPreferredWidth(86);
		categoriasTabla.getColumnModel().getColumn(1).setPreferredWidth(95);
		scrollPane_3.setViewportView(categoriasTabla);
		
		JPanel TiposPanel = new JPanel();
		TiposPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				showearTipos();
			}
		});
		tabbedPane_1.addTab("Tipos", null, TiposPanel, null);
		TiposPanel.setLayout(null);
		
		JButton btnCrearTipo = new JButton("Crear");
		btnCrearTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vCrearTipo();
				showearTipos();
			}
		});
		btnCrearTipo.setBounds(376, 10, 103, 20);
		TiposPanel.add(btnCrearTipo);
		
		JButton btnBorrarTipo = new JButton("Borrar");
		btnBorrarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vBorrarTipo();
				showearTipos();
			}
		});
		btnBorrarTipo.setBounds(376, 70, 103, 20);
		TiposPanel.add(btnBorrarTipo);
		
		JButton btnModificarTipo = new JButton("Modificar");
		btnModificarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vModificarTipo();
				showearTipos();
			}
		});
		btnModificarTipo.setBounds(376, 40, 103, 20);
		TiposPanel.add(btnModificarTipo);
		
		JButton btnConsultarTipo = new JButton("Consultar");
		btnConsultarTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vConsultarTipo();
				showearTipos();
			}
		});
		btnConsultarTipo.setBounds(376, 100, 103, 20);
		TiposPanel.add(btnConsultarTipo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 13, 356, 230);
		TiposPanel.add(scrollPane_1);
		
		tiposTabla = new JTable();
		tiposTabla.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Cant. Items"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tiposTabla.getColumnModel().getColumn(1).setPreferredWidth(110);
		scrollPane_1.setViewportView(tiposTabla);
		
		JPanel prestamosP = new JPanel();
		tabbedPane.addTab("Prestamos", null, prestamosP, null);
		prestamosP.setLayout(null);
		
		JButton btnNuevoPrestamo = new JButton("Nuevo");
		btnNuevoPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vNuevoPrestamo();
			}
		});
		btnNuevoPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNuevoPrestamo.setBounds(10, 24, 136, 58);
		prestamosP.add(btnNuevoPrestamo);
		
		JButton btnModificarPrestamo = new JButton("Modificar");
		btnModificarPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnModificarPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vModificarPrestamo();
			}
		});
		btnModificarPrestamo.setBounds(193, 24, 136, 58);
		prestamosP.add(btnModificarPrestamo);
		
		JButton btnFinalizarPrestamo = new JButton("Finalizar");
		btnFinalizarPrestamo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vFinalizarPrestamo();
			}
		});
		btnFinalizarPrestamo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFinalizarPrestamo.setBounds(10, 108, 136, 58);
		prestamosP.add(btnFinalizarPrestamo);
		
		JPanel reportesP = new JPanel();
		tabbedPane.addTab("Reportes", null, reportesP, null);
		reportesP.setLayout(null);
		
		JButton btnItemsReporte = new JButton("Items");
		btnItemsReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vReporteItems();
			}
		});
		btnItemsReporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnItemsReporte.setBounds(10, 10, 156, 64);
		reportesP.add(btnItemsReporte);
		
		JButton btnClientesReporte = new JButton("Clientes");
		btnClientesReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vReporteClientes();
			}
		});
		btnClientesReporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClientesReporte.setBounds(197, 10, 156, 64);
		reportesP.add(btnClientesReporte);
		
		JButton btnCategoriasReporte = new JButton("Categorias");
		btnCategoriasReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vReporteCategorias();
			}
		});
		btnCategoriasReporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCategoriasReporte.setBounds(10, 98, 156, 64);
		reportesP.add(btnCategoriasReporte);
		
		JButton btnTiposReporte = new JButton("Tipos");
		btnTiposReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vReporteTipos();
			}
		});
		btnTiposReporte.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTiposReporte.setBounds(197, 98, 156, 64);
		reportesP.add(btnTiposReporte);
	}
}
