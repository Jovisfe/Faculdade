package a;

public class ProdutoAlimenticio extends Produto {
    private String dataValidade;

    public ProdutoAlimenticio(int codigo, String nome, String descricao, double precoCusto, double precoVenda, int quantidadeEstoque, Categoria categoria, String dataValidade) {
        super(codigo, nome, descricao, precoCusto, precoVenda, quantidadeEstoque, categoria);
        this.dataValidade = dataValidade;
    }

	public String getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(String dataValidade) {
		this.dataValidade = dataValidade;
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

