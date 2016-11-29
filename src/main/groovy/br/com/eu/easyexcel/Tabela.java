package br.com.eu.easyexcel;

import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class Tabela<T> implements Secao {

	private List<String> cabecalhos;
	private Iterable<T> data;
	private RowMapper<T> rowMapper;
	
	public Tabela(RowMapper<T> rowMapper, Iterable<T> data) {
		this.rowMapper = rowMapper;
		this.data = data;
		cabecalhos = new LinkedList<String>();
	}
	
	public void addCabecalho(String cabecalho) {
		cabecalhos.add(cabecalho);
	}

	@Override
	public void autoEscrever(Sheet sheet, int iLinhaInicial, int iColunaInicial) {
		escreverCabecalhos(sheet.createRow(iLinhaInicial), iColunaInicial);
		escreverLinhas(sheet, ++iLinhaInicial, iColunaInicial);
	}

	private void escreverLinhas(Sheet sheet, int iLinhaInicial, int iColunaInicial) {
		Linha linha = new LinhaSimples();
		for (T dado : data) {
			rowMapper.mapearLinha(linha, dado);
			int iColuna = iColunaInicial;
			for (int i = 0; i < cabecalhos.size(); i++) {
				String cabecalho = cabecalhos.get(i);
				String valorCelula = linha.getValorDaColuna(cabecalho);
				definirCelula(sheet.createRow(iLinhaInicial), iColuna, valorCelula);
				++iColuna;
			}
			++iLinhaInicial;
		}
	}

	private void escreverCabecalhos(Row row, int coluna) {
		for (String cabecalho : cabecalhos) {
			definirCelula(row, coluna, cabecalho);
			++coluna;
		}
		
	}

	private void definirCelula(Row row, int iColuna, String valor) {
		Cell cell = row.createCell(iColuna);
		cell.setCellValue(valor);
	}

}
