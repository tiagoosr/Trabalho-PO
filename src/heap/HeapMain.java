package heap;

import java.io.*;

public class HeapMain {
	static String tipoDoArquivo[] = { "Alea", "Inv", "Ord" };
	static String lerArquivos = "./src/arquivosDeTeste/Imovel";
	static String gravarArquivos = "./src/arquivosAlterados/";
	static String tamanhodoDeRegistro[] = { "500", "1000", "5000", "10000", "50000" };
	static int quantidadeDeRegistro[] = { 500, 1000, 5000, 10000, 50000 };
	static LeArquivo ler = null;
	static GravaArquivo gravarRegistroOrdenado, gravarCpfPesquisado = null;
	static CadastroImobiliadrioVetor vetor = null;

	public static void main(String[] args) throws IOException {
		long tempoInicial;
		long tempoFinal = 0;
		long tempoGasto = 0;
		long mediaDotempoGasto = 0;
		tempoInicial = System.currentTimeMillis();

//        int cont=0;
//        for(int i=0;i<tamanhodoDeRegistro.length;i++) {
////        	System.out.println(i);
//        	for(int j=0;j<5;j++) {
//        		for(int k=0;k<3;k++) {
////        			System.out.println("teste"+lerArquivos+tamanhodoDeRegistro[i]+tipoDoArquivo[k]+".txt");
//        			
//        		}
//        		cont++;
//        	}
//        	
//        }
//        System.out.println(cont);
		
		//HeapSort + Pesquisa Binária
		for (int i = 0; i < 5; i++) {
			for (int j = 0, k = 0; j < 3; j++) {
//        		System.out.println("teste"+lerArquivos+tamanhodoDeRegistro[k]+tipoDoArquivo[j]+".txt");
				ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[k] + tipoDoArquivo[j] + ".txt");
				gravarRegistroOrdenado = new GravaArquivo(gravarArquivos + "Heap" + tipoDoArquivo[j] + tamanhodoDeRegistro[k] + ".txt");
				gravarCpfPesquisado = new GravaArquivo(gravarArquivos + "HeapPesquisado.txt");
//        		gravarCpfPesquisado = new GravaArquivo("./src/arquivosAlterados/imovelPesquisado.txt");

				// vetor receber o tamanho 500 e vetor recebe os dados e parametros do metodo
				vetor = ler.leArquivo(quantidadeDeRegistro[k]);

				vetor.heapSort();
//        		System.out.println(vetor.toString());

				gravarRegistroOrdenado.gravaArquivo(vetor.toString());
				gravarCpfPesquisado.gravaArquivo((vetor.pesquisarCpfImovel()));
				ler.fecharArquivo();
				gravarRegistroOrdenado.fechaArquivo();
				gravarCpfPesquisado.fechaArquivo();

			}
			tempoFinal = System.currentTimeMillis();
			tempoGasto += (tempoFinal - tempoInicial);

		}

//		tempoFinal = System.currentTimeMillis();
		mediaDotempoGasto = tempoGasto / 5;
		System.out.println("Tempo de execução: " + tempoGasto + " ms");
		System.out.println("Tempo de execução: " + mediaDotempoGasto + " ms");
		
		// QuickSort + Pesquisa Binária
		for (int i = 0; i < 5; i++) {
			for (int j = 0, k = 0; j < 3; j++) {
////	        		System.out.println("teste"+lerArquivos+tamanhodoDeRegistro[k]+tipoDoArquivo[j]+".txt");
				ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[k] + tipoDoArquivo[j] + ".txt");
				gravarRegistroOrdenado = new GravaArquivo(gravarArquivos + "Quick" + tipoDoArquivo[j] + tamanhodoDeRegistro[k] + ".txt");
				gravarCpfPesquisado = new GravaArquivo(gravarArquivos + "QuickPesquisado.txt");

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
			tempoFinal = System.currentTimeMillis();
			tempoGasto += (tempoFinal - tempoInicial);
		}

	}

}
