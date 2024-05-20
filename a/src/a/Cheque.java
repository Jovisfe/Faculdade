package a;

public class Cheque extends FormaPagamento {
    private String banco;
    private String numeroCheque;

    public Cheque(double valorPago, String banco, String numeroCheque) {
        super("Cheque", valorPago);
        this.banco = banco;
        this.numeroCheque = numeroCheque;
    }

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}

}
