package br.com.eu.easyexcel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import br.com.poi.Coordenada;

public class Tabela implements Secao {

	private List<String> cabecalhos;
	
	public Tabela() {
		cabecalhos = new ArrayList<String>();
	}
	
	public void addCabecalho(String cabecalho) {
		cabecalhos.add(cabecalho);
	}

	@Override
	public void autoEscrever(Sheet sheet, Coordenada coordenada) {
		escreverCabecalhos(sheet, coordenada);
	}

	private void escreverCabecalhos(Sheet sheet, Coordenada coordenada) {
		Row row = sheet.createRow(coordenada.getLinha());
		int coluna = coordenada.getColuna();
		for (String cabecalho : cabecalhos) {
			Cell cell = row.createCell(coluna++);
			cell.setCellValue(cabecalho);
		}
		
	}

}
