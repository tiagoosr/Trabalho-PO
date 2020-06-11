package ArvoreAbb;

import java.io.IOException;

import dados.DadosDoCadastro;

public class ArvoreMain {
	static String tipoDoArquivo[] = { "Alea", "Inv", "Ord" };
	static String lerArquivos = "./src/arquivosDeTeste/Imovel";
	static String gravarArquivos = "./arquivosGerados/";
	static String tamanhodoDeRegistro[] = { "500", "1000", "5000", "10000", "50000" };
	static int quantidadeDeRegistro[] = { 500, 1000, 5000, 10000, 50000 };
	static LeArquivo ler = null;
//	static GravaArquivo gravarRegistroOrdenado, gravarCpfPesquisado, gravarResultadoDaMedia = null;
	
	static Arvore arvore = null;

	public static void main(String[] args) throws IOException {
		ler = new LeArquivo(lerArquivos + tamanhodoDeRegistro[0] + tipoDoArquivo[0] + ".txt");
		arvore = ler.leArquivo(500);
		
	}

}
