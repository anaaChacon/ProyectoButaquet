package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import controlador.Discounts;
import controlador.SecondActivity;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.UIManager;

public class SeleccionDescuento extends JFrame implements ActionListener, ItemListener{

	private JPanel contentPane;
	private JTextField textField;
	private JButton button, btnPasoAtrs, btnSacarCuenta;

	private JComboBox<Integer> comboBox_1, comboBox_2, comboBox;
	private int cantidadSiguiente;
	public static JLabel label_9;
	private int numEntradas;
	private int carnetJove = 0, desempleado = 0, jubilado = 0;
	public static Double variableDescuentos = 0.0, precioConDescuento = 0.0, variablePrecioEntrada, precioConIva = 0.0, importeTotal = 0.0;
	private int descontar;
	private JLabel etiquetaDescuentos, etiquetaDescuentoTotal, etiquetaIva, etiquetaImporteTotal;
	

	Border emptyBorder = BorderFactory.createEmptyBorder();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionDescuento frame = new SeleccionDescuento();
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
	public SeleccionDescuento() {
		super("BUTAQUET");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		/*JLabel label_9 = new JLabel("Arag\u00F3 Cinema");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Bebas Neue", Font.PLAIN, 63));*/
		/*Poner la fecha actual*/
		Date date = new Date();
		//Caso 1: obtenerhora y fecha y salida por pantalla con formato:
		DateFormat hourdateFormat = new SimpleDateFormat("EEEEEEEEE dd/MM/yyyy  HH:mm");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 141, 1274, 550);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		
		JLabel lblDescuentoCarnetJove = new JLabel("DESCUENTO CARNET JOVE\r\n");
		lblDescuentoCarnetJove.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentoCarnetJove.setForeground(Color.WHITE);
		lblDescuentoCarnetJove.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblDescuentoCarnetJove.setBounds(0, 105, 244, 39);
		panel_1.add(lblDescuentoCarnetJove);
		
		JLabel lblDescuentoDesempleado = new JLabel("DESCUENTO DESEMPLEADO\r\n");
		lblDescuentoDesempleado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentoDesempleado.setForeground(Color.WHITE);
		lblDescuentoDesempleado.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblDescuentoDesempleado.setBounds(0, 179, 244, 39);
		panel_1.add(lblDescuentoDesempleado);
		
		JLabel lblDescuentoPensionista = new JLabel("DESCUENTO PENSIONISTA\r\n");
		lblDescuentoPensionista.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentoPensionista.setForeground(Color.WHITE);
		lblDescuentoPensionista.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblDescuentoPensionista.setBounds(0, 255, 244, 39);
		panel_1.add(lblDescuentoPensionista);
		
		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Bebas Neue", Font.PLAIN, 27));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(254, 105, 101, 36);
		
		/****************************************************************/
		//ArrayList<Integer>listaButacasSeleccionadas = new ArrayList<>();
		int numButacas = Integer.parseInt(SeleccionPrincipal.textField.getText().toString());
		for(int i = 0; i < numButacas + 1; i++){
			//listaButacasSeleccionadas.add(i);
			comboBox.addItem(i);
		}
		comboBox.setSelectedItem(null);
		
		/*for(int i = 0; i < listaButacasSeleccionadas.size(); i++){
			comboBox.addItem(listaButacasSeleccionadas.get(i));
		}*/
		/****************************************************************/

		comboBox.setSelectedItem(null);
		

		comboBox.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				 	
					 int numDescSelec = Integer.parseInt(comboBox.getSelectedItem().toString());
					 comboBox_1.removeAllItems();
					 descontar = numButacas - numDescSelec;
					 for(int i = 0; i < descontar + 1; i++){
						 comboBox_1.addItem(i);
					 }
					 comboBox_1.setSelectedItem(null);
					 comboBox_2.removeAllItems();
				 }
			}

		});
		
		panel_1.add(comboBox);
		
		comboBox_1 = new JComboBox<>();
		comboBox_1.setFont(new Font("Bebas Neue", Font.PLAIN, 27));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(254, 179, 101, 36);

		comboBox_1.setSelectedItem(null);
		/*comboBox_1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				if (e.getStateChange() == ItemEvent.SELECTED) {
				
					int cantidadSeleccionada = Integer.parseInt(comboBox_1.getSelectedItem().toString());
					int cantidadSiguiente2 = cantidadSiguiente - cantidadSeleccionada;
					ArrayList<Integer>listaDescuento = new ArrayList<>();
					
					for(int i = 0; i < cantidadSiguiente2+1; i++){
						listaDescuento.add(i);
					}
					
					for(int i = 0; i < listaDescuento.size(); i++){
						comboBox_2.addItem(listaDescuento.get(i));
					}
					
					
				}	
			}		
		});*/

		
		comboBox_1.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){
				 if (e.getStateChange() == ItemEvent.SELECTED) {
				 	comboBox_2.removeAllItems();
					 int numDescSelec = Integer.parseInt(comboBox_1.getSelectedItem().toString());
					 int descontar2 = descontar - numDescSelec;
					 for(int i = 0; i < descontar2 + 1; i++){
						 comboBox_2.addItem(i);
					 }
					 comboBox_2.setSelectedItem(null);
				 }
			}
		});
		

		panel_1.add(comboBox_1);
		
		comboBox_2 = new JComboBox<>();
		comboBox_2.setFont(new Font("Bebas Neue", Font.PLAIN, 27));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(254, 255, 101, 36);
		
		panel_1.add(comboBox_2);
		
		JLabel label_3 = new JLabel("N\u00BA de Butacas Selec.");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		label_3.setBounds(0, 27, 244, 39);
		panel_1.add(label_3);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Bebas Neue", Font.PLAIN, 27));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.WHITE);
		textField.setBounds(254, 30, 48, 36);
		//almacenamos en una variable de tipo entero el numero de butacas/entradas
		numEntradas = Integer.parseInt(SeleccionPrincipal.textField.getText().toString());
		textField.setText(String.valueOf(numEntradas));
		panel_1.add(textField);
		
		button = new JButton("Siguiente Paso\r\n");
		button.setEnabled(false);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Bebas Neue", Font.PLAIN, 46));
		button.setBackground(new Color(0, 102, 255));
		button.setBounds(863, 382, 284, 56);
		button.addActionListener(this);
		button.setBorder(emptyBorder);
		button.setFocusable(false);
		panel_1.add(button);
		
		JLabel lblSubtotal = new JLabel("SUBTOTAL");
		lblSubtotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubtotal.setForeground(Color.BLACK);
		lblSubtotal.setFont(new Font("Bebas Neue", Font.PLAIN, 53));
		lblSubtotal.setBounds(650, 1, 548, 77);
		panel_1.add(lblSubtotal);
		
		btnPasoAtrs = new JButton("Paso Anterior");
		btnPasoAtrs.setForeground(Color.WHITE);
		btnPasoAtrs.setFont(new Font("Bebas Neue", Font.PLAIN, 46));
		btnPasoAtrs.setBackground(new Color(0, 102, 255));
		btnPasoAtrs.setBounds(194, 382, 284, 56);
		btnPasoAtrs.addActionListener(this);
		btnPasoAtrs.setBorder(emptyBorder);
		btnPasoAtrs.setFocusable(false);
		panel_1.add(btnPasoAtrs);
		
		JLabel lblPrecioEntradas = new JLabel("PRECIO ENTRADAS");
		lblPrecioEntradas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioEntradas.setForeground(Color.WHITE);
		lblPrecioEntradas.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblPrecioEntradas.setBounds(673, 75, 244, 39);
		panel_1.add(lblPrecioEntradas);
		
		JLabel lblDescuentos = new JLabel("DESCUENTOS");
		lblDescuentos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescuentos.setForeground(Color.WHITE);
		lblDescuentos.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblDescuentos.setBounds(673, 112, 244, 39);
		panel_1.add(lblDescuentos);
		
		JLabel lblPrecioConDescuento = new JLabel("PRECIO CON DESCUENTO");
		lblPrecioConDescuento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPrecioConDescuento.setForeground(Color.WHITE);
		lblPrecioConDescuento.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblPrecioConDescuento.setBounds(673, 149, 244, 39);
		panel_1.add(lblPrecioConDescuento);
		
		JLabel lblIva = new JLabel("IVA 21%");
		lblIva.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIva.setForeground(Color.WHITE);
		lblIva.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		lblIva.setBounds(673, 215, 244, 39);
		panel_1.add(lblIva);
		
		//Almacenamos en una variable de tipo Double el valor double que nos devuelve el método
		variablePrecioEntrada =  Discounts.precioEntradas(numEntradas);
		
		JLabel label_1 = new JLabel((double)Math.round(variablePrecioEntrada*100)/100 + "\u20AC\r\n");
		label_1.setBackground(new Color(211, 211, 211));
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(SystemColor.controlHighlight);
		label_1.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		label_1.setBounds(927, 75, 244, 39);
		panel_1.add(label_1);
		
		/*DESCUENTOS*/
		etiquetaDescuentos = new JLabel((double)Math.round(variableDescuentos*100)/100 + "\u20AC\r\n");
		
		etiquetaDescuentos.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaDescuentos.setForeground(SystemColor.controlHighlight);
		etiquetaDescuentos.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		etiquetaDescuentos.setBounds(927, 112, 244, 39);
		panel_1.add(etiquetaDescuentos);
		
		/*APLICAR EL DESCUENTO A LAS ENTRADAS*/
		
		etiquetaDescuentoTotal = new JLabel((double)Math.round(precioConDescuento*100)/100 + "\u20AC");
		etiquetaDescuentoTotal.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaDescuentoTotal.setForeground(SystemColor.controlHighlight);
		etiquetaDescuentoTotal.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		etiquetaDescuentoTotal.setBounds(927, 149, 244, 39);
		panel_1.add(etiquetaDescuentoTotal);
		
		/*Sacar el 21% del iva del importe con descuento*/
		//precioConIva = (precioConDescuento * 21) / 100;
		
		etiquetaIva = new JLabel((double)Math.round(precioConIva*100)/100 + "\u20AC");
		etiquetaIva.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaIva.setForeground(SystemColor.controlHighlight);
		etiquetaIva.setFont(new Font("Bebas Neue", Font.PLAIN, 30));
		etiquetaIva.setBounds(927, 215, 244, 39);
		panel_1.add(etiquetaIva);
		
		JLabel lblTotalAPagar = new JLabel("Total a pagar\r\n");
		lblTotalAPagar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalAPagar.setForeground(Color.WHITE);
		lblTotalAPagar.setFont(new Font("Bebas Neue", Font.PLAIN, 48));
		lblTotalAPagar.setBounds(673, 286, 244, 39);
		panel_1.add(lblTotalAPagar);
		
		/*SACAR EL IMPORTE TOTAL*/
		//importeTotal = precioConDescuento + precioConIva;
				
		etiquetaImporteTotal = new JLabel((double)Math.round(importeTotal*100)/100 + "\u20AC");
		etiquetaImporteTotal.setBackground(UIManager.getColor("Button.light"));
		etiquetaImporteTotal.setHorizontalAlignment(SwingConstants.LEFT);
		etiquetaImporteTotal.setForeground(SystemColor.controlHighlight);
		etiquetaImporteTotal.setFont(new Font("Bebas Neue", Font.PLAIN, 48));
		etiquetaImporteTotal.setBounds(927, 286, 244, 39);
		panel_1.add(etiquetaImporteTotal);
		
		btnSacarCuenta = new JButton("SACAR CUENTA");
		btnSacarCuenta.setForeground(Color.WHITE);
		btnSacarCuenta.setFont(new Font("Bebas Neue", Font.PLAIN, 46));
		btnSacarCuenta.setFocusable(false);
		btnSacarCuenta.setBorder(emptyBorder);
		btnSacarCuenta.setBackground(new Color(0, 102, 255));
		btnSacarCuenta.setBounds(528, 382, 284, 56);
		btnSacarCuenta.addActionListener(this);
		panel_1.add(btnSacarCuenta);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1274, 140);
		contentPane.add(panel_2);
		panel_2.setPreferredSize(new Dimension(1280, 140));
		panel_2.setBackground(Color.DARK_GRAY);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("./src/images/ticketpeque.png"));
		
		label_9 = new JLabel(SecondActivity.nombreCine(Integer.parseInt(Login.usuarioInt.getText().toString())));
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Bebas Neue", Font.PLAIN, 63));
		
		        JLabel label_10 = new JLabel(hourdateFormat.format(date).toString());
		        
		//JLabel label_10 = new JLabel("LUNES 16/01/2017 15:30");
		label_10.setForeground(Color.LIGHT_GRAY);
		label_10.setFont(new Font("Bebas Neue", Font.PLAIN, 25));
		
		JLabel label_11 = new JLabel("USUARIO: " + Login.usuarioInt.getText().toString());
		label_11.setForeground(Color.LIGHT_GRAY);
		label_11.setFont(new Font("Bebas Neue", Font.PLAIN, 24));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(41)
					.addComponent(label_8)
					.addGap(18)
					.addComponent(label_9)
					.addPreferredGap(ComponentPlacement.RELATED, 719, Short.MAX_VALUE)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(label_11)
						.addComponent(label_10))
					.addGap(23))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(119, Short.MAX_VALUE)
					.addComponent(label_8)
					.addGap(21))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(36)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(label_9)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(2)
							.addComponent(label_11)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_10, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(40, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		setLocationRelativeTo(null);
		setResizable(false);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button){
			SeleccionPago f = new SeleccionPago();
			
			f.setVisible(true);
			setVisible(false);
			
		}
		
		if(e.getSource() == btnPasoAtrs){
			
			carnetJove = 0;
			desempleado = 0;
			jubilado = 0;
			variableDescuentos = 0.0;
			precioConDescuento = 0.0;
			precioConIva = 0.0;
			importeTotal = 0.0;
			
			SeleccionPrincipal f = new SeleccionPrincipal();	
			f.setVisible(true);
			setVisible(false);
		}
		
		if(e.getSource() == btnSacarCuenta){
			
			carnetJove = Integer.parseInt(comboBox.getSelectedItem().toString());
			desempleado = Integer.parseInt(comboBox_1.getSelectedItem().toString());
			jubilado = Integer.parseInt(comboBox_2.getSelectedItem().toString());
	
			variableDescuentos = Discounts.descuentos(carnetJove, desempleado, jubilado);
			etiquetaDescuentos.setText(variableDescuentos + "\u20AC\r\n");
			
			precioConDescuento = variablePrecioEntrada - variableDescuentos;
			etiquetaDescuentoTotal.setText(precioConDescuento + "\u20AC");
			/*Sacar el 21% del iva del importe con descuento*/
			precioConIva = (precioConDescuento * 21) / 100;
			etiquetaIva.setText(precioConIva + "\u20AC");
			
			/*SACAR EL IMPORTE TOTAL*/
			importeTotal = precioConDescuento + precioConIva;
			etiquetaImporteTotal.setText(importeTotal + "\u20AC");
		
			btnSacarCuenta.setEnabled(false);
			button.setEnabled(true);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
}


	

