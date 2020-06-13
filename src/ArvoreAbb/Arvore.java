package ArvoreAbb;

import java.io.BufferedReader;
import java.io.FileReader;


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

//

	// inserir um novo nó na arvore.
	public boolean inserir(DadosDoCadastro elem) {
//		if (this.pesquisar(elem.getCpf())) {
//			this.raiz = inserir(elem, this.raiz);
//			this.quantNos++;
//			return true;
//		} else {
//			this.raiz = inserir(elem, this.raiz);
//			this.quantNos++;
//			return true;
//		}
		this.raiz = inserir(elem, this.raiz);
		this.quantNos++;
		return true;
	}

	// Sempre irá inserir em um atributo(esq ou dir) que seja igual a null.
	public NoArv inserir(DadosDoCadastro elem, NoArv no) {
		if (no == null) {
			NoArv novo = new NoArv(elem);
			return novo;
		} else {
			if (elem.getCpf().compareTo(no.getInfo().getCpf()) < 0) {
				no.setEsq(inserir(elem, no.getEsq()));
				return no;
			} else {
				if (elem.getCpf().compareTo(no.getInfo().getCpf()) > 0) {
					no.setDir(inserir(elem, no.getDir()));
					return no;
				} else {
					if (elem.getCpf().compareTo(no.getInfo().getCpf()) == 0) {
						if (no.getDir() == null) {
							no.setDir(inserir(elem, no.getDir()));
							return no;
						} else {
							if (elem.getCpf().compareTo(no.getInfo().getCpf()) < 0) {
								no.setEsq(inserir(elem, no.getEsq()));
								return no;
							} else {
								no.setDir(inserir(elem, no.getDir()));
								return no;
							}
						}
					}
				}
			}
		}
		return no;
	}

	// Pesquisa se um determinado valor está na árvore
	public boolean pesquisar(String chave) {
		if (pesquisar(chave, this.raiz) != null) {
			return true;
		} else {
			return false;
		}
	}

	// retorna null se não encontrar o valor desejado.
	// Se encontrar o valor, o método retorna o ponteiro do valor desejado.
	private NoArv pesquisar(String chave, NoArv no) {
		if (no != null) {
			if (chave.compareTo(no.getInfo().getCpf()) < 0) {
				no = pesquisar(chave, no.getEsq());
			} else {
				if (chave.compareTo(no.getInfo().getCpf()) > 0) {
					no = pesquisar(chave, no.getDir());
				}
			}
		}
		return no;
	}

//	public DadosDoCadastro[] CamCentral() {
//		int[] n = new int[1];
//		n[0] = 0;
//		DadosDoCadastro[] vet = new DadosDoCadastro[this.quantNos];
//		return (FazCamCentral(this.raiz, vet, n));
//	}
//
//	private DadosDoCadastro[] FazCamCentral(NoArv arv, DadosDoCadastro[] vet, int[] n) {
//		if (arv != null) {
//			vet = FazCamCentral(arv.getEsq(), vet, n);
//			vet[n[0]] = arv.getInfo();
//			n[0]++;
//			vet = FazCamCentral(arv.getDir(), vet, n);
//		}
//		return vet;
//	}

	public TabelaOrd CamCentral(TabelaOrd vetOrdenado) {
		return (this.FazCamCentral(this.raiz, vetOrdenado));
	}

	private TabelaOrd FazCamCentral(NoArv arv, TabelaOrd vetOrdenado) {
		if (arv != null) {
			vetOrdenado = this.FazCamCentral(arv.getEsq(), vetOrdenado);
			vetOrdenado.insere(arv.getInfo());
			vetOrdenado = this.FazCamCentral(arv.getDir(), vetOrdenado);
		}
		return vetOrdenado;
	}

	public Arvore ArvoreBalanceada(TabelaOrd vetOrdenado) {
		Arvore temp = new Arvore();
		this.Balancear(vetOrdenado, temp, 0, vetOrdenado.getQuantVet() - 1);
		return temp;
	}

	private void Balancear(TabelaOrd vet, Arvore temp, int inic, int fim) {
		int meio;
		if (fim >= inic) {
			meio = (inic + fim) / 2;
			temp.inserir(vet.getVetor(meio));
			this.Balancear(vet, temp, inic, meio - 1);
			this.Balancear(vet, temp, meio + 1, fim);
		}
	}

	public String[] pesquisarCpf() {
		String arquivos = "./src/arquivosDeTeste/Imovel.txt";
		int i = 0;
		String cpf = null;
		String[] vetorCpf = new String[400];
		try {
			FileReader arq = new FileReader(arquivos);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine();
			while (linha != null) {
				cpf = linha;

				vetorCpf[i] = cpf;
				i++;
				linha = lerArq.readLine(); // lê da segunda até a última linha
			}

		} catch (Exception e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		return vetorCpf;

	}

	public String pesuisarCpfImovel() {
		String[] vetorCpf = pesquisarCpf();
		String cpf = "";
		String resposta = "";
		int cont=0;
		double imposto=0.0;
		NoArv aux;
		for (int i = 0; i < vetorCpf.length; i++) {
			cpf = vetorCpf[i];
			
			NoArv no = pesuisarCpfImovel(cpf, this.raiz);
			if (no != null) {
				aux = no;
				resposta += "\nCPF " +no.getInfo().getCpf()+":\n";
				while ((no != null) && (no.getInfo().getCpf().compareTo(aux.getInfo().getCpf()) == 0)) {
					resposta +="Incr: " + no.getInfo().getInscricao()
							+ " Imposto: " + no.getInfo().getValor() + (no.getInfo().isPago()==true ?" PAGO" : " NÃO PAGO") + "\n";
					cont++;
					
					if(no.getInfo().isPago()==false) {
						imposto+=no.getInfo().getValor();				
					}
					if(no!=aux) {
						resposta+="Total Imposto a pagar: "+imposto+"\n";
						imposto=0.0;
					}
					no = no.getDir();
					
					
//					resposta+="Total Imposto a pagar: "+imposto+"\n";
//					imposto=0.0;
				}
			}
		}
		System.out.println(cont);
		return resposta;
		
	}

	private NoArv pesuisarCpfImovel(String chave, NoArv no) {
		if (no != null) {
			if (chave.compareTo(no.getInfo().getCpf()) < 0) {
				no = pesquisar(chave, no.getEsq());
			} else {
				if (chave.compareTo(no.getInfo().getCpf()) > 0) {
					no = pesquisar(chave, no.getDir());
				}
			}
		}
		return no;
	}
}
