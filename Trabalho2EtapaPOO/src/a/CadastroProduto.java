package a;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProduto extends JFrame {
    private JTextField nomeField, descricaoField, precoCustoField, precoVendaField, quantidadeEstoqueField;
    private JComboBox<String> categoriaComboBox;

    public CadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("Descrição:"));
        descricaoField = new JTextField();
        panel.add(descricaoField);

        panel.add(new JLabel("Preço de Custo:"));
        precoCustoField = new JTextField();
        panel.add(precoCustoField);

        panel.add(new JLabel("Preço de Venda:"));
        precoVendaField = new JTextField();
        panel.add(precoVendaField);

        panel.add(new JLabel("Quantidade em Estoque:"));
        quantidadeEstoqueField = new JTextField();
        panel.add(quantidadeEstoqueField);

        panel.add(new JLabel("Categoria:"));
        categoriaComboBox = new JComboBox<>(new String[]{"Eletrônico", "Alimentício", "Limpeza"});
        panel.add(categoriaComboBox);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        add(panel, BorderLayout.CENTER);
        add(cadastrarButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
	}

	public JTextField getDescricaoField() {
		return descricaoField;
	}

	public void setDescricaoField(JTextField descricaoField) {
		this.descricaoField = descricaoField;
	}

	public JTextField getPrecoCustoField() {
		return precoCustoField;
	}

	public void setPrecoCustoField(JTextField precoCustoField) {
		this.precoCustoField = precoCustoField;
	}

	public JTextField getPrecoVendaField() {
		return precoVendaField;
	}

	public void setPrecoVendaField(JTextField precoVendaField) {
		this.precoVendaField = precoVendaField;
	}

	public JTextField getQuantidadeEstoqueField() {
		return quantidadeEstoqueField;
	}

	public void setQuantidadeEstoqueField(JTextField quantidadeEstoqueField) {
		this.quantidadeEstoqueField = quantidadeEstoqueField;
	}

	public JComboBox<String> getCategoriaComboBox() {
		return categoriaComboBox;
	}

	public void setCategoriaComboBox(JComboBox<String> categoriaComboBox) {
		this.categoriaComboBox = categoriaComboBox;
	}
}
