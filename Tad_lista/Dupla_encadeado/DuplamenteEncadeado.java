package Tad_lista.Dupla_encadeado;
import Tad_lista.Dupla_encadeado.Tad_ListaExcecao;

public class DuplamenteEncadeado {

    public static class Node {
        public Object elemento;
        public Node prev;
        public Node next;

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

    public Node getNo(Node no) {
     
        if (no == null) {
        throw new Tad_ListaExcecao("A posição (nó) não pode ser nula.");
        }
        if (no == cabeca) {
            throw new Tad_ListaExcecao("A posição não pode ser a sentinela 'cabeca'.");
        }
        if (no == cauda) {
            throw new Tad_ListaExcecao("A posição não pode ser a sentinela 'cauda'.");
        }
        return no;
    }

    public Object replaceElement( Node no, Object elemento) {
        Node novo = getNo(no);
        Object antigo_valor = novo.elemento;
        novo.elemento = elemento;
        return antigo_valor;
    }

    public String swapElement( Node no, Node no2) {
        Node novo1 = getNo(no);
        Node novo2 = getNo(no2);
        Object antigo_valor = novo1.elemento;
        novo1.elemento = novo2.elemento;
        novo2.elemento = antigo_valor;
        return "Elementos trocados com sucesso!";
    }

    public void insertBefore(Node no, Object elemento) {
        Node n = getNo(no);
        Node novo = new Node(elemento,null,null);
        novo.next = n;
        novo.prev = n.prev;
        n.prev.next = novo;
        n.prev = novo;
        tamanho++;
    }

    public void insertAfter(Node no, Object elemento) {
        Node n = getNo(no);
        Node novo = new Node(elemento,null,null);
        novo.next = n.next;
        novo.prev = n;
        n.next.prev = novo;
        n.next = novo;
        tamanho++;
    }

    public void insertFirst( Object elemento) {
        Node novo = new Node(elemento,null,null);
        novo.prev = cabeca;
        novo.next = cabeca.next;
        cabeca.next.prev = novo;
        cabeca.next = novo;
        tamanho++;
    }

    public void insertLast( Object elemento) {
        Node novo = new Node(elemento,null,null);
        novo.next = cauda;
        novo.prev = cauda.prev;
        cauda.prev.next = novo;
        cauda.prev = novo;
        tamanho++;
    }

    public Object removerNo(Node no) throws Tad_ListaExcecao {
    Node removido = getNo(no);
    Object elemento = removido.elemento;  
    removido.prev.next = removido.next;
    removido.next.prev = removido.prev;
    removido.prev = null;
    removido.next = null;
    removido.elemento = null;
    tamanho--;
    return elemento;
    }

    public Object buscarNo(Object elemento){
        if (IsEmpty()) {
            throw new Tad_ListaExcecao("A lista está vazia.");
        }
        Node atual = cabeca.next;
        while (atual != cauda) {
            if (atual.elemento.equals(elemento)) {
                return atual;
            }
            atual = atual.next;
        }
        throw new Tad_ListaExcecao("Elemento não encontrado.");
    }

    // padrão----------------------------------------------

    public int size() {
        return tamanho; 
    }

    public boolean IsEmpty() { 
        return tamanho == 0;
    }

    // novos-----------------------------------------------

    public boolean IsFirst(Node no){
        if (IsEmpty()) {
            throw new Tad_ListaExcecao("Tad_Lista esta vazio");
        }
        if (cabeca.next == no){
            return true;
        }
        return false;
    }

    public boolean IsLast(Node no){
        if (IsEmpty()) {
            throw new Tad_ListaExcecao("Tad_Lista esta vazio");
        }
        if (cauda.prev == no){
            return true;
        }
        return false;
    }

    public Object First(){
        if (IsEmpty()) {
            throw new Tad_ListaExcecao("Tad_Lista esta vazio");
        }
        Node primeiro = cabeca.next;
        return primeiro.elemento;
    }

    public Object Last(){
        if (IsEmpty()) {
            throw new Tad_ListaExcecao("Tad_Lista esta vazio");
        }
        Node ultimo = cauda.prev;
        return ultimo.elemento;
    }
    public Object before(Node no){
        if (IsEmpty()) {
            throw new Tad_ListaExcecao("Tad_Lista esta vazio");
        }
        if (IsFirst(no)) {
            return null;
        }
        return no.prev.elemento;
    }

    public Object after(Node no){
        if (IsEmpty()) {
            throw new Tad_ListaExcecao("Tad_Lista esta vazio");
        }
        if (IsLast(no)) {
            return null;
        }
        return no.next.elemento;
    }

    // printar---------------------------------------------
    public Object print() {
        System.out.println();
        
        if (IsEmpty()) {
            System.out.println("-------------------------------");
            System.out.println("Tad_Lista está vazio.");
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