/**
 * Copyright (C), 2019-2020
 * FileName: UnionFindThird
 * Author:   Brave
 * Date:     2020/7/2 23:41
 * Description: 并查集第三次实现：基于 size 的优化
 */

public class UnionFindThird implements UnionFind {

    private int[] parent;
    private int[] rootSize;

    public UnionFindThird(int size){
        parent = new int[size];
        rootSize = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rootSize[i] = 1;
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

        if (rootSize[oneRoot] < rootSize[otherRoot]){
            parent[oneRoot] = otherRoot;
            rootSize[otherRoot] += rootSize[oneRoot];
        }
        else {
            parent[otherRoot] = oneRoot;
            rootSize[oneRoot] += rootSize[otherRoot];
        }
    }
}
