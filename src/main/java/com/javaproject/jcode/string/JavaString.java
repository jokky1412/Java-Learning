package com.javaproject.jcode.string;

/**
 * <p>字符串：
 * "abcd"和new String("abcd")的使用区别
 * <p>如果只需要创建一个字符串，可以使用双引号的方式
 * <p>如果需要在堆中创建一个新的对象，可以选择构造函数的方式
 */
public class JavaString {

	
	//比较两个已经存在于字符串池中字符串对象可以用"=="进行，拥有比equals操作符更快的速度
	public static void main(String[] args) {
		
		// 首先，检查字符串池中是否存在"abcd"：
		// 有，则直接赋给字符串a
		// 没有，则在字符串池中创建一个"abcd"，再赋给字符串a
		String a = "abcd";
		
		// 检查字符串池中是否存在"abcd"
		// 有，则直接赋给字符串b
		String b = "abcd";
		
		// 字符串a和字符串b，都指向同一个对象：字符串池中的"abcd"
		System.out.println( "a == b : " + (a == b) ); // true
		System.out.println( "a.equals(b) : " + (a.equals(b)) ); // true
		
		
		System.out.println("\r\n");
		
		
		// 在堆中创建了2个不同的字符串对象
		String c = new String("abcde");
		String d = new String("abcde");
		System.out.println( "c == d : " + (c == d) ); // false，对象不同
		System.out.println( "c.equals(d) : " + (c.equals(d)) ); // true，字符串的值相同
		
		
		System.out.println("\r\n");
		
		// 在堆中创建了2个不同的字符串对象
		// 因为字面值“abcdef”已经是字符串类型，那么使用构造函数方式只会创建一个额外没有用处的对象
		String e = new String("abcdef").intern();
		String f = new String("abcdef").intern();
		System.out.println( "e == f : " + (e == f) ); // true
		System.out.println( "e.equals(f) : " + (e.equals(f)) ); // true    （JDK1.7）
		
	}
	
}
