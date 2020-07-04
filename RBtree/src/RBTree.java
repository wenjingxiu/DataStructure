/**
 * Copyright (C), 2019-2020
 * FileName: RBTree
 * Author:   Brave
 * Date:     2020/7/4 11:46
 * Description: 红黑树实现
 */

public class RBTree<K extends Comparable<K>, V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private boolean isRed(Node node){
        if (node == null){
            return BLACK;
        }
        return node.color;
    }

    private Node leftRotate(Node node){

        Node right = node.right;

        node.right = right.left;
        right.left = node;

        right.color = node.color;
        node.color = RED;

        return right;
    }

    private Node rightRotate(Node node){
        Node left = node.left;

        node.left = left.right;
        left.right = node;

        left.color = node.color;
        node.color = RED;

        return left;
    }

    private void flipColors(Node node){
        node.color = RED;
        node.left.color = node.right.color = BLACK;
    }

    public void add(K key, V value){
        this.root = add(this.root, key, value);
        this.root.color = BLACK;
    }

    private Node add(Node node, K key, V value) {
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

        if (isRed(node.right) && !isRed(node.left)){
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)){
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }

        return node;
    }

    private Node getNode(Node node, K key){

        if(node == null)
            return null;

        if(key.equals(node.key))
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean isContained(K key){
        return getNode(root, key) != null;
    }

    public V get(K key){

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V value){
        Node node = getNode(root, key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = value;
    }

    private Node minimum(Node node){
        if(node.left == null)
            return node;
        return minimum(node.left);
    }

    private Node removeMin(Node node){

        if(node.left == null){
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
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){

        if( node == null )
            return null;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove(node.right, key);
            return node;
        }
        else{   // key.compareTo(node.key) == 0
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            if(node.right == null){
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
