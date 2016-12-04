package br.com.eu.easyexcel;

import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellUtil;

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
		escreverCabecalhos(criarLinhaSeNecessario(sheet, iLinhaInicial), iColunaInicial);
		escreverLinhas(sheet, ++iLinhaInicial, iColunaInicial);
	}

	private void escreverLinhas(Sheet sheet, int iLinhaInicial, int iColunaInicial) {
		Linha linha = new LinhaSimples();
		for (T dado : data) {
			rowMapper.mapearLinha(linha, dado);
			int iColuna = iColunaInicial;
			for (String cabecalho : cabecalhos) {
				String valorCelula = linha.getValorDaColuna(cabecalho);
				Row row = criarLinhaSeNecessario(sheet, iLinhaInicial);
				Cell cell = criarCelula(row, iColuna);
				cell.setCellValue(valorCelula);
				++iColuna;
			}
			++iLinhaInicial;
		}
	}

	private Row criarLinhaSeNecessario(Sheet sheet, int indice) {
		return CellUtil.getRow(indice, sheet);
	}

	private void escreverCabecalhos(Row row, int coluna) {
		for (String cabecalho : cabecalhos) {
			CellUtil.createCell(row, coluna++, cabecalho);
		}
	}

	private Cell criarCelula(Row row, int iColuna) {
		return CellUtil.getCell(row, iColuna);
	}

}
