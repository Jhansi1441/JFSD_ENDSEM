package com.controller;

import com.model.Student;
import com.model.StudentManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/RetrieveData")
public class RetrieveData extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html"); 
    	  PrintWriter pw=response.getWriter(); 
    	  List<Student> list;   
    	  try 
    	  { 
    	   StudentManager sm=new StudentManager(); 
    	   list=sm.retrieveData(); 
    	   request.setAttribute("slist", list); 
    	   RequestDispatcher rd=request.getRequestDispatcher("retrieve.jsp"); 
    	   rd.forward(request, response);    
    	  } 
    	  catch (Exception e)  
    	  { 
    	   pw.print(e.getMessage()); 
    	  }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}