package br.com.eu.easyexcel;

import static br.com.poi.test.matcher.WorkbookMatcher.possuiTexto;
import static org.junit.Assert.assertThat;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import br.com.poi.Coordenada;

public class TabelaTest {

	private Workbook workbook;
	
	private Sheet sheet;
	
	@Before
	public void setUp() throws Exception {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet();
	}

	@Test
	public void deveAdicionarCabecalho(){
		Tabela tabela = new Tabela();
		tabela.addCabecalho("Nome");
		tabela.addCabecalho("Endereço");
		tabela.autoEscrever(sheet, Coordenada.A0);
		assertThat(workbook, possuiTexto("Nome").naCelula("A1"));
		assertThat(workbook, possuiTexto("Endereço").naCelula("B1"));
	}
}
