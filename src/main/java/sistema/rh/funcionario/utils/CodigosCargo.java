package sistema.rh.funcionario.utils;

import java.util.Random;

public class CodigosCargo {

	private static Random codCargo = new  Random();
	private static Random codNivel = new Random();
	
	public static int gerarCodCargo() {
		return codCargo.nextInt(100, 999);
	}
	
	public static int gerarCodNivel() {
		return codNivel.nextInt(10,60);
	}
	
	public static void main(String[] args) {
		System.out.println("Codiogo Gerado: "+gerarCodCargo());
		System.out.println("Codigo Nivel:" +gerarCodNivel());
	}
	
}
