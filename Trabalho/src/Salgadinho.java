import java.util.Date;

public class Salgadinho extends Prato {
	
	private String recheio;
	private String massa;
	private String tipo;

	public String getRecheio() {
		return recheio;
	}

	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}

	public String getMassa() {
		return massa;
	}

	public void setMassa(String massa) {
		this.massa = massa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Salgadinho(Double precoVenda, Date dataValidade, Double peso, String recheio, String massa, String tipo, String nome) {
		super(precoVenda, dataValidade, peso, nome);
		this.recheio = recheio;
		this.massa = massa;
		this.tipo = tipo;
	}
	
	public Salgadinho () {}

}
