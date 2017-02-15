package vista;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import models.Cines;
import models.Empleados;
import models.SessionFactoryUtil;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;

public class GestionUsuarios extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblApellidos;
	private JTextField textField_2;
	private JLabel lblTelefono;
	private JTextField textField_3;
	private JLabel lblDni;
	private JTextField textField_4;
	private JLabel lblDireccin;
	private JLabel lblIdArag;
	private JLabel lblIdCine;
	private JLabel lblIdKinepolis;
	private JLabel lblIdAbc;
	private JLabel lblIdOcine;
	private JLabel lblIdCine_1;
	private JTextField textField_5;
	private JLabel lblNewLabel;
	private String nombre, apellidos, dni, direccion;
	private Cines idCine;
	private int telefono, id_cine;
	private int random;
	private JButton btnNewButton;
	private JButton btnVolverALogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionUsuarios frame = new GestionUsuarios();
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
	public GestionUsuarios() {
		setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("NOMBRE\r\n");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblNombre.setBounds(304, 108, 134, 49);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setFont(new Font("Bebas Neue", Font.PLAIN, 24));
		textField.setBounds(382, 114, 192, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		textField_1.setColumns(10);
		textField_1.setBounds(382, 174, 192, 33);
		contentPane.add(textField_1);
		
		
		lblApellidos = new JLabel("APELLIDOS");
		lblApellidos.setForeground(Color.WHITE);
		lblApellidos.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblApellidos.setBounds(288, 168, 134, 49);
		contentPane.add(lblApellidos);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		textField_2.setColumns(10);
		textField_2.setBounds(382, 234, 192, 33);
		contentPane.add(textField_2);
		
		
		lblTelefono = new JLabel("TEL\u00C9FONO");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblTelefono.setBounds(238, 228, 134, 49);
		contentPane.add(lblTelefono);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		textField_3.setColumns(10);
		textField_3.setBounds(382, 294, 192, 33);
		contentPane.add(textField_3);
		
		lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblDni.setBounds(238, 288, 134, 49);
		contentPane.add(lblDni);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		textField_4.setColumns(10);
		textField_4.setBounds(382, 351, 192, 33);
		contentPane.add(textField_4);

		
		lblDireccin = new JLabel("DIRECCI\u00D3N");
		lblDireccin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccin.setForeground(Color.WHITE);
		lblDireccin.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblDireccin.setBounds(238, 345, 134, 49);
		contentPane.add(lblDireccin);
		
		btnNewButton = new JButton("INSERTAR DATOS");
		btnNewButton.setFont(new Font("Bebas Neue", Font.PLAIN, 38));
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.setBackground(new Color(0, 102, 204));
		btnNewButton.setBounds(500, 498, 291, 49);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		lblIdArag = new JLabel("ID 1: ARAG\u00D3 CINEMA\r\n");
		lblIdArag.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdArag.setForeground(Color.WHITE);
		lblIdArag.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblIdArag.setBounds(696, 130, 218, 49);
		contentPane.add(lblIdArag);
		
		lblIdCine = new JLabel("ID 2: CINE LYS");
		lblIdCine.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdCine.setForeground(Color.WHITE);
		lblIdCine.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblIdCine.setBounds(696, 183, 218, 49);
		contentPane.add(lblIdCine);
		
		lblIdKinepolis = new JLabel("ID 3: KINEPOLIS VAL\u00C8NCIA");
		lblIdKinepolis.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdKinepolis.setForeground(Color.WHITE);
		lblIdKinepolis.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblIdKinepolis.setBounds(696, 234, 218, 49);
		contentPane.add(lblIdKinepolis);
		
		lblIdAbc = new JLabel("ID 4: ABC EL SALER");
		lblIdAbc.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdAbc.setForeground(Color.WHITE);
		lblIdAbc.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblIdAbc.setBounds(696, 281, 218, 49);
		contentPane.add(lblIdAbc);
		
		lblIdOcine = new JLabel("ID 5: OCINE AQUA");
		lblIdOcine.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdOcine.setForeground(Color.WHITE);
		lblIdOcine.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblIdOcine.setBounds(696, 327, 218, 49);
		contentPane.add(lblIdOcine);
		
		lblIdCine_1 = new JLabel("ID CINE\r\n");
		lblIdCine_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdCine_1.setForeground(Color.WHITE);
		lblIdCine_1.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		lblIdCine_1.setBounds(238, 405, 134, 49);
		contentPane.add(lblIdCine_1);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		textField_5.setColumns(10);
		textField_5.setBounds(382, 411, 192, 33);
		contentPane.add(textField_5);

		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dam2\\workspace\\ButaquetProyecto\\src\\images\\ticketpeque.png"));
		lblNewLabel.setBounds(37, 556, 238, 102);
		contentPane.add(lblNewLabel);
		
		btnVolverALogin = new JButton("VOLVER A LOGIN");
		btnVolverALogin.setForeground(Color.WHITE);
		btnVolverALogin.setFont(new Font("Bebas Neue", Font.PLAIN, 31));
		btnVolverALogin.setBackground(new Color(0, 102, 204));
		btnVolverALogin.setBounds(1012, 609, 218, 49);
		btnVolverALogin.addActionListener(this);
		contentPane.add(btnVolverALogin);
		
	/*	if(!textField.getText().toString().isEmpty()&&!textField_1.getText().toString().isEmpty()&&!textField_2.getText().toString().isEmpty()&&!textField_3.getText().toString().isEmpty()&&!textField_4.getText().toString().isEmpty()&&!textField_5.getText().toString().isEmpty()){
			btnNewButton.setEnabled(true);
		}*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btnNewButton){
			
			btnNewButton.setEnabled(false);
		
		//InsertarDatos.nuevoEmpleado(nombre, apellidos, telefono, dni,  direccion, idCine);
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		session.beginTransaction();
		
		nombre = textField.getText().toString();
		apellidos = textField_1.getText().toString();
		dni = textField_3.getText().toString();
		direccion = textField_4.getText().toString();
		id_cine = Integer.parseInt(textField_5.getText().toString());
		telefono = Integer.parseInt(textField_2.getText().toString());

		Empleados nuevoEmp=new Empleados();
		
		random = (int)Math.floor(Math.random()*(600000-500000+1)+500000); 
		
		nuevoEmp.setNombre(nombre);
		nuevoEmp.setApellidos(apellidos);
		nuevoEmp.setTelefono(telefono);
		nuevoEmp.setDni(dni);
		nuevoEmp.setDireccionEmpleado(direccion);
		nuevoEmp.setAccesoUsuario(random);
		nuevoEmp.setAccesoContrasenya(11111111);
		
		Cines cine = new Cines();
		cine.setIdCine(id_cine);
		
		
		JOptionPane.showMessageDialog(null, "Usuario: "+random+"\nContraseña: 11111111", "Usuario Creado", JOptionPane.WARNING_MESSAGE);
	
		nuevoEmp.setCines(cine);
				
		session.persist(nuevoEmp);
	
		//Realize to transaction
		session.getTransaction().commit();
		//Close the sesion
		session.close();
		}
		
		if(e.getSource()==btnVolverALogin){
			setVisible(false);
			Login l=new Login();
			l.setVisible(true);
		}
	}
}
