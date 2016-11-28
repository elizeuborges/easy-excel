package br.com.poi.test.matcher;

import org.apache.poi.ss.usermodel.Cell;

public interface ExtratorDeConteudoDaCelula<T> {
	T extrairValor(Cell cell);
}
