package a;

public abstract class FormaPagamento {
    protected String tipo;
    protected double valorPago;

    public FormaPagamento(String tipo, double valorPago) {
        this.tipo = tipo;
        this.valorPago = valorPago;
    }

	public void FormaPagamento1(String tipo2, double valorPago2) {
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}

}

