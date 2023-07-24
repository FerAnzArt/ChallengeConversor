package mx.com.conversor.modelo;


import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;


/**
 * @author Fernando Anzures
 *
 * @param 	cantidadAConvertir: Obtenida mediante el metodo IngresarConversor.
			conversionSeleccionada: Obtenida mediante el metodo IngresarConversor.
			valorDeCambio: Valor obtenido ya realizada la conversion mediante el metodo Conversion.
			tipoDeMoneda: Valor mostrado mediante el metodo Resultado.
			tipoDeMoneda2:Valor mostrado mediante el metodo Resultado.
 */


	public class Registro {
	
	
	//Conjuntos de String para mostrar las opciones de JOptinoPane.
	
	Integer opcionFinal;
	String[] opcionesConversor = {"Pesos a Dolares", "Pesos a Euros", "Pesos a Libras esterlinas", "Pesos a Yen Japones", "Pesos a Won surcoreanos","Dolares a Pesos","Euros a Pesos","Libras esterlinas a Pesos","Yen Japones a Pesos","Won surcoreanos a Pesos"};
	String[] opcionesFinal = {"Finalizar","Nuevo Registro", "Mostrar Registros"};
	String[] opcionesHistorial = {"Finalizar","Nuevo Registro"};
	static ArrayList<String> historialArrayList = new ArrayList<>();
	Resultado resultado = new Resultado();
	String valorIngresarConversor;
	double valorIngresarCantidad;
	
	//Constructor principal para generar el programa
	public Registro() throws ExceptionMoneda{
		IngresarConversor();
		IngresarCantidad();
		String resumen = resultado.Resultado(valorIngresarConversor,valorIngresarCantidad);
		historialArrayList.add(resumen + "\n");
		OpcionesRegistros();

	}
	
	
	//Metodo para ingresar la conversion a realizar
	public String IngresarConversor() {
		
		String conversorJOptionPane = (String) JOptionPane.showInputDialog(null,"Selecciona el tipo de conversion que deseas realizar","Conversor",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/IconoConversor.png"), opcionesConversor,opcionesConversor[0]);
		valorIngresarConversor = conversorJOptionPane;
		return this.valorIngresarConversor;
	}
	
	//Metodo para ingresar la cantidad a convertir	
	public double IngresarCantidad() throws ExceptionMoneda {
		
		String monto = (String) JOptionPane.showInputDialog(null,"Ingrese el monto a convertir", valorIngresarConversor, 0, new ImageIcon("src/IconoConversor.png"), null, null);
		ValidaMoneda(monto);
		valorIngresarCantidad = Double.parseDouble(monto);
		return this.valorIngresarCantidad;
	}
	
	
	//Validador de Moneda, en este caso que sean solo numeros	
	public void ValidaMoneda(String monto) throws ExceptionMoneda {
	
		if(monto.length() > 0 && monto.matches("^[0-9]+(\\.[0-9]+){0,1}$")) {
			System.out.println("Numero Correcto");
		}else {
			JOptionPane.showMessageDialog(null,"Datos erroneos, ingrese solamente numeros validos", "Error",0,new ImageIcon("src/IconoConversor.png"));
			new Registro();
			throw new ExceptionMoneda("Datos erroneos");
		}	
	}
	
	//
	public void OpcionesRegistros() throws ExceptionMoneda {
		
		opcionFinal = JOptionPane.showOptionDialog(null,resultado.MostrarResultado(), "Historial",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/IconoConversor.png"), opcionesFinal, "Finalizar");
		
		while(opcionFinal != 0) {
			switch(opcionFinal) {
			case 1:
				new Registro();
				opcionFinal = 0;
			case 2:
				opcionFinal = JOptionPane.showOptionDialog(null,mostrarHistorial(), "Historial", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,new ImageIcon("src/IconoConversor.png"),opcionesHistorial,"Finalizar");	
			}
		}
		if(opcionFinal == 0) {
			JOptionPane.showMessageDialog(null,"Gracias por probarme","Conversor de Fernando Anzures", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/IconoConversor.png"));
			System.exit(0);
		}
	}
	
	String mostrarHistorial(){
		String mostrar = "Se tuvieron " + historialArrayList.size()+" registros: \n"; 
		
		return mostrar + historialArrayList.toString().replace("[" , " ").replace("]", " ").replace(",", " ");
		
		
	}
	
}