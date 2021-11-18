package br.senai.sp.jandira.model;

public enum Console {
	
	COLORTVGAME("Color TV Game"),
	NINTENDO64("Nintendo 64"),
	NINTENDOSWITCH("Nintendo Switch");
	
	private String descricao;
	
	private Console(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
