package banco;

public class ContaPoupanca extends Conta {
    public ContaPoupanca(Cliente cliente, int numeroConta) {
        super(cliente, numeroConta);
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso na poupança.");
            extrato.add("Saque: R$" + valor);
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + valor + " na poupança.");
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso na poupança.");
        extrato.add("Depósito: R$" + valor);
    }
}
