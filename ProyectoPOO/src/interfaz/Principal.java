package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 547, 358);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel administracionP = new JPanel();
		tabbedPane.addTab("Administración", null, administracionP, null);
		administracionP.setLayout(null);
		
		JButton btnItems = new JButton("Items");
		btnItems.setBounds(10, 10, 84, 21);
		administracionP.add(btnItems);
		
		JButton btnClienteAd = new JButton("Clientes");
		btnClienteAd.setBounds(10, 41, 84, 20);
		administracionP.add(btnClienteAd);
		
		JButton btnCategoriasAd = new JButton("Categorias");
		btnCategoriasAd.setBounds(10, 71, 84, 20);
		administracionP.add(btnCategoriasAd);
		
		JButton btnTiposAd = new JButton("Tipos");
		btnTiposAd.setBounds(10, 101, 84, 20);
		administracionP.add(btnTiposAd);
		
		JPanel prestamosP = new JPanel();
		tabbedPane.addTab("Prestamos", null, prestamosP, null);
		prestamosP.setLayout(null);
		
		JButton btnNuevoPrestamo = new JButton("Nuevo");
		btnNuevoPrestamo.setBounds(10, 24, 84, 20);
		prestamosP.add(btnNuevoPrestamo);
		
		JButton btnModificarPrestamo = new JButton("Modificar");
		btnModificarPrestamo.setBounds(10, 66, 84, 20);
		prestamosP.add(btnModificarPrestamo);
		
		JButton btnFinalizarPrestamo = new JButton("Finalizar");
		btnFinalizarPrestamo.setBounds(10, 108, 84, 20);
		prestamosP.add(btnFinalizarPrestamo);
		
		JPanel reportesP = new JPanel();
		tabbedPane.addTab("Reportes", null, reportesP, null);
		reportesP.setLayout(null);
		
		JButton btnItemsReporte = new JButton("Items");
		btnItemsReporte.setBounds(10, 10, 84, 20);
		reportesP.add(btnItemsReporte);
		
		JButton btnClientesReporte = new JButton("Clientes");
		btnClientesReporte.setBounds(10, 52, 84, 20);
		reportesP.add(btnClientesReporte);
		
		JButton btnCategoriasReporte = new JButton("Categorias");
		btnCategoriasReporte.setBounds(10, 98, 84, 20);
		reportesP.add(btnCategoriasReporte);
		
		JButton btnTiposReporte = new JButton("Tipos");
		btnTiposReporte.setBounds(10, 145, 84, 20);
		reportesP.add(btnTiposReporte);
	}
}
