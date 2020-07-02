/**
 * Copyright (C), 2019-2020
 * FileName: SegmentTree
 * Author:   Brave
 * Date:     2020/7/2 15:00
 * Description: 线段树实现
 */

public class SegmentTree<T> {

    private T[] data;
    private T[] tree;
    private Merger<T> merger;

    public SegmentTree(T[] arr, Merger<T> merger){
        this.merger = merger;
        data = (T[])new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);

        tree = (T[])new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在 treeIndex的位置创建表示区间[left, right]的线段树
     * @param treeIndex 线段树的位置
     * @param left 闭区间的左端点
     * @param right 闭区间的右端点
     */
    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right){
            tree[treeIndex] = data[left];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = left + (right - left) / 2;

        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    public int getSize(){
        return data.length;
    }

    public T get(int index){
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    public T query(int left, int right){
        if (left < 0 || left >= data.length ||
                right < 0 || right >= data.length  ||
                left > right){
            throw new IllegalArgumentException("Index is illegal.");
        }

        return query(0, 0, data.length - 1, left, right);
    }

    private T query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left == queryLeft && right == queryRight){
            return tree[treeIndex];
        }

        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rigthTreeIndex = rightChild(treeIndex);

        if (queryLeft >= mid + 1){
            return query(rigthTreeIndex, mid + 1, right, queryLeft, queryRight);
        }
        else if (queryRight <= mid){
            return query(leftTreeIndex, left, mid, queryLeft, queryRight);
        }

        T leftResult = query(leftTreeIndex, left, mid, queryLeft, mid);
        T rightResult = query(rigthTreeIndex, mid + 1, right, mid + 1, queryRight);
        return merger.merge(leftResult, rightResult);
    }

    public void set(int index, T temp){
        if (index < 0 || index >= data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }

        data[index] = temp;
        set(0, 0, data.length - 1, index, temp);
    }

    private void set(int treeIndex, int left, int right, int index, T temp) {
        if (left == right){
            tree[treeIndex] = temp;
            return;
        }

        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1){
            set(rightTreeIndex, mid + 1, right, index, temp);
        }
        else {
            set(leftTreeIndex, left, mid, index, temp);
        }

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null){
                result.append(tree[i]);
            }
            else{
                result.append("null");
            }

            if (i != tree.length - 1){
                result.append(", ");
            }
        }
        result.append(']');
        return result.toString();
    }
}
