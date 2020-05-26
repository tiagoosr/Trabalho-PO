package heap;

import java.util.Arrays;

import dados.DadosDoCadastro;

public class CadastroImobiliadrioVetor {

	private int fim;
	private DadosDoCadastro[] info;

	public CadastroImobiliadrioVetor(int tamanho) {
		this.fim = 0;
		this.info = new DadosDoCadastro[tamanho];
	}

	// Getters
	public DadosDoCadastro getInfo(int i) {
		return this.info[i];
	}

	public int getFim() {
		return this.fim;
	}

	// Setters
	public void setInfo(int i, DadosDoCadastro elem) {
		this.info[i] = elem;
	}

	public void setFim(int _fim) {
		this.fim = _fim;
	}

	public boolean eVazia() {
		return (this.fim == 0);
	}

	public boolean eCheia() {
		return (this.fim == this.info.length);
	}

	// retorna verdadeiro se conseguiu inserir o novo nó no final na lista.
	public boolean inserir(DadosDoCadastro elem) {
		if (this.eCheia()) {
			return false;
		} else {
			this.info[this.fim] = elem;
			this.fim++;
			return true;
		}
	}

	
	//retorna uma String com todo o conteúdo da lista.
	public String toString() {
		String msg = "";
		for (int i = 0; i < this.fim; i++) {
			msg += this.info[i].getCpf()+";"+this.info[i].getInscricao()+";"+this.info[i].getValor()+";"+this.info[i].isPago()+"\n";
		}
		return msg;
	}
}
