public class ContaCorrente extends ContaBancaria {
    private double taxaManutencao;
    
    public ContaCorrente(String numeroConta, String titular, double saldoInicial, double taxaManutencao) {
        super(numeroConta, titular, saldoInicial);
        this.taxaManutencao = taxaManutencao;
    }
    
    @Override
    public void sacar(double valor) {
        double valorComTaxa = valor + taxaManutencao;
        if (valor > 0 && valorComTaxa <= getSaldo()) {
            setSaldo(getSaldo() - valorComTaxa);
            System.out.println("Saque de R$" + valor + " realizado com sucesso na conta corrente " + getNumeroConta() + 
                               " (Taxa de manutenção: R$" + taxaManutencao + ")");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque na conta corrente " + getNumeroConta() + 
                               " (incluindo taxa de manutenção)");
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + " (Conta Corrente - Taxa de Manutenção: R$" + taxaManutencao + ")";
    }
}