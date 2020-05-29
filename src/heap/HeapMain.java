package heap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import dados.DadosDoCadastro;
	
public class HeapMain {
	
	static LeArquivo ler=null;
	static GravaArquivo gravar=null;
	static CadastroImobiliadrioVetor vetor=null;
	
	public static void main(String[] args) throws IOException {
		long tempoInicial;
        long tempoFinal;
        long tempoGasto;
		
        tempoInicial = System.currentTimeMillis();
        ler = new LeArquivo("./src/arquivosDeTeste/imovel500alea.txt");
		gravar = new GravaArquivo("./src/arquivosAlterados/imovel500alea.txt");
	
		//vetor receber o tamanho 500 e vetor recebe os dados e parametros do metodo lerAruivos.
		vetor = ler.leArquivo(500);
		
		vetor.heapSort();
//		System.out.println(vetor.toString());

		gravar.gravaArquivo(vetor.toString());
		vetor.pesquisarCpfImovel();
		ler.fecharArquivo();
		gravar.fechaArquivo();
		
		tempoFinal = System.currentTimeMillis();
		tempoGasto = (tempoFinal-tempoInicial);
//		System.out.println("Tempo de execução: "+tempoGasto+" ms" );
	}
	

}
