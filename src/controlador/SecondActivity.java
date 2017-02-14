package controlador;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import models.Peliculas;
import models.Proyeccion;
import models.Salas;
import models.SessionFactoryUtil;
import vista.SeleccionDescuento;

public class SecondActivity {
	
	public static String nombreCine(int userId){
		//Instance of class SessionFactory
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		session.beginTransaction();
		
		//Hacer una consulta
		Iterator<?> iter = session.createQuery("select c.nombre from Cines c, Empleados e WHERE e.cines = c.idCine and e.accesoUsuario = '"+userId+"'").iterate();
		
		String nombreCine;
		
		nombreCine=(String) iter.next();
		
		//Realize to transaction
		session.getTransaction().commit();
		//Close the sesion
		session.close();
		
		return nombreCine;
		
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
				+ " where nombre = 'Aragó Cinema')) group by p.nombrePelicula").iterate();
		
		
		
		
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
	
	public static ArrayList<String> numSala(String pelicula, String fecha, String hora){
		//Instance of class SessionFactory
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		session.beginTransaction();
		
		//Hacer una consulta
		Iterator<?> iter = session.createQuery("select s.numSala from Salas s, Proyeccion p, Peliculas pe where p.peliculas = pe.idPelicula"
				+ " and pe.nombrePelicula = '"+pelicula+"'"
				+ " and s.idSala = p.salas"
						+ " and p.fecha = '"+fecha+"'"
								+ " and p.hora = '"+hora+"' GROUP BY s.numSala").iterate();
		
		ArrayList<String>listaSalas = new ArrayList<>();
		
		while(iter.hasNext()){
			//Salas sala = (Salas) iter.next();	
			listaSalas.add("Sala " + iter.next() );//sala.getIdSala()
		}
		//Realize to transaction
		session.getTransaction().commit();
		//Close the sesion
		session.close();		
		return listaSalas;
	}
	
	public static int filaButacas(int numSala){
		//Instance of class SessionFactory
				SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
				Session session = sesion.openSession();
				session.beginTransaction();
				
				int iter = (int) session.createQuery("select s.filas from Salas s, Proyeccion p where s.idSala = p.salas and p.salas = (select idSala from Salas where numSala = '"+numSala+"') group by p.salas").uniqueResult();
				
				//Realize to transaction
				session.getTransaction().commit();
				//Close the sesion
				session.close();
		return iter;
	}
	
	public static ArrayList<Integer> dimensionSala(int numSala, String nombreCine){
		//Instance of class SessionFactory
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		session.beginTransaction();
		
		int filas = 0, columnas = 0;
		
		/*Iterator<?>iter = session.createQuery("select s.filas, s.columnas"
				+ " from Salas s, Proyeccion p"
				+ " where s.idSala = p.salas"
				+ " and p.salas = (select idSala"
				+ " from Salas where numSala = '"+numSala+"')"
				+ " group by p.salas").iterate();*/
		
		/*Iterator<?> iter = session.createQuery("select s.filas from Salas s, Proyeccion p where s.idSala = p.salas and p.salas = (select idSala from Salas where numSala = '"+numSala+"') group by p.salas").iterate();
		Iterator<?> iter2 = session.createQuery("select s.columnas from Salas s, Proyeccion p where s.idSala = p.salas and p.salas = (select idSala from Salas where numSala = '"+numSala+"') group by p.salas").iterate();
		*/
		
		Iterator<?>iter= session.createQuery("select s.filas from Salas s, Proyeccion p where s.idSala=p.salas and p.salas=(select sa.idSala from Salas sa where sa.numSala='"+numSala+"' and sa.cines=(select cin.idCine from Cines cin where cin.nombre='"+nombreCine+"'))").iterate();
		Iterator<?>iter2= session.createQuery("select s.columnas from Salas s, Proyeccion p where s.idSala=p.salas and p.salas=(select sa.idSala from Salas sa where sa.numSala='"+numSala+"' and sa.cines=(select cin.idCine from Cines cin where cin.nombre='"+nombreCine+"'))").iterate();

		ArrayList<Integer>filas1 = new ArrayList<>();
		
		
		while(iter.hasNext()){
			
			filas1.add(Integer.parseInt(iter.next().toString()));
		}
		
		ArrayList<Integer>columnas1= new ArrayList<>();
		//Proyeccion p= new Proyeccion();
		while(iter2.hasNext()){

			//Proyeccion proyec = (Proyeccion) iter2.next();
			
			columnas1.add(Integer.parseInt(iter2.next().toString()));
		}
		/*while(iter.hasNext()){

			Salas sala = (Salas) iter.next();
			filas = sala.getFilas();
			columnas = sala.getColumnas();
		}*/
		
		/*ArrayList<Integer>filasColumnas = new ArrayList<>();
		filasColumnas.add(filas);
		filasColumnas.add(columnas);*/
			ArrayList<Integer>arrayDimensional = new ArrayList<>();
			arrayDimensional.add(filas1.get(0));
			arrayDimensional.add(columnas1.get(0));
			
	
		//Realize to transaction
		session.getTransaction().commit();
		//Close the sesion
		session.close();
		
		return arrayDimensional;
	}
	
	//Create method for date system date
	public static String dateToMySQLDate(Date fecha){
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(fecha);
	}
	
	public static ArrayList<String> fecha(String pelicula){
		//Instance of class SessionFactory
		SessionFactory sesion = SessionFactoryUtil.getSessionFactory();
		Session session = sesion.openSession();
		session.beginTransaction();
		
		//Hacer una consulta
		//Iterator<?> iter2 = session.createQuery("select p.hora, p.fecha from Proyeccion p, Peliculas pe where p.peliculas = pe.idPelicula and pe.nombrePelicula = '"+pelicula+"' GROUP BY p.hora, p.fecha ORDER BY p.fecha asc").iterate();
		Iterator<?> iter = session.createQuery("select p.fecha from Proyeccion p, Peliculas pe where p.peliculas = pe.idPelicula and pe.nombrePelicula = '"+pelicula+"' GROUP BY p.hora, p.fecha ORDER BY p.fecha asc").iterate();
		Iterator<?> iter2 = session.createQuery("select p.hora from Proyeccion p, Peliculas pe where p.peliculas = pe.idPelicula and pe.nombrePelicula = '"+pelicula+"'").iterate();
		
		ArrayList<String>listaFecha = new ArrayList<>();
		while(iter.hasNext()){
			listaFecha.add(String.valueOf(iter.next()));
		}
		
		ArrayList<String>listaHora= new ArrayList<>();
		//Proyeccion p= new Proyeccion();
		while(iter2.hasNext()){

			//Proyeccion proyec = (Proyeccion) iter2.next();
			
			listaHora.add(String.valueOf(iter2.next()));
			//Creamos un objeto de tipo Proyeccion
			/*Proyeccion p = (Proyeccion)iter.next();
			p.getFecha();
			p.getHora();
			
			
			//creamos un objeto de tipo calendar
			
			Calendar date1 = Calendar.getInstance();
			Date fecha = new Date();
			
			//A ese objeto le instanciamos la fecha de alquiler que introduce el usuario
			date1.setTime(fecha);
			
			//Después le sumamos los dias de alquiler, es decir el tiempo que tiene para devolverlo
			//date1.add(Calendar.DAY_OF_YEAR, + diasFinAlquiler);	
						
			SimpleDateFormat dateformatter = new SimpleDateFormat("E dd/MM/yyyy ");
			
			//Aquí mostraremos la fecha en la que tiene que devolverla		
			listaSalas.add(String.valueOf(dateformatter.format(date1.getTime())));*/
			
			
		}
		ArrayList<String>listaSalas = new ArrayList<>();
		
		for(int i = 0; i < listaFecha.size(); i++){
			
				listaSalas.add(listaFecha.get(i) +"   "+ listaHora.get(i));
			
		}
		
		//Realize to transaction
		session.getTransaction().commit();
		//Close the sesion
		session.close();
		
		return listaSalas;
		
	}
}
