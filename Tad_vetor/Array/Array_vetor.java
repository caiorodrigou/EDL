package Tad_vetor.Array;

public class Array_vetor{

    public int capacidade ;
    public int tamanho ;
    public Object[] elementos;

    public Array_vetor(int capacidade){
        this.capacidade = capacidade;
        this.tamanho = 0;
        this.elementos = new Object[capacidade];
    }

    public Object ElemAtRank(int r){
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if (r < 0 || r >= tamanho) {
            throw new Tad_vetorExcecao("indice invalido");
        }

        Object elemento = elementos[r];
        return elemento;
    }

    public Object ReplaceAtRank(int r, Object o){ 
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if (r < 0 || r >= tamanho) {
            throw new Tad_vetorExcecao("indice invalido");
        }
  
        Object antigo_elemento = elementos[r];
        elementos[r] = o;
        return antigo_elemento;
    }

    public void insertAtRank(int r, Object o){
        if (r < 0 || r > tamanho) {
            throw new Tad_vetorExcecao("indice invalido");
        }

        for(int i = tamanho - 1 ; i >= r ; i--){
            elementos[i + 1] = elementos[i];
        }
        elementos[r] = o ;
        tamanho++;
    }

    public Object removeAtRank(int r){
        if (IsEmpty()) {
            throw new Tad_vetorExcecao("Tad_Vetor esta vazio");
        }
        if (r < 0 || r >= tamanho) {
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
     
    public Object op(int p){
        System.out.println();
        System.out.print("Indices disponiveis: ");
        if(p == 0){
            for (int i = 0; i < tamanho + 1; i++) {
                System.out.print(i + " ");
            }
        }
        else{
            for (int i = 0; i < tamanho; i++) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        return null;
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