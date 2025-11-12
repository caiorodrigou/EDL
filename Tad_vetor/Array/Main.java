package Tad_vetor.Array;

import java.util.Scanner;

public class Main {

    Scanner imput = new Scanner(System.in);
    Array_vetor array = new Array_vetor(5);

    public void menu() {

        System.out.println();
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println("1 - ElemAtRank");
        System.out.println("2 - ReplaceAtRank");
        System.out.println("3 - insertAtRank");
        System.out.println("4 - removeAtRank");
        System.out.println("5 - IsEmpty");
        System.out.println("6 - Size");
        System.out.println();
        System.out.println("7 - sair");
        System.out.println();
        System.out.println("Qual operação deseja fazer?");
        System.out.println();

        int op = imput.nextInt();
        switch (op) {

            case 1 : {

                array.op(1);
                System.out.println("qual indice vc quer acessar?");
                int rank = imput.nextInt();
                Object resposta = array.ElemAtRank(rank);
                System.out.println("Elemento no indice " + rank + " é: " + resposta);
                array.print();
                menu();
            }

            case 2 : {

                array.op(1);
                System.out.println("Digite o indice em que deseja substituir");
                int rank = imput.nextInt();
                imput.nextLine();
                System.out.println("Digite o elemento que deve substituir");
                Object elemento = imput.nextLine();
                Object resposta = array.ReplaceAtRank(rank,elemento);
                System.out.println("Antigo elemento :" + resposta);
                array.print();
                menu();
            }

            case 3 : {

                array.op(0);
                System.out.println("Digite o indice em que deseja inserir");
                int rank = imput.nextInt();
                imput.nextLine();
                System.out.println("Digite o elemento que deseja inserir");
                Object elemento = imput.nextLine();
                array.insertAtRank(rank,elemento);
                array.print();
                menu();
            }

            case 4 : {

                array.op(1);
                System.out.println("Digite o indice em que deseja remover o elemento");
                int rank = imput.nextInt();
                Object resposta = array.removeAtRank(rank);
                System.out.println("Elemento removido :" + resposta);
                array.print();
                menu();
            }


            case 5 : {

                if(array.IsEmpty()) {
                    System.out.println("Tad_Vetor está vazio");
                } else {
                    System.out.println("Tad_Vetor não está vazio");
                }
                array.print();
                menu();
            }

            case 6 : {

                array.Size();
                System.out.println("O tamanho do tad_Vetor é " + array.Size());
                array.print();
                menu();
            }

            case 7 : {
                System.out.println("Saindo...");
            break;
            }

            default : {
                System.out.println("Opção inválida. Tente novamente.");
                menu();
            }

        }
    }

    public static void main(String[] args) {

        Main meuPrograma = new Main();
        meuPrograma.menu();
    }

}