/**
 * Copyright (C), 2019-2020
 * FileName: UnionFindFirst
 * Author:   Brave
 * Date:     2020/7/2 23:08
 * Description: 并查集第一次实现，快速查询
 */

public class UnionFindFirst implements UnionFind {

    private int[] id;

    public UnionFindFirst(int size){
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    private int find(int index){
        if (index < 0 || index >= id.length){
            throw new IllegalArgumentException("index is out of bound");
        }

        return id[index];
    }

    @Override
    public boolean isConnected(int one, int other) {
        return find(one) == find(other);
    }

    @Override
    public void unionElements(int one, int other) {
        int oneID = find(one);
        int otherID = find(other);

        if (oneID == otherID) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == oneID){
                id[i] = otherID;
            }
        }
    }
}
