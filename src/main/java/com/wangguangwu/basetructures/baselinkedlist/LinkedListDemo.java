package com.wangguangwu.basetructures.baselinkedlist;

/**
 * @author wangguangwu
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println(list.contains(100));
        int times = 10;
        for (int i = 0; i < times; i++) {
            list.add(i);
        }
        list.add(0, -9999);
        System.out.println(list.size());
        list.add(5, 9999);
        list.append(Integer.MAX_VALUE);
        System.out.println(list);

        list.remove(5);
        list.add(6, 6666);
        System.out.println(list);
        System.out.println(list.contains(6666));
    }

}
