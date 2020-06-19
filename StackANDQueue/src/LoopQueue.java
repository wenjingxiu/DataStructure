/**
 * Copyright (C), 2019-2020
 * FileName: LoopQueue
 * Author:   Brave
 * Date:     2020/6/19 15:17
 * Description:
 */

public class LoopQueue<T> implements Queue<T> {

    private T[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity){
        data = (T[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    private void resize(int newCapacity){
        T[] newData = (T[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public void enqueue(T temp) {
        if ((tail + 1) % data.length == front){
            resize(getCapacity() * 2);
        }

        data[tail] = temp;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        T result = data[tail];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return result;
    }

    @Override
    public T getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }

        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Array: size = %d, capacity = %d\n", size, getCapacity());
        result.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            result.append(data[i]);
            if ((i + 1) % data.length != tail){
                result.append(", ");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
