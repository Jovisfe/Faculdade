package aula13;

public class Main {
    public static void main(String[] args) {
        Conta conta1 = new Conta("12345678900", "BancoA", 1000.00);
        Conta conta2 = new Conta("09876543211", "BancoA", 500.00);

        BancoA bancoA = new BancoA();
        bancoA.depositar(conta1, 200);
        bancoA.sacar(conta1, 300);
        bancoA.transferenciaConta(conta1, conta2, 400);
        bancoA.extrato(conta1);
        bancoA.extrato(conta2);

        Conta conta3 = new Conta("11223344556", "BancoB", 300.00);

        BancoB bancoB = new BancoB();
        bancoB.depositar(conta3, 150);
        bancoB.sacar(conta3, 700);
        bancoB.extrato(conta3);
    }
}



