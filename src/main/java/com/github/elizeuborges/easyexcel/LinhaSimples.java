package com.github.elizeuborges.easyexcel;

import java.util.HashMap;
import java.util.Map;

public class LinhaSimples implements Linha {

	private Map<String, String> colunas;
	
	public LinhaSimples() {
		colunas = new HashMap<String, String>();
	}
	
	@Override
	public void setarNaColuna(String nomeDaColuna, String valor) {
		colunas.put(nomeDaColuna, valor);
	}

	@Override
	public String getValorDaColuna(String nomeDaColuna) {
		return colunas.get(nomeDaColuna);
	}

}
