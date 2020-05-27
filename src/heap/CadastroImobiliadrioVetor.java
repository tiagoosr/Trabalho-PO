package heap;

import java.util.Arrays;

import dados.DadosDoCadastro;

public class CadastroImobiliadrioVetor {
	private DadosDoCadastro[] vetor;
	private int quantVet;

	// constructor
	public CadastroImobiliadrioVetor(int tamanho) {
		this.vetor = new DadosDoCadastro[tamanho];
		this.quantVet = 0;
	}

	// Getters
	public DadosDoCadastro getVetor(int indice) {
		return this.vetor[indice];
	}

	public int getQuantVet() {
		return this.quantVet;
	}

	// Setters
	public void setVetor(int indice, DadosDoCadastro novo) {
		this.vetor[indice] = novo;
	}

	public void setQuantVet(int novo) {
		this.quantVet = novo;
	}

	public boolean eVazio() {
		return this.quantVet == 0;
	}

	public boolean eCheio() {
		return this.quantVet == this.vetor.length;
	}

	public boolean inserir(DadosDoCadastro novo) {
		if (this.eCheio()) {
			return false;
		} else {
			this.vetor[this.quantVet] = novo;
			this.quantVet++;
			return true;
		}
	}

	public String toString() {
		String msg = "";
		for (int i = 0; i < this.quantVet; i++) {
			msg += this.vetor[i].getCpf() + ";" + this.vetor[i].getInscricao() + ";" + this.vetor[i].getValor() + ";"
					+ this.vetor[i].isPago() + "\n";
		}
		return msg;
	}

	/*
	 * class Dados{ private Item[] vetor; //referência a um vetor de itens private
	 * int nElem; //número de itens de dados //construtor(es) e métodos desta classe
	 * }
	 */
	// HeapSort ordenação
	public void heapSort() {
		int dir = quantVet - 1;
		int esq = (dir - 1) / 2;
		DadosDoCadastro temp;

		while (esq >= 0) {
			refazHeap(esq, this.quantVet - 1);
			esq--;
		}
		while (dir > 0) {
			temp = this.vetor[0];
			this.vetor[0] = this.vetor[dir];
			this.vetor[dir] = temp;
			dir--;
			refazHeap(0, dir);
		}
	}

	private void refazHeap(int esq, int dir) {
		int i = esq;
		int mF = 2 * i + 1; // maior filho
		DadosDoCadastro raiz = this.vetor[i];
		boolean heap = false;

		while ((mF <= dir) && (!heap)) {
			if (mF < dir) {
				//verifica se tem um valor a direito do maior filho
				// se tiver o maior filhor passa a ser o próximo valor
				// seria o 2i+2
				if (this.vetor[mF].getCpf().compareTo(this.vetor[mF + 1].getCpf()) < 0)
					mF++;
			}
			// Se a raiz for menor que o maior filho, ocorre a troca. Volta e verifica se
			// sub-árvore continuará heap
			if (raiz.getCpf().compareTo(this.vetor[mF].getCpf()) < 0) {
				this.vetor[i] = this.vetor[mF];
				i = mF;
				mF = 2 * i + 1;
			} else
				heap = true;
		}
		
		this.vetor[i] = raiz;
	}


}
