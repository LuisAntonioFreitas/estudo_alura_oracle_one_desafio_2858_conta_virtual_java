import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {

        String nomeCliente = "Luis Antonio";
        String tipoConta = "Corrente";
        double saldoConta = 2500;

        String dadosCliente = """
                *******************************
                Dados iniciais do cliente:
                                
                Nome:           %s
                Tipo de conta:  %s
                Saldo inicial:  R$ %.2f
                *******************************
                """.formatted(nomeCliente, tipoConta, saldoConta);

        String menuOpcoes = """
                    Operações:
                                        
                    1 | Consultar saldo
                    2 | Receber valor
                    3 | Transferir valor
                    4 | Sair
                                        
                    Digite a opção desejada:""";

        System.out.println(dadosCliente);

        Scanner scanner = new Scanner(System.in);
        int opcaoDesejada = 0;
        while (opcaoDesejada != 4) {
            System.out.println(menuOpcoes);

            opcaoDesejada = scanner.nextInt();

            switch (opcaoDesejada) {
                case 1:
                    // Consultar saldo
                    ConsultarSaldo(saldoConta);
                    break;
                case 2:
                    // Receber valor
                    saldoConta = ReceberValor(saldoConta, scanner);
                    break;
                case 3:
                    // Transferir valor
                    saldoConta = TransferirValor(saldoConta, scanner);
                    break;
                case 4:
                    // Sair
                    break;
                default:
                    // Opção inválida
                    System.out.println("Opção inválida\n");
                    break;
            }
        }
        scanner.close();

    }

    public static void ConsultarSaldo(double saldo) {
        System.out.println("O saldo atual é R$ %.2f\n".formatted(saldo));
    }

    public static double ReceberValor(double saldo, Scanner scanner) {
        System.out.println("Informe o valor a receber:");
        double valor = scanner.nextDouble();
        saldo += valor;
        ConsultarSaldo(saldo);
        return saldo;
    }

    public static double TransferirValor(double saldo, Scanner scanner) {
        System.out.println("Informe o valor a transferir:");
        double valor = scanner.nextDouble();
        if (saldo > valor) {
            saldo -= valor;
            ConsultarSaldo(saldo);
        } else {
            System.out.println("Não há saldo suficiente para fazer essa transferência\n");
        }
        return saldo;
    }

}
