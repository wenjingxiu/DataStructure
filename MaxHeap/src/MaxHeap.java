/**
 * Copyright (C), 2019-2020
 * FileName: MaxHeap
 * Author:   Brave
 * Date:     2020/6/28 22:33
 * Description: 最大堆实现
 */

public class MaxHeap<T extends Comparable<T>> {

    private MyArrayExpand<T> data;

    public MaxHeap(int capacity){
        data = new MyArrayExpand<>(capacity);
    }

    public MaxHeap(){
        data = new MyArrayExpand<>();
    }

    public MaxHeap(T[] array){
        data = new MyArrayExpand<>(array);

        for (int i = parent(array.length - 1); i >= 0; --i){
            siftDown(i);
        }
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if (index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(T temp){
        data.addLast(temp);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0){
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public T findMax(){
        if (data.isEmpty()){
            throw new IllegalArgumentException("Cannot find the max element when the heap is empty.");
        }
        return data.get(0);
    }

    public T extractMax(){
        T result = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return result;
    }

    private void siftDown(int index){
        while (leftChild(index) < data.getSize()){
            int childIndex = leftChild(index);
            if (childIndex + 1 < data.getSize() && data.get(childIndex + 1).compareTo(data.get(childIndex)) > 0){
                childIndex++;
            }

            if (data.get(index).compareTo(data.get(childIndex)) >= 0){
                break;
            }

            data.swap(index, childIndex);
            index = childIndex;
        }
    }

    public T replace(T temp){
        T result = findMax();

        data.set(0, temp);
        siftDown(0);

        return result;
    }


}
