package Listas_Encadeadas.Simples;

import java.util.Scanner;

public class Main_Encadeada {

    Scanner imput = new Scanner(System.in);
    Deque_Encadeado Deque = new Deque_Encadeado();

    public void menu() {

        System.out.println();
        System.out.println("-------------------------------");
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println("1 - adicionar inicio");
        System.out.println("2 - remover inicio");
        System.out.println("3 - adicionar final");
        System.out.println("4 - remover final");
        System.out.println("5 - primeiro");
        System.out.println("6 - ultimo");
        System.out.println("7 - verificar se esta vazia");
        System.out.println("8 - tamanho");
        System.out.println("9 - sair");
        System.out.println("-------------------------------");
        System.out.println();

        int op = imput.nextInt();
        switch (op) {

            case 1: {
                System.out.println();
                System.out.println("Digite o valor que deseja adicionar");
                int valor = imput.nextInt();
                Deque.Adicionar_I(valor);
                Deque.print();
                menu();

            }

            case 2: {

                Deque.Remover_I();
                System.out.println();
                Deque.print();
                menu();

            }

            case 3: {
                System.out.println();
                System.out.println("Digite o valor que deseja adicionar");
                int valor = imput.nextInt();
                Deque.Adicionar_F(valor);
                Deque.print();
                menu();

            }

            case 4: {

                Deque.Remover_F();
                System.out.println();
                Deque.print();
                menu();

            }

            case 5: {
                
                System.out.println("Inicio: " + Deque.Inicio());
                menu();

            }

            case 6: {
                
                System.out.println("Fim: " + Deque.Fim());
                menu();

            }

            case 7: {

                if (Deque.Vazia()) {
                    System.out.println("Deque está vazio");
                } else {
                    System.out.println("Deque não está vazio");
                }   
                menu();

            }

            case 8: {

                System.out.println("Tamanho: " + Deque.Tamanho());
                menu();

            }

            case 9: {
                System.out.println("Saindo...");
                break;
            }

        }
    }
    public static void main(String[] args) {

        Main_Encadeada main = new Main_Encadeada();
        main.menu();

    }
}
