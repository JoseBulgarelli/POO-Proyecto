package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import control.Controladora;
import logica.Cliente;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class NuevoPrestamo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable clientesTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NuevoPrestamo dialog = new NuevoPrestamo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	/**
	 * Create the dialog.
	 */
	
	public NuevoPrestamo() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				showearClientes();
			}
		});
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cliente del Prestamo:");
			lblNewLabel.setBounds(10, 10, 122, 19);
			contentPanel.add(lblNewLabel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 39, 383, 183);
			contentPanel.add(scrollPane);
			{
				clientesTabla = new JTable();
				clientesTabla.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Nombre", "Email", "Telefono", "Prestamos"
					}
				) {
					Class[] columnTypes = new Class[] {
						String.class, String.class, String.class, Float.class
					};
					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
				clientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(clientesTabla);
			}
		}
		{
			showearClientes();
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Controladora control = Controladora.getInstance();
						int filer = clientesTabla.getSelectedRow();
						try {
							control.hacerPrestamo(filer);
							dispose();
						} catch (Exception StarWalker) {
							JOptionPane.showMessageDialog(contentPanel, StarWalker, "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
