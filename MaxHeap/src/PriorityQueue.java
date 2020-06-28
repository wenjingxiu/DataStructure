/**
 * Copyright (C), 2019-2020
 * FileName: PriorityQueue
 * Author:   Brave
 * Date:     2020/6/29 0:25
 * Description: 基于堆实现的优先队列
 */

public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

    private MaxHeap<T> maxHeap;

    public PriorityQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void enqueue(T temp) {
        maxHeap.add(temp);
    }

    @Override
    public T dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public T getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
