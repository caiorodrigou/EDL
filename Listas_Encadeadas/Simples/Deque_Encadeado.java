package Listas_Encadeadas.Simples;

import Listas_Encadeadas.DequeVaziaExcecao;

public class Deque_Encadeado {

    private Node inicio = null;
    private Node fim = null;
    private int tamanho = 0;

    private class Node {
        Object Valor;
        Node Proximo;

        Node(Object Valor) {
            this.Valor = Valor;
            this.Proximo = null;
        }
    }

    // Metodos

    public void Adicionar_I(Object Valor) {
        Node no = new Node(Valor);

        if (tamanho == 0) {
            inicio = no;
            fim = no;
        } else {
            no.Proximo = inicio;
            inicio = no;
        }
        tamanho++;

    }

    public void Adicionar_F(Object Valor) {
        Node no = new Node(Valor);

        if (tamanho == 0) {
            inicio = no;
            fim = no;
        } else {
            fim.Proximo = no;
            fim = no;
        }
        tamanho++;

    }

    public Object Remover_I() {

        if (tamanho == 0) {
            throw new DequeVaziaExcecao("Fila esta vazia");
        }

        Object Valor_Removido = inicio.Valor;
        inicio = inicio.Proximo;

        if (inicio == null) {
            fim = null;
        }

        tamanho--;
        return Valor_Removido;
    }

    public Object Remover_F() {
        if (tamanho == 0) {
            throw new DequeVaziaExcecao("Fila esta vazia");
        }

        Object Valor_Removido = fim.Valor;

        if (inicio.Proximo == null) {
            inicio = null;
            fim = null;
        } else {
            Node agora = inicio;
            for (int i = 0; i < tamanho - 2; i++) {
                agora = agora.Proximo;
            }
            agora.Proximo = null;
            fim = agora;
        }
        tamanho--;
        return Valor_Removido;
    }
    
    public Object Inicio() {
        if (inicio == null) {
            throw new DequeVaziaExcecao("Deque não tem inicio");
        }
        return inicio.Valor;
    }

    public Object Fim() {
        if (fim == null) {
            throw new DequeVaziaExcecao("Deque não tem inicio");
        }
        return fim.Valor;
    }

    public boolean Vazia() {
        return tamanho == 0;
    }   

    public int Tamanho() {
        return tamanho;
    }

    public void print() {
        System.out.println();
        if (tamanho == 0) {
            System.out.println("-------------------------------");
            System.out.println("Deque está vazio");
            System.out.println("-------------------------------");
            return;
        }
        System.out.println("-------------------------------");
        System.out.print("Deque: ");
        Node agora = inicio;
        while (agora != null) {
            System.out.print(agora.Valor + " ");
            agora = agora.Proximo;
        }
        System.out.println();
        System.out.println("Tamanho: " + tamanho);
        System.out.println("inicio " + Inicio());
        System.out.println("fim " + Fim());
        System.out.println("-------------------------------");
        System.out.println();
    }



}
