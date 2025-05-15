package banco;

import java.util.ArrayList;
import java.util.List;

abstract class Conta {
    protected Cliente cliente;
    protected double saldo;
    protected int numeroConta;
    protected List<String> extrato = new ArrayList<>();

    public Conta(Cliente cliente, int numeroConta) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public abstract void sacar(double valor);

    public abstract void depositar(double valor);

    public void transferir(Conta destino, double valor) {
        if (this.saldo + getLimiteDisponivel() >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
            extrato.add("Transferência de R$" + valor + " para conta " + destino.getNumeroConta());
        } else {
            System.out.println("Transferência não realizada: saldo insuficiente.");
        }
    }

    public void imprimirExtrato() {
        for (String linha : extrato) {
            System.out.println(linha);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getLimiteDisponivel() {
        return 0;
    }
}