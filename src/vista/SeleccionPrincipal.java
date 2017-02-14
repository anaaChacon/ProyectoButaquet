package vista;


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import controlador.SecondActivity;
import models.SessionFactoryUtil;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import java.awt.GridLayout;


public class SeleccionPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField textField;
	private JComboBox<String> comboBox_2, comboBox, comboBox_1;
	private JButton btnSiguientePaso, btnNewButton, btnNuevo, butaca, butaca2, butacaOcupada;
	@SuppressWarnings("unused")
	private ArrayList<Integer>filasColumnas;
	@SuppressWarnings("unused")
	private int filas, columnas;
	private JScrollPane pintarButacas;
	private JPanel panel;
	@SuppressWarnings("unused")
	private JButton [][] asientos;
	private ArrayList<JButton>asientosOcupados;
	private int fila, columna;
	private JPanel misButacas;
	private boolean ocupado = false;
	private static String nombreCine;
	
	
	private int posicion, contador;
	Border emptyBorder = BorderFactory.createEmptyBorder();

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionPrincipal frame = new SeleccionPrincipal();
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
	public SeleccionPrincipal() {
		super("BUTAQUET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel datosCine = new JPanel();
		datosCine.setBounds(0, 0, 1273, 140);
		datosCine.setBackground(Color.DARK_GRAY);
		datosCine.setPreferredSize(new Dimension(1280,140));
		
		nombreCine = SecondActivity.nombreCine(Integer.parseInt(Login.usuarioInt.getText().toString()));
		JLabel lblAragCinema = new JLabel(nombreCine);
		
		
		
		lblAragCinema.setForeground(Color.WHITE);
		lblAragCinema.setFont(new Font("Bebas Neue", Font.PLAIN, 63));	
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("./src/images/ticketpeque.png"));
		
		
		JLabel lblUsuario = new JLabel("USUARIO: " + Login.usuarioInt.getText().toString());
		lblUsuario.setForeground(Color.LIGHT_GRAY);
		lblUsuario.setFont(new Font("Bebas Neue", Font.PLAIN, 24));
		/*Poner la fecha actual*/
		Date date = new Date();
		//Caso 1: obtenerhora y fecha y salida por pantalla con formato:
		DateFormat hourdateFormat = new SimpleDateFormat("EEEEEEEEE dd/MM/yyyy  HH:mm");
        JLabel lblLunes = new JLabel(hourdateFormat.format(date).toString());
                
        
		lblLunes.setForeground(Color.LIGHT_GRAY);
		lblLunes.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		GroupLayout gl_datosCine = new GroupLayout(datosCine);
		gl_datosCine.setHorizontalGroup(
			gl_datosCine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_datosCine.createSequentialGroup()
					.addGap(41)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblAragCinema)
					.addPreferredGap(ComponentPlacement.RELATED, 747, Short.MAX_VALUE)
					.addGroup(gl_datosCine.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsuario)
						.addComponent(lblLunes, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE))
					.addGap(18))
		);
		gl_datosCine.setVerticalGroup(
			gl_datosCine.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_datosCine.createSequentialGroup()
					.addContainerGap(119, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(21))
				.addGroup(gl_datosCine.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_datosCine.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_datosCine.createSequentialGroup()
							.addGap(2)
							.addComponent(lblUsuario)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblLunes, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblAragCinema))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		datosCine.setLayout(gl_datosCine);
		
		panel = new JPanel();
		panel.setBounds(0, 139, 1273, 553);
		panel.setBackground(Color.GRAY);
		panel.setLayout(null);
		
		JLabel lblSeleccionePelcula = new JLabel("SELECCIONE PEL\u00CDCULA");
		lblSeleccionePelcula.setForeground(Color.WHITE);
		lblSeleccionePelcula.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblSeleccionePelcula.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeleccionePelcula.setBounds(0, 31, 244, 39);
		panel.add(lblSeleccionePelcula);
		
		JLabel lblSeleccioneSesin = new JLabel("SELECCIONE SESI\u00D3N\r\n");
		lblSeleccioneSesin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeleccioneSesin.setForeground(Color.WHITE);
		lblSeleccioneSesin.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblSeleccioneSesin.setBounds(0, 81, 244, 39);
		panel.add(lblSeleccioneSesin);
		
		JLabel lblSeleccioneSala = new JLabel("SELECCIONE SALA\r\n");
		lblSeleccioneSala.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSeleccioneSala.setForeground(Color.WHITE);
		lblSeleccioneSala.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblSeleccioneSala.setBounds(0, 131, 244, 39);
		panel.add(lblSeleccioneSala);
		
		comboBox = new JComboBox<String>();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Bebas Neue", Font.PLAIN, 27));
		comboBox.setBounds(254, 31, 244, 36);
		ArrayList<String>listado = new ArrayList<>();
		listado.addAll(nombrePelicula());
		
		for(int i = 0; i < listado.size(); i++){
			comboBox.addItem(listado.get(i));
		}
		comboBox.setSelectedItem(null);
		
		comboBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				 
					 ArrayList<String>listadoSesion = new ArrayList<>();
					 String nombrePelicula = (String) comboBox.getSelectedItem();
					 listadoSesion.addAll(SecondActivity.fecha(nombrePelicula));
				
					 comboBox_1.removeAllItems();
					 
						for(int i = 0; i < listadoSesion.size(); i++){
							comboBox_1.addItem(listadoSesion.get(i));
						}
						
						int itemCount = comboBox_1.getItemCount();
						int itemCount2 = comboBox_2.getItemCount();

						   if(itemCount > 1){
							   comboBox_1.setEnabled(true);
							   comboBox_1.setSelectedItem(null);
							   comboBox_2.setEnabled(false);
							   comboBox_2.setSelectedItem(null);
						   }
						   else if(itemCount == 0){
							   comboBox_2.removeAllItems();
							   comboBox_1.setEnabled(false);
							   comboBox_2.setEnabled(false);
						   }
						   else{
							   comboBox_1.setEnabled(false);
							   
							   if(itemCount2 > 1){
								   comboBox_2.setEnabled(true);
								   comboBox_2.setSelectedItem(null);
 
							   }else{
								   comboBox_2.setSelectedItem(0);
								   comboBox_2.setEnabled(false);
									
							   }
							  
						   }	
			 }	   
			}
		});   
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setEnabled(false);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("Bebas Neue", Font.PLAIN, 27));
		comboBox_1.setBounds(254, 81, 244, 36);
		
		comboBox_1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if (e.getStateChange() == ItemEvent.SELECTED) {
					 
					 ArrayList<String>listadoSalas = new ArrayList<>();
					 
					  String nombrePelicula = (String) comboBox.getSelectedItem();
					  
					  String sesion = (String) comboBox_1.getSelectedItem();
					  StringTokenizer tk = new StringTokenizer(sesion, " ");
					  String fecha = null, hora = null;
					  while(tk.hasMoreTokens()){
						  fecha = tk.nextToken();
						  hora = tk.nextToken();
					  }
					  
						listadoSalas.addAll(SecondActivity.numSala(nombrePelicula, fecha, hora));
						
						 comboBox_2.removeAllItems();
						 
							for(int i = 0; i < listadoSalas.size(); i++){
								  
								   comboBox_2.addItem(listadoSalas.get(i));
		 
							}
							
							 int itemCount = comboBox_2.getItemCount();

							   if(itemCount > 1){
								   comboBox_2.setEnabled(true);
								   comboBox_2.setSelectedItem(null);
 
							   }else{
								   comboBox_2.setSelectedItem(0);
								   comboBox_2.setEnabled(false);
									
							   }
							   
								//comboBox_2.getItemAt(1);	
				}
				 }	   
			});
		panel.add(comboBox_1);
		
		comboBox_2 = new JComboBox<String>();
		comboBox_2.setEnabled(false);
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setFont(new Font("Bebas Neue", Font.PLAIN, 27));
		comboBox_2.setBounds(254, 131, 244, 36);
		
		comboBox_2.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String cadena = null, numSala = null;
					StringTokenizer tk = new StringTokenizer((String) comboBox_2.getSelectedItem(), " ");
					while(tk.hasMoreTokens()){
						cadena = tk.nextToken();
						numSala = tk.nextToken();
					}
					System.out.print(cadena + " - " + numSala);
					int salita = Integer.parseInt(numSala);
					
					ArrayList<Integer> listaSala = new ArrayList<>();
					listaSala.addAll(SecondActivity.dimensionSala(salita, nombreCine));
					System.out.println(listaSala);
					
					
				
					fila = listaSala.get(0);
					columna = listaSala.get(1);
					System.out.println("Fila: " +fila + "\nColumna: " + columna);
					}
					 
				 } 
			
		});
		panel.add(comboBox_2);
		
		
		
		JLabel lblNDeButacas = new JLabel("N\u00BA de Butacas Selec.");
		lblNDeButacas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNDeButacas.setForeground(Color.WHITE);
		lblNDeButacas.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblNDeButacas.setBounds(0, 255, 244, 39);
		panel.add(lblNDeButacas);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Bebas Neue", Font.PLAIN, 27));
		textField.setBackground(Color.WHITE);
		textField.setBounds(254, 258, 51, 36);
		panel.add(textField);
		textField.setColumns(10);
		
		btnSiguientePaso = new JButton("Siguiente Paso\r\n");
		btnSiguientePaso.setForeground(Color.WHITE);
		btnSiguientePaso.setFont(new Font("Bebas Neue", Font.PLAIN, 46));
		btnSiguientePaso.setBackground(new Color(0, 102, 255));
		btnSiguientePaso.setBounds(173, 382, 284, 56);
		btnSiguientePaso.addActionListener(this);
		btnSiguientePaso.setBorder(emptyBorder);
		btnSiguientePaso.setFocusable(false);
		panel.add(btnSiguientePaso);
		
		JLabel lblSeleccioneUbicacin = new JLabel("SELECCIONE UBICACI\u00D3N");
		lblSeleccioneUbicacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneUbicacin.setForeground(Color.WHITE);
		lblSeleccioneUbicacin.setFont(new Font("Bebas Neue", Font.PLAIN, 45));
		lblSeleccioneUbicacin.setBounds(649, -13, 548, 117);
		panel.add(lblSeleccioneUbicacin);
		
		JLabel lblNewLabel_1 = new JLabel("VERDE: LIBRE");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bebas Neue", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(719, 400, 267, 39);
		panel.add(lblNewLabel_1);
		
		JLabel lblAsientoRojoSeleccionado = new JLabel("SELECCIONADO: AMARILLO");
		lblAsientoRojoSeleccionado.setForeground(Color.WHITE);
		lblAsientoRojoSeleccionado.setFont(new Font("Bebas Neue", Font.PLAIN, 19));
		lblAsientoRojoSeleccionado.setBounds(719, 436, 267, 39);
		panel.add(lblAsientoRojoSeleccionado);
		
		JLabel lblAsientoConPersona = new JLabel("ROJO: ASIENTO NO DISPONIBLE");
		lblAsientoConPersona.setForeground(Color.WHITE);
		lblAsientoConPersona.setFont(new Font("Bebas Neue", Font.PLAIN, 19));
		lblAsientoConPersona.setBounds(719, 473, 267, 39);
		panel.add(lblAsientoConPersona);
		
		btnNewButton = new JButton("LISTO");
		btnNewButton.setBackground(new Color(0, 102, 255));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Bebas Neue", Font.PLAIN, 28));
		btnNewButton.setBounds(233, 191, 107, 36);
		btnNewButton.setBorder(emptyBorder);
		btnNewButton.setFocusable(false);
		btnNewButton.addActionListener(this);
		panel.add(btnNewButton);
		
		misButacas = new JPanel();
		misButacas.setBackground(Color.GRAY);
	
		pintarButacas = new JScrollPane();
		pintarButacas.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pintarButacas.setViewportView(misButacas);
		pintarButacas.setBackground(Color.GRAY);
		pintarButacas.setBounds(619, 102, 606, 287);
		
		panel.add(pintarButacas);
		
		btnNuevo = new JButton("NUEVO");
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setFont(new Font("Bebas Neue", Font.PLAIN, 28));
		btnNuevo.setBackground(new Color(0, 102, 255));
		btnNuevo.setBounds(391, 191, 107, 36);
		btnNuevo.setEnabled(false);
		btnNuevo.setBorder(emptyBorder);
		btnNuevo.setFocusable(false);
		btnNuevo.addActionListener(this);
		panel.add(btnNuevo);
		
		
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		contentPane.add(panel);
		contentPane.add(datosCine);
		setResizable(false);
	}
	
	public static ArrayList<String> nombrePelicula(){
		//Instance of class SessionFactory
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		session.beginTransaction();
		
		//Hacer una consulta//MODIFICAR 
		//Iterator<?> iter = session.createQuery("").iterate();
		
		Iterator<?> iter = session.createQuery("select p.nombrePelicula"
				+ " from Peliculas p, Proyeccion pr, Salas s"
				+ " where p.idPelicula = pr.peliculas"
				+ " and pr.salas = s.idSala"
				+ " and s.idSala in (select sa.idSala"
				+ " from Salas sa, Cines c"
				+ " where sa.cines = c.idCine"
				+ " and c.idCine = (select idCine"
				+ " from Cines"
				+ " where nombre = '"+nombreCine+"')) group by p.nombrePelicula").iterate();
		
		
		
		
		ArrayList<String>listaPeliculas = new ArrayList<>();
		
		while(iter.hasNext()){
			//Peliculas pelicula = (Peliculas) iter.next();
			//listaPeliculas.add(pelicula.getNombrePelicula());
			listaPeliculas.add(String.valueOf(iter.next()));
		}
		
		//Realize to transaction
		session.getTransaction().commit();
		//Close the sesion
		session.close();
		
		return listaPeliculas;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource() == btnSiguientePaso){
			
			if(!textField.getText().toString().isEmpty()){
				SeleccionDescuento f = new SeleccionDescuento();
			
				f.setVisible(true);	
				
				setVisible(false);
				
				/*Escribir en un fichero*/
				File cargarFichero = new File("Control_de_salas.txt");
				try {
					FileWriter crearFichero = new FileWriter(cargarFichero, true);
					PrintWriter escribir = new PrintWriter(crearFichero);
					escribir.println(comboBox.getSelectedItem() + ", " + comboBox_1.getSelectedItem() + ", " + comboBox_2.getSelectedItem() + ", " + contador);
					escribir.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
			else{
				setVisible(true);
			}
		}
		if(e.getSource() == btnNewButton){
			
			if(comboBox.getSelectedItem() != null && comboBox_1.getSelectedItem() != null && comboBox_2.getSelectedItem() != null){
				asientos = new JButton[fila][columna];
				
				for(int i = 0; i < asientos.length; i++){
					for(int j = 0; j < asientos[i].length; j++){

						if(ocupado == true){
							//Creamos 5 botones con este icono
							for(int h = 0; h < contador; h++){
								butacaOcupada = new JButton();
								//butacaOcupada = (JButton)e.getSource();
								ImageIcon icono2 = new ImageIcon("./src/images/ocupado.png");
								Image img2 = icono2.getImage();
								Image otraimg2 = img2.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
								ImageIcon icon2 = new ImageIcon(otraimg2);
							
								butacaOcupada.setIcon(icon2);
								butacaOcupada.setBorderPainted(false);
								butacaOcupada.setContentAreaFilled(false);
								butacaOcupada.setFocusable(false);
								butacaOcupada.setRolloverEnabled(true);
								asientosOcupados.add(butacaOcupada);
								
							}
						}
						butaca = new JButton();
						
						ImageIcon icono = new ImageIcon("./src/images/libre.png");
						Image img = icono.getImage();
						Image otraimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
						ImageIcon icon = new ImageIcon(otraimg);
						
						butaca.setIcon(icon);
						butaca.setBorderPainted(false);
						//butaca.setMargin(new Insets(0, 0, 0, 0));
						butaca.setContentAreaFilled(false);
						butaca.setFocusable(false);
						butaca.setRolloverEnabled(true);
						
						butaca.addActionListener(this);
						butaca.setActionCommand(posicion++ +"boton");
						
						asientos[i][j] = butaca;
						misButacas.add(asientos[i][j]);
					}
				}
				misButacas.setLayout(new GridLayout(fila,columna));
				//pintarButacas.revalidate();
				misButacas.revalidate();
				misButacas.repaint();
				btnNewButton.setEnabled(false);
				comboBox.setEnabled(false);
				comboBox_1.setEnabled(false);
				comboBox_2.setEnabled(false);
				btnNuevo.setEnabled(true);
			}
			else{
				System.out.print("No se han seleccionado los combobox. No hay datos");
			}
		}
		//A los botones sobre los que se haga clic cambiaran de icono(selccionado)
		for(int i = 0; i < posicion; i++){
			
			if(e.getActionCommand().equals(i+"boton")){
				contador++;
				butaca2 = new JButton();
				butaca2 = (JButton)e.getSource();
				ImageIcon icono = new ImageIcon("./src/images/seleccionado.png");
				Image img = icono.getImage();
				Image otraimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
				ImageIcon icon = new ImageIcon(otraimg);
				//butaca2.setMargin(new Insets(0, 0, 0, 0));
				butaca2.setIcon(icon);
				butaca2.setBorderPainted(false);
				butaca2.setContentAreaFilled(false);
				butaca2.setFocusable(false);
				butaca2.setRolloverEnabled(true);
				//Hacemos que el botón seleccionado no pueda volver a ser pulsaldo
				butaca2.removeActionListener(this);
				
				textField.setText(String.valueOf(contador));
				//asientosOcupados = new JButton[][];
				ocupado = true;
				
			}
			
		}
		
		if(e.getSource() == btnNuevo){
			for(int i = 0; i < asientos.length; i++){
				for(int j = 0; j < asientos[i].length; j++){
				
				misButacas.remove(asientos[i][j]);
				}
			}
			fila = 0;
			columna = 0;
			contador = 0;
			textField.setText("");
			comboBox.setSelectedItem(null);
			comboBox_1.removeAllItems();
			comboBox_2.removeAllItems();
			comboBox.setEnabled(true);
			misButacas.revalidate();
			misButacas.repaint();
			btnNewButton.setEnabled(true);
			btnNuevo.setEnabled(false);
		
		}
		
		
		
		
	}
}
