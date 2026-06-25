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
import control.Controladora;

public class Principal {

	private JFrame frame;

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
	
	private void adminItems() {
		AdminItems ventanaAdminItems = new AdminItems();
		ventanaAdminItems.setVisible(true);
	}
	
	private void adminClientes() {
		AdminClientes ventanaAdminClientes = new AdminClientes();
		ventanaAdminClientes.setVisible(true);
	}
	
	private void adminCategorias() {
		AdminCategorias ventanaAdminCategorias = new AdminCategorias();
		ventanaAdminCategorias.setVisible(true);
	}
	
	private void adminTipos() {
		AdminTipos ventanaAdminTipos = new AdminTipos();
		ventanaAdminTipos.setVisible(true);
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
		frame.setBounds(100, 100, 421, 268);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel administracionP = new JPanel();
		tabbedPane.addTab("Administración", null, administracionP, null);
		administracionP.setLayout(null);
		
		JButton btnItemsAd = new JButton("Items");
		btnItemsAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminItems();
			}
		});
		btnItemsAd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnItemsAd.setBounds(10, 10, 134, 50);
		administracionP.add(btnItemsAd);
		
		JButton btnClienteAd = new JButton("Clientes");
		btnClienteAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminClientes();
			}
		});
		btnClienteAd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClienteAd.setBounds(193, 10, 134, 50);
		administracionP.add(btnClienteAd);
		
		JButton btnCategoriasAd = new JButton("Categorias");
		btnCategoriasAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vReporteCategorias();
			}
		});
		btnCategoriasAd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCategoriasAd.setBounds(193, 87, 134, 50);
		administracionP.add(btnCategoriasAd);
		
		JButton btnTiposAd = new JButton("Tipos");
		btnTiposAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vReporteTipos();
			}
		});
		btnTiposAd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTiposAd.setBounds(10, 87, 134, 50);
		administracionP.add(btnTiposAd);
		
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
