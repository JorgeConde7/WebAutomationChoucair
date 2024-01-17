package pe.choucair.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class Utilitarios {
	
	public static List<Integer> numerosAleatorios(int totalNumeros, int respuestaNumeros) {
		List<Integer> numeroCantidad = new ArrayList<>();

		for (int i = 1; i <= totalNumeros; i++) {
			numeroCantidad.add(i);
		}

		Collections.shuffle(numeroCantidad);
		return numeroCantidad.subList(0, Math.min(totalNumeros, respuestaNumeros));
	}

}
