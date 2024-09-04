package a;

public class ProdutoLimpeza extends Produto {
    private boolean produtoQuimico;

    public ProdutoLimpeza(int codigo, String nome, String descricao, double precoCusto, double precoVenda, int quantidadeEstoque, Categoria categoria, boolean produtoQuimico) {
        super(codigo, nome, descricao, precoCusto, precoVenda, quantidadeEstoque, categoria);
        this.produtoQuimico = produtoQuimico;
    }

	public boolean isProdutoQuimico() {
		return produtoQuimico;
	}

	public void setProdutoQuimico(boolean produtoQuimico) {
		this.produtoQuimico = produtoQuimico;
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
