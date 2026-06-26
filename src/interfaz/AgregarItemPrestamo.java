package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.Controladora;
import logica.Item;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;
import javax.swing.JScrollPane;

public class AgregarItemPrestamo extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable itemsTabla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarItemPrestamo dialog = new AgregarItemPrestamo(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	private void showearItems() {
		Controladora control = Controladora.getInstance();
		DefaultTableModel model = (DefaultTableModel) itemsTabla.getModel();
		model.setRowCount(0);
		List<Item> listaItems = control.getItems();
		for (Item item : listaItems) {
			String nombrePrestamo;
			if (item.getPrestamo() == null) {
				nombrePrestamo = "No esta en un prestamo";
			}
			else {
				nombrePrestamo = item.getPrestamo().getClientePrestamo().getNombre();
			}
			Object[] fila = new Object[] {item.getNombre(), item.getCodigo(), item.getTipo().getNombre(), nombrePrestamo};
			model.addRow(fila);
		}
	}
	
	public AgregarItemPrestamo(int filer) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				showearItems();
			}
		});
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Cual item agregar?");
			lblNewLabel.setBounds(10, 10, 121, 12);
			contentPanel.add(lblNewLabel);
		}
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(20, 32, 379, 190);
			contentPanel.add(scrollPane);
			{
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
				itemsTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				itemsTabla.getColumnModel().getColumn(3).setPreferredWidth(148);
				scrollPane.setViewportView(itemsTabla);
			}
		}
		{
			showearItems();
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Controladora control = Controladora.getInstance();
						DefaultTableModel model = (DefaultTableModel) itemsTabla.getModel();
						int fil = itemsTabla.getSelectedRow();
						if (fil == -1) {
							JOptionPane.showMessageDialog(contentPanel, "Seleccione un item para agregar!!!", "Error", JOptionPane.ERROR_MESSAGE);
						} else {
							if (itemsTabla.getValueAt(fil, 3) != "No esta en un prestamo") {
								JOptionPane.showMessageDialog(contentPanel, "Ese item ya esta siendo prestameado!!", "Error", JOptionPane.ERROR_MESSAGE);
							} else {
								try {
									control.agregarItemAPrestamo(fil, filer);
								} catch (Exception StarWalker) {
									StarWalker.printStackTrace();
								}
								dispose();
							}
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
