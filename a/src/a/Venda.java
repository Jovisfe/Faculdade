package a;

import java.util.List;
import java.util.ArrayList;

public class Venda {
    private List<Produto> produtos;
    private Cliente cliente;
    private FormaPagamento formaPagamento;
    private double valorTotal;

    public Venda() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        this.produtos.add(produto);
        this.valorTotal += produto.getPrecoVenda() * quantidade;
    }

    public double calcularValorTotal() {
        return this.valorTotal;
    }

    public void aplicarDesconto(double desconto) {
        this.valorTotal -= desconto;
    }

    public void finalizarVenda(Cliente cliente, FormaPagamento formaPagamento) {
        this.cliente = cliente;
        this.formaPagamento = formaPagamento;
        // Persistência no banco de dados
    }

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
    
    
}
