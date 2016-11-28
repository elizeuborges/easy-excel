package br.com.poi.test.matcher

import org.apache.poi.ss.usermodel.Cell
import org.hamcrest.Description
import org.hamcrest.TypeSafeDiagnosingMatcher

class CellMatcher extends TypeSafeDiagnosingMatcher<Cell> {

	def esperado;

	def retornado;

	private ExtratorDeConteudoDaCelula extrator

	private Description mismatchDescription

	public CellMatcher(String esperado) {
		this.esperado = esperado;
		this.extrator = { Cell cell -> cell.getStringCellValue() };
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("era esperado uma celula contendo ")
		.appendValue(esperado);
	}

	@Override
	public boolean matchesSafely(Cell cell, Description mismatchDescription) {
		retornado = extrator.extrairValor(cell);
		return esperado.equals(retornado);
	}

	def descreverNaoMatch(Description description) {
		description
		.appendText("uma celula com ")
		.appendValue(retornado)
	}
}
