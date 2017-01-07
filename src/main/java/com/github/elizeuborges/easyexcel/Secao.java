package com.github.elizeuborges.easyexcel;

import org.apache.poi.ss.usermodel.Sheet;

public interface Secao {

	void autoEscrever(Sheet sheet, int linha, int coluna);

}
