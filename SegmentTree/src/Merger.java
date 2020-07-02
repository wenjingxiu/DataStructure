/**
 * Copyright (C), 2019-2020
 * FileName: Merger
 * Author:   Brave
 * Date:     2020/7/2 15:21
 * Description: 融合器，将两个或多个不同的元素融合成一个
 */

public interface Merger<T> {
    T merge(T a, T b);
}
