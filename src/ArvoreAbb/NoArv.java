package ArvoreAbb;

import dados.DadosDoCadastro;

public class NoArv {
	private DadosDoCadastro info; // o tipo Item está declarado no capítulo 1
	private NoArv esq, dir;

	public NoArv(DadosDoCadastro elem){
		this.info = elem;
		this.esq = null;
		this.dir = null;
	}
	public NoArv getEsq(){
		return this.esq;
	}
	public NoArv getDir(){
		return this.dir;
	}
	public DadosDoCadastro getInfo(){
		return this.info;
	}
	public void setEsq(NoArv no){
		this.esq = no;
	}
	public void setDir(NoArv no){
		this.dir = no;
	}
	public void setInfo(DadosDoCadastro elem){
		this.info = elem;
	}
}
