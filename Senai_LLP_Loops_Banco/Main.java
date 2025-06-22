import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        // Criando contas de diferentes tipos
        ContaCorrente cc1 = new ContaCorrente("1001", "João Silva", 1000.0, 2.5);
        ContaPoupanca cp1 = new ContaPoupanca("2001", "Maria Souza", 1500.0, 0.01);
        ContaCorrente cc2 = new ContaCorrente("1002", "Carlos Oliveira", 500.0, 1.8);
        ContaPoupanca cp2 = new ContaPoupanca("2002", "Ana Lima", 3000.0, 0.008);

        banco.abrirConta(cc1);
        banco.abrirConta(cp1);
        banco.abrirConta(cc2);
        banco.abrirConta(cp2);

        boolean sair = false;
        while (!sair) {
            System.out.println("\n1 - Depositar\n2 - Sacar\n3 - Listar Contas\n4 - Aplicar Rendimento (Poupança)\n5 - Ver Saldo\n0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Número da conta: ");
                    String numContaDep = scanner.nextLine();
                    System.out.print("Valor para depositar: ");
                    double valorDep = scanner.nextDouble();
                    banco.realizarOperacao(numContaDep, "depositar", valorDep);
                    break;
                case 2:
                    System.out.print("Número da conta: ");
                    String numContaSaq = scanner.nextLine();
                    System.out.print("Valor para sacar: ");
                    double valorSaq = scanner.nextDouble();
                    banco.realizarOperacao(numContaSaq, "sacar", valorSaq);
                    break;
                case 3:
                    banco.listarContas();
                    break;
                case 4:
                    System.out.print("Número da conta poupança: ");
                    String numContaPoup = scanner.nextLine();
                    ContaBancaria conta = banco.buscarConta(numContaPoup);
                    if (conta instanceof ContaPoupanca) {
                        ((ContaPoupanca) conta).aplicarRendimento();
                    } else {
                        System.out.println("Conta não é poupança ou não existe.");
                    }
                    break;
                case 5:
                    System.out.print("Número da conta: ");
                    String numContaSaldo = scanner.nextLine();
                    ContaBancaria contaSaldo = banco.buscarConta(numContaSaldo);
                    if (contaSaldo != null) {
                        System.out.printf("Saldo da conta %s: %.2f\n", numContaSaldo, contaSaldo.getSaldo());
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 0:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}
