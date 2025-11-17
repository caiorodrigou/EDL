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

    //Vetor--------------------------------------------

    public Object ElemAtRank(int r){ 
    if (IsEmpty()) {
        throw new Tad_SequenciaExcecao("Tad_Lista esta vazio");
    }
    if (r < 0 || r > tamanho) { 
        throw new Tad_SequenciaExcecao("indice invalido");
    }
    return elementos[r];
    }

    public Object replaceAtRank( int r, Object elemento) {
        return null;

    }

    public void insertAtRank(int r, Object elemento) {
        
    }

    public Object removeAtRank(int r) {
        return null;
   
    }

    //Lista--------------------------------------------

    public Object First(){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Lista esta vazio");
        }
        Node primeiro = cabeca.next;
        return primeiro.elemento;
    }

    public Object Last(){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Lista esta vazio");
        }
        Node ultimo = cauda.prev;
        return ultimo.elemento;
    }

    public Object before(Node no){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Lista esta vazio");
        }
        if (no == cabeca.next) {
            return null;
        }
        return no.prev.elemento;
    }

    public Object after(Node no){
        if (IsEmpty()) {
            throw new Tad_SequenciaExcecao("Tad_Lista esta vazio");
        }
        if (no == cauda.prev) {
            return null;
        }
        return no.next.elemento;
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

    public Object removerNo(Node no) throws Tad_SequenciaExcecao {
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
            throw new Tad_SequenciaExcecao("A lista está vazia.");
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