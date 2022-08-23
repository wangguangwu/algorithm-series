package com.wangguangwu.basetructures.baselinkedlist;

/**
 * 定义一个接口，用来表示我们要实现的功能
 *
 * @author wangguangwu
 */
public interface MyCollection<E> {

    /**
     * 往链表尾部加入一个数据
     *
     * @param o 加入到链表当中的数据
     * @return boolean
     */
    boolean add(E o);

    /**
     * 表示在第 index 位置插入数据 o
     *
     * @param index index
     * @param o     o
     * @return boolean
     */
    boolean add(int index, E o);

    /**
     * 从链表中删除数据 o
     *
     * @param o o
     * @return boolean
     */
    boolean remove(E o);

    /**
     * 根据下表删除某个节点
     *
     * @param index index
     * @return boolean
     */
    boolean remove(int index);

    /**
     * 往链表尾部加入一个数据
     *
     * @param o o
     * @return boolean
     */
    boolean append(E o);

    /**
     * 返回链表的大小
     *
     * @return int
     */
    int size();

    /**
     * 表示链表是否为空
     *
     * @return boolean
     */
    boolean isEmpty();

    /**
     * 表示链表当中是否包含数据 o
     *
     * @param o p
     * @return boolean
     */
    boolean contains(E o);

}
