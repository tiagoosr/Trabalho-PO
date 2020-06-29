package Arvore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import dados.DadosDoCadastro;

public class LeArquivo {
	// objeto do tipo Scanner para realizar a leitura dos dados do arquivo.
	private Scanner entrada;
	
	public LeArquivo(String nome) throws FileNotFoundException {
		try {
			// Instanciamento do objeto do tipo Scanner, tendo como argumento File que será
			// o arquivo que será lido
			this.entrada = new Scanner(new File(nome));
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException(e+"ARQUIVO NAO ENCONTRADO");
		}
	}
	
	
	// Metodo para ler os dados contidos no arquivo
	public ArvoreBB leArquivo(int tamanho) throws NoSuchElementException, ArrayIndexOutOfBoundsException {
		ArvoreBB cadastro = new ArvoreBB();	
		
		String linha;
		try {
			while (this.entrada.hasNext()) {
				// A função hasNext() indica se ainda existe uma String
				// para ser lida.
				
				linha = this.entrada.nextLine();
				// A função nextLine() devolve a próxima linha como
				// uma String.
							
				cadastro.inserir(separaDados(linha));
				
//				System.out.println(cadastro.toString("07074426629"));	
			}
			return cadastro;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Arquivo corrompido");
		}
		
		
	}
	
	public ArvoreAVL leArquivoAvl(int tamanho)
			throws NoSuchElementException, ArrayIndexOutOfBoundsException {
		ArvoreAVL cadastro = new ArvoreAVL();	
		
		String linha;
		try {
			while (this.entrada.hasNext()) {
				// A função hasNext() indica se ainda existe uma String
				// para ser lida.
				
				linha = this.entrada.nextLine();
				// A função nextLine() devolve a próxima linha como
				// uma String.
							
				cadastro.insereRaiz(separaDados(linha));
				
//				System.out.println(cadastro.toString("07074426629"));	
			}
			return cadastro;
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new ArrayIndexOutOfBoundsException("Arquivo corrompido");
		}
		
		
	}

	// Metodo para transformar uma linha do arquivo em um objeto
	private DadosDoCadastro separaDados(String linha) throws NoSuchElementException {
		String[] dados;
		String cpf, inscricao;
		double valor;
		boolean pago;

		try {
			dados = linha.split(";");
			// O método split quebra uma String em várias substrings a partir
			// do caracter definido como argumento,nesse caso ";", cria
			// um vetor de String e armazena cada substring em um posicao
			cpf = dados[0];
			inscricao = dados[1];
			valor = Double.parseDouble(dados[2]);
			pago = Boolean.parseBoolean(dados[3]);

			return (new DadosDoCadastro(cpf, inscricao, valor, pago));
		} catch (NoSuchElementException erro) {
			throw new NoSuchElementException("ARQUIVO DIFERENTE DO REGISTRO");
		}
	}

	
	public void fecharArquivo() throws IllegalStateException {
		try {
			this.entrada.close();
		} catch (IllegalStateException e) {
			throw new IllegalStateException("ERRO AO FECHAR O ARQUIVO");
		}
	}
}

