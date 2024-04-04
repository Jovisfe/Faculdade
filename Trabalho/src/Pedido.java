import java.util.ArrayList;

public class Pedido {
	
	private String nomeCliente;
	private ArrayList<Prato> prato;
	private Double taxaServico=5.0;
	private Double recebido;
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public ArrayList<Prato> getPrato() {
		return prato;
	}
	public void setPrato(ArrayList<Prato> prato) {
		this.prato = prato;
	}
	public Double getTaxaServico() {
		return taxaServico;
	}
	public void setTaxaServico(Double taxaServico) {
		this.taxaServico = taxaServico;
	}
	public Double getRecebido() {
		return recebido;
	}
	public void setRecebido(Double precoFinal) {
		this.recebido = precoFinal;
	}
	
	public Pedido(String nomeCliente, ArrayList<Prato> prato, Double precoFinal) {
		this.nomeCliente = nomeCliente;
		this.prato = prato;
		this.recebido = precoFinal;
	}
	
	public Double CalcularTotal(ArrayList<Prato> prato){
		Double aux=0.0;
		
		for(Prato x: prato) {
			aux+=x.getprecoVenda();
		}
		return aux+taxaServico;
	}
	
	public void NF() {
        Double precoTotal = CalcularTotal(prato);
        System.out.println("Preço total: " + precoTotal);
        for(Prato x : prato) {
        	System.out.println(x.getNome());
        }
        Double troco = recebido - precoTotal;
        System.out.println("Troco: " + troco);
        System.out.println("--------------------------");
    }
}
