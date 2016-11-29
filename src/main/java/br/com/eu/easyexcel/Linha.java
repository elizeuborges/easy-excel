package br.com.eu.easyexcel;

public interface Linha {

	void setarNaColuna(String nomeDaColuna, String valor);

	String getValorDaColuna(String nomeDaColuna);

}
