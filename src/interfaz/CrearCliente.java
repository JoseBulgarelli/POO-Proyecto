package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Controladora;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrearCliente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField nuevoClienteName;
	private JTextField nuevoClienteTelefono;
	private JTextField nuevoClienteEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CrearCliente dialog = new CrearCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CrearCliente() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Nombre: ");
			lblNewLabel.setBounds(25, 26, 61, 12);
			contentPanel.add(lblNewLabel);
		}
		{
			nuevoClienteName = new JTextField();
			nuevoClienteName.setBounds(102, 23, 96, 18);
			contentPanel.add(nuevoClienteName);
			nuevoClienteName.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Telefono: ");
			lblNewLabel_1.setBounds(25, 66, 61, 12);
			contentPanel.add(lblNewLabel_1);
		}
		{
			nuevoClienteTelefono = new JTextField();
			nuevoClienteTelefono.setBounds(102, 63, 154, 18);
			contentPanel.add(nuevoClienteTelefono);
			nuevoClienteTelefono.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Email: ");
			lblNewLabel_2.setBounds(25, 105, 61, 12);
			contentPanel.add(lblNewLabel_2);
		}
		{
			nuevoClienteEmail = new JTextField();
			nuevoClienteEmail.setBounds(102, 102, 154, 18);
			contentPanel.add(nuevoClienteEmail);
			nuevoClienteEmail.setColumns(10);
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
						control.crearCliente(nuevoClienteName.getText(), nuevoClienteTelefono.getText(), nuevoClienteEmail.getText());
						dispose();
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
