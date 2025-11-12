package Tad_lista.Dupla_encadeado;

import Tad_lista.Dupla_encadeado.DuplamenteEncadeado.Node;
import java.util.Scanner;

public class Main {

    Scanner imput = new Scanner(System.in);
    DuplamenteEncadeado lista = new DuplamenteEncadeado(); 

    public void menu() {

        System.out.println();
        System.out.println("-----------------------");
        System.out.println("1 - ReplaceElement");
        System.out.println("2 - swapElements");
        System.out.println("3 - insertBefore");
        System.out.println("4 - insertAfter");
        System.out.println("5 - insertFirst");
        System.out.println("6 - insertLast");
        System.out.println("7 - remove");
        System.out.println("8 - Size");
        System.out.println("9 - IsEmpty");
        System.out.println("10 - IsFirst");
        System.out.println("11 - IsLast");
        System.out.println("12 - First");
        System.out.println("13 - Last");
        System.out.println("14 - before");
        System.out.println("15 - after");
        System.out.println("16 - Sair");
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
                    System.out.print("Qual nó vc quer trocar?");
                    Object elemento = imput.nextLine();
                    Node no = (Node)lista.buscarNo(elemento);
                    imput.nextLine();
                    System.out.print("Qual elemento quer colocar?");
                    Object elemento2 = imput.nextLine();
                    lista.replaceElement(no, elemento2); 
                    lista.print();
                    menu();
                }

                case 2: {
                    System.out.print("Qual o primeiro nó que vc quer trocar?");
                    Object elemento1 = imput.nextLine();
                    Node no1 = (Node)lista.buscarNo(elemento1);
                    imput.nextLine();
                    System.out.print("Qual o segundo nó vc quer trocar?");
                    Object elemento2 = imput.nextLine();
                    Node no2 = (Node)lista.buscarNo(elemento2);
                    lista.swapElement(no1, no2);
                    lista.print();
                    menu();
                }

                case 3: {
                    System.out.print("Qual nó vc quer adicionar antes dele?");
                    Object elemento = imput.nextLine();
                    Node no = (Node)lista.buscarNo(elemento);
                    imput.nextLine();
                    System.out.print("Qual elemento quer colocar?");
                    Object elemento2 = imput.nextLine();
                    lista.insertBefore(no, elemento2);
                    lista.print();
                    menu();
                }
                
                case 4: {
                    System.out.print("Qual nó vc quer adicionar depois dele?");
                    Object elemento = imput.nextLine();
                    Node no = (Node)lista.buscarNo(elemento);
                    imput.nextLine();
                    System.out.print("Qual elemento quer colocar?");
                    Object elemento2 = imput.nextLine();
                    lista.insertAfter(no, elemento2);
                    lista.print();
                    menu();
                }
                
                case 5: {
                    System.out.print("Qual elemnto vc quer adicionar no inicio?");
                    Object elemento = imput.nextLine();
                    lista.insertFirst(elemento);
                    lista.print();
                    menu();
                }

                case 6: {
                    System.out.print("Qual elemnto vc quer adicionar no final?");
                    Object elemento = imput.nextLine();
                    lista.insertLast(elemento);
                    lista.print();
                    menu();
                }

                case 7: {
                    System.out.print("Digite o nó que deseja remover ");
                    Object elemento = imput.nextLine();
                    Node no = (Node)lista.buscarNo(elemento);
                    lista.removerNo(no);
                    lista.print();
                    menu();
                }


                case 8: {
                    int tamanho = lista.size();
                    System.out.println("O tamanho do Tad_lista é " + tamanho);
                    lista.print();
                    menu();
                }

                case 9: {
                    if (lista.IsEmpty()) {
                        System.out.println("Tad_Lista está vazio");
                    } else {
                        System.out.println("Tad_Lista não está vazio");
                    }
                    lista.print();
                    menu();
                }

                case 10: {
                    System.out.print("Digite o nó que deseja verificar se é o primeiro: ");
                    Object elemento = imput.nextLine();
                    Node no = (Node)lista.buscarNo(elemento); 
                    boolean resposta = lista.IsFirst(no);
                    System.out.println("O nó é o primeiro? " + resposta);
                    lista.print();
                    menu();
                }

                case 11: {
                    System.out.print("Digite o nó que deseja verificar se é o ultimo: ");
                    Object elemento = imput.nextLine();
                    Node no = (Node)lista.buscarNo(elemento); 
                    boolean resposta = lista.IsLast(no);
                    System.out.println("O nó é o primeiro? " + resposta);
                    lista.print();
                    menu();
                }

                case 12: {
                    Object elemento = lista.First();
                    System.out.println("O primeiro elemento é: " + elemento);
                    lista.print();
                    menu();
                }

                case 13: {
                    Object elemento = lista.Last();
                    System.out.println("O último elemento é: " + elemento);
                    lista.print();
                    menu();
                }

                case 14: {
                    System.out.print("Digite o nó que deseja verificar o nó anterior: ");
                    Object elemento = imput.nextLine();
                    Node no = (Node)lista.buscarNo(elemento); 
                    Object elemento2 = lista.before(no);
                    System.out.println("O nó anterior é: " + elemento2);
                    lista.print();
                    menu();
                }

                case 15: {
                    System.out.print("Digite o nó que deseja verificar o nó depois dele: ");
                    Object elemento = imput.nextLine();
                    Node no = (Node)lista.buscarNo(elemento); 
                    Object elemento2 = lista.after(no);
                    System.out.println("O próximo nó é: " + elemento2);
                    lista.print();
                    menu();
                }
                case 16: {
                    System.out.println("Saindo .....");
                    System.exit(0);
                }

                default: {
                    System.out.println("Opção inválida. Tente novamente.");
                    menu();
                }

            }
        } catch (Tad_ListaExcecao e) {
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