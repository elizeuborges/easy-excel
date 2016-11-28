package br.com.poi.test.matcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import br.com.poi.Coordenada;

public class CoordenadaMatcher extends TypeSafeDiagnosingMatcher<Coordenada> {
	
	private int coluna;

	private int linha;

	public CoordenadaMatcher(int coluna, int linha) {
		this.coluna = coluna;
		this.linha = linha;
	}
	
	public static Matcher<Coordenada> is(int coluna, int linha) {
		return new CoordenadaMatcher(coluna, linha);
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("era esperado");
		descreverEstaCoordenada(description, new Coordenada(coluna, linha));
	}

	private Description descreverEstaCoordenada(Description description, Coordenada coordenada) {
		return description.appendText(" uma Coordenada com coluna ")
		.appendValue(coordenada.getColuna())
		.appendText(" e com linha ")
		.appendValue(coordenada.getLinha());
	}

	@Override
	protected boolean matchesSafely(Coordenada coordenada, Description mismatchDescription) {
		mismatchDescription.appendText("foi recebido");
		descreverEstaCoordenada(mismatchDescription, coordenada);
		return coordenada.getLinha() == linha
				&&
			   coordenada.getColuna() == coluna;
	}
}