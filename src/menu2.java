import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class menu2 extends JFrame {

	private JPanel contentPane;
	private JTextField Usuario;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu2 frame = new menu2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public menu2() {
		setTitle("Minijuego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Usuario = new JTextField();
		Usuario.setBounds(81, 90, 114, 19);
		contentPane.add(Usuario);
		Usuario.setColumns(10);
		
		JLabel lblIniciaSesin = new JLabel("Inicia Sesión");
		lblIniciaSesin.setBounds(81, 36, 114, 15);
		contentPane.add(lblIniciaSesin);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(81, 75, 70, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(81, 146, 70, 15);
		contentPane.add(lblPassword);
		
		JButton Submit = new JButton("Submit");
		Submit.setBounds(78, 205, 117, 25);
		contentPane.add(Submit);
		
		JButton Registrarse = new JButton("Registrarse");
		Registrarse.setBounds(279, 87, 117, 25);
		contentPane.add(Registrarse);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(279, 205, 117, 25);
		contentPane.add(btnSalir);
		
		password = new JPasswordField();
		password.setBounds(80, 160, 115, 19);
		contentPane.add(password);
	}
}
