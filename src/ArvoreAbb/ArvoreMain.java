package ArvoreAbb;

import java.io.IOException;


public class ArvoreMain {
	static String tipoDoArquivo[] = { "Alea", "Inv", "Ord" };
	static String lerArquivos = "./src/arquivosDeTeste/Imovel";
	static String gravarArquivos = "./arquivosGerados/";
	static String tamanhodoDeRegistro[] = { "500", "1000", "5000", "10000", "50000" };
	static int quantidadeDeRegistro[] = { 500, 1000, 5000, 10000, 50000 };
	static LeArquivo ler = null;
//	static GravaArquivo gravarRegistroOrdenado, gravarCpfPesquisado, gravarResultadoDaMedia = null;
	
	static Arvore arvore = null;
	static TabelaOrd vetorOrdenado;
	public static void main(String[] args) throws IOException {
		
		ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[0] + tipoDoArquivo[0] + ".txt");
		arvore = ler.leArquivo(500);//ler o arquivo de tammanho n.
		vetorOrdenado = new TabelaOrd(quantidadeDeRegistro[0]);//passa um tamanho para o vetor.
		arvore.CamCentral(vetorOrdenado);//metodo para ordenar e inserir no vetor.
		arvore.ArvoreBalanceada(vetorOrdenado);//metodo para pegar o elemento no vetor e montar a arvore balanceada.

		System.out.println(arvore.pesuisarCpfImovel());
//		arvore.pesuisarCpfImovel();
//		System.out.println(vetorOrdenado.resultado());
	}

}
