package com.javaproject.jcode.collections;

import java.util.*;

/**
 * <p>ArrayList
 * <p>基于数组实现的List类，它封装了一个动态的增长的、允许再分配的Object[]数组
 */
public class ArrayList_runoob {
	
		public static void main(String[] args) {
		
		/**
		 * 元素有序，可重复，并能引入位置下标
		 */
		List<String> list = new ArrayList<String>();
	    list.add("Hello");
	    list.add("World");
	    list.add("HAHAHAHA");
	    list.add(0, "index0");
	    list.add(2, "index2");

	    
	    
	     //第一种遍历方法：使用for遍历List
	    System.out.println("for (String str : list):");
	    for (String str : list) {            //也可以改写for(int i=0;i<list.size();i++)形式
	       System.out.println(str);
	    }
//	    for(int i = 0; i < list.size(); i++) {
//	    	System.out.println("" + list.arr);
//	    }
	    System.out.println("\r\n System.out.println(list):");
	    System.out.println(list);
	    // [index0, Hello, index2, World, HAHAHAHA]
	    
	    
	    lineFeed();	//换行
	    
	    
	     //第二种遍历：把链表变为数组相关的内容进行遍历
	    String[] strArray = new String[list.size()];
	    list.toArray(strArray);
	    for(int i=0; i < strArray.length; i++) { //这里也可以改写为  foreach(String str:strArray)形式
	    
	       System.out.println("strArray[" + i + "]: " + strArray[i]);
	    }
	    
	    
	    lineFeed();
	    
	    
	    //第三种遍历：使用迭代器进行相关遍历
	    //该方法不用担心在遍历的过程中会超出集合的长度
	    Iterator<String> ite = list.iterator();
	    while(ite.hasNext())//判断下一个元素之后有值
	    {
	        System.out.println("ite.next():" + ite.next());
	    }
	    
	    
	     
	    lineFeed();
	    
	   
	    //indexOf: 判断指定元素在List集合中位置
        System.out.println("indexOf 'World': " + list.indexOf(new String("World"))); 		    
        //替换元素对象
        list.set(0, new String("My"));
        System.out.println("set index0 = \"My\"");
        System.out.println(list);
        lineFeed();
	    
	    
	    //删除第N个元素
	    list.remove(2);
	    System.out.println("remove index=2...");
	    System.out.println(list);
	    
	    
	    lineFeed();
	    
	    
	    //获取指定位置的元素
	    for(int i = 0; i < list.size(); i++ ) {
	    	System.out.println("list.get(" + i + "): " + list.get(i));
	    }
        
        
	    lineFeed();
	    
	    
	    //截取集合的一部分变为子集合：不包括第二个下标的元素
	    //这里不包括3
	    System.out.println("list.subList(1, 3):" + list.subList(1, 3));
        
	    
	    lineFeed();
	    
	    
	    //清空数组
	    list.clear();
	    System.out.println("list.clear();");
	    System.out.println(list);

	}
	
	
	/**
	 * 换行
	 */
	static void lineFeed() {
		System.out.println("\r\n");
	}
}
