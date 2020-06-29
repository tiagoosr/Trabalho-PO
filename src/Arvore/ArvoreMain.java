package Arvore;

import java.io.IOException;

import heap_quick.GravaArquivo;

public class ArvoreMain {
	static String tipoDoArquivo[] = { "Alea", "Inv", "Ord" };
	static String lerArquivos = "./src/arquivosDeTeste/Imovel";
	static String gravarArquivos = "./arquivosGerados/";
	static String tamanhodoDeRegistro[] = { "500", "1000", "5000", "10000", "50000" };
	static int quantidadeDeRegistro[] = { 500, 1000, 5000, 10000, 50000 };
	static LeArquivo ler = null;
	static GravaArquivo gravarCpfPesquisado, gravarResultadoDaMedia = null;

	static ArvoreBB arvoreBB = null;
	static ArvoreAVL avl = null;
	static TabelaOrd vetorOrdenado;

	public static void main(String[] args) throws IOException {

		long tempoInicial;
		long tempoFinal;
		long tempoTotal = 0;
		long mediaDotempoGasto = 0;
		String mediaDotempoGastoEmString;
		
		//abb
		for (int i = 0; i < tamanhodoDeRegistro.length - 1; i++) {
			tempoInicial = System.currentTimeMillis();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 3; k++) {
					ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[i] + tipoDoArquivo[k] + ".txt");
					gravarCpfPesquisado = new GravaArquivo(gravarArquivos + "arquivosPesquisados/Abb-AVL/" + "ABB"
							+ tipoDoArquivo[k] + tamanhodoDeRegistro[i] + ".txt");

					arvoreBB = ler.leArquivo(quantidadeDeRegistro[i]);
					vetorOrdenado = new TabelaOrd(quantidadeDeRegistro[i]);// passa um tamanho para o vetor.
					arvoreBB.CamCentral(vetorOrdenado);// metodo para ordenar e inserir no vetor.
					arvoreBB.ArvoreBalanceada(vetorOrdenado);// metodo para pegar o elemento no vetor e montar a arvore
																// balanceada.
					ler.fecharArquivo();

					gravarCpfPesquisado.gravaArquivo((arvoreBB.pesquisarCpfImovel()));
					gravarCpfPesquisado.fechaArquivo();
				}
			}
			tempoFinal = System.currentTimeMillis();
			tempoTotal = tempoFinal - tempoInicial;
			mediaDotempoGasto = tempoTotal / 5;

			mediaDotempoGastoEmString = "Media: " + Long.toString(mediaDotempoGasto);
			gravarResultadoDaMedia = new GravaArquivo(
					gravarArquivos + "mediaDeTempo/" + "ABB" + tamanhodoDeRegistro[i] + ".txt");
			gravarResultadoDaMedia.gravaArquivo(mediaDotempoGastoEmString);
			gravarResultadoDaMedia.fechaArquivo();
			System.out.println("Tempo de execução: ABB " + i + " " + mediaDotempoGastoEmString + " ms");
		}
		//ABB 50000
		for (int i = 4; i < tamanhodoDeRegistro.length; i++) {
			tempoInicial = System.currentTimeMillis();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 1; k++) {
					ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[i] + tipoDoArquivo[k] + ".txt");
					gravarCpfPesquisado = new GravaArquivo(gravarArquivos + "arquivosPesquisados/Abb-AVL/" + "ABB"
							+ tipoDoArquivo[k] + tamanhodoDeRegistro[i] + ".txt");

					arvoreBB = ler.leArquivo(quantidadeDeRegistro[i]);
					vetorOrdenado = new TabelaOrd(quantidadeDeRegistro[i]);// passa um tamanho para o vetor.
					arvoreBB.CamCentral(vetorOrdenado);// metodo para ordenar e inserir no vetor.
					arvoreBB.ArvoreBalanceada(vetorOrdenado);// metodo para pegar o elemento no vetor e montar a arvore
																// balanceada.
					ler.fecharArquivo();

					gravarCpfPesquisado.gravaArquivo((arvoreBB.pesquisarCpfImovel()));
					gravarCpfPesquisado.fechaArquivo();
				}
			}
			tempoFinal = System.currentTimeMillis();
			tempoTotal = tempoFinal - tempoInicial;
			mediaDotempoGasto = tempoTotal / 5;

			mediaDotempoGastoEmString = "Media: " + Long.toString(mediaDotempoGasto);
			gravarResultadoDaMedia = new GravaArquivo(gravarArquivos + "mediaDeTempo/" + "ABB" + tamanhodoDeRegistro[i] + ".txt");
			gravarResultadoDaMedia.gravaArquivo(mediaDotempoGastoEmString);
			gravarResultadoDaMedia.fechaArquivo();
			System.out.println("Tempo de execução: ABB " + i + " " + mediaDotempoGastoEmString + " ms\n");
		}
		
		//AVL
		for (int i = 0; i < tamanhodoDeRegistro.length; i++) {
			tempoInicial = System.currentTimeMillis();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 3; k++) {

					ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[i] + tipoDoArquivo[k] + ".txt");
					gravarCpfPesquisado = new GravaArquivo(gravarArquivos + "arquivosPesquisados/Abb-AVL/" + "AVL" + tipoDoArquivo[k] + tamanhodoDeRegistro[i] + ".txt");

					avl = ler.leArquivoAvl(quantidadeDeRegistro[i]);
					avl.pesquisarCpfImovel();
					ler.fecharArquivo();

					gravarCpfPesquisado.gravaArquivo((avl.pesquisarCpfImovel()));
					gravarCpfPesquisado.fechaArquivo();
				}
			}
			tempoFinal = System.currentTimeMillis();
			tempoTotal = tempoFinal - tempoInicial;
			mediaDotempoGasto = tempoTotal / 5;

			mediaDotempoGastoEmString = "Media: " + Long.toString(mediaDotempoGasto);
			gravarResultadoDaMedia = new GravaArquivo( gravarArquivos + "mediaDeTempo/" + "AVL" + tamanhodoDeRegistro[i] + ".txt");
			gravarResultadoDaMedia.gravaArquivo(mediaDotempoGastoEmString);
			gravarResultadoDaMedia.fechaArquivo();
			System.out.println("Tempo de execução: AVL " + i + " " + mediaDotempoGastoEmString + " ms");
		}

	}

}
