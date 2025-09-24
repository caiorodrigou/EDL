package teste;

public class Metodos {
    
    private int capacidade;
    private Object[] itens;
    private int t_v;
    private int t_p;    
    private int FC;

    public Metodos (int capacidade, int crescimento){
        this.capacidade = capacidade;
        this.t_v = -1;
        this.t_p = capacidade;
        this.FC = crescimento;
        if (crescimento <= 0){
            this.FC = 0;
        }
        itens =  new Object[capacidade];
    }
    
    public void push_vermelho (Object o){
        if (t_v ==  t_p - 1){
            if (FC > 0){
                Object[] novo = new Object[itens.length + FC];
                for (int i = 0; i < t_v; i++){
                    novo[i] = itens[i];
                }
                for (int i = capacidade - 1; i < t_p; i--){
                    novo[capacidade - i] = itens[capacidade - i];
                }
                this.capacidade = novo.length;
                itens = novo;
            } else if (FC == 0) {
                Object[] novo = new Object[itens.length + itens.length];
                for (int i = 0; i < itens.length; i++){
                    novo[i] = itens[i];
                }
                this.capacidade = novo.length;
                itens = novo;
            } else {
                System.out.println("Pilha está cheia. Não é possível adicionar mais elementos.");
                return;
            }
        }

        t_v = t_v + 1;
        itens[t_v] = o;
           
    }

    public Object pop_vermelho () throws PilhaVaziaExcecao {
        if (t_v == -1){
            System.out.println();
            System.out.println("Pilha está vazia. Não é possível remover mais elementos.");
            return null;
        } else {
            t_v = t_v - 1;
        }
        Object removido = itens[t_v + 1];

        System.out.println(" Elemento removido: " + removido);

        return removido;
    }

    public Object top_vermelho () throws PilhaVaziaExcecao {
        if (t_v == -1){
            System.out.println("Pilha está vazia. Não é possível ver o topo da pilha.");
            return null;
        }
        return itens[t_v];
    }

    public int size_vermelho (){
        return t_v + 1;
    }

    public boolean isEmpty_vermelho(){
        return t_v == -1;
    }
    //                                 pilha preta
    //----------------------------------------------------------------------------------------------------------------

    public void push_preto (Object o){
        if (t_p == t_v + 1 ){
            if (FC > 0){
                Object[] novo = new Object[itens.length + FC];
                for (int i = 0; i < t_v; i++){
                    novo[i] = itens[i];
                }
                for (int i = capacidade - 1; i < t_p; i--){
                    novo[capacidade - i] = itens[capacidade - i];
                }
                this.capacidade = novo.length;
                itens = novo;
            } else if (FC == 0) {
                Object[] novo = new Object[itens.length + itens.length];
                for (int i = 0; i < itens.length; i++){
                    novo[i] = itens[i];
                }
                this.capacidade = novo.length;
                itens = novo;
            } else {
                System.out.println("Pilha está cheia. Não é possível adicionar mais elementos.");
                return;
            }
        }

        t_p = t_p - 1;
        itens[t_p] = o;
           
    }

    public Object pop_preto () throws PilhaVaziaExcecao {
        if (t_p == -1){
            System.out.println();
            System.out.println("Pilha está vazia. Não é possível remover mais elementos.");
            return null;
        } else {
            t_p = t_p - 1;
        }
        Object removido = itens[t_p + 1];

        System.out.println(" Elemento removido: " + removido);

        return removido;
    }

    public Object top_preto () throws PilhaVaziaExcecao {
        if (t_p == -1){
            System.out.println("Pilha está vazia. Não é possível ver o topo da pilha.");
            return null;
        }
        return itens[t_p];
    }

    public int size_preto (){
        return t_p + 1;
    }

    public boolean isEmpty_preto(){
        return t_p == -1;
    }

    public void print (){
        System.out.println();
        System.out.println("----------------------------------");
        System.out.print("Pilha: ");
        for (int i = 0; i <= capacidade - 1; i++){
            System.out.print(itens[i] + " ");
        }
        System.out.print("  /  ");
        System.out.println("tamanho do array: " + capacidade);
        System.out.println("----------------------------------");
        System.out.println();
    }
}