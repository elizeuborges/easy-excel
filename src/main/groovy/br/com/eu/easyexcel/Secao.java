package br.com.eu.easyexcel;

import org.apache.poi.ss.usermodel.Sheet;

import br.com.poi.Coordenada;

public interface Secao {

	void autoEscrever(Sheet sheet, Coordenada coordenada);

}
