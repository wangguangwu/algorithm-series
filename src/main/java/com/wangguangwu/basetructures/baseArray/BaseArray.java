package com.wangguangwu.basetructures.baseArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * 数组
 * <p>
 * 1. 特点
 * 1.1 数组的下标从 0 开始；
 * 1.2 数组需要先声明才能使用，未指定初始值时，值为 0
 * 1.3 数组的大小一旦确定就不可以再改变了
 * 1.4 数组本身是一块连续的内存空间，方便查找，不方便删除
 * <p>
 * 2. 声明方式
 * 2.1 只声明长度
 * 2.2 在声明的同时进行初始化
 *
 * @author wangguangwu
 */
@SuppressWarnings("all")
public class BaseArray {

    public static void main(String[] args) {
        // 声明一个长度为 10 的数组
        int[] array = new int[10];
        for (int i : array) {
            System.out.println(i);
        }

        System.out.println("======================");
        // 声明的同时进行初始化
        int[] array2 = new int[]{1, 2, 3};
        for (int i : array2) {
            System.out.println(i);
        }

        // 线程不安全
        // 扩容会扩 1.5 倍
        List<String> list = new ArrayList<>();

        // 线程安全
        // 在 add 和 remove ，即修改数据时，它的方法是 synchronized 的
        // 每次 add 时，size 只会加 1，同理 remove 时，size 只会减 1
        Vector<String> vector = new Vector<>();
    }

}
