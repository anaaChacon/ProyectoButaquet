package controlador;

public class Discounts {
	//Creamos un método para calculas el precio de las entradas
	public static double precioEntradas(int numEntradas){
		
		double precioUnidadEntrada = 6.8; 
		double precioEntradasTotal = precioUnidadEntrada * numEntradas;
	
		return precioEntradasTotal;
	}
	//Creamos un método para sacar la cantidad en euros de los descuentos totalas que se aplicaran a cada entrada, si esque tiene
	public static double descuentos(int carnetJove, int desempleado, int jubilado){
		
		int descuentoJove = carnetJove * 1; 
		int descuentoDesempleado = desempleado * 2;
		double descuentoJubilado = jubilado * 1.5;
		
		double descuentoTotal = descuentoJove + descuentoDesempleado + descuentoJubilado;
		
		return descuentoTotal;
	}
	
}
