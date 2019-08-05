package com.javaproject.jcode.set;

import java.util.Iterator;
import java.util.HashSet;


/** HashSet：是一个没有重复元素的、无序的集合
 *<p> 不保证元素的顺序，而且HashSet允许使用 null 元素
 *<p> 非同步，通过iterator()返回的迭代器是fail-fast的
 * 
 *<p> 依赖于HashMap，通过HashMap实现 
 * 
 */
public class HashSet_skywang {
	
    public static void main(String[] args) {
        // HashSet常用API
    	HashSet_APIs() ;
    	
    	
    	// 测试遍历
    	// 新建HashSet
        HashSet set = new HashSet();
        System.out.println("\n通过Iterator遍历HashSet：\n");
        // 添加元素 到HashSet中
        for (int i = 0; i < 5; i++)
            set.add(""+i);
        
        // 通过Iterator遍历HashSet
        iteratorHashSet(set) ;

        
    }

    /**
     * HashSet除了iterator()和add()之外的其它常用API
     */
    private static void HashSet_APIs() {
        // 新建HashSet
        HashSet<String> set = new HashSet<String>();

        // add()：将元素添加到Set中
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");

        // 打印HashSet的实际大小
        System.out.printf("size : %d\n", set.size());

        // set.contains()：判断HashSet是否包含某个值
        System.out.printf("HashSet contains a :%s\n", set.contains("a"));
        System.out.printf("HashSet contains g :%s\n", set.contains("g"));

        // set.remove()：删除HashSet中的“e”
        set.remove("e");

        // 将Set转换为数组
        String[] arr = (String[])set.toArray(new String[0]);
        for (String str:arr)
            System.out.printf("for each : %s\n", str);

        // 新建一个包含b、c、f的HashSet
        HashSet<String> otherset = new HashSet<String>();
        otherset.add("b");
        otherset.add("c");
        otherset.add("f");

        // 克隆一个removeset，内容和set一模一样
        HashSet removeset = (HashSet)set.clone();
        // 删除“removeset中，属于otherSet的元素”
        removeset.removeAll(otherset);
        // 打印removeset
        System.out.printf("removeset : %s\n", removeset);

        // 克隆一个retainset，内容和set一模一样
        HashSet retainset = (HashSet)set.clone();
        // 保留“retainset中，属于otherSet的元素”
        retainset.retainAll(otherset);
        // 打印retainset
        System.out.printf("retainset : %s\n", retainset);


        // set.iterator()：遍历HashSet
        for(Iterator iterator = set.iterator();
               iterator.hasNext(); ) 
            System.out.printf("iterator : %s\n", iterator.next());

        // set.clear()：清空HashSet
        set.clear();

        // set.isEmpty()：输出HashSet是否为空
        System.out.printf("%s\n", set.isEmpty()?"set is empty":"set is not empty");
    }



    /**
     * 推荐：通过Iterator遍历HashSet：
     * 不推荐：通过for-each遍历HashSet
     */
    private static void iteratorHashSet(HashSet set) {
        for(Iterator iterator = set.iterator();
               iterator.hasNext(); ) {
            System.out.printf("iterator : %s\n", iterator.next());
        }
    }



}
