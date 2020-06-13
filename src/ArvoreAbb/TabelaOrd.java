package ArvoreAbb;

import dados.DadosDoCadastro;

public class TabelaOrd {
	private DadosDoCadastro[] vetor;
	private int quantVet;

	// constructor
	public TabelaOrd(int tamanho) {
		this.vetor = new DadosDoCadastro[tamanho];
		this.quantVet = 0;
	}
	
	public DadosDoCadastro getVetor(int indice) {
		return this.vetor[indice];
	}
	
	public int getQuantVet() {
		return this.quantVet;
	}
	
	public void insere(DadosDoCadastro vetor) {
		this.vetor[this.quantVet] = vetor;
		this.quantVet++;
	}
	
	public String resultado() {
		String msg = "";
		for (int i = 0; i < this.quantVet; i++) {
			msg += this.vetor[i].getCpf() + ";" + this.vetor[i].getInscricao() + ";" + this.vetor[i].getValor() + ";"
					+ this.vetor[i].isPago() + "\n";
		}
		return msg;
	}
}
