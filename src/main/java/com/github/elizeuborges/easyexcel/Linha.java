package com.github.elizeuborges.easyexcel;

public interface Linha {

	void setarNaColuna(String nomeDaColuna, String valor);

	String getValorDaColuna(String nomeDaColuna);

}
