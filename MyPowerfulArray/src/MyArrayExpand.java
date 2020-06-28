public class MyArrayExpand<T> {
    private T[] data;
    private int size;

    // TODO: 实现可能的其他接口

    /**
     * 无参数的构造函数，默认数组容量为10
     */
    public MyArrayExpand(){
        this(10);
    }

    /**
     * 传入的容量capacity构造MyArray
     * @param capacity 必须为正整数
     */
    public MyArrayExpand(int capacity){
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public MyArrayExpand(T[] array){
        data = (T[])new Object[array.length];
        System.arraycopy(array, 0, data, 0, array.length);
        size = array.length;
    }

    /**
     * 获取数组中的元素个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取数组的容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 在数组所有元素前添加一个元素
     */
    public void addFirst(T temp){
        add(0, temp);
    }

    /**
     * 在数组所有元素后添加一个元素
     */
    public void addLast(T temp){
        // the first implement
//        if (size == data.length){
//            throw new IllegalArgumentException("AddLast failed. The array is full.");
//        }
//
//        data[size] = temp;
//        size ++;

        add(size, temp);
    }

    /**
     * 向数组中特定位置添加元素
     */
    public void add(int index, T temp){
        if (size == data.length){
            resize(2 * data.length);
        }

        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require size >= index >= 0.");
        }

        System.arraycopy(data, index, data, index + 1, size - index);

        data[index] = temp;
        size ++;
    }

    /**
     * 获取第一个元素
     */
    public T getFirst(){
        return get(0);
    }

    /**
     * 获取最后一个元素
     */
    public T getLast(){
        return get(size - 1);
    }

    /**
     * 获取索引位置的元素
     */
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Require size >= index >= 0.");
        }

        return data[index];
    }

    /**
     * 将指定索引位置的元素修改为目标值
     */
    public void set(int index, T temp){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Require size >= index >= 0.");
        }

        data[index] = temp;
    }

    /**
     * 是否包含某一元素
     */
    public boolean isContained(T temp){
        for (int i = 0; i < size; i++) {
            if (data[i] == temp){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找某一元素并且返回相应索引值
     */
    public int find(T temp){
        for (int i = 0; i < size; i++) {
            if (data[i].equals(temp)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除第一个元素，并返回该值
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * 删除最后一个元素，并返回该值
     */
    public T removeLast(){
        return remove(size - 1);
    }

    /**
     * 删除指定索引的元素，并返回该值
     */
    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed. Require size >= index >= 0.");
        }

        T ret = data[index];
        if (index != size - 1){
            System.arraycopy(data, index + 1, data, index, size - index);
        }
        data[index] = null;
        size --;

        if (size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }
        return ret;
    }

    /**
     * 通过元素值删除元素
     */
    public void removeElement(T temp){
        int index = find(temp);
        if (index != -1){
            remove(index);
        }
    }

    /**
     * toString方法重写，用于按格式打印数组。如直接输出
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Array: size = %d, capacity = %d\n", size, data.length);
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i != size - 1){
                result.append(", ");
            }
        }
        result.append(']');
        return result.toString();
    }

    /**
     * 直接调用函数打印数组，利用toString包装
     */
    public void print(){
        System.out.println(this);
    }

    /**
     * 重设容量：实现一定的动态性
     */
    private void resize(int newCapacity){
        T[] newData = (T[])new Object[newCapacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }

    /**
     * 交换两个位置的值
     */
    public void swap(int indexA, int indexB){
        if (indexA < 0 || indexB >= size || indexB < 0 || indexB >= size){
            throw new IllegalArgumentException("Index is illegal");
        }

        T temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }
}
