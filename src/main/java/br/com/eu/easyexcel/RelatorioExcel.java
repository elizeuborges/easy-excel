package br.com.eu.easyexcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class RelatorioExcel implements Relatorio {

	private Workbook workbook;
	
	private Sheet sheet;
	
	public RelatorioExcel(){
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet();
	}

	public void adicionar(Secao sessao) {
		sessao.autoEscrever(sheet, 0, 0);
	}
	
	public Workbook getWorkbook() {
		return workbook;
	}
	
}
