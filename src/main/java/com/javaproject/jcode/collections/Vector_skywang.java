package com.javaproject.jcode.collections;

import java.util.Enumeration;
import java.util.Vector;



/**
 * <p>Vector：矢量队列，线程安全，默认容量10
 * <p>若容量增加系数 >0，则将容量的值增加“容量增加系数”；否则，将容量大小增加一倍       
 * <p>队列，支持添加、删除、修改、遍历等功能       
 *         
 * <p>推荐用随机访问去遍历，而不用迭代器：                  
 * <pre>vetcor.get(i)
 * <p> 
 */
public class Vector_skywang {
    public static void main(String[] args) {
        // 新建Vector
        Vector<String> vec = new Vector<String>();
            
        // 添加元素
        vec.add("1");
        vec.add("2");
        vec.add("3");
        vec.add("4");
        vec.add("5");

        // 设置第一个元素为100
        vec.set(0, "100");
        // 将“500”插入到第3个位置
        vec.add(2, "300");
        System.out.println("vec:"+vec);

        // (顺序查找)获取100的索引
        System.out.println("vec.indexOf(100):"+vec.indexOf("100"));
        // (倒序查找)获取100的索引
        System.out.println("vec.lastIndexOf(100):"+vec.lastIndexOf("100"));
        // 获取第一个元素
        System.out.println("vec.firstElement():"+vec.firstElement());
        // 获取第3个元素
        System.out.println("vec.elementAt(2):"+vec.elementAt(2));
        // 获取最后一个元素
        System.out.println("vec.lastElement():"+vec.lastElement());

        // 获取Vector的大小
        System.out.println("size:"+vec.size());
        // 获取Vector的总的容量
        System.out.println("capacity:"+vec.capacity());

        // 获取vector的“第2”到“第4”个元素，不包括“第4”个元素
        System.out.println("subList(1, 4):"+vec.subList(1, 4));

        // 通过Enumeration遍历Vector
        Enumeration<String> enu = vec.elements();
        while(enu.hasMoreElements())
            System.out.println("enu.nextElement():"+enu.nextElement());
            
        Vector<String> retainVec = new Vector<String>();
        retainVec.add("100");
        retainVec.add("300");
        // 获取“vec”中包含在“retainVec中的元素”的集合
        System.out.println("vec.retain():"+vec.retainAll(retainVec));
        System.out.println("vec:"+vec);
            
        // 获取vec对应的String数组
        String[] arr = (String[]) vec.toArray(new String[0]);
        // for循环
        for(int i = 0; i < arr.length; i++) {
        	System.out.println("arr[" + i + "]: " +  arr[i]);
        }       
        // 另一种for循环
        for (String str:arr)
            System.out.println("str:"+str);
             
        // 最快遍历方式：随机访问，通过索引值去遍历
        String value = null;
        for (int i = 0; i < vec.size(); i++) {
            value = vec.get(i);        
            System.out.println("value[" + i + "]: " + value);
        }

        
        
        
        // 清空Vector。clear()和removeAllElements()一样！
        vec.clear();
//        vec.removeAllElements();

        // 判断Vector是否为空
        System.out.println("vec.isEmpty():"+vec.isEmpty());
    }   
}
