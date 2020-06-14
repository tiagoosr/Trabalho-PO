package ArvoreAbb;

import dados.DadosDoCadastro;

public class Nodo {
	private DadosDoCadastro info;
	private Nodo esq, dir;
	private byte fatorBalanceamento;

	public Nodo(DadosDoCadastro i) {// construtor
		this.info = i;
		this.fatorBalanceamento = 0;
	}

	public Nodo getDir() {
		return this.dir;
	}

	public void setDir(Nodo dir) {
		this.dir = dir;
	}

	public Nodo getEsq() {
		return this.esq;
	}

	public void setEsq(Nodo esq) {
		this.esq = esq;
	}

	public byte getFatorBalanceamento() {
		return this.fatorBalanceamento;
	}

	public void setFatorBalanceamento(byte fatorBalanceamento) {
		this.fatorBalanceamento = fatorBalanceamento;
	}

	public DadosDoCadastro getInfo() {
		return this.info;
	}

}
