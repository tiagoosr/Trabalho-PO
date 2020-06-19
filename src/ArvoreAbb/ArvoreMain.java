package ArvoreAbb;

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
	
	static Arvore arvore = null;
	static ArvoreAVL avl = null ;
	static TabelaOrd vetorOrdenado;
	public static void main(String[] args) throws IOException {
		
		long tempoInicial;
		long tempoFinal;
		long tempoTotal = 0;
		long mediaDotempoGasto = 0;
		String mediaDotempoGastoEmString;
		
//		ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[0] + tipoDoArquivo[0] + ".txt");
//		arvore = ler.leArquivo(500);//ler o arquivo de tammanho n.
//		vetorOrdenado = new TabelaOrd(quantidadeDeRegistro[0]);//passa um tamanho para o vetor.
//		arvore.CamCentral(vetorOrdenado);//metodo para ordenar e inserir no vetor.
//		arvore.ArvoreBalanceada(vetorOrdenado);//metodo para pegar o elemento no vetor e montar a arvore balanceada.
////		
//		gravarCpfPesquisado = new GravaArquivo(gravarArquivos+"arquivosPesquisados/" + "QuickPesquisado"+tipoDoArquivo[0] +tamanhodoDeRegistro[0] +".txt");
//		System.out.println(arvore.pesquisarCpfImovel());
//		arvore.pesquisarCpfImovel();
//		System.out.println(vetorOrdenado.resultado());
		
		for (int i = 0; i < tamanhodoDeRegistro.length; i++) {
			tempoInicial = System.currentTimeMillis();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 3; k++) {
					ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[i] + tipoDoArquivo[k] + ".txt");
					gravarCpfPesquisado = new GravaArquivo(gravarArquivos+"arquivosPesquisados/Abb-AVL/" + "ABB"+tipoDoArquivo[k] +tamanhodoDeRegistro[i]+".txt");
		
					arvore = ler.leArquivo(quantidadeDeRegistro[i]);
					vetorOrdenado = new TabelaOrd(quantidadeDeRegistro[i]);//passa um tamanho para o vetor.
					arvore.CamCentral(vetorOrdenado);//metodo para ordenar e inserir no vetor.
					arvore.ArvoreBalanceada(vetorOrdenado);//metodo para pegar o elemento no vetor e montar a arvore balanceada.
					ler.fecharArquivo();
					
					gravarCpfPesquisado.gravaArquivo((arvore.pesquisarCpfImovel()));
					gravarCpfPesquisado.fechaArquivo();
				}		
			}
			tempoFinal = System.currentTimeMillis();
			tempoTotal = tempoFinal-tempoInicial;
			mediaDotempoGasto = tempoTotal / 5;
			
			mediaDotempoGastoEmString = "Media: "+Long.toString(mediaDotempoGasto);
			gravarResultadoDaMedia = new GravaArquivo(gravarArquivos+"mediaDeTempo/"+"ABB"+tamanhodoDeRegistro[i]+".txt");
			gravarResultadoDaMedia.gravaArquivo(mediaDotempoGastoEmString);
			gravarResultadoDaMedia.fechaArquivo();
			System.out.println("Tempo de execução: ABB " + i +" "+ mediaDotempoGastoEmString + " ms");
		}
		
//		for (int i = 0; i < tamanhodoDeRegistro.length; i++) {
//			tempoInicial = System.currentTimeMillis();
//			for (int j = 0; j < 5; j++) {
//				for (int k = 0; k < 3; k++) {
//					
//					ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[i] + tipoDoArquivo[k] + ".txt");
//					gravarCpfPesquisado = new GravaArquivo(gravarArquivos+"arquivosPesquisados/Abb-AVL/" + "AVL"+tipoDoArquivo[k] +tamanhodoDeRegistro[i]+".txt");
//		
//					avl = ler.leArquivoAvl(quantidadeDeRegistro[i]);
//					avl.pesquisarCpfImovel();
//					ler.fecharArquivo();
//					
//					gravarCpfPesquisado.gravaArquivo((avl.pesquisarCpfImovel()));
//					gravarCpfPesquisado.fechaArquivo();
//				}		
//			}
//			tempoFinal = System.currentTimeMillis();
//			tempoTotal = tempoFinal-tempoInicial;
//			mediaDotempoGasto = tempoTotal / 5;
//			
//			mediaDotempoGastoEmString = "Media: "+Long.toString(mediaDotempoGasto);
//			gravarResultadoDaMedia = new GravaArquivo(gravarArquivos+"mediaDeTempo/"+"ABB"+tamanhodoDeRegistro[i]+".txt");
//			gravarResultadoDaMedia.gravaArquivo(mediaDotempoGastoEmString);
//			gravarResultadoDaMedia.fechaArquivo();
//			System.out.println("Tempo de execução: ABB " + i +" "+ mediaDotempoGastoEmString + " ms");
//		}
		
		
//		ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[0] + tipoDoArquivo[0] + ".txt");
//		avl = ler.leArquivoAvl(500);//ler o arquivo de tammanho n.
//		System.out.println(avl.pesquisarCpfImovel());
//		vetorOrdenado = new TabelaOrd(quantidadeDeRegistro[0]);//passa um tamanho para o vetor.
//		arvore.CamCentral(vetorOrdenado);//metodo para ordenar e inserir no vetor.
//		arvore.ArvoreBalanceada(vetorOrdenado);//metodo para pegar o elemento no vetor e montar a arvore balanceada.
		
//		gravarCpfPesquisado = new GravaArquivo(gravarArquivos+"arquivosPesquisados/" + "QuickPesquisado"+tipoDoArquivo[k] +tamanhodoDeRegistro[i] +".txt");
//		System.out.println(arvore.pesuisarCpfImovel());
//		arvore.pesuisarCpfImovel();
//		System.out.println(vetorOrdenado.resultado());
		
	}

}
