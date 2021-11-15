package br.senai.sp.jandira.model;

import java.time.LocalDate;

public class Fabricante {

	private String nome;
	private LocalDate dataFundação;
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setDataFundação(LocalDate dataFundação) {
		this.dataFundação = dataFundação;
	}
	
	public LocalDate getDataFundação() {
		return dataFundação;
	}
}
