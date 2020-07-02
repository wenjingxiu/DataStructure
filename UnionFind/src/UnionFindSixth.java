/**
 * Copyright (C), 2019-2020
 * FileName: UnionFindSixth
 * Author:   Brave
 * Date:     2020/7/3 0:18
 * Description: 并查集第六次实现：完全路径压缩（递归）
 */

public class UnionFindSixth implements UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFindSixth(int size){
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        if (index != parent[index]){
            parent[index] = find(parent[index]);
        }
        return parent[index];
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

        if (rank[oneRoot] < rank[otherRoot]){
            parent[oneRoot] = otherRoot;
        }
        else if (rank[oneRoot] > rank[otherRoot]){
            parent[otherRoot] = oneRoot;
        }
        else {
            parent[oneRoot] = otherRoot;
            rank[otherRoot] ++;
        }
    }
}
