/**
 * Copyright (C), 2019-2020
 * FileName: UnionFindForth
 * Author:   Brave
 * Date:     2020/7/2 23:53
 * Description: 并查集第四次实现：基于 rank 的优化
 */

public class UnionFindForth implements UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFindForth(int size){
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
