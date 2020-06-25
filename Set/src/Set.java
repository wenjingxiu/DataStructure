/**
 * Copyright (C), 2019-2020
 * FileName: Set
 * Author:   Brave
 * Date:     2020/6/25 16:34
 * Description: 集合接口
 */

public interface Set<T> {

    void add(T temp);
    void remove(T temp);
    boolean isContained(T temp);
    int getSize();
    boolean isEmpty();
}
