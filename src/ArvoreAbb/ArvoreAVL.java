package ArvoreAbb;


import java.io.BufferedReader;
import java.io.FileReader;

import dados.DadosDoCadastro;

public class ArvoreAVL {
	private Nodo raiz;
	private boolean h;
	private int quantNos;
	
	public ArvoreAVL() {
		this.raiz = null;
		this.h = true;
		this.quantNos = 0;
	}
	// Outros m�todos
	public Nodo getRaiz() {
		return this.raiz;
	}

	public int getQuantNos() {
		return this.quantNos;
	}
	public void setQuantNos(int novo) {
		this.quantNos = novo;
	}
	public boolean eVazia() {
		return (this.raiz == null);
	}
	public void setRaiz(Nodo novo) {
		this.raiz = novo;
	}
	// M�todo para inserir um n� na �rvore
	public void insereRaiz(DadosDoCadastro elem) {
		this.raiz = this.insere(elem, this.raiz);
	}

	private Nodo insere(DadosDoCadastro elem, Nodo no) {
		if (no == null) {
			Nodo novo = new Nodo(elem);
			this.h = true;
			return novo;
		} else {
			if (elem.getCpf().compareTo(no.getInfo().getCpf()) < 0) {
				// Insere � esquerda e verifica se precisa balancear � direita
				no.setEsq(this.insere(elem, no.getEsq()));
				no = this.balancearDir(no);
				return no;
			} else {
				// Insere � direita e verifica se precisa balancear � esquerda
				no.setDir(this.insere(elem, no.getDir()));
				no = this.balancearEsq(no);
				return no;
			}
		}
	}

//	M�todo para verificar se � necess�rio o balanceamento para direita do n�
	private Nodo balancearDir(Nodo no) {
		if (this.h)
			switch (no.getFatorBalanceamento()) {
			case 1:
				no.setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFatorBalanceamento((byte) -1);
				break;
			case -1:
				no = this.rotacaoDireita(no);
			}
		return no;
	}

//	M�todo para verificar se � necess�rio o balanceamento para esquerda do n�
	private Nodo balancearEsq(Nodo no) {
		if (this.h)
			switch (no.getFatorBalanceamento()) {
			case -1:
				no.setFatorBalanceamento((byte) 0);
				this.h = false;
				break;
			case 0:
				no.setFatorBalanceamento((byte) 1);
				break;
			case 1:
				no = this.rotacaoEsquerda(no);
			}
		return no;
	}

//	 M�todo para realizar ROTA��O DIREITA (RD) ou ROTA��O DUPLA DIREITA (RDD)
	private Nodo rotacaoDireita(Nodo no) {
		Nodo temp1, temp2;
		temp1 = no.getEsq();
		if (temp1.getFatorBalanceamento() == -1) {
			no.setEsq(temp1.getDir());
			temp1.setDir(no);
			no.setFatorBalanceamento((byte) 0);
			no = temp1;
		} else {
			temp2 = temp1.getDir();
			temp1.setDir(temp2.getEsq());
			temp2.setEsq(temp1);
			no.setEsq(temp2.getDir());
			temp2.setDir(no);
			if (temp2.getFatorBalanceamento() == -1)
				no.setFatorBalanceamento((byte) 1);
			else
				no.setFatorBalanceamento((byte) 0);
			if (temp2.getFatorBalanceamento() == 1)
				temp1.setFatorBalanceamento((byte) -1);
			else
				temp1.setFatorBalanceamento((byte) 0);
			no = temp2;
		}
		no.setFatorBalanceamento((byte) 0);
		this.h = false;
		return no;
	}

//	M�todo para realizar ROTA��O ESQUERDA (RE) ou ROTA��O DUPLA ESQUERDA (RDE)
	private Nodo rotacaoEsquerda(Nodo no) {
		Nodo temp1, temp2;
		temp1 = no.getDir();
		if (temp1.getFatorBalanceamento() == 1) {
			no.setDir(temp1.getEsq());
			temp1.setEsq(no);
			no.setFatorBalanceamento((byte) 0);
			no = temp1;
		} else {
			temp2 = temp1.getEsq();
			temp1.setEsq(temp2.getDir());
			temp2.setDir(temp1);
			no.setDir(temp2.getEsq());
			temp2.setEsq(no);
			if (temp2.getFatorBalanceamento() == 1)
				no.setFatorBalanceamento((byte) -1);
			else
				no.setFatorBalanceamento((byte) 0);
			if (temp2.getFatorBalanceamento() == -1)
				temp1.setFatorBalanceamento((byte) 1);
			else
				temp1.setFatorBalanceamento((byte) 0);
			no = temp2;
		}
		no.setFatorBalanceamento((byte) 0);
		this.h = false;
		return no;
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
				linha = lerArq.readLine(); // l� da segunda at� a �ltima linha
			}

		} catch (Exception e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		return vetorCpf;

	}

	public String pesquisarCpfImovel() {
		String[] vetorCpf = pesquisarCpf();
		String cpf = "";
		String resposta = "";
		double imposto=0.0;
		Nodo aux;
		for (int i = 0; i < vetorCpf.length; i++) {
			cpf = vetorCpf[i];
			
			Nodo no = pesquisarCpfImovel(cpf, this.raiz);
			if (no != null) {
				aux = no;
				resposta += "\nCPF " +no.getInfo().getCpf()+":\n";
				while ((no != null) && (no.getInfo().getCpf().compareTo(aux.getInfo().getCpf()) == 0)) {
					resposta +="Incr: " + no.getInfo().getInscricao()
							+ " Imposto: " + no.getInfo().getValor() + (no.getInfo().isPago()==true ?" PAGO" : " N�O PAGO") + "\n";
					
					if(no.getInfo().isPago()==false) {
						imposto+=no.getInfo().getValor();				
					}
					
					no = no.getDir();
					resposta+="Total Imposto a pagar: "+imposto+"\n";
					imposto=0.0;
				}
			}else {
				resposta += "\nCPF " + cpf + ":\n" + "N�O H� NENHUM REGISTRO COM O CPF: " + cpf + "\n";
			}
		}
		return resposta;
		
	}

	private Nodo pesquisarCpfImovel(String chave, Nodo no) {
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
	private Nodo pesquisar(String chave, Nodo no) {
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
