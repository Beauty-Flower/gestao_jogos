package br.senai.sp.jandira.model;

public enum Console {
	
	PS("Play Station"),
	XBOX("XBOX"),
	NINTENDO("Nintendo"),
	OUTRO("Outro");
	
	private String descricao;
	
	private Console(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
