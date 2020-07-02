import java.util.ArrayList;

/**
 * Copyright (C), 2019-2020
 * FileName: AVLTree
 * Author:   Brave
 * Date:     2020/7/3 0:46
 * Description: AVLTree 实现
 */

public class AVLTree<K extends Comparable<K>, V> {
    private class Node{
        public K key;
        public V value;
        public Node left, right;
        public int height;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);

        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i + 1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null){
            return;
        }

        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null){
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int getHeight(Node node){
        if (node == null){
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node node){
        if (node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private Node add(Node node, K key, V value){
        if (node == null){
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }
        else if (key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }
        else {
            node.value = value;
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1){
            System.out.println("unbalanced: " + balanceFactor);
        }

        return node;
    }

    public void add(K key, V value){
        root = add(root, key, value);
    }

    private Node getNode(Node node, K key){
        if (node == null){
            return null;
        }

        if (key.compareTo(node.key) == 0){
            return node;
        }
        else if (key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }
        else {
            return getNode(node.right, key);
        }
    }

    public void set(K key, V value) {
        Node node = getNode(root, key);

        if (node == null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }

        node.value = value;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public boolean isContained(K key){
        return getNode(root, key) != null;
    }

    private Node minimum(Node node) {
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    private Node removeMin(Node node) {
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public V remove(K key){
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if (node == null){
            return null;
        }

        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }
        else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }
        else {
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }
}
