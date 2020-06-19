/**
 * Copyright (C), 2019-2020
 * FileName: Queue
 * Author:   Brave
 * Date:     2020/6/19 14:58
 * Description: 这是队列接口
 */

public interface Queue<T> {
    /**
     * 在队末加入元素
     */
    void enqueue(T temp);

    /**
     * 删除一个元素
     */
    T dequeue();

    /**
     * 弹出队列中第一元素
     */
    T getFront();

    /**
     * 获取队列大小
     */
    int getSize();

    /**
     * 判断是否为空
     */
    boolean isEmpty();
}
