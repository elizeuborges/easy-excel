package br.com.eu.easyexcel;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RelatorioExcelTest {

	private RelatorioExcel relatorio;
	
	@Mock
	private Secao secao;
	
	@Before
	public void setUp() throws Exception {
		relatorio = new RelatorioExcel();
	}
	
	@Test
	public void deveCriarUmaPlanilha(){
		Workbook workbook = relatorio.getWorkbook();
		assertThat(workbook, is(notNullValue()));
	}
	
	@Test
	public void deveSerPossivelAdicionarSecoes() throws Exception {
		relatorio.adicionar(secao);
		verify(secao, times(1)).autoEscrever(Mockito.any(Sheet.class), Mockito.eq(0), Mockito.eq(0));
	}

}
