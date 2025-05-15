package banco;

class ContaCorrente extends Conta {
    private double limiteEspecial;

    public ContaCorrente(Cliente cliente, int numeroConta, double limiteEspecial) {
        super(cliente, numeroConta);
        this.limiteEspecial = limiteEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo + limiteEspecial) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            extrato.add("Saque: R$" + valor);
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + valor);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        extrato.add("Depósito: R$" + valor);
    }

    @Override
    public double getLimiteDisponivel() {
        return limiteEspecial;
    }
}