package br.com.eu.easyexcel;

import org.apache.poi.ss.usermodel.Sheet;

public interface Secao {

	void autoEscrever(Sheet sheet, int linha, int coluna);

}
