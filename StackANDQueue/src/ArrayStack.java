public class ArrayStack<T> implements Stack<T> {
    MyArrayExpand<T> array;

    public ArrayStack(int capacity){
        array = new MyArrayExpand<>(capacity);
    }

    public ArrayStack(){
        array = new MyArrayExpand<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public void push(T temp) {
        array.addLast(temp);
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack: ");
        result.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if (i != array.getSize() - 1){
                result.append(", ");
            }
        }
        result.append("] top");
        return result.toString();
    }
}
