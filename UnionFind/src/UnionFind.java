/**
 * Copyright (C), 2019-2020
 * FileName: UnionFind
 * Author:   Brave
 * Date:     2020/7/2 23:03
 * Description: 并查集接口
 */

public interface UnionFind {
    int getSize();
    boolean isConnected(int one, int other);
    void unionElements(int one, int other);
}
