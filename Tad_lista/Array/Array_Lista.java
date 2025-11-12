package Tad_lista.Array;
import Tad_vetor.Array.Tad_vetorExcecao;

public class Array_Lista{

    public int capacidade ;
    public int tamanho ;
    public Object[] elementos;

    public Array_Lista(int capacidade){
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.elementos = new Object[capacidade];
    }

    private void aumentarTamanho() {
        int novaCapacidade = this.capacidade * 2;
        Object[] novoArray = new Object[novaCapacidade];
        

        for(int i = 0; i < this.capacidade; i++) {
        novoArray[i] = this.elementos[i];
        }
        

        this.elementos = novoArray;
        this.capacidade = novaCapacidade;
}

    public Object ReplaceElement(int r, Object o){ 
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if (r < 0 || r > tamanho) {
            throw new Tad_vetorExcecao("indice invalido");
        }
        Object antigo_elemento = elementos[r];
        elementos[r] = o;

        return antigo_elemento;
    }

    public String swapElements(int r, int s){ 
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if ((r < 0 || r > tamanho)|| (s < 0 || s >= tamanho)) {
            throw new Tad_vetorExcecao("indice invalido");
        }

        Object primeiro = elementos[r];
        elementos[r] = elementos[s];
        elementos[s] = primeiro ;

        return "Elementos trocados com sucesso!";
    }

    public void insertBefore(int r, Object o){
        if (tamanho == capacidade){
            aumentarTamanho();
        }
        if (r < 0 || r > tamanho) {
            throw new Tad_vetorExcecao("indice invalido");
        }
        for (int i = tamanho - 1 ; i >= r ; i--){
            elementos[i + 1] = elementos[i];
        }
        elementos[r] = o ;
        tamanho++;
    }

    public void insertAfter(int r, Object o){
        if (tamanho == capacidade){
            aumentarTamanho();
        }
        if (r < 0 || r >= tamanho) {
            throw new Tad_vetorExcecao("indice invalido");
        }
        for(int i = tamanho - 1 ; i >= r + 1; i--){
            elementos[i + 1] = elementos[i];
        }
        elementos[r + 1] = o ;
        tamanho++;
    }

    public void insertFirst(Object o){
        if (tamanho == capacidade){
            aumentarTamanho();
        }
        for(int i = tamanho - 1 ; i >= 0; i--){
            elementos[i + 1] = elementos[i];
        }
        elementos[0] = o ;
        tamanho++;
    }

    public void insertLast(Object o){
        if (tamanho == capacidade){
            aumentarTamanho();
        }
        elementos[tamanho] = o ;
        tamanho++;
    }

    public Object remove(int r){
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if (r < 0 || r > tamanho) {
            throw new Tad_vetorExcecao("indice invalido");
        }

        Object elemento_removido = elementos[r];
        for(int i = r ; i < tamanho - 1 ; i++){
            elementos[i] = elementos[i + 1];
        }
        elementos[tamanho - 1] = null;
        tamanho--;
        return elemento_removido;
    }

    //novos------------------------------------------------------
    
    public boolean IsFirst(int r){
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if (r == 0){
            return true;
        }
        return false;
    }

    public boolean IsLast(int r){
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if (r == tamanho - 1){
            return true;
        }
        return false;
    }

    public Object First(int r){
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        return elementos[0];
    }

    public Object Last(int r){
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        return elementos[tamanho-1];
    }

    public Object before(int r){
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if (IsFirst(r)) {
            return null;
        }
        return elementos[r-1];
    }

    public Object after(int r){
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if (IsLast(r)) {
            return null;
        }
        return elementos[r+1];
    }

    public Object ElemAtRank(int r){ 
    if (IsEmpty()) {
        throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
    }
    if (r < 0 || r > tamanho) { 
        throw new Tad_vetorExcecao("indice invalido");
    }
    return elementos[r];
}

    //padrao------------------------------------------------------

    public boolean IsEmpty(){
        return tamanho == 0;
    }

    public int Size(){
        return tamanho;
    }

    public Object print(){

        System.out.println();
        if (IsEmpty()) {
            System.out.println("-------------------------------");
            System.out.println("Tad_Vetor está vazio");
            System.out.println("-------------------------------");
            return null;
        }
        System.out.println("-------------------------------");
        System.out.print("Tad_Vetor: ");
        for (int i = 0; i < capacidade; i++) {
            System.out.print(elementos[i] + " ");
        }
        System.out.println();
        System.out.println("Tamanho: " + tamanho);
        System.out.println("-------------------------------");
        return null;
    }

    


}
