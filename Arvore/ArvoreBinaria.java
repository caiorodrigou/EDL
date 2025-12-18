package Arvore;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArvoreBinaria {

    public static class Node {
        public Object elemento;
        public Node pai;
        public Node left;
        public Node right;

        public Node(Object elemento, Node p, Node l, Node r) {
            this.elemento = elemento;
            this.pai = p;
            this.left = l;
            this.right = r;
        }
    }

    private Node root;
    private int size;

    public ArvoreBinaria() {
        root = null;
        size = 0;
    }

    public Node root() {
        if (root != null) {
            return root;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public Node parent(Node node) {
        return node.pai;
    }

    public boolean isRoot(Node node) {
        if (node.pai == null) {
            return true;
        }
        return false;
    }

    public int depth(Node node) {
        if (isRoot(node)) {
            return 0;
        } else {
            return (1 + depth(node.pai));
        }
    }
   
    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public Node leftChild(Node node) {
        return node.left;
    }

    public Node rightChild(Node node) {
        return node.right;
    }

    public boolean hasLeft(Node node) {
        if (node.left == null) {
            return false;
        }
        return true;
    }

    public boolean hasRight(Node node) {
        if (node.right == null) {
            return false;
        }
        return true;
    }
    
    public Node search(Object elemento, Node atual) {
        Comparable<Object> valor = (Comparable<Object>) elemento;
        if (atual == null) {
            return null;
        }

        int cmp = valor.compareTo(atual.elemento);
    
        if (cmp < 0) {
            return search(elemento, atual.left);
        }
        else if (cmp == 0) {
            return atual;
        }
        else {
            return search(elemento, atual.right);
        }
    }

    public void insert(Object elemento) {
        Comparable<Object> valor = (Comparable<Object>) elemento;
        if (root == null) {
            root = new Node(elemento, null, null, null);
            size++;
            return;
        } 
        Node atual = root;
        Node pai = null;
        while (atual != null) {
            pai = atual;
            if (valor.compareTo(atual.elemento) < 0) {
                atual = atual.left;
            } else {
                atual = atual.right;    
            }
        }

        Node novoNo = new Node(elemento, pai, null, null);

        if (valor.compareTo(pai.elemento) < 0) {
            pai.left = novoNo;
        } else {
            pai.right = novoNo;
        }
        size++;
    }

    public Node remove(Node atual, Object elemento) {
        if (atual == null) {
            return null; 
        }

        Comparable chave = (Comparable) elemento;
        int cmp = chave.compareTo(atual.elemento);

        if (cmp < 0) {
            atual.left = remove(atual.left, elemento);
        } else if (cmp > 0) {
            atual.right = remove(atual.right, elemento);
        } else {
            size--;
    
            if (atual.left == null) return atual.right;
            if (atual.right == null) return atual.left;

            Node sucessor = atual.right;
            while (sucessor.left != null) sucessor = sucessor.left;

            atual.elemento = sucessor.elemento;
            size++;
            atual.right = remove(atual.right, sucessor.elemento);
            if (atual.right != null) atual.right.pai = atual;
        }
        return atual;
    }

    public Iterator<Node> preorder() {
        List<Node> lista = new ArrayList<>();
        preOrderRecursivo(root, lista);
        return lista.iterator();
    }
    private void preOrderRecursivo(Node n, List<Node> lista) {
        if (n == null) return;
        lista.add(n); 
        preOrderRecursivo(n.left, lista);
        preOrderRecursivo(n.right, lista);
    }

    public Iterator<Node> inOrder() {
        List<Node> lista = new ArrayList<>();
        inOrderRecursivo(root, lista);
        return lista.iterator();
    }
    private void inOrderRecursivo(Node n, List<Node> lista) {
        if (n == null) return;
        inOrderRecursivo(n.left, lista);
        lista.add(n); 
        inOrderRecursivo(n.right, lista);
    }

    public Iterator<Node> postOrder() {
        List<Node> lista = new ArrayList<>();
        postOrderRecursivo(root, lista);
        return lista.iterator();
    }
    private void postOrderRecursivo(Node n, List<Node> lista) {
        if (n == null) return;
        postOrderRecursivo(n.left, lista);
        postOrderRecursivo(n.right, lista);
        lista.add(n); 
    }

    public Iterator<Node> nodes() {
        return inOrder();
    }

    public Iterator<Object> elements() {
        List<Object> listaElementos = new ArrayList<>();
        Iterator<Node> it = nodes();
        while (it.hasNext()) {
            listaElementos.add(it.next().elemento);
        }
        return listaElementos.iterator();
    }

    public void desenharHorizontal(Node no, int nivel) {
        if (no == null) return;

        desenharHorizontal(no.right, nivel + 1);

        System.out.println("       ".repeat(nivel) + "── " + no.elemento);

        desenharHorizontal(no.left, nivel + 1);
    }
}