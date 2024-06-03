package aula13;

public class Conta {
    private String cpf;
    private String banco;
    private double saldo;

    public Conta(String cpf, String banco, double saldo) {
        this.cpf = cpf;
        this.banco = banco;
        this.saldo = saldo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void addSaldo(double valor) {
        this.saldo += valor;
    }

    public void subSaldo(double valor) {
        this.saldo -= valor;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cpf='" + cpf + '\'' +
                ", banco='" + banco + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}

