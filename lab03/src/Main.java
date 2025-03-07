package lab03;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciadorNomes gerenciador = new GerenciadorNomesArq(); // Alterado para usar arquivo
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1. Adicionar Nome");
            System.out.println("2. Remover Nome");
            System.out.println("3. Listar Nomes");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite um nome: ");
                    String nomeAdicionar = scanner.nextLine();
                    gerenciador.adicionarNome(nomeAdicionar);
                    System.out.println("Nome adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite um nome para remover: ");
                    String nomeRemover = scanner.nextLine();
                    gerenciador.removerNome(nomeRemover);
                    System.out.println("Nome removido com sucesso!");
                    break;
                case 3:
                    List<String> nomes = gerenciador.listarNomes();
                    System.out.println("Nomes armazenados:");
                    for (String nome : nomes) {
                        System.out.println("- " + nome);
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
