package a;

public class ProdutoEletronico extends Produto {
    private String marca;
    private String modelo;

    public ProdutoEletronico(int codigo, String nome, String descricao, double precoCusto, double precoVenda, int quantidadeEstoque, Categoria categoria, String marca, String modelo) {
        super(codigo, nome, descricao, precoCusto, precoVenda, quantidadeEstoque, categoria);
        this.marca = marca;
        this.modelo = modelo;
    }

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	protected int getPrecoVenda1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected int getCodigo1() {
		// TODO Auto-generated method stub
		return 0;
	}

}
