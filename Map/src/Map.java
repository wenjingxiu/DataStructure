/**
 * Copyright (C), 2019-2020
 * FileName: Map
 * Author:   Brave
 * Date:     2020/6/25 21:29
 * Description: 映射接口
 */

public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean isContained(K key);
    V get(K key);
    void set(K key, V value);
    int getSize();
    boolean isEmpty();
}
