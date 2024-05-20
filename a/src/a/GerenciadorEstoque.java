package a;

import java.util.List;
import java.util.ArrayList;

public class GerenciadorEstoque {
    private List<Produto> produtos;

    public GerenciadorEstoque() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removerProduto(int codigo) {
    }

    public Produto buscarProdutoPorCodigo(int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo1() == codigo) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> buscarProdutoPorNome(String nome) {
        List<Produto> resultados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                resultados.add(produto);
            }
        }
        return resultados;
    }

    public void atualizarProduto(Produto produtoAtualizado) {
        // Lógica para atualizar produto
    }

    public void gerarRelatorioEstoque() {
        // Lógica para gerar relatório de estoque
    }
}
