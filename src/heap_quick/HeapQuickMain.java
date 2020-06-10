package heap_quick;

import java.io.*;

public class HeapQuickMain {
	static String tipoDoArquivo[] = { "Alea", "Inv", "Ord" };
	static String lerArquivos = "./src/arquivosDeTeste/Imovel";
	static String gravarArquivos = "./arquivosGerados/";
	static String tamanhodoDeRegistro[] = { "500", "1000", "5000", "10000", "50000" };
	static int quantidadeDeRegistro[] = { 500, 1000, 5000, 10000, 50000 };
	static LeArquivo ler = null;
	static GravaArquivo gravarRegistroOrdenado, gravarCpfPesquisado, gravarResultadoDaMedia = null;
	static CadastroImobiliadrioVetor vetor = null;

	public static void main(String[] args) throws IOException {
		long tempoInicial;
		long tempoFinal;
		long tempoTotal = 0;
		long mediaDotempoGasto = 0;
		String mediaDotempoGastoEmString;
	

		System.out.println("HeapSort + Pesquisa Binaria");
		// HeapSort + Pesquisa Binaria
		for (int i = 0; i < tamanhodoDeRegistro.length; i++) {
			tempoInicial = System.currentTimeMillis();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 3; k++) {
//					System.out.println("teste" + lerArquivos + tamanhodoDeRegistro[i] + tipoDoArquivo[k] + ".txt");
					ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[i] + tipoDoArquivo[k] + ".txt");
					gravarRegistroOrdenado = new GravaArquivo(gravarArquivos+"arquivosOrdenados/"+"Heap" + tipoDoArquivo[k] + tamanhodoDeRegistro[i] + ".txt");
					gravarCpfPesquisado = new GravaArquivo(gravarArquivos+"arquivosPesquisados/" + "HeapPesquisado"+tipoDoArquivo[k] +tamanhodoDeRegistro[i]+".txt");
					
					// vetor receber o tamanho N e vetor recebe os dados e parametros do metodo
					vetor = ler.leArquivo(quantidadeDeRegistro[i]);

					vetor.heapSort();

					gravarRegistroOrdenado.gravaArquivo(vetor.toString());
					gravarCpfPesquisado.gravaArquivo((vetor.pesquisarCpfImovel()));
					ler.fecharArquivo();
					gravarRegistroOrdenado.fechaArquivo();
					gravarCpfPesquisado.fechaArquivo();
				}		
			}
			tempoFinal = System.currentTimeMillis();
			tempoTotal = tempoFinal-tempoInicial;
			mediaDotempoGasto = tempoTotal / 5;
			
			mediaDotempoGastoEmString = "Media: "+Long.toString(mediaDotempoGasto);
			gravarResultadoDaMedia = new GravaArquivo(gravarArquivos+"mediaDeTempo/"+"Heap"+tamanhodoDeRegistro[i]+".txt");
			gravarResultadoDaMedia.gravaArquivo(mediaDotempoGastoEmString);
			gravarResultadoDaMedia.fechaArquivo();
			System.out.println("Tempo de execução: Heap " + i +" "+ mediaDotempoGastoEmString + " ms");
		}
	
		
		System.out.println("QuickSort + Pesquisa Binaria");
		// QuickSort + Pesquisa Binária
		for (int i = 0; i < tamanhodoDeRegistro.length; i++) {
			tempoInicial = System.currentTimeMillis();
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 3; k++) {
//					System.out.println("teste" + lerArquivos + tamanhodoDeRegistro[i] + tipoDoArquivo[k] + ".txt");
					
					ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[i] + tipoDoArquivo[k] + ".txt");
					gravarRegistroOrdenado = new GravaArquivo(gravarArquivos+"arquivosOrdenados/" + "Quick" + tipoDoArquivo[k] + tamanhodoDeRegistro[i] + ".txt");
					gravarCpfPesquisado = new GravaArquivo(gravarArquivos+"arquivosPesquisados/" + "QuickPesquisado"+tipoDoArquivo[k] +tamanhodoDeRegistro[i] +".txt");
					// vetor receber o tamanho N e vetor recebe os dados e parametros do metodo
					vetor = ler.leArquivo(quantidadeDeRegistro[i]);

					vetor.quicksort();
					
					gravarRegistroOrdenado.gravaArquivo(vetor.toString());
					gravarCpfPesquisado.gravaArquivo((vetor.pesquisarCpfImovel()));
					ler.fecharArquivo();
					gravarRegistroOrdenado.fechaArquivo();
					gravarCpfPesquisado.fechaArquivo();		
				}		
			}
			
			tempoFinal = System.currentTimeMillis();
			tempoTotal = tempoFinal-tempoInicial;
			mediaDotempoGasto = tempoTotal / 5;
			
			mediaDotempoGastoEmString = "Media: "+Long.toString(mediaDotempoGasto);
			gravarResultadoDaMedia = new GravaArquivo(gravarArquivos+"mediaDeTempo/" + "Quick"+tamanhodoDeRegistro[i]+".txt");
			gravarResultadoDaMedia.gravaArquivo(mediaDotempoGastoEmString);
			gravarResultadoDaMedia.fechaArquivo();
			System.out.println("Tempo de execução: Quick " + i +" "+ mediaDotempoGastoEmString + " ms");
		}
	
/*
		// QuickSort + Pesquisa Binária
		tempoInicial = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			for (int j = 0, k = 0; j < 3; j++) {
//	        	System.out.println("teste"+lerArquivos+tamanhodoDeRegistro[k]+tipoDoArquivo[j]+".txt");
				

				// vetor receber o tamanho 500 e vetor recebe os dados e parametros do metodo
				vetor = ler.leArquivo(quantidadeDeRegistro[k]);

				vetor.quicksort();
//	        	system.out.println(vetor.toString());

				gravarRegistroOrdenado.gravaArquivo(vetor.toString());
				gravarCpfPesquisado.gravaArquivo((vetor.pesquisarCpfImovel()));
				ler.fecharArquivo();
				gravarRegistroOrdenado.fechaArquivo();
				gravarCpfPesquisado.fechaArquivo();

			}
			
		}
		tempoFinal = System.currentTimeMillis();
		tempoTotal = tempoFinal-tempoInicial;
		mediaDotempoGasto = tempoTotal / 5;
		System.out.println("Tempo de execução: " + mediaDotempoGasto + " ms");
		*/
	}

}
