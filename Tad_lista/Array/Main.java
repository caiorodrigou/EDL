package Tad_lista.Array;

import Tad_vetor.Array.Tad_vetorExcecao;
import java.util.Scanner;

public class Main {

    Scanner imput = new Scanner(System.in);
    Array_Lista lista = new Array_Lista(5); 

    public void menu() {

        System.out.println();
        System.out.println("-----------------------");
        System.out.println("1 - ElemAtRank");
        System.out.println("2 - ReplaceElement");
        System.out.println("3 - swapElements");
        System.out.println("4 - insertBefore");
        System.out.println("5 - insertAfter");
        System.out.println("6 - insertFirst");
        System.out.println("7 - insertLast");
        System.out.println("8 - remove");
        System.out.println("9 - IsEmpty");
        System.out.println("10 - Size");
        System.out.println("11 - Sair");
        System.out.println("----------------------");
        System.out.print("Qual operação deseja fazer? ");

        if (!imput.hasNextInt()) {
            System.out.println("Entrada inválida. Digite um número.");
            imput.next(); 
            menu();
            return;
        }

        int op = imput.nextInt();
        imput.nextLine(); 
        
        try {
            switch (op) {
                case 1: {
                    System.out.print("Qual índice você quer acessar (0 a " + (lista.tamanho - 1) + ")? ");
                    int rank = imput.nextInt();
                    Object resposta = lista.ElemAtRank(rank); // <--- USO DO NOVO MÉTODO
                    System.out.println("Elemento no índice " + rank + " é: " + resposta);
                    lista.print();
                    menu();
                }

                case 2: {
                    System.out.print("Digite o índice (0 a " + (lista.tamanho - 1) + ") em que deseja substituir: ");
                    int rank = imput.nextInt();
                    imput.nextLine();
                    System.out.print("Digite o elemento que deve substituir: ");
                    Object elemento = imput.nextLine();
                    Object resposta = lista.ReplaceElement(rank, elemento);
                    System.out.println("Antigo elemento: " + resposta);
                    lista.print();
                    menu();
                }

                case 3: {
                    System.out.print("Digite o 1º índice para troca (r): ");
                    int r = imput.nextInt();
                    System.out.print("Digite o 2º índice para troca (s): ");
                    int s = imput.nextInt();
                    String resposta = lista.swapElements(r, s);
                    System.out.println(resposta);
                    lista.print();
                    menu();
                }
                
                case 4: {
                    System.out.print("Digite o índice (0 a " + lista.tamanho + ") ANTES do qual deseja inserir: ");
                    int rank = imput.nextInt();
                    imput.nextLine();
                    System.out.print("Digite o elemento a inserir: ");
                    Object elemento = imput.nextLine();
                    lista.insertBefore(rank, elemento);
                    lista.print();
                    menu();
                }
                
                case 5: {
                    System.out.print("Digite o índice (0 a " + (lista.tamanho - 1) + ") APÓS o qual deseja inserir: ");
                    int rank = imput.nextInt();
                    imput.nextLine();
                    System.out.print("Digite o elemento a inserir: ");
                    Object elemento = imput.nextLine();
                    lista.insertAfter(rank, elemento);
                    lista.print();
                    menu();
                }

                case 6: {
                    System.out.print("Digite o elemento a inserir no INÍCIO: ");
                    Object elemento = imput.nextLine();
                    lista.insertFirst(elemento);
                    lista.print();
                    menu();
                }

                case 7: {
                    System.out.print("Digite o elemento a inserir no FIM: ");
                    Object elemento = imput.nextLine();
                    lista.insertLast(elemento);
                    lista.print();
                    menu();
                }


                case 8: {
                    System.out.print("Digite o índice em que deseja remover o elemento: ");
                    int rank = imput.nextInt();
                    Object resposta = lista.remove(rank);
                    System.out.println("Elemento removido: " + resposta);
                    lista.print();
                    menu();
                }

                case 9: {
                    if (lista.IsEmpty()) {
                        System.out.println("Tad_Vetor está vazio");
                    } else {
                        System.out.println("Tad_Vetor não está vazio");
                    }
                    lista.print();
                    menu();
                }

                case 10: {
                    System.out.println("O tamanho do Tad_Vetor é " + lista.Size());
                    lista.print();
                    menu();
                }

                case 11: {
                    System.out.println("Saindo...");
                    break;
                }

                default: {
                    System.out.println("Opção inválida. Tente novamente.");
                    menu();
                }

            }
        } catch (Tad_vetorExcecao e) {
            System.out.println("ERRO: " + e.getMessage());
            lista.print();
            menu();
        }
    }

    public static void main(String[] args) {

        Main meuPrograma = new Main();
        meuPrograma.menu();
    }

}