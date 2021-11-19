package br.senai.sp.jandira.model;

public class Jogo {

	private String titulo;
	private Fabricante fabricante;
	private boolean zerado;
	private String valor;
	private String observacoes;
	private Console console;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public boolean getZerado() {
		return zerado;
	}

	public void setZerado(boolean zerado) {
		this.zerado = zerado;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public void setConsole(Console console) {
		this.console = console;
	}
	
	public Console getConsole() {
		return console;
	}

}
