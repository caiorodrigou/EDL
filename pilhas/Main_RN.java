import java.util.Scanner;
import Rubronegra.java;

public class Main_RN {
    
    Scanner imput = new Scanner(System.in);
    int op;

    public static void Main (){
        System.out.println("pilha rubronegra");
        System.out.println("-------------------");
        System.out.println("1 - PUSH_Vermelho ");
        System.out.println("2 - PUSH_Preto ");

        System.out.println("3 - POP_Vermelho ");
        System.out.println("4 - POP_Preto ");

        System.out.println("5 - TOP_Vermelho ");
        System.out.println("6 - TOP_Preto ");

        System.out.println("7 - SIZE_Vermelho ");
        System.out.println("8 - SIZE_Preto ");

        System.out.println("9 - ISEMPTY_Vermelho");
        System.out.println("10 - ISEMPTY_Preto ");

        System.out.println("0 - SAIR ");
        System.out.println("-------------------");
        System.out.println(" Digite uma opção: ");

        op = imput.nextInt();
        
        switch (op) {
            case 1:
                System.out.println("Qual a letra a ser inserida na pilha vermelha?");
                string letra = imput.nextLine();
                pilhas.Rubronegra.Push_Vermelha(letra);
                Main();
                
            case 2:
                System.out.println("PUSH_Preto");
                break;

            case 3:
                System.out.println("Removendo o elemento do topo da pilha vermelha:");
                system.out.println(pilhas.Rubronegra.Pop_Vermelha());
                Main();

            case 4:
                System.out.println("POP_Preto");
                break;

            case 5:
                System.out.println("topo da pilha vermelha:");
                system.out.println(pilhas.Rubronegra.Pop_Vermelha());
                Main();

            case 6:
                System.out.println("TOP_Preto");
                break;

            case 7:
                System.out.println("SIZE_Vermelho");
                break;

            case 8:
                System.out.println("SIZE_Preto");
                break;

            case 9:
                System.out.println("ISEMPTY_Vermelho");
                break;

            case 10:
                System.out.println("ISEMPTY_Preto");
                Main();

            case 0:
                System.out.println("SAIR");
                break;

            default:
                System.out.println("Opção inválida!");
                Main();

        }

    }
}
