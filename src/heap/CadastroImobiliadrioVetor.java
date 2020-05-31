package heap;

import java.io.BufferedReader;
import java.io.FileReader;

import dados.DadosDoCadastro;

public class CadastroImobiliadrioVetor {
	private DadosDoCadastro[] vetor;
	private int quantVet;

	// constructor
	public CadastroImobiliadrioVetor(int tamanho) {
		this.vetor = new DadosDoCadastro[tamanho];
		this.quantVet = 0;
	}

	// Getters
	public DadosDoCadastro getVetor(int indice) {
		return this.vetor[indice];
	}

	public int getQuantVet() {
		return this.quantVet;
	}

	// Setters
	public void setVetor(int indice, DadosDoCadastro novo) {
		this.vetor[indice] = novo;
	}

	public void setQuantVet(int novo) {
		this.quantVet = novo;
	}

	public boolean eVazio() {
		return this.quantVet == 0;
	}

	public boolean eCheio() {
		return this.quantVet == this.vetor.length;
	}

	public boolean inserir(DadosDoCadastro novo) {
		if (this.eCheio()) {
			return false;
		} else {
			this.vetor[this.quantVet] = novo;
			this.quantVet++;
			return true;
		}
	}

	public String toString() {
		String msg = "";
		for (int i = 0; i < this.quantVet; i++) {
			msg += this.vetor[i].getCpf() + ";" + this.vetor[i].getInscricao() + ";" + this.vetor[i].getValor() + ";"
					+ this.vetor[i].isPago() + "\n";
		}
		return msg;
	}

	public int comparar(DadosDoCadastro dados1, DadosDoCadastro dados2) {
		if (dados1.getCpf().compareTo(dados2.getCpf()) < 0) {
			return -1;
		} else if (dados1.getCpf().compareTo(dados2.getCpf()) > 0) {
			return 1;
		} else if (dados1.getInscricao().compareTo(dados2.getInscricao()) < 0) {
			return -1;
		} else if (dados1.getInscricao().compareTo(dados2.getInscricao()) > 0) {
			return 1;
		} else {
			return 0;
		}

	}

	// HeapSort ordenação
	public void heapSort() {
		int dir = quantVet - 1;
		int esq = (dir - 1) / 2;
		DadosDoCadastro temp;

		while (esq >= 0) {
			refazHeap(esq, this.quantVet - 1);
			esq--;
		}
		while (dir > 0) {
			temp = this.vetor[0];
			this.vetor[0] = this.vetor[dir];
			this.vetor[dir] = temp;
			dir--;
			refazHeap(0, dir);
		}
	}

	private void refazHeap(int esq, int dir) {
		int i = esq;
		int mF = 2 * i + 1; // maior filho
		DadosDoCadastro raiz = this.vetor[i];
		boolean heap = false;

		while ((mF <= dir) && (!heap)) {
			if (mF < dir) {
				// verifica se tem um valor a direito do maior filho
				// se tiver o maior filhor passa a ser o próximo valor
				// seria o 2i+2

				if (comparar(this.vetor[mF], this.vetor[mF + 1]) < 0) {
					mF++;
				}
			}
			// Se a raiz for menor que o maior filho, ocorre a troca. Volta e verifica se
			// sub-árvore continuará heap
			if (comparar(raiz, this.vetor[mF]) < 0) {
				this.vetor[i] = this.vetor[mF];
				i = mF;
				mF = 2 * i + 1;
			} else
				heap = true;
		}

		this.vetor[i] = raiz;
	}

	// pesquisa binária por cpf
	public int pesqBinaria(String chave) {
		int meio, esq, dir;
		esq = 0;
		dir = this.quantVet - 1;
		while (esq <= dir) {
			meio = (esq + dir) / 2;
			if (chave.equals(this.vetor[meio].getCpf()))
				return meio;
			else {
				if (chave.compareTo(this.vetor[meio].getCpf()) < 0)
					dir = meio - 1;
				else
					esq = meio + 1;
			}
		}
		return -1;
	}

	public String pesquisarCpfImovel() {
		int indice = 0;
		Double imposto1 = 0.0;
		Double imposto2 = 0.0;
		Double imposto3 = 0.0;
		String msg = "";
		
		String[] vetorCpf = pesquisarCpf(); // vetor com dados do Imovel.txt
		// variavel para pegar o vetor do Imovel.txt
		String cpf = "";
	
		for (int i = 0; i < vetorCpf.length; i++) {
			cpf = vetorCpf[i];
			indice = pesqBinaria(cpf);
//			System.out.println(indice);
			if (indice != -1) {
				if (this.vetor[indice].getCpf().equals(this.vetor[indice - 1].getCpf())
						&& this.vetor[indice].getCpf().equals(this.vetor[indice + 1].getCpf())) {
					
					imposto1=this.vetor[indice-1].getValor()+this.vetor[indice].getValor()+this.vetor[indice+1].getValor();
					
					
					msg += "\nCPF " + this.vetor[indice].getCpf() + ":\n" + "Inscr: "
							+ this.vetor[indice - 1].getInscricao() + " Imposto: " + this.vetor[indice - 1].getValor()
							+ (this.vetor[indice-1].isPago()==true? " PAGO":" NÃO PAGO") + "\n" + "Inscr: " + this.vetor[indice].getInscricao() + " Imposto: "
							+ this.vetor[indice].getValor() + (this.vetor[indice].isPago()==true? " PAGO":" NÃO PAGO") + "\n" + "Inscr: "
							+ this.vetor[indice + 1].getInscricao() + " Imposto: " + this.vetor[indice + 1].getValor()
							+ (this.vetor[indice+1].isPago()==true? " PAGO":" NÃO PAGO")+"\n"+
							"Total Imposto a pagar: "+(imposto1)+"\n";
				
				}else {
					//Verificar se tem igual a esquerda
					if(this.vetor[indice].getCpf().equals(this.vetor[indice - 1].getCpf())) {
						imposto2=this.vetor[indice-1].getValor()+this.vetor[indice].getValor();
						
						msg += "\nCPF " + this.vetor[indice].getCpf() + ":\n" + "Inscr: "
								+ this.vetor[indice - 1].getInscricao() + " Imposto: " + this.vetor[indice - 1].getValor()
								+ (this.vetor[indice-1].isPago()==true? " PAGO":" NÃO PAGO") + "\n" + "Inscr: " + this.vetor[indice].getInscricao() + " Imposto: "
								+ this.vetor[indice].getValor() + (this.vetor[indice].isPago()==true? " PAGO":" NÃO PAGO") + "\n"+
								"Total Imposto a pagar: "+(imposto2)+"\n";
					}else {
						//Verificar se tem igual a direita
						if(this.vetor[indice].getCpf().equals(this.vetor[indice + 1].getCpf())) {
							imposto3=this.vetor[indice+1].getValor()+this.vetor[indice].getValor();
							msg += "\nCPF " + this.vetor[indice].getCpf() + ":\n" + "Inscr: "
									+ this.vetor[indice + 1].getInscricao() + " Imposto: " + this.vetor[indice +1].getValor()
									+ (this.vetor[indice+1].isPago()==true? " PAGO":" NÃO PAGO") + "\n" + "Inscr: " + this.vetor[indice].getInscricao() + " Imposto: "
									+ this.vetor[indice].getValor() + (this.vetor[indice].isPago()==true? " PAGO":" NÃO PAGO") + "\n"+
									"Total Imposto a pagar: "+(imposto3)+"\n";
						}
					}	
				}
				
			}else {
				if(indice==-1) {
					msg += "\nCPF " + cpf+":\n"+"NÃO HÁ NENHUM REGISTRO COM O CPF"+ cpf+"\n";
				}
			}
			
		}
//		System.out.println(msg);
		return msg;
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

}
