import java.util.Date;

public class Pizza extends Prato {
	
	private String recheio;
	private String borda;
	private String molho;
	
	public String getrecheio() {
		return recheio;
	}
	
	public void setrecheio(String recheio) {
		this.recheio=recheio;
	}


	public String getBorda() {
		return borda;
	}

	public void setBorda(String borda) {
		this.borda = borda;
	}

	public String getMolho() {
		return molho;
	}

	public void setMolho(String molho) {
		this.molho = molho;
	}

	public Pizza(Double precoVenda, Date dataValidade, Double peso, String nome, String recheio, String borda, String molho) {
		super(precoVenda, dataValidade, peso, nome);
		this.recheio = recheio;
		this.borda = borda;
		this.molho = molho;
	}
	
	public Pizza () {}
	
	

}
