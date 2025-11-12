package Tad_vetor.dupla_encadeado;

public class DuplamenteEncadeado {

    private static class Node {
        Object elemento;
        Node prev;
        Node next;

        public Node(Object elemento, Node p, Node n) {
            this.elemento = elemento;
            this.prev = p;
            this.next = n;
        }
    }

    private Node cabeca; 
    private Node cauda;  
    private int tamanho; 

    public DuplamenteEncadeado() {
        cabeca = new Node(null, null, null); 
        cauda = new Node(null, cabeca, null); 
        cabeca.next = cauda;
        tamanho = 0;
    }

    private Node getNo(int rank) {
     
        if (rank < 0 || rank >= tamanho) {
            throw new Tad_vetorExcecao("Rank inválido: " + rank); 
        }

        Node no;
        if (rank < tamanho / 2) {
            no = cabeca.next;
            for (int i = 0; i < rank; ++i) {
                no = no.next;
            }
        } else {
            no = cauda.prev;
            for (int i = 0; i < tamanho - 1 - rank; ++i) {
                no = no.prev;
            }
        }
        return no;
    }

    private void adicionarNo(Node m, Object elemento) {
        Node no = m.next;
        Node newNo = new Node(elemento, m, no);
        m.next = newNo;
        no.prev = newNo;
        tamanho++;
    }

    private Object removerNo(Node no_r) {
        Node anterior = no_r.prev;
        Node proximo = no_r.next;
        anterior.next = proximo;
        proximo.prev = anterior;
        Object no_removido = no_r.elemento;

        no_r.prev = null;
        no_r.next = null;
        no_r.elemento = null;

        tamanho--;
        return no_removido;
    }

    public Object elementAtRank(int rank) {
        return getNo(rank).elemento;
    }

    public Object replaceAtRank(int rank, Object elemento) {
        Node no = getNo(rank);
        Object antigo_valor = no.elemento;
        no.elemento = elemento;
        return antigo_valor;
    }

    public void insertAtRank(int rank, Object element) {
        if (rank < 0 || rank > tamanho) {
            throw new Tad_vetorExcecao("Rank de inserção inválido.");
        }
        
        Node no;
        if (rank == tamanho) {
            no = cauda; 
        } else {
            no = getNo(rank); 
        }
        
        adicionarNo(no.prev, element);
    }

    public Object removeAtRank(int rank) {

        if (isEmpty()) {
            throw new Tad_vetorExcecao("A lista está vazia.");
        }
        
        Node no = getNo(rank);
        return removerNo(no);
    }

    public int size() { return tamanho; }

    public boolean isEmpty() { return tamanho == 0; }

    public Object print() {
        System.out.println();
        
        if (isEmpty()) {
            System.out.println("-------------------------------");
            System.out.println("Tad_Vetor está vazio.");
            System.out.println("-------------------------------");
            return null;
        }

        System.out.println("-------------------------------");
        System.out.print("Tad_Vetor: ");
        
        Node current = cabeca.next;

        while (current != cauda) {
            System.out.print(current.elemento);
            
            if (current.next != cauda) {
                System.out.print(", ");
            }
            
            current = current.next;
        }
        
        System.out.println(""); 
        System.out.println("Tamanho: " + tamanho);
        System.out.println("-------------------------------");
        
        return null;
}
}