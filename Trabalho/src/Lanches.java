import java.util.Date;

public class Lanches extends Prato {
	
	private String pao;
	private String recheio;
	private String molho;
	
	public String getPao() {
		return pao;
	}
	
	public void setPao(String pao) {
		this.pao = pao;
	}
	
	public String getRecheio() {
		return recheio;
	}
	
	public void setRecheio(String recheio) {
		this.recheio = recheio;
	}
	
	public String getMolho() {
		return molho;
	}
	
	public void setMolho(String molho) {
		this.molho = molho;
	}
	
	
	public Lanches(Double precoVenda, Date dataValidade, Double peso, String pao, String recheio, String molho, String nome) {
		super(precoVenda, dataValidade, peso, nome);
		this.pao = pao;
		this.recheio = recheio;
		this.molho = molho;
	}
	
	public Lanches() {}

}
