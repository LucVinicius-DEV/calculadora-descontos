// O programa simula uma calculadora de descontos em uma loja.

import java.util.Scanner;

public class CalculadoraDescontos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome do produto: ");
        String nome = sc.nextLine();

        System.out.print("Digite o valor do produto (R$): ");
        double valor = sc.nextDouble();

        System.out.println("\nEscolha a forma de pagamento:");
        System.out.println("[1] À vista (dinheiro/Pix) - 10% de desconto");
        System.out.println("[2] Cartão à vista - 5% de desconto");
        System.out.println("[3] Cartão em 2x - Sem desconto");
        System.out.println("[4] Cartão em 3x ou mais - 10% de acréscimo");
        System.out.print("Opção: ");
        int forma = sc.nextInt();

        double valorFinal = valor;
        int parcelas = 1;

        switch (forma) {
            case 1:
                valorFinal = valor * 0.9;
                System.out.printf("\n%s à vista com 10%% de desconto: R$%.2f\n", nome, valorFinal);
                break;
            case 2:
                valorFinal = valor * 0.95;
                System.out.printf("\n%s no cartão à vista com 5%% de desconto: R$%.2f\n", nome, valorFinal);
                break;
            case 3:
                parcelas = 2;
                System.out.printf("\n%s no cartão em 2x SEM juros: 2x de R$%.2f (Total: R$%.2f)\n", nome, valor / 2, valor);
                break;
            case 4:
                System.out.print("Digite o número de parcelas (mínimo 3): ");
                parcelas = sc.nextInt();
                if (parcelas < 3) {
                    System.out.println("Número inválido de parcelas para esta opção.");
                } else {
                    valorFinal = valor * 1.10;
                    double parcelaValor = valorFinal / parcelas;
                    System.out.printf("\n%s no cartão em %dx COM juros (10%%): %dx de R$%.2f (Total: R$%.2f)\n",
                            nome, parcelas, parcelas, parcelaValor, valorFinal);
                }
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        sc.close();
    }
}
