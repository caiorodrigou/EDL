package Tad_Sequencia;

import java.util.Scanner;
import Tad_Sequencia.DuplamenteEncadeado.Node;

public class Main {

    Scanner imput = new Scanner(System.in);
    DuplamenteEncadeado lista = new DuplamenteEncadeado();

    public void menu() {

        System.out.println();
        System.out.println("-----------------------");
        System.out.println("1 - Size");
        System.out.println("2 - IsEmpty");
        System.out.println("3 - ElemAtRank");
        System.out.println("4 - ReplaceAtRank");
        System.out.println("5 - InsertAtRank");
        System.out.println("6 - removeAtRank");
        System.out.println("7 - First");
        System.out.println("8 - Last");
        System.out.println("9 - Before");
        System.out.println("10 - After");
        System.out.println("11 - ReplaceElement");
        System.out.println("12 - swapElements ");
        System.out.println("13 - insertBefore");
        System.out.println("14 - insertAfter ");
        System.out.println("15 - insertFirst");
        System.out.println("16 - insertLast");
        System.out.println("17 - removerNo ");
        System.out.println("18 - Sair");
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
            int r;
            String elemento;
            Node no1, no2;

            switch (op) {
                case 1: { 
                    int tamanho = lista.size();
                    System.out.println("O tamanho do Tad_lista é " + tamanho);
                    lista.print();
                    break;
                }

                case 2: { 
                    if (lista.IsEmpty()) {
                        System.out.println("Tad_Lista está vazio");
                    } else {
                        System.out.println("Tad_Lista não está vazio");
                    }
                    lista.print();
                    break;
                }

                case 3: { 
                    System.out.print("Digite o índice (rank): ");
                    r = imput.nextInt();
                    imput.nextLine();
                    Object elem = lista.ElemAtRank(r);
                    System.out.println("O elemento no índice " + r + " é: " + elem);
                    lista.print();
                    break;
                }

                case 4: { 
                    System.out.print("Digite o índice (rank): ");
                    r = imput.nextInt();
                    imput.nextLine();
                    System.out.print("Digite o novo elemento: ");
                    elemento = imput.nextLine();
                    Object antigo = lista.replaceAtRank(r, elemento);
                    System.out.println("Elemento no rank " + r + " substituído. Valor antigo: " + antigo);
                    lista.print();
                    break;
                }

                case 5: { 
                    System.out.print("Digite o índice (rank): ");
                    r = imput.nextInt();
                    imput.nextLine();
                    System.out.print("Digite o elemento a ser inserido: ");
                    elemento = imput.nextLine();
                    lista.insertAtRank(r, elemento);
                    System.out.println("Elemento '" + elemento + "' inserido no rank " + r + ".");
                    lista.print();
                    break;
                }

                case 6: { 
                    System.out.print("Digite o índice (rank) a ser removido: ");
                    r = imput.nextInt();
                    imput.nextLine();
                    Object elem = lista.removeAtRank(r);
                    System.out.println("Elemento '" + elem + "' removido do rank " + r + ".");
                    lista.print();
                    break;
                }

                case 7: { 
                    Object elem = lista.First();
                    System.out.println("Primeiro elemento: " + elem);
                    lista.print();
                    break;
                }

                case 8: { 
                    Object elem = lista.Last();
                    System.out.println("Último elemento: " + elem);
                    lista.print();
                    break;
                }

                case 9: { 
                    lista.print();
                    System.out.print("Digite o rank do nó para verificar o 'before': ");
                    r = imput.nextInt();
                    imput.nextLine();
                    no1 = lista.getNo(r);
                    Object elem = lista.before(no1);
                    System.out.println("Elemento antes do nó no rank " + r + " é: " + elem);
                    lista.print();
                    break;
                }

                case 10: { 
                    lista.print();
                    System.out.print("Digite o rank do nó para verificar o 'after': ");
                    r = imput.nextInt();
                    imput.nextLine();
                    no1 = lista.getNo(r);
                    Object elem = lista.after(no1);
                    System.out.println("Elemento depois do nó no rank " + r + " é: " + elem);
                    lista.print();
                    break;
                }

                case 11: { 
                    lista.print();
                    System.out.print("Digite o rank do nó a ser substituído: ");
                    r = imput.nextInt();
                    imput.nextLine();
                    no1 = lista.getNo(r);
                    System.out.print("Digite o novo elemento: ");
                    elemento = imput.nextLine();
                    Object antigo = lista.replaceElement(no1, elemento);
                    System.out.println("Elemento substituído no nó. Valor antigo: " + antigo);
                    lista.print();
                    break;
                }

                case 12: { 
                    lista.print();
                    System.out.print("Digite o rank do PRIMEIRO nó: ");
                    r = imput.nextInt();
                    imput.nextLine();
                    no1 = lista.getNo(r);
                    System.out.print("Digite o rank do SEGUNDO nó: ");
                    r = imput.nextInt();
                    imput.nextLine();
                    no2 = lista.getNo(r);
                    String resultado = lista.swapElement(no1, no2);
                    System.out.println(resultado);
                    lista.print();
                    break;
                }

                case 13: { 
                    lista.print();
                    System.out.print("Digite o rank do nó ANTES do qual será inserido: ");
                    r = imput.nextInt();
                    imput.nextLine();
                    no1 = lista.getNo(r);
                    System.out.print("Digite o elemento a ser inserido: ");
                    elemento = imput.nextLine();
                    lista.insertBefore(no1, elemento);
                    System.out.println("Elemento '" + elemento + "' inserido antes do nó no rank " + r + ".");
                    lista.print();
                    break;
                }

                case 14: { 
                    lista.print();
                    System.out.print("Digite o rank do nó DEPOIS do qual será inserido: ");
                    r = imput.nextInt();
                    imput.nextLine();
                    no1 = lista.getNo(r);
                    System.out.print("Digite o elemento a ser inserido: ");
                    elemento = imput.nextLine();
                    lista.insertAfter(no1, elemento);
                    System.out.println("Elemento '" + elemento + "' inserido após o nó no rank " + r + ".");
                    lista.print();
                    break;
                }

                case 15: { 
                    System.out.print("Digite o elemento a ser inserido no início: ");
                    elemento = imput.nextLine();
                    lista.insertFirst(elemento);
                    System.out.println("Elemento '" + elemento + "' inserido no início.");
                    lista.print();
                    break;
                }

                case 16: { 
                    System.out.print("Digite o elemento a ser inserido no final: ");
                    elemento = imput.nextLine();
                    lista.insertLast(elemento);
                    System.out.println("Elemento '" + elemento + "' inserido no final.");
                    lista.print();
                    break;
                }

                case 17: { 
                    lista.print();
                    System.out.print("Digite o rank do nó a ser removido: ");
                    r = imput.nextInt();
                    imput.nextLine();
                    no1 = lista.getNo(r);
                    Object elem = lista.removerNo(no1);
                    System.out.println("Nó com elemento '" + elem + "' removido.");
                    lista.print();
                    break;
                }

                case 18: { 
                    System.out.println("Saindo do programa de teste.");
                    imput.close();
                    return;
                }

                default: {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            }
        } catch (Tad_SequenciaExcecao e) {
            System.err.println("ERRO DA SEQUÊNCIA: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("ERRO: Entrada inválida. Esperado um número.");
            imput.nextLine(); 
        } catch (Exception e) {
             System.err.println("ERRO INESPERADO: " + e.getMessage());
        }

        if (op != 18) {
            menu();
        }
    }

    public static void main(String[] args) {
        new Main().menu();
    }
}