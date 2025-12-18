package Arvore;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        System.out.println("ESTADO INICIAL DA ÁRVORE");
        System.out.println("Está vazia? " + arvore.isEmpty()); 
        System.out.println("Tamanho: " + arvore.size());       

        System.out.println("\n INSERINDO ELEMENTOS");
 
        int[] valores = {10, 5, 15, 3, 7, 12, 18};
        for (int v : valores) arvore.insert(v); 

        System.out.println("ÁRVORE:");
        arvore.desenharHorizontal(arvore.root(), 0); 

        System.out.println("\nPROPRIEDADES DO NÓ: 5");
        ArvoreBinaria.Node no5 = arvore.search(5, arvore.root()); 
        
        if (no5 != null) {
            System.out.println("É raiz? " + arvore.isRoot(no5));         
            System.out.println("Pai do 5: " + arvore.parent(no5).elemento); 
            System.out.println("Filho esquerdo: " + arvore.leftChild(no5).elemento); 
            System.out.println("Filho direito: " + arvore.rightChild(no5).elemento); 
            System.out.println("Tem filho esquerdo? " + arvore.hasLeft(no5)); 
            System.out.println("Tem filho direito? " + arvore.hasRight(no5));   
            System.out.println("Profundidade: " + arvore.depth(no5));   
            System.out.println("Altura: " + arvore.height(no5)); 
        }

        System.out.println("\nITERADORES:");

        System.out.print("Pre-Order: ");
        imprimirIterator(arvore.preorder());
     
        System.out.print("In-Order:  ");
        imprimirIterator(arvore.inOrder());

        System.out.print("Post-Order: ");
        imprimirIterator(arvore.postOrder());

        System.out.print("Elements:   ");
        Iterator<Object> itElem = arvore.elements();
        while(itElem.hasNext()) System.out.print(itElem.next() + " ");
        System.out.println();

        System.out.println("\nREMOÇÃO:");
        System.out.println("Removendo o 10");
    
        arvore.remove(arvore.root(), 10); 
        
        arvore.desenharHorizontal(arvore.root(), 0);
        System.out.println("Novo tamanho: " + arvore.size());
        System.out.println("Está vazia? " + arvore.isEmpty());
    }

    private static void imprimirIterator(Iterator<ArvoreBinaria.Node> it) {
        while (it.hasNext()) {
            System.out.print(it.next().elemento + " ");
        }
        System.out.println();
    }
}