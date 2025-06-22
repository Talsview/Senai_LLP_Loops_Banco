import java.util.ArrayList;

public class Banco {
    private ArrayList<ContaBancaria> contas;
    
    public Banco() {
        contas = new ArrayList<>();
    }
    
    public void abrirConta(ContaBancaria novaConta) {
        contas.add(novaConta);
        System.out.println("Conta " + novaConta.getNumeroConta() + " aberta com sucesso para " + novaConta.getTitular());
    }
    
    public ContaBancaria buscarConta(String numero) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumeroConta().equals(numero)) {
                return conta;
            }
        }
        return null;
    }
    
    public void realizarOperacao(String numeroConta, String tipoOperacao, double valor) {
        ContaBancaria conta = buscarConta(numeroConta);
        if (conta != null) {
            switch (tipoOperacao.toLowerCase()) {
                case "depositar":
                    conta.depositar(valor);
                    break;
                case "sacar":
                    conta.sacar(valor);
                    break;
                default:
                    System.out.println("Operação inválida.");
            }
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
    
    public void listarContas() {
        System.out.println("\n=== Lista de Contas do Banco ===");
        for (ContaBancaria conta : contas) {
            System.out.println(conta);
        }
        System.out.println("===============================\n");
    }
}