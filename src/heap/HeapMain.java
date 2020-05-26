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
		String teste = "";
		LeArquivo ler = new LeArquivo("./src/arquivosDeTeste/imovel500alea.txt");
//		ler.leArquivo(500);
		GravaArquivo gravar = new GravaArquivo("./src/arquivosAlterados/teste2.txt");
		
	
		teste = ler.leArquivo(500).toString();
		System.out.println(teste);
		
		gravar.gravaArquivo(teste);
		
		ler.fecharArquivo();
		gravar.fechaArquivo();
	}
	
}
