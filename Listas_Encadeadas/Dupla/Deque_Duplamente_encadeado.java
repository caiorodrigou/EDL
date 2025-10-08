package Listas_Encadeadas.Dupla;

import Listas_Encadeadas.DequeVaziaExcecao;

public class Deque_Duplamente_encadeado {

    private Node inicio = null;
    private Node fim = null;
    private int tamanho = 0;

    private class Node {
        Object Valor;
        Node Proximo;
        Node Anterior;

        Node(Object Valor) {
            this.Valor = Valor;
            this.Proximo = null;
            this.Anterior = null;
        }
    }

    public void Adicionar_I(Object Valor) {
        Node no = new Node(Valor);

        if (tamanho == 0) {
            inicio = no;
            fim = no;
        } else {
            inicio.Anterior = no;
            no.Proximo = inicio;
            no.Anterior = null;
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
            no.Anterior = fim;
            fim = no;
        }
        tamanho++;

    }

    public Object Remover_I() {

        if (tamanho == 0) {
            throw new DequeVaziaExcecao("Deque esta vazio");
        }

        Object Valor_Removido = inicio.Valor;

        if (tamanho == 1) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.Proximo;
            inicio.Anterior = null;
        }

        tamanho--;
        return Valor_Removido;
    }

    public Object Remover_F() {
        if (tamanho == 0) {
            throw new DequeVaziaExcecao("Deque esta vazio");
        }

        Object Valor_Removido = fim.Valor;

        if (inicio.Proximo == null) {
            inicio = null;
            fim = null;
        } else {
            fim = fim.Anterior;
            fim.Proximo = null;
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
