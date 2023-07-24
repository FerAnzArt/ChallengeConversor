package mx.com.conversor.modelo;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Resultado {

	
	
	Double cantidadAConvertir;
	Double valorDeCambio;
	String resultadofinal;

	//Realiza la conversion segun el tipo de cambio
	public Double Conversion(double d) {
		return this.valorDeCambio = (cantidadAConvertir / d);
	}
	
	//Convierte a Double de dos decimales el monto resultado de la conversion
	public  Double ValorDecimales(double valor) {
		return valor = Math.round(valor * 100)/100d;	
	}
	
	
	public String MostrarResultado() {
		return this.resultadofinal;
	}
	
	
	//Genera la conversion  e imprime el resultado de está
	public String Resultado(String s, Double cantidad ) throws ExceptionMoneda {
		this.cantidadAConvertir = cantidad;
		String tipoDeMoneda2 = null;
		String tipoDeMoneda = null;
		try{
			switch (s) {
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
			new Registro();
		}
		return this.resultadofinal = cantidadAConvertir + " " + tipoDeMoneda2 + " equivalen a " + ValorDecimales(valorDeCambio) + " " + tipoDeMoneda;	
	}
}
