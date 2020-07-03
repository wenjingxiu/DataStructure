/**
 * Copyright (C), 2019-2020
 * FileName: AVLSet
 * Author:   Brave
 * Date:     2020/7/3 14:43
 * Description: 基于 AVLTree 的 Set 实现
 */

public class AVLSet<T extends Comparable<T>> implements Set<T> {
    private AVLTree<T, Object> avlTree;

    public AVLSet(){
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(T temp) {
        avlTree.add(temp, null);
    }

    @Override
    public void remove(T temp) {
        avlTree.remove(temp);
    }

    @Override
    public boolean isContained(T temp) {
        return avlTree.isContained(temp);
    }

    @Override
    public int getSize() {
        return avlTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avlTree.isEmpty();
    }
}
