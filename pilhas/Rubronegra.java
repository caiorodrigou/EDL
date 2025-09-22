public class Rubronegra {

    public class Pilha_Vermelha {  
        public int size(tamanho_array){};    
        public boolean isEmpty();
        public Object top() throws PilhaVaziaExcecao;
        public void push(Object o);
        public Object pop() throws PilhaVaziaExcecao;
    }

    public class Pilha_Preta {  
        public int size(tamanho_array){};    
        public boolean isEmpty();
        public Object top() throws PilhaVaziaExcecao;
        public void push(Object o);
        public Object pop() throws PilhaVaziaExcecao;
    }

    //1
    public void Push_Vermelha (array){ 
        if (t_vermelho == S.length - 1) {
            throw new PilhaCheiaExcecao("Pilha está cheia. Não é possível adicionar mais elementos.");
        } else {
            t = t + 1;
            S[t] = o;
        }
      
    }

    //2
    public int Push_Preta (array) { 
      return 0;
    }

    //1
    public int Pop_Vermelha (array) { 
      
    }

    //2
    public int Pop_Preta (array) { 
        return 0;
      
    }

    //5
    public int Size_Vermelho (int t_vermelho){ 
        return t_vermelho + 1;
    }

    //5
    public int Size_Preto (int t_preto){ 
        return - (t_preto) ;
    }

    //5
    public int Top_Vermelho (array){ 
      
    }

    //5
    public int Top_Preto (array){ 
      
    }

}