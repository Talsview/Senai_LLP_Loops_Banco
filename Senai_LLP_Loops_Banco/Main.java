public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        
        // Criando contas de diferentes tipos
        ContaCorrente cc1 = new ContaCorrente("1001", "João Silva", 1000.0, 2.5);
        ContaPoupanca cp1 = new ContaPoupanca("2001", "Maria Souza", 1500.0, 0.01); // 1% de rendimento
        ContaCorrente cc2 = new ContaCorrente("1002", "Carlos Oliveira", 500.0, 1.8);
        ContaPoupanca cp2 = new ContaPoupanca("2002", "Ana Lima", 3000.0, 0.008); // 0.8% de rendimento
        
        // Adicionando contas ao banco
        banco.abrirConta(cc1);
        banco.abrirConta(cp1);
        banco.abrirConta(cc2);
        banco.abrirConta(cp2);
        
        // Realizando operações
        banco.realizarOperacao("1001", "depositar", 500.0);
        banco.realizarOperacao("1001", "sacar", 200.0);
        
        banco.realizarOperacao("2001", "depositar", 300.0);
        banco.realizarOperacao("2001", "sacar", 100.0);
        
        // Tentando sacar valor maior que o saldo
        banco.realizarOperacao("1002", "sacar", 600.0);
        
        // Aplicando rendimento específico para conta poupança
        ContaBancaria conta = banco.buscarConta("2002");
        if (conta instanceof ContaPoupanca) {
            ((ContaPoupanca) conta).aplicarRendimento();
        }
        
        // Listando todas as contas
        banco.listarContas();
        
        // Demonstração de polimorfismo
        System.out.println("\n=== Demonstração de Polimorfismo ===");
        ContaBancaria contaPolimorfica = banco.buscarConta("1001");
        contaPolimorfica.sacar(50.0); // Chama o método sacar() de ContaCorrente
        
        contaPolimorfica = banco.buscarConta("2001");
        contaPolimorfica.sacar(50.0); // Chama o método sacar() de ContaBancaria (pois não foi sobrescrito em ContaPoupanca)
    }
}