/**
 * Copyright (C), 2019-2020
 * FileName: LinkedListQueue
 * Author:   Brave
 * Date:     2020/6/19 19:26
 * Description:
 */

public class LinkedListQueue<T> implements Queue<T> {

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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(T temp) {
        if (tail == null){
            tail = new Node(temp);
            head = tail;
        }
        else {
            tail.next = new Node(temp);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if (head == null){
            tail = null;
        }
        size --;
        return retNode.element;
    }

    @Override
    public T getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.element;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: front ");

        Node cur = head;
        while (cur != null){
            result.append(cur).append(" -> ");
            cur = cur.next;
        }

        result.append("null tail");
        return result.toString();
    }
}
