package com.javaproject.jcode.collections;

import java.util.*;

/**
 * <p>ArrayList
 * <p>
 */
public class ArrayList_runoob {
	
	public static void main(String[] args) {
		
		/**
		 * List:
		 * 元素有序，可重复，并引入位置下标
		 */
		List<String> list = new ArrayList<String>();
	    list.add("Hello");
	    list.add("World");
	    list.add("HAHAHAHA");
	    list.add(0, "index0");
	    list.add(2, "index2");

	    
	    System.out.println("for (String str : list):");
	     //第一种遍历方法使用for遍历List
	    for (String str : list) {            //也可以改写for(int i=0;i<list.size();i++)形式
	       System.out.println(str);
	    }
//	    for(int i = 0; i < list.size(); i++) {
//	    	System.out.println("" + list.arr);
//	    }
	    System.out.println("\r\n System.out.println(list):");
	    System.out.println(list);
	    // [index0, Hello, index2, World, HAHAHAHA]
	    
	    
	    System.out.println("\r\n");
	    
	    
	     //第二种遍历，把链表变为数组相关的内容进行遍历
	    String[] strArray = new String[list.size()];
	    list.toArray(strArray);
	    for(int i=0; i < strArray.length; i++) { //这里也可以改写为  foreach(String str:strArray)形式
	    
	       System.out.println(strArray[i]);
	    }
	    
	    
	    System.out.println("\r\n");
	    
	    
	    //第三种遍历 使用迭代器进行相关遍历
	    Iterator<String> ite=list.iterator();
	    while(ite.hasNext())//判断下一个元素之后有值
	    {
	        System.out.println(ite.next());
	    }
	    
	}
}
