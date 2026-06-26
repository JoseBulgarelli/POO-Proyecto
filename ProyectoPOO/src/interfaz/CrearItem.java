package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.Controladora;
import logica.Tipo;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.List;

public class CrearItem extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nuevoItemNombre;
	private JTable tiposTabla;
	private JTextField nuevoItemDescripcion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearItem dialog = new CrearItem();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
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

	/**
	 * Create the dialog.
	 */
	public CrearItem() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		nuevoItemNombre = new JTextField();
		nuevoItemNombre.setBounds(94, 10, 96, 18);
		contentPanel.add(nuevoItemNombre);
		nuevoItemNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(23, 13, 61, 12);
		contentPanel.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(94, 59, 311, 163);
		contentPanel.add(scrollPane);
		
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
		tiposTabla.getColumnModel().getColumn(1).setPreferredWidth(109);
		scrollPane.setViewportView(tiposTabla);
		
		JLabel lblNewLabel_1 = new JLabel("Elije un tipo:");
		lblNewLabel_1.setBounds(23, 59, 74, 12);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Descripcion:");
		lblNewLabel_2.setBounds(23, 35, 96, 12);
		contentPanel.add(lblNewLabel_2);
		
		nuevoItemDescripcion = new JTextField();
		nuevoItemDescripcion.setBounds(94, 31, 311, 18);
		contentPanel.add(nuevoItemDescripcion);
		nuevoItemDescripcion.setColumns(10);
		{
			showearTipos();
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Controladora control = Controladora.getInstance();
						int filer = tiposTabla.getSelectedRow();
						try {
							control.crearItem(nuevoItemNombre.getText(), filer, nuevoItemDescripcion.getText());
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
