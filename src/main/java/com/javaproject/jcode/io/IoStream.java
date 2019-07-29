package com.javaproject.jcode.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * JAVA的io流
 */
public class IoStream {

	public static void main(String[] args) throws FileNotFoundException, IOException {
//		writeFile();
		
//		writeFile2("D:/test.txt");
		
//		readFile();
				
		

//		writeByBufferedStream("D:/test.txt");
//		
//		readByBufferedStream("D:/test.txt");
			
		String sourceFile = "D:/bszh_20190714225700.mp3";
		String copyFile = "D:/copy_bszh_20190714225700.mp3";
//		copyFile(sourceFile, copyFile);		
		copyFileByBufferedStream(sourceFile, copyFile);
		

		
	}
	
	/**
	 * <p>复制文件，使用字节缓冲流
	 * <p>最高效最快速的方式
	 * <p>BufferedOutputStream / BufferedInputStream
	 */
	private static void copyFileByBufferedStream(String source, String copy) throws IOException {
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(copy));
		
		try {
			int len = 0 ;
			byte[] bs = new byte[1024];
			while((len = bis.read(bs)) != -1) {
				bos.write(bs, 0, len);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bis.close();
			bos.close();
		}
		
		
	}

	/**
	 * <p>写出数据到文件，更高效的方式
	 * <p>字节缓冲流 BufferedOutputStream
	 */	
	private static void writeByBufferedStream(String fileName) throws IOException {
		
		OutputStream ops = null;
		BufferedOutputStream bos = null;
		
		try {
			// 不覆盖数据，在末尾继续写
			ops = new FileOutputStream(fileName, true);
			
			// 字节缓冲区流仅仅提供缓冲区，为高效而设计
			// 但是，真正的读写操作还得靠基本的流对象实现，如FileOutputStream
			bos = new BufferedOutputStream(ops);
			
			bos.write("\r\n".getBytes());		//换行符
			bos.write("ABCDEFG.".getBytes());	//换行符
			
			//刷新此缓冲的输出流
			bos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ops.close();
			bos.close();			
		}
	}

	/**
	 * <p>读取文件数据，更高效的方式
	 * <p>字节缓冲流 BufferedInputStream
	 */
	private static void readByBufferedStream(String fileName) throws IOException {
		
		InputStream ins = null;
		BufferedInputStream bis = null;
		
		try {
			ins = new FileInputStream(fileName);
			
			//创建一个 BufferedInputStream 并保存其参数，即输入流ins，以便将来使用
			// 字节缓冲区流仅仅提供缓冲区，为高效而设计
			// 但是，真正的读写操作还得靠基本的流对象实现，如FileInputStream					
			bis = new BufferedInputStream(ins);
			
			byte[] b = new byte[1024]; 
			int len = 0 ;
			while((len = bis.read(b)) != -1	) {
				System.out.println(new String(b, 0, len));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ins.close();
			bis.close();
		}
		
	}


	/**
	 * <p>复制文件 
	 * <p>利用输入流读取一个文件里的字节，再利用输出流将读取到的字节写出到另一个文件中（不存在会自动创建）
	 */
	private static void copyFile(String source, String copy) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
				
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(copy);
			
			byte[] bytes = new byte[1024];
			int len = 0;
			while((len = fis.read(bytes)) != -1) {
				fos.write(bytes, 0, len);
			}	
			//字节流一次读写一个数组的速度，明显比一次读写一个字节的速度快很多
			//这是加入了数组这样的缓冲区效果					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
			fos.close();
		}
		
		
		
		
	}

	
	/**
	 * <p>FileOutputStream：字节文件输出流，属于字节文件操作流
	 * <p>用于将数据写入到File，从程序中写入到其他位置
	 * <p>如果输出的目的地文件不存在，则会自动创建，不指定盘符的话，默认创建在项目目录下
	 */
	private static void writeFile2(String fileName) throws IOException,FileNotFoundException {
		FileOutputStream fos = null;
		try {
			// true，设置为写入的数据拼接在尾部，即追加写入
			fos = new FileOutputStream(fileName, true);
			/**
			* 创建字节输出流对象了做了几件事情：
            * 1.调用系统功能去创建文件
            * 2.创建fos对象
            * 3.把fos对象指向这个文件
            */
			fos.write("\r\n".getBytes());	// 换行符
			
//			byte[] bytes = {97, 98, 99, 100, 101}; 
//			fos.write(bytes, 1, 3);
			
			fos.write("hello".getBytes());
			fos.write("\r\n".getBytes());	// 换行符
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
		}
		
	}

	
	/**
	 * <p>读取文件数据
	 * <p>FileInputStream：字节文件输入流，属于字节文件操作流
	 * <p>从文件系统中的某个文件中获得输入字节，用于读取诸如图像数据之类的原始字节流
	 */
	private static void readFile() throws IOException,FileNotFoundException {
		/*
		//创建文件对象
		File file = new File("D:/test.txt");
		//创建文件输入流，从硬盘将数据读入本程序	
		//通过打开一个到实际文件的连接来创建一个FileInputStream，该文件通过文件系统中的File对象file指定
		FileInputStream fis = new FileInputStream(file);
		for(int i = 0 ; i < file.length(); i++) {
			System.out.println((char)fis.read());
		}
		*/
			
		//通过打开一个到实际文件的连接来创建一个FileInputStream，该文件通过文件系统中的路径name指定
		/*
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("D:/test.txt");
			int i = 0;
			while((i = fis.read()) != -1) {
				System.out.println((char)i + " ");
			}	
			// A
			// B
			// C
			// D					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis.close();
		}
		*/
		
		System.out.println("————————");
				
		
		// 相对更快的读取方式
		FileInputStream fis2 = null;						
		try {
			fis2 = new FileInputStream("D:/test.txt");	
			//使用字节数组，一般1024
//			byte[] byteArr = new byte[2];		// AB CD
			byte[] byteArr = new byte[1024];	// ABCD
			int i2 = 0;
			//fis2.read(byteArr)：一次读取一个字节数组
			while((i2 = fis2.read(byteArr)) != -1) {
				System.out.println(new String(byteArr, 0, i2) + " ");
			}				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fis2.close();
		}
		
	
	}

	

	private static void writeFile() throws IOException,FileNotFoundException {
		//创建文件对象
//		File file = new File("D:/test.txt");
		
		//创建文件输出流，从本程序写数据出到硬盘的文件
		FileOutputStream fos = null;
		try {		
			fos = new FileOutputStream("D:/test.txt");
			fos.write('a');
			fos.write('b');
			fos.write('c');
			fos.write('d');
			fos.write('e');
			fos.write('f');
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			fos.close();
		}
		
		


				
		
	}
	
	
}
