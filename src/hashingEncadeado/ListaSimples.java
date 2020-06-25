package hashingEncadeado;

import dados.DadosDoCadastro;

public class ListaSimples {
	private NoHashing prim;
	private NoHashing ult;
	private int quantNos;

	// construtor da classe
	public ListaSimples() {
		this.prim = null;
		this.ult = null;
		this.quantNos = 0;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public NoHashing getPrim() {
		return this.prim;
	}

	public NoHashing getUlt() {
		return this.ult;
	}

	public void setQuantNos(int novoValor) {
		this.quantNos = novoValor;
	}

	public void setPrim(NoHashing novoNo) {
		this.prim = novoNo;
	}

	public void setUlt(NoHashing novoNo) {
		this.ult = novoNo;
	}

	public boolean eVazia() {
		return (this.prim == null);
	}

	// insere um novo nó no final da lista ou se a lista estiver vazia, insere o
	// primeiro nó na lista
	public void inserirUltimo(DadosDoCadastro elem) {
		NoHashing novoNo = new NoHashing(elem);
		if (this.eVazia()) {
			this.prim = novoNo;
		} else {
			this.ult.setProx(novoNo);
		}
		this.ult = novoNo;
		this.quantNos++;
	}

	// retorna o endereço do nó que está contendo o valor a ser procurado.
	public NoHashing pesquisarNo(String chave) {
		NoHashing atual = this.prim;
		while ((atual != null) && (atual.getInfo().getCpf() != chave)) {
			atual = atual.getProx();
		}
		return atual;
	}

	// mostra todo o conteúdo da lista
	public String toString() {
		String msg = "";
		NoHashing atual = this.prim;
		while (atual != null) {
			msg += atual.getInfo().getCpf() + "\n";
			atual = atual.getProx();
		}
		return msg;
	}

}
