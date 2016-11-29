package br.com.poi.test.matcher;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WorkbookMatcherTest {

	@Mock
	private Workbook workbook;
	
	@Mock
	private Sheet sheet;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void deveLancarExcecaoSeMatcherIncompleto() throws Exception {
		WorkbookMatcher matcher = WorkbookMatcher.possuiTexto("textoEsperado");
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage(containsString("não informou a célula"));
		matcher.matches(workbook);
	}

	@Test
	public void deveRetornarFalseSeNenhumaFolhaTiverSidoCriada() throws Exception {
		WorkbookMatcher matcher = WorkbookMatcher.possuiTexto("textoEsperado").naCelula("A1");
		boolean matches = matcher.matches(workbook);
		assertThat(matches, is(false));
	}

	@Test
	public void deveRetornarFalseSeRowInformadaNaoTiverSidoCriada() throws Exception {
		WorkbookMatcher matcher = WorkbookMatcher.possuiTexto("textoEsperado").naCelula("A1");
		Mockito.when(workbook.getNumberOfSheets()).thenReturn(1);
		Mockito.when(workbook.getSheetAt(Mockito.anyInt())).thenReturn(sheet);
		boolean matches = matcher.matches(workbook);
		assertThat(matches, is(false));
	}
	
	@Test
	public void deveRetornarFalseSeCelulaInformadaNaoTiverSidoCriada() throws Exception {
		WorkbookMatcher matcher = WorkbookMatcher.possuiTexto("textoEsperado").naCelula("A1");
		Mockito.when(workbook.getNumberOfSheets()).thenReturn(1);
		Mockito.when(workbook.getSheetAt(Mockito.anyInt())).thenReturn(sheet);
		Row row = Mockito.mock(Row.class);
		Mockito.when(sheet.getRow(Mockito.anyInt())).thenReturn(row);
		boolean matches = matcher.matches(workbook);
		assertThat(matches, is(false));
	}
	
}
