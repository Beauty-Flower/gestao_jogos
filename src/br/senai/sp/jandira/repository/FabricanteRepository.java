package br.senai.sp.jandira.repository;

import java.time.LocalDate;
import java.util.Arrays;

import br.senai.sp.jandira.model.Fabricante;

public class FabricanteRepository {
	
	private Fabricante[] fabricantes;
	
	public FabricanteRepository() {
		
		fabricantes = new Fabricante[3];
		
		Fabricante sony = new Fabricante();
		sony.setNome("Sony");
		sony.setDataFundação(LocalDate.of(1946, 5, 7));
		fabricantes[0] = sony;
		
		Fabricante activision = new Fabricante();
		activision.setNome("Activision");
		activision.setDataFundação(LocalDate.of(1979, 10, 1));
		fabricantes[1] = activision;
		
		Fabricante nintendo = new Fabricante();
		nintendo.setNome("Nintendo");
		nintendo.setDataFundação(LocalDate.of(1889, 9, 23));
		fabricantes[2] = nintendo;
	} 
	
	public Fabricante[] getFabricantes() {
		return fabricantes;
	}
	
	public Fabricante getFabricantes(int index) {
		return fabricantes[index];
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
	
	public int getIndex(Fabricante fabricante) {
		int getIndex = Arrays.asList(this.fabricantes).indexOf(fabricante);
		return getIndex;
	}
	
}
