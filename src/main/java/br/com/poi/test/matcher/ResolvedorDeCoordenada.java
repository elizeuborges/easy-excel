package br.com.poi.test.matcher;

import br.com.poi.Coordenada;

public class ResolvedorDeCoordenada {

	public static Coordenada resolver(String celula) {
		String letras = celula.toUpperCase();
		int coluna = 0;
		int linha = 0;
		for (int i = 0, iletras = 0, inumeros = 0; i < letras.length(); i++) {
			/*
			A = 65 
			Z = 90
			0 = 48
			9 = 57
			*/
			char letra = letras.charAt(i);
			if (isLetra(letra)) {
				int pesoDaLetra = letra - 65;
				if (iletras>0) {
					coluna++;
					coluna *= 26;
				} 
				coluna += pesoDaLetra;
				iletras++;
			} else {
				int pesoDoNumero = letra - 48;
				if (inumeros>0) {
					linha *= 10;
				}
				linha += pesoDoNumero;
				inumeros++;
			}
		}
		return new Coordenada(coluna, linha-1);
	}

	private static boolean isLetra(char letra) {
		return letra > 64 && letra < 91;
	}

}
