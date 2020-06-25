/**
 * Copyright (C), 2019-2020
 * FileName: LinkedListSet
 * Author:   Brave
 * Date:     2020/6/25 17:44
 * Description:
 */

public class LinkedListSet<T> implements Set<T> {
    private LinkedList<T> linkedList;

    public LinkedListSet(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(T temp) {
        if (!linkedList.isContained(temp)){
            linkedList.addFirst(temp);
        }
    }

    @Override
    public void remove(T temp) {
        linkedList.removeElement(temp);
    }

    @Override
    public boolean isContained(T temp) {
        return linkedList.isContained(temp);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
}
