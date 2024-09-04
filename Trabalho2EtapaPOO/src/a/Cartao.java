package a;

public class Cartao extends FormaPagamento {
    private String numeroCartao;
    private String validade;
    private String cvv;

    public Cartao(double valorPago, String numeroCartao, String validade, String cvv) {
        super("Cartão", valorPago);
        this.numeroCartao = numeroCartao;
        this.validade = validade;
        this.cvv = cvv;
    }

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
    
    

}

