package teste;

public class Metodos {
    
    private int capacidade;
    private Object[] itens;
    private int t;
    private int FC;

    public Metodos (int capacidade, int crescimento){
        this.capacidade = capacidade;
        this.t = -1;
        this.FC = crescimento;
        if (crescimento <= 0){
            this.FC = 0;
        }
        itens =  new Object[capacidade];
    }
    
    public void push (Object o){
        if (t == itens.length - 1){
            if (FC > 0){
                Object[] novo = new Object[itens.length + FC];
                for (int i = 0; i < itens.length; i++){
                    novo[i] = itens[i];
                }
                itens = novo;
            } else if (FC == 0) {
                Object[] novo = new Object[itens.length + itens.length];
                for (int i = 0; i < itens.length; i++){
                    novo[i] = itens[i];
                }
                itens = novo;
            } else {
                System.out.println("Pilha está cheia. Não é possível adicionar mais elementos.");
                return;
            }
        }

        t = t + 1;
        itens[t] = o;
           
    }

    public Object pop (){
        if (t == 0){
            
            System.out.println("Pilha está vazia. Não é possível remover mais elementos.");
            return null;
        } else {
            t = t - 1;
        }
        Object removido = itens[t + 1];

        System.out.println(" Elemento removido: " + removido);

        return removido;
    }

    public Object top (){

        return itens[t];
    }

    public int size (){
        return t + 1;
    }

    public void print (){
        System.out.println();
        System.out.print("Pilha: ");
        for (int i = 0; i <= t; i++){
            System.out.print(itens[i] + " ");
        }
        System.out.println();
    }
}
