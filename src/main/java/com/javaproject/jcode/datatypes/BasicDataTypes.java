package com.javaproject.jcode.datatypes;


/**
 * <p>基本数据类型
 */
public class BasicDataTypes {

		public static void main (String[] args) {
		
			//基本数据类型的边界
			byte d = 127;
//		    byte dd = 128;
		   
		   int a    = 1234567890;
		//   int aa   = 12345678901;
		   int aaa  = 2147483647;
		//   int aaaa = 2147483648;
		   int aaaaa= 0x7fffffff;
		   int aaaaaa = -2147483648;
		//   int maaaaa = -2147483649;
		   
		   
		   long b = 1234567890;
		//   long bb = 12345678901;	
//		   long bbb = 9223372036854775807;
		//   long bbbb = 0x7fffffffffffffff;
		   long bbbbb = 9223372036854775807L;
		   long bbbbbb = 0x7fffffffffffffffL;
		   
		   short c = 12345;
//		   short cc = 123456;
		   short ccc = 0x7fff;
		   short cccc = -32768;
//		   short ccccc = 0x8000;
		   
		   float e = 1234567890;
		   float ee = 3.4028235E38f;
//		   float eee = 1.4E-45;
		   
		   
		   double f = 1234567890;
		   double fff = 1.7976931348623157E308;
//		   double ffff = 1.7976931348623157E309;
		
		   
		   // 各类型的最值
		   boolean trueBoolean = Boolean.TRUE;
		   boolean falseBoolean = Boolean.FALSE;
		   char minChar = Character.MIN_VALUE; // '' [\u0000]
		   char maxChar = Character.MAX_VALUE;	// [\uffff]
		   byte minByte = Byte.MIN_VALUE;		// -128 [0x80]
		   byte maxByte = Byte.MAX_VALUE;		// 127 [0x7f]
		   short minShort = Short.MIN_VALUE;	// -32768 [0x8000]
		   short maxShort = Short.MAX_VALUE;	// 32767 [0x7fff]
		   int minInt = Integer.MIN_VALUE;		// -2147483648 [0x80000000]
		   int maxint = Integer.MAX_VALUE;		// 2147483647 [0x7fffffff]
		   long minLong = Long.MIN_VALUE;		// -9223372036854775808 [0x8000000000000000]
		   long maxLong = Long.MAX_VALUE;		// 9223372036854775807 [0x7fffffffffffffff]
		   float minFloat = Float.MIN_VALUE;	// 1.4E-45
		   float maxFloat = Float.MAX_VALUE;	// 3.4028235E38
		   double minDouble = Double.MIN_VALUE;// 4.9E-324
		   double maxDouble = Double.MAX_VALUE;// 1.7976931348623157E308
		
		   int sizeBoolean = Character.SIZE; //16
		   int sizeByte = Byte.SIZE; 	// 8
		   int sizeShort = Short.SIZE; // 16
		   int sizeInt = Integer.SIZE; // 32
		   int sizeLong = Long.SIZE;	// 64
		   int sizeFloat = Float.SIZE;	// 32
		   int sizeDouble = Double.SIZE;// 64
		   
		   
		   //不同类型的计算
	       byte bbyte 		= 50;
	       char cchar 		= 'z';
	       short sshort 	= 1024; 
	       int iint 		= 50000; 
	       float ffloat 	= 5.67f; 
	       double ddouble 	= 0.1234; 
	       double result 	= (ffloat * bbyte) + (iint / cchar) - (ddouble * sshort);       
		   
//	       System.out.println("*********test*********");
//	       System.out.println("float * byte: " + (ffloat * bbyte));
//	       System.out.println("int / char: " + (iint / cchar));
//	       System.out.println("double * short: " + ddouble * sshort);
			
		   
//		   System.out.println("result: " + result);
		   
		   int abc = (int)3.14;
//		   System.out.println(abc);
		   
		   
		   byte aabyte = 1;
		   byte bbbyte = 2;
		   
//		   aabyte = aabyte + bbbyte;	// 编译出错自动类型提升成int
		   
		   aabyte = (byte)(aabyte + bbbyte);	// 高类型向低类型计算，要做强制类型转换
		   
		   aabyte += bbbyte;			// 自加没有自动类型提升问题
		   
		   
		   byte b1=1,b2=2,b3,b6; 
		   final byte b4=4,b5=6; 
		   b6 = b4+b5; 		// final修饰，保持原型byte，不变成int
//		   b3 = b1+b2;		// 编译错误。没有final修饰的变量相加后会被自动提升为int
		   b3 = (byte)(b1+b2);//必须向下转型
		   
		   
		   
		   //常用的类型
		   final double PI = 3.1415927;
		   
		   char A = 'A';
		   byte byteA = 68;
		   
		   int decimal = 100; 
		   int octal = 0144;
		   int hexa = 0x64;
		   
		   char charA = '\u0041';
		   String stringA = "\u0041";
		   System.out.println("char A: " + charA);
		   System.out.println("string A: " + stringA);
		   char newLine = '\n';
		   char nullChar = '\0';
		   char singleQuotation = '\'';
		   char doubleQuotation = '\"';
		   char backSlash = '\\';
		   System.out.println("this is a new line: " + newLine);
		   
		   System.out.println("this is a null char: " + nullChar);
		   
		   System.out.println("单引号: " + singleQuotation);
		   System.out.println("双引号: " + doubleQuotation);
		   System.out.println("反斜杠: " + backSlash);
		   System.out.println("换行符：" + "\r\n");
		   
		   
		   
		   // StringBuilder
		   StringBuilder aStringBuilder = new StringBuilder("Java Util");
		   aStringBuilder.append(" Package");
		   System.out.println("aStringBuilder: " + aStringBuilder);
		   
		   int uIndex = aStringBuilder.indexOf("U");
		   System.out.println("index of 'U': " + uIndex);
		   int pIndex = aStringBuilder.indexOf("P");
		   System.out.println("index of 'P': " + pIndex);	   
		   
		   
		   aStringBuilder.replace(5, 9, "Lang");
		   System.out.println("replace 5-9: " + aStringBuilder);
		   
		   aStringBuilder.insert(2, "yy");
		   System.out.println("insert 2 : " + aStringBuilder);
		   
		   aStringBuilder.delete(2, 4);
		   System.out.println("delete 2-4: " + aStringBuilder);
		   
		}
}
