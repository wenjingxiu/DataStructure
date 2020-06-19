/**
 * Copyright (C), 2019-2020
 * FileName: LinkedListStack
 * Author:   Brave
 * Date:     2020/6/19 19:29
 * Description:
 */

public class LinkedListStack<T> implements Stack<T> {
    private LinkedList<T> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T temp) {
        list.addFirst(temp);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        return "Stack: top" + list;
    }
}
