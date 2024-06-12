package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bin.Elearn_bo;

public class Elearn_dao {

	
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Yash@2000");
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static int signup( Elearn_bo em)
	{
		int status=0;
		
		try 
		{
		  Connection con=   Elearn_dao.getConnection();
		  String query="insert into signup(name,email,phone,password)values(?,?,?,?)";
		   PreparedStatement ps= con.prepareStatement(query);
		    ps.setString(1, em.getName());
		    ps.setString(2, em.getEmail());
		    ps.setString(3, em.getPhone());
		    ps.setString(4, em.getMessage());
		    
		        status=ps.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	
	public static List getAllEmoployee()
	{
		List<Elearn_bo> list=new ArrayList< Elearn_bo>();
		
		  try
		  {
		 Connection con=Elearn_dao.getConnection();
		 
		PreparedStatement ps=con.prepareStatement("select * from signup");
		
		 ResultSet rs= ps.executeQuery();
		 
		 while(rs.next())
		 {
			  Elearn_bo em=new Elearn_bo();
			 
			
			 em.setName(rs.getString(1));
			 em.setEmail(rs.getString(2));
			 em.setPhone(rs.getString(3));
			 em.setMessage(rs.getString(4));
			 
			 list.add(em);
		 }
		            
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		  
		  return list;
	}
}
