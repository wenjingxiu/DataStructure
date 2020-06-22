import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Copyright (C), 2019-2020
 * FileName: BST
 * Author:   Brave
 * Date:     2020/6/21 22:42
 * Description: 二分搜索树实现
 */

public class BST<T extends Comparable<T>> {
    private class Node{
        public T element;
        public Node left, right;

        public Node(T temp){
            this.element = temp;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

//    第一种实现方法
//    private void add(Node node, T temp){
//        if (temp.equals(node.element)){
//            return;
//        }
//        else if (temp.compareTo(node.element) < 0 && node.left == null){
//            node.left = new Node(temp);
//            size ++;
//            return;
//        }
//        else if (temp.compareTo(node.element) > 0 && node.right == null){
//            node.right = new Node(temp);
//            size ++;
//            return;
//
//        }
//
//        if (temp.compareTo(node.element) < 0){
//            add(node.left, temp);
//        }
//        else {
//            add(node.right, temp);
//        }
//    }

    // 第二种实现方法
    private Node add(Node node, T temp){
        if (node == null){
            size ++;
            return new Node(temp);
        }


        if (temp.compareTo(node.element) < 0){
            node.left = add(node.left, temp);
        }
        else if (temp.compareTo(node.element) > 0){
            node.right = add(node.right, temp);
        }

        return node;
    }

    public void add(T temp){
//        第一种实现方法
//        if (root == null){
//            root = new Node(temp);
//            size ++;
//        }
//        else {
//            add(root, temp);
//        }

        root = add(root, temp);
    }

    public boolean isContained(T temp){
        return isContained(root, temp);
    }

    private boolean isContained(Node node, T temp) {
        if (node == null){
            return false;
        }

        if (temp.compareTo(node.element) == 0){
            return true;
        }
        else if (temp.compareTo(node.element) < 0){
            return isContained(node.left, temp);
        }
        else { // temp.compareTo(node.element) > 0
            return isContained(node.right, temp);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null){
            return;
        }

        System.out.println(node.element);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.element);

            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.element);

            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public T minimum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }

        return minimum(root).element;
    }

    private Node minimum(Node node) {
        if (node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public T maximum(){
        if (size == 0){
            throw new IllegalArgumentException("BST is empty!");
        }

        return maximum(root).element;
    }

    private Node maximum(Node node) {
        if (node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    public T removeMin(){
        T result = minimum();

        root = removeMin(root);

        return result;
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

    public T removeMax(){
        T result = maximum();

        root = removeMax(root);

        return result;
    }

    private Node removeMax(Node node) {
        if (node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(T temp){
        root = remove(root, temp);
    }

    private Node remove(Node node, T temp) {
        if (node == null){
            return null;
        }

        if (temp.compareTo(node.element) < 0){
            node.left = remove(node.left, temp);
            return node;
        }
        else if (temp.compareTo(node.element) > 0){
            node.right = remove(node.right, temp);
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        generateBSTString(root, 0, result);
        return result.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder result) {
        if (node == null){
            result.append(generateDepthString(depth)).append("null\n");
            return;
        }

        result.append(generateDepthString(depth)).append(node.element).append('\n');
        generateBSTString(node.left, depth + 1, result);
        generateBSTString(node.right, depth + 1, result);
    }

    private String generateDepthString(int depth) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            if (i == 0) {
                result.append("|-");
            }
            result.append("--");
        }
        return result.toString();
    }
}
