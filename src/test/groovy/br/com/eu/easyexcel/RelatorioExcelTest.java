package br.com.eu.easyexcel;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;

public class RelatorioExcelTest {

	private RelatorioExcel relatorio;
	
	@Before
	public void setUp() throws Exception {
		relatorio = new RelatorioExcel();
	}
	
	@Test
	public void deveCriarUmaPlanilha(){
		Workbook workbook = relatorio.getWorkbook();
		assertThat(workbook, is(notNullValue()));
	}

}
