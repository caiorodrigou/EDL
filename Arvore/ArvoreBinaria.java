package Arvore;

import java.util.Iterator;

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
            return 1 + depth(node.pai);
        }
    }
    //verificar---------------------------------------------------
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

    public void insert(Object elemento) {
    }

    public Node search(Object elemento) {
        return null;
    }

    public void remove(Object elemento) {
    }

    public Iterator<Node> preorder() {
        return null;
    }

    public Iterator<Node> inOrder() {
        return null;
    }

    public Iterator<Node> postOrder() {
        return null;
    }

    public Iterator<Node> nodes() {
        return null;
    }

    public Iterator<Object> elements() {
        return null;
    }

    public void desenharArvore() {
    }
}