package Listas_Encadeadas;

public class DequeVaziaExcecao extends RuntimeException {
    public DequeVaziaExcecao(String err){
        super(err);
    }
}