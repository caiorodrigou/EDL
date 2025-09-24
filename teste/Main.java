package teste;
import java.util.Scanner;
public class Main {

    Scanner imput = new Scanner(System.in);
    Metodos pilha = new Metodos(5,0);
    
    public void menu(){
        System.out.println();
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println("1 - Push Vermelho / 6 - Push Preto");
        System.out.println("2 - Pop Vermelho / 7 - Pop Preto");
        System.out.println("3 - Top Vermelho / 8 - Top Preto");
        System.out.println("4 - Size Vermelho / 9 - Size Preto");
        System.out.println("5 - IsEmpty Vermelho / 10 - IsEmpty Preto");
        System.out.println();
        System.out.println("11 - sair");
        System.out.println();
        System.out.println("Qual operação deseja fazer?");
        System.out.println();

        int op = imput.nextInt();
        switch (op) {

            case 1 -> {
                System.out.println();
                System.out.println("Digite o valor que deseja adicionar");
                int valor = imput.nextInt();
                pilha.push_vermelho(valor);
                pilha.print();
                menu();
            }
    
            case 2 -> {
                pilha.pop_vermelho();
                pilha.print();
                menu();
            }
            case 3 -> {
                System.out.println();
                System.out.println("topo da pilha :" + pilha.top_vermelho());
                menu();
            }   

            case 4 -> {
                System.out.println();
                System.out.println("tamanho da pilha :" + pilha.size_vermelho());
                pilha.print();
                menu();
            }

            case 5 -> {
                System.out.println();
                pilha.isEmpty_vermelho();
                System.out.println();
                menu();
            }   

            case 6 -> {
                System.out.println();
                System.out.println("Digite o valor que deseja adicionar");
                int valor = imput.nextInt();
                pilha.push_preto(valor);
                pilha.print();
                menu();
            }

            case 11 -> {
                System.out.println("Saindo...");
                break;
            }
            
            default -> {
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