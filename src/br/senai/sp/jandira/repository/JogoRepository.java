package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Jogo;

public class JogoRepository {
	
	private Jogo[] colecao;
	
	public JogoRepository() {
		colecao = new Jogo[25];
	}
	
	public JogoRepository(int quantidade) {
		colecao = new Jogo[quantidade];
	}
	
	public void gravar(Jogo jogo, int posicao) {
		colecao[posicao] = jogo;
	}
	
	public Jogo listarJogo(int posicao) {
		return colecao[posicao];
	}
	
	public Jogo[] listarTodos() {
		return colecao;
	}
	
	public int getTamanho() {
		return colecao.length;
	}
}
