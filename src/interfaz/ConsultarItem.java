package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controladora;
import logica.Item;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarItem extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultarItem dialog = new ConsultarItem(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarItem(int filer) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 426, 228);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Controladora control = Controladora.getInstance();
		Item itemEC = control.getItems().get(filer);
		
		JLabel itemName = new JLabel("Nombre: " + itemEC.getNombre());
		itemName.setBounds(10, 10, 392, 20);
		contentPanel.add(itemName);
		
		JLabel itemDesc = new JLabel("Descripcion:" + itemEC.getDescripcion());
		itemDesc.setBounds(10, 44, 392, 20);
		contentPanel.add(itemDesc);
		
		JLabel itemCodigo = new JLabel("Codigo: " + itemEC.getCodigo());
		itemCodigo.setBounds(10, 85, 392, 25);
		contentPanel.add(itemCodigo);
		
		String prestamo;
		if (itemEC.getPrestamo() == null) {
			prestamo = "Este item no esta en prestamo";
		} else {
			prestamo = itemEC.getPrestamo().getClientePrestamo().getNombre();
		}
		JLabel itemPrestamo = new JLabel("Prestameado a: " + prestamo);
		itemPrestamo.setBounds(10, 120, 392, 20);
		contentPanel.add(itemPrestamo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Salir");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
}
