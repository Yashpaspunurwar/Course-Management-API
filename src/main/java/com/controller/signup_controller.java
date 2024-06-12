package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bin.Elearn_bo;
import com.dao.Elearn_dao;

/**
 * Servlet implementation class signup_controller
 */

public class signup_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
        PrintWriter pw= response.getWriter();
        
       String name=  request.getParameter("name"); 
       String email= request.getParameter("email");
       String phone= request.getParameter("phone");
       String message= request.getParameter("message");
       
       Elearn_bo em=new  Elearn_bo();
       
       em.setName(name);
       em.setEmail(email);
       em.setPhone(phone);
       em.setMessage(message);
       
         int status=  Elearn_dao.signup(em);
         
         if(status>0)
         {
        	 pw.println("signup sucessfully....");
         }
         else
         {
        	 pw.println("something went wrong.....");
         }
       
       
	}

}