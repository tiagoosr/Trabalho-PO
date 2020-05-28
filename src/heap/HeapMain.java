package heap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import dados.DadosDoCadastro;

public class HeapMain {
	public static void main(String[] args) throws IOException {
		long tempoInicial;
        long tempoFinal;
        long tempoGasto;
		LeArquivo ler = new LeArquivo("./src/arquivosDeTeste/imovel500alea.txt");
		GravaArquivo gravar = new GravaArquivo("./src/arquivosAlterados/imovel500alea.txt");
		
		tempoInicial = System.currentTimeMillis();
		
		//vetor receber o tamanho 500 e vetor recebe os dados e parametros do metodo lerAruivos.
		CadastroImobiliadrioVetor vetor = ler.leArquivo(500);
		
		vetor.heapSort();
		System.out.println(vetor.toString());
		
		gravar.gravaArquivo(vetor.toString());
		
		ler.fecharArquivo();
		gravar.fechaArquivo();
		
		tempoFinal = System.currentTimeMillis();
		tempoGasto = (tempoFinal-tempoInicial);
		System.out.println("Tempo de execução: "+tempoGasto+" ms" );
	}
	
}
