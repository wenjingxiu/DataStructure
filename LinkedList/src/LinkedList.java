import java.time.chrono.MinguoDate;

/**
 * Copyright (C), 2019-2020
 * FileName: LinkedList
 * Author:   Brave
 * Date:     2020/6/19 16:13
 * Description: 链表实现
 */

public class LinkedList<T> {
    private class Node {
        public T element;
        public Node next;

        public Node(T temp, Node next) {
            this.element = temp;
            this.next = next;
        }

        public Node(T temp) {
            this.element = temp;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

//    private Node head;
    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, T temp){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. illegal index.");
        }

//        if (index == 0){
//            addFirst(temp);
//        } else {
//            Node pre = head;
//            for (int i = 0; i < index - 1; i++) {
//                pre = pre.next;
//            }
//
////            Node node = new Node(temp);
////            node.next = pre.next;
////            pre.next = node;
//
//            pre.next = new Node(temp, pre.next);
//            size++;

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        pre.next = new Node(temp, pre.next);
        size++;
    }

    public void addFirst(T temp){
        // 第一种实现方式
//        Node node = new Node(temp);
//        node.next = head;
//        head = node;

        // 第二种
//        head = new Node(temp, head);

//        size ++;

        add(0, temp);
    }

    public void addLast(T temp){
        add(size , temp);
    }

    public T get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Get failed. illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    public T getFirst(){
        return get(0);
    }

    public T getLast(){
        return get(size - 1);
    }

    public void set(int index, T temp){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Set failed. illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.element = temp;
    }

    public boolean isContained(T temp){
        Node cur = dummyHead.next;

        while (cur != null){
            if (cur.element.equals(temp)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public T remove(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Remove failed. illegal index.");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node retNode = pre.next;
        pre.next = retNode.next;
        retNode.next = null;
        size --;

        return retNode.element;
    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size - 1);
    }

    public void removeElement(T temp){
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.element.equals(temp)){
                break;
            }
            prev = prev.next;
        }

        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("LinkedList: size = ").append(size).append('\n');

        for (Node cur = dummyHead.next; cur != null ; cur = cur.next) {
            result.append(cur).append(" -> ");
        }

        result.append("NULL");
        return result.toString();
    }
}
