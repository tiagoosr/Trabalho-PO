package ArvoreAbb;

import dados.DadosDoCadastro;

public class Arvore {
	private NoArv raiz;
	private int quantNos;

	//construtor da arvore
	public Arvore(){ 
		this.quantNos=0;
		this.raiz = null;
	}
	public boolean eVazia (){
		return (this.raiz == null);
	}
	public NoArv getRaiz(){
		return this.raiz;
	}
	public int getQuantNos(){
		return this.quantNos;
	}
	public void setRaiz(NoArv novo){
		this.raiz=novo;
	}
	public void setQuantNos(int novo){
		this.quantNos=novo;
	}
	//inserir um novo nó na arvore.
	public boolean inserir (DadosDoCadastro elem){
		if (this.pesquisar(elem.getInscricao())){
			return false;
		}else{
			this.raiz = inserir(elem, this.raiz);
			this.quantNos++;
			return true;
		}
	}
	//Sempre irá inserir em um atributo(esq ou dir) que seja igual a null.
	public NoArv inserir (DadosDoCadastro elem, NoArv no){
		if (no == null){
			NoArv novo = new NoArv(elem);
			return novo;
		}else {
			if (elem.getChave() < no.getInfo().getChave()){
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			}else{
				no.setDir(inserir(elem, no.getDir()));
				return no;
			}
		}
	}
	//Pesquisa se um determinado valor está na árvore
	public boolean pesquisar(int chave){
		if (pesquisar (chave, this.raiz)!= null){
			return true;
		}else{
			return false;
		}
	}
	//retorna null se não encontrar o valor desejado.
	//Se encontrar o valor, o método retorna o ponteiro do valor desejado.
	private NoArv pesquisar(int chave, NoArv no){
		if (no != null){
			if (chave < no.getInfo().getChave()){
				no = pesquisar (chave, no.getEsq());
			}else{
				if (chave > no.getInfo().getChave()){
					no = pesquisar (chave, no.getDir());
				}
			}
		}
		return no;
	}
	//remove um determinado nó procurando pela chave.
	//O nó pode estar em qualquer posição na árvore.
	public boolean remover(int chave){
		if (pesquisar(chave, this.raiz) != null){
			this.raiz = remover(chave, this.raiz);
			this.quantNos--;
			return true;
		}else {
			return false;
		}
	}
	public NoArv remover (int chave, NoArv arv){
		if (chave < arv.getInfo().getChave()){
			arv.setEsq(remover (chave, arv.getEsq()));
		}else{
			if (chave > arv.getInfo().getChave()){
				arv.setDir(remover (chave, arv.getDir()));
			}else{
				if (arv.getDir()== null){
					return arv.getEsq();
				}else{
					if (arv.getEsq() == null){ 
						return arv.getDir();
					}else{
						arv.setEsq(Arrumar (arv, arv.getEsq()));
					}
				}
			}
		}
		return arv;
	}
	private NoArv Arrumar (NoArv arv, NoArv maior){
		if (maior.getDir() != null){
			maior.setDir(Arrumar (arv, maior.getDir()));
		}
		else{
			arv.setInfo(maior.getInfo());
			maior = maior.getEsq();
		}
		return maior;
	}
	//caminhamento central
	public Item [] CamCentral (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamCentral (this.raiz, vet, n));
	}
	private Item [] FazCamCentral (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet = FazCamCentral (arv.getEsq(),vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral (arv.getDir(),vet,n);
		}
		return vet;
	}
	//caminhamento pré-fixado
	public Item [] CamPreFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPreFixado (this.raiz, vet, n));
	}
	private Item [] FazCamPreFixado (NoArv arv, Item [] vet, int []n){
		if (arv != null) {
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamPreFixado (arv.getEsq(), vet,n);
			vet = FazCamPreFixado (arv.getDir(), vet,n);
		}
		return vet;
	}
	//caminhamento pós-fixado
	public Item [] CamPosFixado (){
		int []n= new int[1];
		n[0]=0;
		Item [] vet = new Item[this.quantNos];
		return (FazCamPosFixado (this.raiz, vet, n));
	}
	private Item [] FazCamPosFixado (NoArv arv, Item[] vet, int []n){
		if (arv != null) {
			vet = FazCamPosFixado (arv.getEsq(), vet,n);
			vet = FazCamPosFixado (arv.getDir(), vet,n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
		}
		return vet;
	}

}

