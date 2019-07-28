package com.javaproject.jcode.collections;

import java.util.*;

/**
 * <p> List的使用场景
 * <p> 1.快速插入（list.add），删除元素（list.remove），应该使用 LinkedList
 * <p> 2.快速随机访问（list.get）元素，应该使用 ArrayList
 * <p> 3.对于“单线程环境” 或者 “多线程环境”，但List仅仅只会被单个线程操作，此时应该使用非同步的类
 */
public class Lists_SpeedTest {

   private static final int COUNT = 100000;

    private static LinkedList<Integer> linkedList = new LinkedList<Integer>();
    private static ArrayList<Integer> arrayList = new ArrayList<Integer>();
    private static Vector<Integer> vector = new Vector<Integer>();
    private static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        // 换行符
        System.out.println("\r");
        // 插入
        insertByPosition(stack) ;		// 1245 ms
        insertByPosition(vector) ;		// 1429 ms
        insertByPosition(linkedList) ;	// 9 ms		最快
        insertByPosition(arrayList) ;	// 1145 ms

        // 换行符
        System.out.println("\r");
        // 随机读取
        readByPosition(stack);			// 8 ms
        readByPosition(vector);			// 8 ms
        readByPosition(linkedList);		// 8616 ms	最慢
        readByPosition(arrayList);		// 2 ms		最快

        // 换行符
        System.out.println("\r");
        // 删除 
        deleteByPosition(stack);		// 1524 ms
        deleteByPosition(vector);		// 1198 ms
        deleteByPosition(linkedList);	// 8 ms		最快
        deleteByPosition(arrayList);	// 1423 ms
    }

    /**
     * 获取list的名称：list instanceof *
     */
    private static String getListName(List<Integer> list) {
        if (list instanceof LinkedList) {
            return "LinkedList";
        } else if (list instanceof ArrayList) {
            return "ArrayList";
        } else if (list instanceof Stack) {
            return "Stack";
        } else if (list instanceof Vector) {
            return "Vector";
        } else {
            return "List";
        }
    }

    /**
     * 向list的指定位置插入COUNT个元素，并统计时间：list.add(0, i)
     */
    private static void insertByPosition(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        // 向list的位置0插入COUNT个数
        for (int i = 0; i < COUNT; i++)
            list.add(0, i);

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : insert " + COUNT
        		+ " elements into the 1st position use time：" + interval+" ms");
    }

    /**
     * 从list的指定位置删除COUNT个元素，并统计时间：list.remove(0)
     */
    private static void deleteByPosition(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        // 删除list第一个位置元素
        for (int i = 0; i < COUNT; i++)
            list.remove(0);

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : delete " + COUNT
        		+ " elements from the 1st position use time：" + interval+" ms");
    }

    /** 
     * 根据position，不断从list中读取元素，并统计时间：list.get(i)
     */
    private static void readByPosition(List<Integer> list) {
        long startTime = System.currentTimeMillis();

        // 读取list元素
        for (int i = 0; i < COUNT; i++)
            list.get(i);

        long endTime = System.currentTimeMillis();
        long interval = endTime - startTime;
        System.out.println(getListName(list) + " : read "+COUNT+" elements by position use time：" + interval+" ms");
    }	
	
	
}
