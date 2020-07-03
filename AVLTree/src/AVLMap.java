/**
 * Copyright (C), 2019-2020
 * FileName: AVLMap
 * Author:   Brave
 * Date:     2020/7/3 14:34
 * Description: 基于 AVLTree 的 map 实现
 */

public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> avlTree;

    public AVLMap(){
        avlTree = new AVLTree<>();
    }


    @Override
    public void add(K key, V value) {
        avlTree.add(key, value);
    }

    @Override
    public V remove(K key) {
        return avlTree.remove(key);
    }

    @Override
    public boolean isContained(K key) {
        return avlTree.isContained(key);
    }

    @Override
    public V get(K key) {
        return avlTree.get(key);
    }

    @Override
    public void set(K key, V value) {
        avlTree.set(key, value);
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
