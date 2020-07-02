/**
 * Copyright (C), 2019-2020
 * FileName: UnionFindSecond
 * Author:   Brave
 * Date:     2020/7/2 23:28
 * Description: 并查集第二次实现：快速链接
 */

public class UnionFindSecond implements UnionFind {

    private int[] parent;

    public UnionFindSecond(int size){
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int index){
        if (index < 0 || index >= parent.length){
            throw new IllegalArgumentException("index is out of bound");
        }

        while (index != parent[index]){
            index = parent[index];
        }
        return index;
    }

    @Override
    public boolean isConnected(int one, int other) {
        return find(one) == find(other);
    }

    @Override
    public void unionElements(int one, int other) {
        int oneRoot = find(one);
        int otherRoot = find(other);

        if (oneRoot == otherRoot){
            return;
        }

        parent[oneRoot] = oneRoot;
    }
}
