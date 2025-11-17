package Tad_Sequencia;
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
    //genéricos----------------------------------------

    public int size() {
        return tamanho; 
    }

    public boolean IsEmpty() { 
        return tamanho == 0;
    }

    private Node getNo(int rank) {
     
        if (rank < 0 || rank >= tamanho) {
            throw new Tad_SequenciaExcecao("Rank inválido: " + rank); 
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

    //Vetor--------------------------------------------

    public Object ElemAtRank(int r){ 
    if (IsEmpty()) {
        throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
    }
    return getNo(r).elemento;
    }

    public Object replaceAtRank( int r, Object elemento) {
        if (IsEmpty()) {
        throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
        }
        Node no = getNo(r);
        Object antigo_valor = no.elemento;
        no.elemento = elemento;
        return antigo_valor;

    }

    public void insertAtRank(int r, Object elemento) {
        if (IsEmpty()) {
        throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
        }
        Node no = getNo(r);
        Node novo = new Node(elemento,null,null);
        novo.next = no;
        novo.prev = no.prev;
        no.prev.next = novo;
        no.prev = novo;
        tamanho++;
    }

    public Object removeAtRank(int r) {
        if (IsEmpty()) {
        throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
        }
        Node no = getNo(r);
        Object elemento = no.elemento;
        no.next.prev = no.prev;
        no.prev.next = no.next;
        no.prev = null;
        no.next = null;
        no.elemento = null;
        tamanho--;
        return elemento;
    }
   
    //Lista--------------------------------------------

    public Object First(){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
        }
        Node primeiro = cabeca.next;
        return primeiro.elemento;
    }

    public Object Last(){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
        }
        Node ultimo = cauda.prev;
        return ultimo.elemento;
    }

    public Object before(Node no){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
        }
        if (no == cabeca.next) {
            return null;
        }
        return no.prev.elemento;
    }

    public Object after(Node no){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
        }
        if (no == cauda.prev) {
            return null;
        }
        return no.next.elemento;
    }

    public Object replaceElement( Node no, Object elemento) {
        Object antigo_valor = no.elemento;
        no.elemento = elemento;
        return antigo_valor;
        }

    public String swapElement( Node no, Node no2) {
        Object antigo_valor = no.elemento;
        no.elemento = no2.elemento;
        no2.elemento = antigo_valor;
        return "Elementos trocados com sucesso!";
    }

    public void insertBefore(Node no, Object elemento) {
        Node novo = new Node(elemento,null,null);
        novo.next = no;
        novo.prev = no.prev;
        no.prev.next = novo;
        no.prev = novo;
        tamanho++;
    }

    public void insertAfter(Node no, Object elemento) {
        Node novo = new Node(elemento,null,null);
        novo.next = no.next;
        novo.prev = no;
        no.next.prev = novo;
        no.next = novo;
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

    public Object removerNo(Node no) throws Tad_SequenciaExcecao {
        Object elemento = no.elemento;  
        no.prev.next = no.next;
        no.next.prev = no.prev;
        no.prev = null;
        no.next = null;
        no.elemento = null;
        tamanho--;
        return elemento;
    }

    //ponte--------------------------------------------

    public Node getNo(Node no) {
     
        if (no == null) {
        throw new Tad_SequenciaExcecao("A posição (nó) não pode ser nula.");
        }
        if (no == cabeca) {
            throw new Tad_SequenciaExcecao("A posição não pode ser a sentinela 'cabeca'.");
        }
        if (no == cauda) {
            throw new Tad_SequenciaExcecao("A posição não pode ser a sentinela 'cauda'.");
        }
        return no;
    }

    public Object buscarNo(Object elemento){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
        }
        Node atual = cabeca.next;
        while (atual != cauda) {
            if (atual.elemento.equals(elemento)) {
                return atual;
            }
            atual = atual.next;
        }
        throw new Tad_SequenciaExcecao("Elemento não encontrado.");
    }

    public Object atRank(int r){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio"); 
        }
        Node atual = cabeca.next;
        int rank = 0;
        while (atual != cauda) {
            if (rank == r) {
                return atual.elemento;   
            }
            atual = atual.next;
            rank++;
        }
        throw new Tad_SequenciaExcecao("Elemento não encontrado.");
    }

    public Object rankOf(Node no){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Sequencia esta vazio");
        }
        Node atual = cabeca.next;
        int rank = 0;
        while (atual != cauda) {
            if (atual == no) {
                return rank;
            }
            atual = atual.next;
            rank++;
        }
        throw new Tad_SequenciaExcecao("Nó não encontrado.");
    }

    // printar---------------------------------------------
    public Object print() {
        System.out.println();
        
        if (IsEmpty()) {
            System.out.println("-------------------------------");
            System.out.println("Tad_Sequencia esta vazio");
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