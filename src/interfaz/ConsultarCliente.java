package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controladora;
import logica.Cliente;
import logica.Item;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ConsultarCliente dialog = new ConsultarCliente(0);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ConsultarCliente(int filer) {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		Controladora control = Controladora.getInstance();
		Cliente clienteEC = control.getClientes().get(filer);
		
		
		{
			JLabel clienteNombre = new JLabel("Nombre: " + clienteEC.getNombre());
			clienteNombre.setBounds(28, 27, 398, 25);
			contentPanel.add(clienteNombre);
		}
		{
			JLabel clienteEmail = new JLabel("Email: " + clienteEC.getEmail());
			clienteEmail.setBounds(28, 63, 398, 25);
			contentPanel.add(clienteEmail);
		}
		{
			JLabel clienteTelefono = new JLabel("Telefono: " + clienteEC.getTelefono());
			clienteTelefono.setBounds(28, 98, 398, 25);
			contentPanel.add(clienteTelefono);
		}
		{
			JLabel clientePrestamos = new JLabel("Cantidad de prestamos: " + clienteEC.getPrestamos().size());
			clientePrestamos.setBounds(28, 133, 398, 25);
			contentPanel.add(clientePrestamos);
		}
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
