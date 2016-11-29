package br.com.eu.easyexcel;

public interface RowMapper<T> {

	void mapearLinha(Linha linha, T dado);
	
}
