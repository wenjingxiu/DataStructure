/**
 * Copyright (C), 2019-2020
 * FileName: ArrayQueue
 * Author:   Brave
 * Date:     2020/6/19 15:03
 * Description:
 */
public class ArrayQueue<T> implements Queue<T> {
    private MyArrayExpand<T> array;

    public ArrayQueue(int capacity){
        array = new MyArrayExpand<>(capacity);
    }

    public ArrayQueue(){
        array = new MyArrayExpand<>();
    }

    @Override
    public void enqueue(T temp) {
        array.addLast(temp);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: ");
        result.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize() - 1){
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
