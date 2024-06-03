package aula13;

import java.util.ArrayList;
import java.util.List;

public class BancoB implements Banco {
    private List<String> transacoes = new ArrayList<>();
    private static final double LIMITE = 500.00;

    @Override
    public void sacar(Conta conta, double valor) {
        if (conta.getSaldo() + LIMITE >= valor) {
            conta.subSaldo(valor);
            transacoes.add("Saque de R$" + valor + " na conta " + conta.getCpf());
        } else {
            System.out.println("Saldo insuficiente, considerando o limite de R$500.00!");
        }
    }

    @Override
    public void depositar(Conta conta, double valor) {
        conta.addSaldo(valor);
        transacoes.add("Depósito de R$" + valor + " na conta " + conta.getCpf());
    }

    @Override
    public void extrato(Conta conta) {
        System.out.println("Extrato da conta " + conta.getCpf() + ":");
        for (String transacao : transacoes) {
            System.out.println(transacao);
        }
    }
}


