package com.javaproject.jcode.map;

import java.util.Map;
import java.util.Random;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Collection;

/**	HashMap：散列表（无序的），它存储的内容是键值对(key-value)映射
 * 
 *<p> 容量capacity：哈希表中桶的数量； 
 *<p> 初始容量：哈希表在创建时的容量，默认16
 *
 *<p> 加载因子load factor：哈希表在其容量自动增加之前可以达到多满的一种尺度，默认0.75
 *
 *<p> 阈值threshold：判断是否需要调整HashMap的容量
 *<p> threshold的值=容量*加载因子，当HashMap中存储数据的数量达到threshold时，要将HashMap的容量加倍
 *
 *<p> 通过map.entrySet()遍历HashMap，效率高
 *
 */

public class HashMap_skywang {
	
	public static void main(String[] args) {
		HashMap_API();
		HashMap_Traversal();	
	}

	/**
	 * HashMap的API使用
	 */
	private static void HashMap_API() {
        System.out.println("Testing HashMap APIs...");		
		
        // 初始化随机种子
        Random r = new Random();
        
        // 新建HashMap
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        // 添加键值对：map.put(key, value)
        // key已经存在，则返回旧value，并将新的value存到该key中；
        // key不存在，则返回null
        map.put("one", r.nextInt(10));
        map.put("two", r.nextInt(10));
        map.put("three", r.nextInt(10));
//        map.put("one", 666);
        System.out.println("map put 'one' - 666: " + map.put("one", 666));		// 原来的随机数值
        System.out.println("map put 'four' - 777: " + map.put("four", 777));	// null
        // key为null时，不会抛出异常，而按照一个特殊的方法进行存储
        System.out.println("map put null - 777: " + map.put(null, 888));		// null=888
        
 
        // 打印map
        System.out.println("map:" + map );

        // 通过Iterator遍历key-value
        Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = (Entry<String, Integer>)iter.next();
            System.out.println("next : "+ entry.getKey() + " - " + entry.getValue());
        }

        
        // 通过HashMap.get(key)获取value
        System.out.println("map.get key one: " + map.get("one"));
          
        
        // HashMap的键值对个数：size()
        System.out.println("size: " + map.size());

        // 是否包含键key：containsKey(key)
        System.out.println("contains key two : " + map.containsKey("two"));
        System.out.println("contains key five : " + map.containsKey("five"));

        // 是否包含值value：containsValue(value)
        System.out.println("contains value 0 : " + map.containsValue(new Integer(0)));

        // 删除键key对应的键值对：remove(key) 
        System.out.println("map.remove key-three: " + map.remove("three"));

        System.out.println("map:" + map );

        // clear()：清空HashMap
        map.clear();

        // isEmpty() : HashMap是否为空
        System.out.println((map.isEmpty()?"map is empty":"map is not empty") );		
	}
	
	
	/**
	 * 遍历HashMap的测试
	 */
    private static void HashMap_Traversal() {
    	System.out.println("\nTesting HashMap_Traversal...");
        int val = 0;
        String key = null;
        Integer value = null;
        Random r = new Random();
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i=0; i<12; i++) {
            // 随机获取一个[0,100)之间的数字
            val = r.nextInt(100);
            
            key = String.valueOf(val);
            value = r.nextInt(5);
            
            // 添加到HashMap中
            map.put(key, value);
            
            System.out.println(" key:"+key+" value:"+value);
        }
        
        // 通过entrySet()遍历HashMap的key-value
        iteratorHashMapByEntryset(map) ;
        
        // 通过keySet()遍历HashMap的key-value
        iteratorHashMapByKeyset(map) ;
        
        // 单单遍历HashMap的value
        iteratorHashMapJustValues(map);      
    }
    
    /**
     * 通过entrySet遍历HashMap，效率高
     */
    private static void iteratorHashMapByEntryset(HashMap<String, Integer> map) {
        if (map == null)
            return ;

        System.out.println("\niterator HashMap By entryset");
        String key = null;
        Integer integ = null;
        Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, Integer> entry = (Entry<String, Integer>)iter.next();
            
            key = (String)entry.getKey();
            integ = (Integer)entry.getValue();
            System.out.println(key+" -- "+integ.intValue());
        }
    }

    /**
     * 通过keySet来遍历HashMap，效率低
     */
    private static void iteratorHashMapByKeyset(HashMap<String, Integer> map) {
        if (map == null)
            return ;

        System.out.println("\niterator HashMap By keyset");
        String key = null;
        Integer integ = null;
        Iterator<String> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            key = (String)iter.next();
            integ = (Integer)map.get(key);
            System.out.println(key+" -- "+integ.intValue());
        }
    }
    

    /**
     * 遍历HashMap的values
     */
    private static void iteratorHashMapJustValues(HashMap<String, Integer> map) {
        if (map == null)
            return ;
        
        Collection<Integer> c = map.values();
        Iterator<Integer> iter= c.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
       }
    }
}
