package mx.com.conversor.modelo;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	
	
	//Parametros
	static Double cantidadAConvertir;
	static String conversionSeleccionada;
	static Double valorDeCambio;
	static String tipoDeMoneda;
	static String tipoDeMoneda2;
	
	//Conjuntos de String para mostrar las opciones de JOptinoPane.
	static String[] opcionesConversor = {"Pesos a Dolares", "Pesos a Euros", "Pesos a Libras esterlinas", "Pesos a Yen Japones", "Pesos a Won surcoreanos","Dolares a Pesos","Euros a Pesos","Libras esterlinas a Pesos","Yen Japones a Pesos","Won surcoreanos a Pesos"};
	static Integer opcionFinal;
	static String[] opcionesFinal = {"Finalizar","Nuevo Registro", "Mostrar Registros"};
	static String[] opcionesHistorial = {"Finalizar","Nuevo Registro"};
	
	//Constructor para mostrar el historial de los registros hechos.
	static ArrayList<String> historial = new ArrayList<>();
	
	
	//Constructor principal para generar el programa
	public Registro() throws ExceptionMoneda{
		
		IngresarConversor();
		IngresarCantidad();
		AnadirRegistro(Registro.Resultado());
		OpcionesRegistros();
	}
	
	//Metodo que inica el contructor desde algun punto del codigo
	
	public static void Iniciador() throws ExceptionMoneda {
		Registro registro = new Registro();
	}
	
	//Metodo para ingresar la conversion a realizar
	
	public void IngresarConversor() {
		String conversorJOptionPane = (String) JOptionPane.showInputDialog(null,"Selecciona el tipo de conversion que deseas realizar","Conversor",JOptionPane.INFORMATION_MESSAGE,new ImageIcon("src/IconoConversor.png"), opcionesConversor,opcionesConversor[0]);
		this.conversionSeleccionada = conversorJOptionPane;
	}
	
	//Metodo para ingresar la cantidad a convertir
	
	public void IngresarCantidad() throws ExceptionMoneda {
		String monto = (String) JOptionPane.showInputDialog(null,"Ingrese el monto a convertir", conversionSeleccionada, 0, new ImageIcon("src/IconoConversor.png"), null, null);
		Registro.ValidaMoneda(monto);
		this.cantidadAConvertir = Double.parseDouble(monto);
	}
	
	
	//Validador de Moneda, en este caso que sean solo numeros
	
	public static void ValidaMoneda(String monto) throws ExceptionMoneda {
	
		if(monto.length() > 0 && monto.matches("^[0-9]+(\\.[0-9]+){0,1}$")) {
			System.out.println("Numero Correcto");
		}else {
			JOptionPane.showMessageDialog(null,"Datos erroneos, ingrese solamente numeros validos", "Error",0,new ImageIcon("src/IconoConversor.png"));
			Iniciador();
			throw new ExceptionMoneda("Datos erroneos");
		}	
	}
	
	//Convierte a Double de dos decimales el monto resultado de la conversion

	public static  Double ValorDecimales(double valorDeCambio2) {
		return valorDeCambio2 = Math.round(valorDeCambio2 * 100)/100d;	
	}
	
	//Realiza la conversion segun el tipo de cambio
	
	public static Double Conversion(double d) {
		return valorDeCambio = (cantidadAConvertir / d);
	}
	
	//Genera la conversion  e imprime el resultado de está

	public static String Resultado() throws ExceptionMoneda {
		try{
			switch (conversionSeleccionada) {
				case "Pesos a Dolares":
					tipoDeMoneda2 = "Pesos";
					tipoDeMoneda = "Dolares";
					Conversion(17.04);
					break;
				case "Pesos a Euros":
					tipoDeMoneda2 = "Pesos";
					tipoDeMoneda = "Euros";
					Conversion(18.59);
					break;
				case "Pesos a Libras esterlinas":
					tipoDeMoneda2 = "Pesos";
					tipoDeMoneda = "Libras";
					Conversion(21.62);
					break;
				case "Pesos a Yen Japones":
					tipoDeMoneda2 = "Pesos";
					tipoDeMoneda = "Yenes";
					Conversion(0.12);
					break;
				case "Pesos a Won surcoreanos":
					tipoDeMoneda2 = "Pesos";
					tipoDeMoneda = "Wones";
					Conversion(0.013);
					break;
				case "Dolares a Pesos":
					tipoDeMoneda = "Pesos";
					tipoDeMoneda2 = "Dolares";
					Conversion(1/17.04);
					break;
				case "Euros a Pesos":
					tipoDeMoneda = "Pesos";
					tipoDeMoneda2 = "Euros";
					Conversion(1/18.59);
					break;
				case "Libras esterlinas a Pesos":
					tipoDeMoneda = "Pesos";
					tipoDeMoneda2 = "Libras";
					Conversion(1/21.62);
					break;
				case "Yen Japones a Pesos":
					tipoDeMoneda = "Pesos";
					tipoDeMoneda2 = "Yenes";
					Conversion(1/0.12);
					break;
				case"Won surcoreanos a Pesos":
					tipoDeMoneda = "Pesos";
					tipoDeMoneda2 = "Wones";
					Conversion(1/0.013);
					break;	
			
			}
		}catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null,"Datos erroneos, no selecciono tipo de conversion", "Error",0,new ImageIcon("src/IconoConversor.png"));
			Iniciador();
		}
		
		
		return cantidadAConvertir + " " + tipoDeMoneda2 + " equivalen a " + ValorDecimales(valorDeCambio) + " " + tipoDeMoneda;
			
		
	}
	
	
	//Añade la informacion obtenida de Resultado() a la ArrayList historial
	public static void AnadirRegistro(String string){
		historial.add(string + "\n");
	}
	
	//Menu que muestra el resultado de la conversion y el usuario puede solicitar el historial, generar un nuevo registro o finalizar las ventanas
	
	public static void OpcionesRegistros() throws ExceptionMoneda {
		opcionFinal = JOptionPane.showOptionDialog(null, Registro.Resultado(), "Resultado", 		JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/IconoConversor.png"), opcionesFinal, "Finalizar");
		
		while(opcionFinal != 0) {
			switch(opcionFinal) {
			case 1:
				Iniciador();
				opcionFinal = 0;
			case 2:
				opcionFinal = JOptionPane.showOptionDialog(null,historial.toString(), "Historial", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE,new ImageIcon("src/IconoConversor.png"),opcionesHistorial,"Finalizar");	
			}
		}
		if(opcionFinal == 0) {
			JOptionPane.showMessageDialog(null,"Gracias por probarme","Conversor de Fernando Anzures", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/IconoConversor.png"));
			System.exit(0);
		}
	}
}