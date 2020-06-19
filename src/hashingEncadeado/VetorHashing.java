package hashingEncadeado;

import dados.DadosDoCadastro;

public class VetorHashing {
//	private DadosDoCadastro[] vetor;
	private NoHashing[] vetor;
	private int quantVet;

	// constructor
	public VetorHashing(int tamanho) {
		this.vetor = new NoHashing[tamanho];
		this.quantVet = 0;
	}

	// Getters
	public NoHashing getVetor(int indice) {
		return this.vetor[indice];
	}
//	public NoHashing[] getVetor() {
//		return this.vetor;
//	}

	public int getQuantVet() {
		return this.quantVet;
	}

	// Setters
//	public void setVetor(int indice, NoHashing novo) {
//		this.vetor[indice] = novo;
//	}
//
//	public void setQuantVet(int novo) {
//		this.quantVet = novo;
//	}

	public boolean eVazio() {
		return this.quantVet == 0;
	}

//
	public void inserir(DadosDoCadastro novo, int M) {
		int posicao;
		posicao=Hashing(novo.getCpf(), M);//recebe a posição 
		NoHashing novoNo = new NoHashing(novo);
		if(this.vetor[posicao]==null) {
			this.vetor[posicao] = novoNo; 
		}else {
			novoNo.setProx(vetor[posicao]);
		}
		
		this.quantVet++;
	}
	
	
	// metodo para achar o mod e e dizer a posição
	// metodo para somar os caracteres e depois chamar o metodo Hashing para achar a posição
	public int Hashing(String chave, int tamanho) {
		char carac;
		
		int i, posicao, soma = 0;
		for (i = 0; i < chave.length(); i++) {
			carac = chave.charAt(i);
			soma += Character.getNumericValue(carac);
		}
		posicao=soma % tamanho;
		return posicao;
	}

//	public void inserir1(DadosDoCadastro elem) {
//		int pos = (int) myhash(elem.getCpf());
//		NoHashing novoNo = new NoHashing(elem);
//		if (vetor[pos] == null)
//			vetor[pos] = novoNo;
//		else {
//			novoNo.setProx(vetor[pos]);
//			vetor[pos] = novoNo;
//		}
//		tam++;
//	}

	// Função Hash
//	private long myhash(long x) {
//		long hashVal = x;
//		hashVal = hashVal % table.length;
//		if (hashVal < 0) {
//			hashVal += table.length;
//		}
//		return hashVal;
//	}

//	public String toString() {
//		String msg = "";
//		for (int i = 0; i < this.quantVet; i++) {
//			msg += this.vetor[i].getCpf() + ";" + this.vetor[i].getInscricao() + ";" + this.vetor[i].getValor() + ";"
//					+ this.vetor[i].isPago() + "\n";
//		}
//		return msg;
//	}

}
