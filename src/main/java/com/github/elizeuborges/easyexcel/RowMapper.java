package com.github.elizeuborges.easyexcel;

public interface RowMapper<T> {

	void mapearLinha(Linha linha, T dado);
	
}
