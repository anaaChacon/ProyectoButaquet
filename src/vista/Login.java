package vista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import controlador.MainActivity;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame implements  ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField usuarioInt;
	public static JPasswordField passwordField;
	@SuppressWarnings("unused")
	private String[] args;
	Border emptyBorder = BorderFactory.createEmptyBorder();

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		super("BUTAQUET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./src/images/ticket.png"));
		lblNewLabel.setBounds(445, 55, 380, 192);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("INTRODUZCA SUS CREDENCIALES DE USUARIO\r\n");
		lblNewLabel_1.setBackground(Color.DARK_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Bebas Neue", Font.PLAIN, 38));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(10, 253, 1244, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUsuario = new JLabel("USUARIO");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Bebas Neue", Font.PLAIN, 40));
		lblUsuario.setBounds(453, 307, 146, 41);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("CONTRASE\u00D1A");
		lblContrasea.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Bebas Neue", Font.PLAIN, 40));
		lblContrasea.setBounds(370, 359, 227, 41);
		contentPane.add(lblContrasea);
		
		usuarioInt = new JTextField();
		usuarioInt.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		usuarioInt.setBounds(609, 307, 198, 40);
		contentPane.add(usuarioInt);
		usuarioInt.setColumns(10);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBorder(emptyBorder);
		//Este metodo sirve para quitarle el cuadrado
		btnEntrar.setFocusable(false);
		btnEntrar.addActionListener(this);
		
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBackground(new Color(0, 102, 255));
		btnEntrar.setFont(new Font("Bebas Neue", Font.PLAIN, 40));
		btnEntrar.setBounds(547, 421, 183, 43);
		contentPane.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		passwordField.setBounds(609, 358, 198, 41);
		contentPane.add(passwordField);
		
		ImageIcon logoV = new ImageIcon("./src/images/icotiket.png");
		Image logo = logoV.getImage();
		
		setIconImage(logo);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) { 
		// TODO Auto-generated method stub
		MainActivity m = new MainActivity();
		
		if(m.Logeo2() == true){
			
			SeleccionPrincipal f = new SeleccionPrincipal();
			
			f.setVisible(true);
			
			setVisible(false);
			
			
		}else{
			
			setVisible(true);
		}
		
	
	}
}
