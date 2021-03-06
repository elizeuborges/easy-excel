package com.github.elizeuborges.easyexcel;

import static org.junit.Assert.assertThat;
import static com.github.elizeuborges.poimatchers.WorkbookMatcher.estaCom;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

import com.github.elizeuborges.easyexcel.Linha;
import com.github.elizeuborges.easyexcel.RowMapper;
import com.github.elizeuborges.easyexcel.Tabela;

public class TabelaTest {

	private Workbook workbook;

	private Sheet sheet;

	private RowMapper<Pessoa> rowMapper;

	@Before
	public void setUp() throws Exception {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet();
		
		rowMapper = new RowMapper<Pessoa>() {
			@Override
			public void mapearLinha(Linha linha, Pessoa pessoa) {
				linha.setarNaColuna("Nome", pessoa.getNome());
				linha.setarNaColuna("Endereço", pessoa.getEndereco());
			}
		};
	
	}

	@Test
	public void deveAdicionarValoresConformeCabecalhos() throws Exception {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa("Joao", "Rua 1"));
		pessoas.add(new Pessoa("Ana", "Rua 2"));
		Tabela<Pessoa> tabela = new Tabela<Pessoa>(rowMapper, pessoas);
		tabela.addCabecalho("Nome");
		tabela.addCabecalho("Endereço");
		tabela.autoEscrever(sheet, 0, 0);
		assertThat(workbook, estaCom("Joao").naCelula("A2"));
		assertThat(workbook, estaCom("Rua 1").naCelula("B2"));
		assertThat(workbook, estaCom("Ana").naCelula("A3"));
		assertThat(workbook, estaCom("Rua 2").naCelula("B3"));
		
		workbook.write(new FileOutputStream("C:\\Users\\Elizeu\\Desktop\\pessoas.xlsx"));
	}
	
	@Test
	public void deveAdicionarCabecalho() throws IOException {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		pessoas.add(new Pessoa("Joao", "Rua 1"));
		pessoas.add(new Pessoa("Ana", "Rua 2"));

		Tabela<Pessoa> tabela = new Tabela<Pessoa>(rowMapper, pessoas);
		tabela.addCabecalho("Nome");
		tabela.addCabecalho("Endereço");
		tabela.autoEscrever(sheet, 0, 0);
		
		assertThat(workbook, estaCom("Nome").naCelula("A1"));
		assertThat(workbook, estaCom("Endereço").naCelula("B1"));
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
