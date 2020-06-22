package hashingEncadeado;


import dados.DadosDoCadastro;

public class VetorHashing {
	private NoHashing[] vetor;
	private int quantVet;
	private NoHashing prim;
	private NoHashing ult;

	// constructor
	public VetorHashing(int tamanho) {
		this.vetor = new NoHashing[tamanho];
		this.quantVet = 0;
		this.prim = null;
		this.ult = null;
	}

	// Getters
	public NoHashing getVetor(int indice) {
		return this.vetor[indice];
	}

	public NoHashing getPrim() {
		return this.prim;
	}

	public NoHashing getUlt() {
		return this.ult;
	}

	public int getQuantVet() {
		return this.quantVet;
	}

	public void setPrim(NoHashing novoNo) {
		this.prim = novoNo;
	}

	public void setUlt(NoHashing novoNo) {
		this.ult = novoNo;
	}

	public void setQuantVet(int novo) {
		this.quantVet = novo;
	}

//	public NoHashing[] getVetor() {
//		return this.vetor;
//	}

	// Setters
	public void setVetor(int indice, NoHashing novo) {
		this.vetor[indice] = novo;
	}
//

	public boolean eVazia() {
		return (this.prim == null);
	}

//	public boolean eVazio() {
//		return this.quantVet == 0;
//	}

	public void inserir(DadosDoCadastro novo, int M) {
		int posicao;
		posicao = Hashing(novo.getCpf(), M);// recebe a posição
		NoHashing novoNo = new NoHashing(novo);
		if (this.vetor[posicao] == null) {
			this.vetor[posicao] = novoNo;
		} else {
//			novoNo.setProx(vetor[posicao]);
//			vetor[posicao]=novoNo;
			if (this.eVazia()) {
				this.prim = novoNo;
			} else {
				this.ult.setProx(novoNo);
			}
		}
	
		this.ult = novoNo;
		this.quantVet++;
	}

	// metodo para achar o mod e e dizer a posição
	// metodo para somar os caracteres e depois chamar o metodo Hashing para achar a
	// posição
	public int Hashing(String chave, int tamanho) {
		char carac;

		int i, posicao, soma = 0;
		for (i = 0; i < chave.length(); i++) {
			carac = chave.charAt(i);
			soma += Character.getNumericValue(carac);
		}
		posicao = soma % tamanho;
		return posicao;
	}

//	public String toString() {
//		String msg = "";
//		for (int i = 0; i < this.quantVet; i++) {
//			msg += this.vetor[i].getInfo().getCpf()+"\n";
//		}
//		return msg;
//	}
	// mostra todo o conteúdo da lista
    public String toString() {
    	String msg = "";
        NoHashing atual = this.ult;
        while (atual != null) {
            msg += atual.getInfo().getCpf()+"\n";
            atual = atual.getProx();
        }
        return msg;
    }
	
	// metodo para incrementar caso não ache o numero primo
	public int acumuladorN(int n) { // exem: recebe 500 do tamanho do vetor
		for (int i = 2; i < n; i++) {
			if (isPrimo(n)) {
//				System.out.println("teste " + n);
				return n;
			} else {
				n++;
			}
		}
		return n;

	}


	private boolean isPrimo(int valor) {
		for (int j = 2; j < valor; j++) {
			if (valor % j == 0) {
				return false;
			}
		}
		return true;
	}

}
