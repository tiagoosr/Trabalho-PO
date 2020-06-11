package ArvoreAbb;

import java.util.Arrays;

import dados.DadosDoCadastro;

public class Arvore {
	private NoArv raiz;
	private int quantNos;

	// construtor da arvore
	public Arvore() {
		this.quantNos = 0;
		this.raiz = null;
	}

	public boolean eVazia() {
		return (this.raiz == null);
	}

	public NoArv getRaiz() {
		return this.raiz;
	}

	public int getQuantNos() {
		return this.quantNos;
	}

	public void setRaiz(NoArv novo) {
		this.raiz = novo;
	}

	public void setQuantNos(int novo) {
		this.quantNos = novo;
	}

	public String toString() {
		NoArv no = this.raiz.getDir();
		String resposta = "";
		if (no != null) {
			resposta += "Cpf: " + no.getInfo().getCpf() + "\nIncr: " + no.getInfo().getInscricao() + "\nValor: "
					+ no.getInfo().getValor() + "\nPago: " + no.getInfo().isPago() + "\n";
		}
		return resposta;
	}
	
	// inserir um novo nó na arvore.
//	public boolean inserir(DadosDoCadastro elem) {
//		if (this.pesquisar(elem.getCpf())) {
//			this.raiz = inserir(elem, this.raiz);
//			this.quantNos++;
//			return true;
//		} else {
//			this.raiz = inserir(elem, this.raiz);
//			this.quantNos++;
//			return true;
//		}
//	}

	public boolean pesquisa(String chave) {
		NoArv temp;

		temp = this.pesquisa(chave, this.raiz);
		if (temp != null)
			return true;
		else
			return false;
	}

	private NoArv pesquisa(String chave, NoArv no) {
		NoArv temp;
		temp = no;

		if (temp != null) {
			if (chave.compareTo(temp.getInfo().getCpf()) < 0)
				temp = this.pesquisa(chave, temp.getEsq());
			else {
				if (chave.compareTo(temp.getInfo().getCpf()) > 0)
					temp = this.pesquisa(chave, temp.getDir());
			}
		}
		return temp;
	}

	public boolean insere(DadosDoCadastro elem) {
		boolean existe;

		existe = this.pesquisa(elem.getCpf());
		if (existe)
			return false;
		else {
			this.raiz = this.insere(elem, this.raiz);
			return true;
		}
	}

	private NoArv insere(DadosDoCadastro elem, NoArv no) {
		NoArv novo;

		if (no == null) {
			novo = new NoArv(elem);
			return novo;
		} else {
			if (elem.getCpf().compareTo(no.getInfo().getCpf()) < 0) {
				no.setEsq(this.insere(elem, no.getEsq()));
				return no;
			} else {
				no.setDir(this.insere(elem, no.getDir()));
				return no;
			}
		}
	}

	// Sempre irá inserir em um atributo(esq ou dir) que seja igual a null.
//	public NoArv inserir(DadosDoCadastro elem, NoArv no) {
//		if (no == null) {
//			NoArv novo = new NoArv(elem);
//			return novo;
//		} else {
//			if (elem.getCpf().compareTo(no.getInfo().getCpf()) < 0) {
//				no.setEsq(inserir(elem, no.getEsq()));
//				return no;
//			} else {
//				if (elem.getCpf().compareTo(no.getInfo().getCpf()) > 0) {
//					no.setDir(inserir(elem, no.getDir()));
//					return no;
//				} else {
//					if (elem.getCpf().compareTo(no.getInfo().getCpf()) == 0) {
//						if (no.getDir() == null) {
//							no.setDir(inserir(elem, no.getDir()));
//							return no;
//						} else {
//							if (elem.getCpf().compareTo(no.getInfo().getCpf()) < 0) {
//								no.setEsq(inserir(elem, no.getEsq()));
//								return no;
//							} else {
//								no.setDir(inserir(elem, no.getDir()));
//								return no;
//							}
//						}
//					}
//				}
//			}
//		}
//		return no;
//	}

	// Pesquisa se um determinado valor está na árvore
//	public boolean pesquisar(String chave) {
//		if (pesquisar(chave, this.raiz) != null) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	// retorna null se não encontrar o valor desejado.
	// Se encontrar o valor, o método retorna o ponteiro do valor desejado.
//	private NoArv pesquisar(String chave, NoArv no) {
//		if (no != null) {
//			if (chave.compareTo(no.getInfo().getCpf()) < 0) {
//				no = pesquisar(chave, no.getEsq());
//			} else {
//				if (chave.compareTo(no.getInfo().getCpf()) > 0) {
//					no = pesquisar(chave, no.getDir());
//				}
//			}
//		}
//		return no;
//	}

	public DadosDoCadastro[] CamCentral() {
		int[] n = new int[1];
		n[0] = 0;
		DadosDoCadastro[] vet = new DadosDoCadastro[this.quantNos];
		return (FazCamCentral(this.raiz, vet, n));
	}

	private DadosDoCadastro[] FazCamCentral(NoArv arv, DadosDoCadastro[] vet, int[] n) {
		if (arv != null) {
			vet = FazCamCentral(arv.getEsq(), vet, n);
			vet[n[0]] = arv.getInfo();
			n[0]++;
			vet = FazCamCentral(arv.getDir(), vet, n);
		}
		return vet;
	}
}
