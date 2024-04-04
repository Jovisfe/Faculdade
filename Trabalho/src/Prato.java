import java.util.Date;

public class Prato {
	
	private String nome;
	private Double precoVenda;
 	private  Date dataValidade;
 	private Double peso;
 	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
 	
 	public Double getprecoVenda() {
 		return precoVenda;
 	}
 	
 	public void setprecoVenda(Double precoVenda) {
 		this.precoVenda=precoVenda;
 	}

 	public Date getdataValidade() {
 		return dataValidade;
 	}
 	
 	public void setdataValidade(Date dataValidade) {
 		this.dataValidade=dataValidade;
 		
 	}
 	
 	public Double getpeso() {
 		return peso;
 	}
 	
 	public void setpeso(Double peso) {
 		this.peso=peso;
 	}
 	
 	public Prato(Double precoVenda, Date dataValidade, Double peso, String nome) {
 		this.precoVenda=precoVenda;
 		this.nome = nome;
 		this.dataValidade=dataValidade;
 		this.peso=peso;
 	}
 	
 	public Prato() {}		
 	
}	
