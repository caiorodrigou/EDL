package Listas_Encadeadas;
import java.util.Scanner;

import Rubro_Negra.RubroNegra;

public class lista_Encadeada {

    Scanner imput = new Scanner(System.in);
    RubroNegra pilha = new RubroNegra(5, 0);
    
    public void menu() {

        System.out.println();
        System.out.println("ESCOLHA UMA OPÇÃO");
        System.out.println("1 - Push Vermelho / 6 - Push Preto");
        System.out.println("2 - Pop Vermelho / 7 - Pop Preto");
        System.out.println("3 - Top Vermelho / 8 - Top Preto");
        System.out.println("4 - Size Vermelho / 9 - Size Preto");
        System.out.println("5 - IsEmpty Vermelho
}
