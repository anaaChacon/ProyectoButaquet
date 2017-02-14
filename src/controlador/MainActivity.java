package controlador;


import models.SessionFactoryUtil;
import vista.Login;
import vista.SeleccionPrincipal;

import java.util.Iterator;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MainActivity {
	
	
	public static boolean Logeo2() {
		// TODO Auto-generated method stub
		//Instance of class SessionFactory
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		session.beginTransaction();
		
		boolean correcto = false;
		
		//Obtenemos la contraseña y el usuario y almacenarlos en una variable
		char[]arrayC = Login.passwordField.getPassword();
		String contra = new String(arrayC);
		
		String usuario = Login.usuarioInt.getText().toString();
		//Comprobar que los campos no estan vacíos
		if(Login.usuarioInt.getText().toString().isEmpty() || contra.isEmpty()){
			
			JOptionPane.showMessageDialog(null, "Los campos no pueden estar vacíos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
			correcto = false;
		}
		
			
			if(!Login.usuarioInt.getText().toString().isEmpty() && !contra.isEmpty()){
			
			
			Iterator<?> iter = session.createQuery("from Empleados where acceso_usuario = '"+usuario+"' "
					+ "and acceso_contrasenya = '"+contra+"'").iterate();
			
			if(iter.hasNext()){
				
				correcto = true;
				
			}else{
				JOptionPane.showMessageDialog(null, "Los datos no son correctos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				correcto = false;
			}
			
			
			//Realize to transaction
			session.getTransaction().commit();
			//Close the sesion
			session.close();
			
		}
		return correcto;
	
	}

	

}
