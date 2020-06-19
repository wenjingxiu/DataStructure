public interface Stack<T> {
    /**
     * 获取栈已使用的容量
     * @return 栈已使用的容量
     */
    int getSize();

    /**
     * 判断是否为空
     * @return 空则为true
     */
    boolean isEmpty();

    /**
     * 向栈顶加入一个元素
     * @param temp 一个元素
     */
    void push(T temp);

    /**
     * 弹出并获取栈顶
     * @return 栈顶元素
     */
    T pop();

    /**
     * 获取栈顶
     * @return 栈顶元素
     */
    T peek();
}
