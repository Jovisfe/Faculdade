package aula13;

import java.util.ArrayList;
import java.util.List;

public class BancoA implements Banco {
    private List<String> transacoes = new ArrayList<>();

    @Override
    public void sacar(Conta conta, double valor) {
        if (conta.getSaldo() >= valor) {
            conta.subSaldo(valor);
            transacoes.add("Saque de R$" + valor + " na conta " + conta.getCpf());
        } else {
            System.out.println("Saldo insuficiente!");
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

    public void transferenciaConta(Conta contaOrigem, Conta contaDestino, double valor) {
        if (contaOrigem.getSaldo() >= valor) {
            contaOrigem.subSaldo(valor);
            contaDestino.addSaldo(valor);
            transacoes.add("Transferência de R$" + valor + " da conta " + contaOrigem.getCpf() + " para a conta " + contaDestino.getCpf());
        } else {
            System.out.println("Saldo insuficiente para transferência!");
        }
    }
}



