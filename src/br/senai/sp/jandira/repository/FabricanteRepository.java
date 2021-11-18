package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Fabricante;

public class FabricanteRepository {
	
	private Fabricante[] fabricantes;
	
	public FabricanteRepository() {
		fabricantes = new Fabricante[25];
	} 
	
	public void gravar(Fabricante fabricante, int posicao) {
		fabricantes[posicao] = fabricante;
	}
	
	public Fabricante listarFabricante(int posicao) {
		return fabricantes[posicao];
	}
	
	public Fabricante[] listarTodos() {
		return fabricantes;
	}
	
	public int getTamanho() {
		return fabricantes.length;
	}
}
