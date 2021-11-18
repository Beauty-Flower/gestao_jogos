package br.senai.sp.jandira.model;

public enum Console {
	
	PS("Play Station"),
	COLORTVGAME("Color TV Game"),
	NINTENDO("Nintendo 64"),
	NINTENDOSWITCH("Nintendo Switch");
	
	private String descricao;
	
	private Console(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
