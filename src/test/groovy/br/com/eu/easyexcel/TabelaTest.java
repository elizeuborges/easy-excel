package br.com.eu.easyexcel;

import static br.com.poi.test.matcher.WorkbookMatcher.possuiTexto;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class TabelaTest {

	private Workbook workbook;

	private Sheet sheet;

	@Before
	public void setUp() throws Exception {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet();
	}

	@Ignore
	@Test
	public void deveAdicionarCabecalho() throws IOException {
		RowMapper<Pessoa> rowMapper = new RowMapper<Pessoa>() {
			@Override
			public void mapearLinha(Linha linha, Pessoa pessoa) {
				linha.setarNaColuna("Nome", pessoa.getNome());
				linha.setarNaColuna("Endereço", pessoa.getEndereco());
			}
		};

		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa("Joao", "Rua 1"));
		pessoas.add(new Pessoa("Ana", "Rua 2"));

		Tabela<Pessoa> tabela = new Tabela<Pessoa>(rowMapper, pessoas);
		tabela.addCabecalho("Nome");
		tabela.addCabecalho("Endereço");
		tabela.autoEscrever(sheet, 0, 0);
		
		assertThat(workbook, possuiTexto("Nome").naCelula("A1"));
		assertThat(workbook, possuiTexto("Endereço").naCelula("B1"));
		assertThat(workbook, possuiTexto("Joao").naCelula("A2"));
		assertThat(workbook, possuiTexto("Rua 1").naCelula("B2"));
		assertThat(workbook, possuiTexto("Ana").naCelula("A3"));
		assertThat(workbook, possuiTexto("Rua 2").naCelula("B3"));
	}

	public static class Pessoa {
		private String nome;
		private String endereco;

		public Pessoa(String nome, String endereco) {
			this.nome = nome;
			this.endereco = endereco;
		}

		public String getNome() {
			return nome;
		}

		public String getEndereco() {
			return endereco;
		}

	}

}
