package dados;
public class DadosDoCadastro {
	private String cpf;
	private String inscricao;
	private Double valor;
	private boolean pago;

	// CONSTRUTOR:
	public DadosDoCadastro(String cpf, String inscricao, Double valor, boolean pago) {
		super();
		this.cpf = cpf;
		this.inscricao = inscricao;
		this.valor = valor;
		this.pago = pago;
	}
	
	// METODOS DE ACESSO AOS ATRIBUTOS:
	public String getCpf() {
		return cpf;
	}
	
	public String getInscricao() {
		return inscricao;
	}
	
	public Double getValor() {
		return valor;
	}

	public boolean isPago() {
		return pago;
	}
	
	// METODOS DE ACESSO AOS ATRIBUTOS:
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	@Override
	public String toString() {
		return "Item [cpf=" + cpf + ", inscricao=" + inscricao + ", valor=" + valor + ", pago=" + pago + "]";
	}

	
}
