package heap;

import java.io.*;

public class HeapMain {
	static String tipoDoArquivo[] = { "alea", "inv", "ord" };
	static String lerArquivos = "./src/arquivosDeTeste/Imovel";
	static String gravarArquivos = "./src/arquivosAlterados/imovel";
	static String tamanhodoDeRegistro[] = { "500", "1000", "5000", "10000", "50000" };
	static int quantidadeDeRegistro[] = { 500, 1000, 5000, 10000, 50000 };
	static LeArquivo ler = null;
	static GravaArquivo gravarRegistroOrdenado, gravarCpfPesquisado = null;
	static CadastroImobiliadrioVetor vetor = null;

	public static void main(String[] args) throws IOException {
		long tempoInicial;
        long tempoFinal;
        long tempoGasto;
       
        tempoInicial = System.currentTimeMillis();
        
        for(int i=0;i<5;i++) {

        	for(int j=0,k=0;j<3;j++) {
//        		System.out.println("teste"+localDoArquivo+tamanhodoDeRegistro[k]+tipoDoArquivo[j]+".txt");
        		ler = new LeArquivo(lerArquivos+tamanhodoDeRegistro[k]+tipoDoArquivo[j]+".txt");
        		gravarRegistroOrdenado = new GravaArquivo(gravarArquivos+tamanhodoDeRegistro[k]+tipoDoArquivo[j]+".txt");
        		gravarCpfPesquisado = new GravaArquivo(gravarArquivos+"Pesquisado.txt");
//        		gravarCpfPesquisado = new GravaArquivo("./src/arquivosAlterados/imovelPesquisado.txt");
        		
        		//vetor receber o tamanho 500 e vetor recebe os dados e parametros do metodo lerAruivos.
        		vetor = ler.leArquivo(quantidadeDeRegistro[k]);
        		
        		vetor.heapSort();
//        		System.out.println(vetor.toString());

        		gravarRegistroOrdenado.gravaArquivo(vetor.toString());
        		gravarCpfPesquisado.gravaArquivo((vetor.pesquisarCpfImovel()));
        		ler.fecharArquivo();
        		gravarRegistroOrdenado.fechaArquivo();
        		gravarCpfPesquisado.fechaArquivo();
        		
        		if(k==1) {
        			k--;
        		}
            }   	
        }
		
		tempoFinal = System.currentTimeMillis();
		tempoGasto = (tempoFinal-tempoInicial)/5;
		System.out.println("Tempo de execução: "+tempoGasto+" ms" );
	}
	

}
