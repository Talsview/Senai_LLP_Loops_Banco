public class ContaPoupanca extends ContaBancaria {
    private double taxaRendimento;
    
    public ContaPoupanca(String numeroConta, String titular, double saldoInicial, double taxaRendimento) {
        super(numeroConta, titular, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }
    
    public void aplicarRendimento() {
        double rendimento = getSaldo() * taxaRendimento;
        setSaldo(getSaldo() + rendimento);
        System.out.println("Rendimento de R$" + rendimento + " aplicado na conta poupança " + getNumeroConta());
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Conta Poupança - Taxa de Rendimento: " + (taxaRendimento*100) + "%)";
    }
}