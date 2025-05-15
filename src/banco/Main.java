package banco;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João Silva", "123.456.789-00", "joao@email.com");
        ContaCorrente contaCorrente = new ContaCorrente(cliente1, 1001, 500);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente1, 1002);

        contaCorrente.depositar(1000);
        contaCorrente.sacar(1200);
        contaCorrente.transferir(contaPoupanca, 200);

        System.out.println("Saldo Corrente: R$" + contaCorrente.getSaldo());
        System.out.println("Saldo Poupança: R$" + contaPoupanca.getSaldo());

        System.out.println("\nExtrato Conta Corrente:");
        contaCorrente.imprimirExtrato();

        System.out.println("\nExtrato Conta Poupança:");
        contaPoupanca.imprimirExtrato();
    }
}