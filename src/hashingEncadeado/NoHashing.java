package hashingEncadeado;

import dados.DadosDoCadastro;

public class NoHashing {
	private DadosDoCadastro info; 
	private NoHashing prox;

	public NoHashing(DadosDoCadastro elem) {
		this.info = elem;
		this.prox = null;

	}

	public DadosDoCadastro getInfo() {
		return this.info;
	}

	public void setInfo(DadosDoCadastro elem) {
		this.info = elem;
	}

	public NoHashing getProx() {
		return this.prox;
	}

	public void setProx(NoHashing novoNo) {
		this.prox = novoNo;
	}

}
