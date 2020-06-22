package hashingEncadeado;

import java.io.IOException;

public class HashingMain {
	static String tipoDoArquivo[] = { "Alea", "Inv", "Ord" };
	static String lerArquivos = "./src/arquivosDeTeste/Imovel";
	static String gravarArquivos = "./arquivosGerados/";
	static String tamanhodoDeRegistro[] = { "500", "1000", "5000", "10000", "50000" };
	static int quantidadeDeRegistro[] = { 500, 1000, 5000, 10000, 50000 };
	static LeArquivo ler = null;
	static GravaArquivo gravarRegistroOrdenado, gravarCpfPesquisado, gravarResultadoDaMedia = null;
//	static CadastroImobiliadrioVetor vetor = null;
//	static VetorHashing vetorHashing = null;
	public static void main(String[] args) throws IOException {
//		CadastroImobiliadrioVetor vetor = new CadastroImobiliadrioVetor(quantidadeDeRegistro[i]+(quantidadeDeRegistro[i]*10/100)+1);//+1 por causa do 499+1=500,
		int tamanhoDoHashing=0;
		long tempoInicial;
		long tempoFinal;
		long tempoTotal = 0;
		long mediaDotempoGasto = 0;
		String mediaDotempoGastoEmString;

//		for (int i = 0; i < tamanhodoDeRegistro.length; i++) {
			tempoInicial = System.currentTimeMillis();
//			for (int j = 0; j < 5; j++) {
//				for (int k = 0; k < 3; k++) {
					VetorHashing vetorHashing = new VetorHashing(quantidadeDeRegistro[0]+(quantidadeDeRegistro[0]*10/100)+1);
					tamanhoDoHashing=vetorHashing.acumuladorN(quantidadeDeRegistro[0]+(quantidadeDeRegistro[0]*10/100));
					ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[0] + tipoDoArquivo[0] + ".txt");			
					//gravarCpfPesquisado = new GravaArquivo(gravarArquivos + "arquivosPesquisados/" + "HeapPesquisado"+ tipoDoArquivo[k] + tamanhodoDeRegistro[i] + ".txt");
					
					// vetor receber o tamanho N e vetor recebe os dados e parametros do metodo

					vetorHashing = ler.leArquivo(tamanhoDoHashing);
					
					
					//gravarCpfPesquisado.gravaArquivo((vetor.pesquisarCpfImovel()));
					ler.fecharArquivo();				
					//gravarCpfPesquisado.fechaArquivo();
//				}
//			}
			tempoFinal = System.currentTimeMillis();
			tempoTotal = tempoFinal - tempoInicial;
			mediaDotempoGasto = tempoTotal / 5;

			mediaDotempoGastoEmString = "Media: " + Long.toString(mediaDotempoGasto);
			//gravarResultadoDaMedia = new GravaArquivo(gravarArquivos + "mediaDeTempo/" + "Heap" + tamanhodoDeRegistro[i] + ".txt");
			//gravarResultadoDaMedia.gravaArquivo(mediaDotempoGastoEmString);
			//gravarResultadoDaMedia.fechaArquivo();
//			System.out.println("Tempo de execução: Heap " + i + " " + mediaDotempoGastoEmString + " ms");
		}

//	}

}
