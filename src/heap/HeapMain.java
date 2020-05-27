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
		LeArquivo ler = new LeArquivo("./src/arquivosDeTeste/imovel500alea.txt");
		GravaArquivo gravar = new GravaArquivo("./src/arquivosAlterados/teste1.txt");
		
		//vetor receber o tamanho 500 e vetor recebe os dados e parametros do metodo lerAruivos.
		CadastroImobiliadrioVetor vetor = ler.leArquivo(500);
		
		vetor.heapSort();
		System.out.println(vetor.toString());
		
		gravar.gravaArquivo(vetor.toString());
		
		ler.fecharArquivo();
		gravar.fechaArquivo();
	}
	
}
