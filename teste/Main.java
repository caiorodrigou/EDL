package teste;
import java.util.Scanner;
public class Main {

    Scanner imput = new Scanner(System.in);
    Metodos pilha = new Metodos(5,0);
    
    public void menu(){
        System.out.println();
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println("1 - PUSH");
        System.out.println("2 - POP");
        System.out.println("3 - TOP");
        System.out.println("4 - SIZE");
        System.out.println("5 - ISEMPTY");
        System.out.println("6 - sair");
        System.out.println("Qual operação deseja fazer?");
        System.out.println();

        int op = imput.nextInt();
        switch (op) {

            case 1 -> {
                System.out.println("Digite o valor que deseja adicionar");
                int valor = imput.nextInt();
                pilha.push(valor);
                pilha.print();
                menu();
            }
    
            case 2 -> {
                pilha.pop();
                pilha.print();
                menu();
            }
            case 3 -> {
            System.out.println("topo da pilha :" + pilha.top());
                menu();
            }   

            case 4 -> {
            System.out.println("tamanho da pilha :" + pilha.size());
                pilha.print();
                menu();
            }

            case 5 -> {
                System.out.println("Saindo...");
                break;
            }   

            case 6 -> {
                System.out.println("Saindo...");
                break;
            }
        }
    }
    public static void main(String[] args) {

        Main meuPrograma = new Main();
        meuPrograma.menu();
    }
     
}
