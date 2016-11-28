package br.com.poi;

public class Coordenada {

	public static Coordenada A0 = new Coordenada(0, 0);
	
	private int linha;

	private int coluna;
	
	public Coordenada() {
	}
	
	public Coordenada(int coluna, int linha) {
		this.coluna = coluna;
		this.linha = linha;
	}

	public int getLinha() {
		return linha;
	}
	
	public int getColuna() {
		return coluna;
	}

}
