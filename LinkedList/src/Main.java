/**
 * Copyright (C), 2019-2020
 * FileName: Main
 * Author:   Brave
 * Date:     2020/6/19 16:09
 * Description: 链表测试用
 */

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 10; i >= 0; i--) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(6, 666);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
