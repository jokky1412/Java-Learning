package com.javaproject.jcode.jdbc;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.PreparedStatement;

/**
 * <p>JDBC步骤：共7个
 * <p>1.加载JDBC驱动程序：Class.forName(driver);
 * <p>2.提供JDBC连接的URL
 * <p>3.创建数据库的连接: Connection con = DriverManager.getConnection(url, user, password); 
 * <p>4.创建一个Statement：Statement stmt = connection.CreateStatement();
 * <p>5.执行SQL语句
 * <p>6.处理结果
 * <p>7.关闭JDBC对象：结果集ResultSet、连接Connection、声明Statement
 */
public class Jdbc {
	
	public static void main(String[] args)  throws Exception {
		
		String getPro = System.getProperty("file.encoding");
		System.out.println(getPro);
		
		System.out.println("JDBC Start...");
		
		String driver = "com.mysql.jdbc.Driver";
	
		 String user = "root";
         String password = "1234";
         String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=utf-8";
         //String url = "jdbc:mysql://localhost:3306/test";
         //Connection testCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&amp;characterEncoding=UTF-8","root","1234");
         
         Connection con = null;
         Statement stmt = null;
         ResultSet rSet = null;

         // Class.forName("com.mysql.jdbc.Driver");
         // or
         // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
         // or
         // new com.mysql.jdbc.Driver();
         
         Class.forName(driver); 
         try{
        	//
            con = DriverManager.getConnection(url, user, password); 
            // 一个Connection代表一个数据库连接
            stmt = con.createStatement(); //
            
            // Statement里面带有很多方法，比如executeUpdate可以实现插入，更新和删除等
            
            //stmt.executeQuery("SET CHARACTER SET utf8mb4");
            //stmt.executeQuery("SET names 'utf8'");
            
            //String insertQuery = "INSERT INTO school VALUES ('你666我666 6他6')";
            //stmt.execute(insertQuery);
                    
            // executeQuery会返回查询结果的集合，否则返回空值
            rSet =  stmt.executeQuery("select trainee_id,trainee_name,online_id from trainee_info");
//            Boolean temp;
//            temp = stmt.execute("select trainee_id,trainee_name,online_id from trainee_info");
//            System.out.println(temp);
            while(rSet.next()){
            	//System.out.println(rSet.getString(1)+" ");
            	//System.out.println(rSet.getString(1)+" "+rSet.getString(2));
                System.out.println(rSet.getString(1)+" "+rSet.getString(2)+" "+rSet.getString(3));
            }
            
            
            // 编码
            String str = URLEncoder.encode("中国","UTF-8");
            System.out.println(str);
            // 解码
            String str1=URLDecoder.decode(str, "UTF-8");
            System.out.println(str1);
            
//            while(rSet.next()){
//                System.out.println(rSet.getInt(1)+" "+rSet.getString(2)+" "+rSet.getInt(3)+" "+rSet.getString(4)+" "+rSet.getInt(5) );
//            }
//            stmt.execute("set names utf8");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(rSet!=null) rSet.close();
            if(con!=null) con.close();
            if(stmt!=null) stmt.close();
        }
		
		System.out.println("\n JDBC End...");

		
	}
}
