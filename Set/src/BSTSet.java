/**
 * Copyright (C), 2019-2020
 * FileName: BSTSet
 * Author:   Brave
 * Date:     2020/6/25 16:35
 * Description:
 */

public class BSTSet<T extends Comparable<T>> implements Set<T> {
    private BST<T> bst;
    public BSTSet(){
        bst = new BST<>();
    }

    @Override
    public void add(T temp) {
        bst.add(temp);
    }

    @Override
    public void remove(T temp) {
        bst.remove(temp);
    }

    @Override
    public boolean isContained(T temp) {
        return bst.isContained(temp);
    }

    @Override
    public int getSize() {
        return bst.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
