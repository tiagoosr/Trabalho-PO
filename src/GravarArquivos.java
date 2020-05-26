
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Scanner;

import dados.DadosDoCadastro;

public class GravarArquivos {
	public static void main(String[] args) {
		String cpf = "", inscricao = "";
		double valor = 0;
		boolean pago = false;
		DadosDoCadastro dados = new DadosDoCadastro(cpf, inscricao, valor, pago);
		String arquivos = "C:\\Users\\Tiago\\Desktop\\Trabalho pesquisa e ordenação\\imovel500alea.txt";

		String[] dados2;

	
		System.out.printf("\nConteúdo do arquivo texto:\n");
		try {
			FileReader arq = new FileReader(arquivos);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = lerArq.readLine(); // lê a primeira linha
			
			// a variável "linha" recebe o valor "null" quando o processo
			// de repetição atingir o final do arquivo texto
			while (linha != null) {
				dados2 = linha.split(";");
//				System.out.printf("%s\n", dados2[0]);

					dados.setCpf(dados2[0]);
					dados.setInscricao(dados2[1]);
					dados.setValor(Double.parseDouble(dados2[2]));
					dados.setPago(Boolean.parseBoolean(dados2[3]));

//				System.out.printf("%s\n", dados.getCpf()+";"+dados.getInscricao());
				System.out.printf(" teste %s\n", dados.getCpf()+","+dados.getInscricao()+","+dados.getValor()+","+dados.isPago());
				linha = lerArq.readLine(); // lê da segunda até a última linha
				
			}

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
		
	}

}
