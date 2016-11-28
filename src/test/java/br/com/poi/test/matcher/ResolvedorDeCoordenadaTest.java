package br.com.poi.test.matcher;

import static br.com.poi.test.matcher.CoordenadaMatcher.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import br.com.poi.Coordenada;

public class ResolvedorDeCoordenadaTest {

	@Test
	public void deveResolverCoordenadaComUmaLetraEUmNumero() throws Exception {
		Coordenada coordenada = ResolvedorDeCoordenada.resolver("K5");
		assertThat(coordenada, is(10, 4));
	}

	@Test
	public void deveResolverCoordenadaComDuasLetrasEUmNumero() throws Exception {
		Coordenada coordenada = ResolvedorDeCoordenada.resolver("AA8");
		assertThat(coordenada, is(26, 7));
	}

	@Test
	public void deveResolverCoordenadaComUmaLetraEDoisNumeros() throws Exception {
		Coordenada coordenada = ResolvedorDeCoordenada.resolver("C81");
		assertThat(coordenada, is(2, 80));
	}
	
	@Test
	public void deveResolverCoordenadaComDuasLetrasEDoisNumeros() throws Exception {
		Coordenada coordenada = ResolvedorDeCoordenada.resolver("AB90");
		assertThat(coordenada, is(27, 89));
	}

	@Test
	public void deveResolverCoordenadaComDuasLetrasEDoisNumerosComecandoComZero() throws Exception {
		Coordenada coordenada = ResolvedorDeCoordenada.resolver("AB05");
		assertThat(coordenada, is(27, 4));
	}
	
}