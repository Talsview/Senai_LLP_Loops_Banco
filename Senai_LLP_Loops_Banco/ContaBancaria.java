public class ContaBancaria {
    private String numeroConta;
    private double saldo;
    private String titular;
    
    public ContaBancaria(String numeroConta, String titular, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }
    
    public String getNumeroConta() {
        return numeroConta;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public String getTitular() {
        return titular;
    }
    
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso na conta " + numeroConta);
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }
    
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso na conta " + numeroConta);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque na conta " + numeroConta);
        }
    }
    
    @Override
    public String toString() {
        return "Conta " + numeroConta + " - Titular: " + titular + " - Saldo: R$" + saldo;
    }
}