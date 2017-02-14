package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.SecondActivity;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FinOperacion extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JButton btnNuevaOperacin, btnCerrarSesin;
	Border emptyBorder = BorderFactory.createEmptyBorder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinOperacion frame = new FinOperacion();
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
	public FinOperacion() {
		super("BUTAQUET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(1280, 140));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 1274, 140);
		contentPane.add(panel_1);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("./src/images/ticketpeque.png"));
		
		String nombreCine = SecondActivity.nombreCine(Integer.parseInt(Login.usuarioInt.getText().toString()));
		JLabel label_9 = new JLabel(nombreCine);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Bebas Neue", Font.PLAIN, 63));
		
		JLabel label_10 = new JLabel("USUARIO: " + Login.usuarioInt.getText().toString());
		label_10.setForeground(Color.LIGHT_GRAY);
		label_10.setFont(new Font("Bebas Neue", Font.PLAIN, 24));
		
		/*Poner la fecha actual*/
		Date date = new Date();
		//Caso 1: obtenerhora y fecha y salida por pantalla con formato:
		DateFormat hourdateFormat = new SimpleDateFormat("EEEEEEEEE dd/MM/yyyy  HH:mm");
        JLabel label_11 = new JLabel(hourdateFormat.format(date).toString());
		
		label_11.setForeground(Color.LIGHT_GRAY);
		label_11.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1259, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(41)
					.addComponent(label_8)
					.addGap(18)
					.addComponent(label_9)
					.addPreferredGap(ComponentPlacement.RELATED, 732, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_10)
							.addGap(82))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(label_11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 140, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(119, Short.MAX_VALUE)
					.addComponent(label_8)
					.addGap(21))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(2)
							.addComponent(label_10)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_11, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(label_9))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 140, 1274, 551);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel realizado = new JLabel("OPERACI\u00D3N REALIZADA CORRECTAMENTE");
		realizado.setBounds(10, 170, 1254, 64);
		realizado.setHorizontalAlignment(SwingConstants.CENTER);
		realizado.setForeground(Color.WHITE);
		realizado.setFont(new Font("Bebas Neue", Font.PLAIN, 70));
		realizado.setBorder(emptyBorder);
		realizado.setFocusable(false);
		
		panel.add(realizado);
		
		btnNuevaOperacin = new JButton("NUEVA OPERACI\u00D3N");
		btnNuevaOperacin.setForeground(Color.WHITE);
		btnNuevaOperacin.setFont(new Font("Bebas Neue", Font.PLAIN, 46));
		btnNuevaOperacin.setFocusable(false);
		btnNuevaOperacin.setBorder(emptyBorder);
		btnNuevaOperacin.setBackground(new Color(0, 102, 255));
		btnNuevaOperacin.setBounds(327, 313, 284, 74);
		btnNuevaOperacin.addActionListener(this);
		panel.add(btnNuevaOperacin);
		
		btnCerrarSesin = new JButton("CERRAR SESI\u00D3N");
		btnCerrarSesin.setForeground(Color.WHITE);
		btnCerrarSesin.setFont(new Font("Bebas Neue", Font.PLAIN, 46));
		btnCerrarSesin.setFocusable(false);
		btnCerrarSesin.setBorder(emptyBorder);
		btnCerrarSesin.setBackground(new Color(0, 102, 255));
		btnCerrarSesin.setBounds(660, 313, 284, 74);
		btnCerrarSesin.addActionListener(this);
		panel.add(btnCerrarSesin);
		
		setLocationRelativeTo(null);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnNuevaOperacin){
			
			SeleccionDescuento.variableDescuentos = 0.0;
			SeleccionDescuento.precioConDescuento = 0.0;
			SeleccionDescuento.precioConIva = 0.0;
			SeleccionDescuento.importeTotal = 0.0;
			setVisible(false);
			SeleccionPrincipal f = new SeleccionPrincipal();
			f.setVisible(true);
		}
		
		if(e.getSource() == btnCerrarSesin){
			System.exit(0);
		}
		
	}
}
