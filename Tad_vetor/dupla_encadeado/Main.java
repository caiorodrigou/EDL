package Tad_vetor.dupla_encadeado;

import java.util.Scanner;

public class Main {

    Scanner input = new Scanner(System.in);
    DuplamenteEncadeado lista = new DuplamenteEncadeado(); 

    public void menu() {

        System.out.println();
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println("1 - elementAtRank");
        System.out.println("2 - replaceAtRank");
        System.out.println("3 - insertAtRank");
        System.out.println("4 - removeAtRank");
        System.out.println("5 - isEmpty");
        System.out.println("6 - size");
        System.out.println("7 - sair");
        System.out.println();
        System.out.println("Qual operação deseja fazer?");
        System.out.println();

        try {
            int op = input.nextInt();
            input.nextLine(); 

            switch (op) {

                case 1: { 
                    System.out.println("Qual índice você quer acessar?");
                    int rank = input.nextInt();
                    Object resposta = lista.elementAtRank(rank);
                    System.out.println("Elemento no índice " + rank + " é: " + resposta);
                    lista.print();
                    menu();
                    break;
                }

                case 2: { 
                    System.out.println("Digite o índice em que deseja substituir");
                    int rank = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o elemento que deve substituir");
                    Object elemento = input.nextLine();
                    Object resposta = lista.replaceAtRank(rank, elemento);
                    System.out.println("Antigo elemento: " + resposta);
                    lista.print();
                    menu();
                }

                case 3: { 
                    System.out.println("Digite o índice em que deseja inserir (0 até " + lista.size() + ")");
                    int rank = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o elemento que deseja inserir");
                    Object elemento = input.nextLine();
                    lista.insertAtRank(rank, elemento);
                    lista.print();
                    menu();
                }

                case 4: { 
                    System.out.println("Digite o índice em que deseja remover o elemento");
                    int rank = input.nextInt();
                    Object resposta = lista.removeAtRank(rank);
                    System.out.println("Elemento removido: " + resposta);
                    lista.print();
                    menu();
                }

                case 5: { 
                    if (lista.isEmpty()) {
                        System.out.println("Tad_Vetor está vazio (true)");
                    } else {
                        System.out.println("Tad_Vetor não está vazio (false)");
                    }
                    lista.print();
                    menu();
                }

                case 6: { 
                    System.out.println("O tamanho do Tad_Vetor é " + lista.size());
                    lista.print();
                    menu();
                }

                case 7: {
                    System.out.println("Saindo...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida. Tente novamente.");
                    menu();
                }
            }
        } catch (Tad_vetorExcecao e) {
            System.err.println("\n[ERRO NA OPERAÇÃO]: " + e.getMessage());
            lista.print();
            menu();
        } catch (java.util.InputMismatchException e) {
            System.err.println("\n digite um número válido para a opção ou índice.");
            input.nextLine(); 
            menu();
        }
    }

    public static void main(String[] args) {
        Main Main = new Main();
        Main.menu();
    }
}