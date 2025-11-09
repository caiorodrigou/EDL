package Tad_vetor;

public class Tad_vetor{

    public int capacidade ;
    public int tamanho ;
    public Object[] elementos;

    public Tad_vetor(int capacidade , int tamanho){
        this.capacidade = capacidade;
        this.tamanho = tamanho;
        this.elementos = new Object[capacidade];
    }

    public Object ElemAtRank(int r){ 
        if(tamanho == capacidade){
            System.out.println("Vetor cheio");
            return;
        }
        Object elemento = elementos[r];
        return elemento;
    }

    public Object ReplaceAtRank(int r, Object o){ 
        Object antigo_elemento = elementos[r];
        elementos[r] = o;
        return antigo_elemento;
    }

    public void insertAtRank(int r, Object o){
        if(tamanho == capacidade){
            System.out.println("Vetor cheio");
            return;
        }
        for(int i = tamanho - 1 ; i >= r ; i--){
            elementos[i + 1] = elementos[i];
        }
        elementos[r] = o ;
        tamanho++;
    }

    public Object removeAtRank(int r){
        Object elemento_removido = elementos[r];
        for(int i = r ; i < tamanho - 1 ; i++){
            elementos[i] = elementos[i + 1];
        }
        elementos[tamanho - 1] = null;
        tamanho--;
        return elemento_removido;
    }

    
}