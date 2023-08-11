package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchServlet extends HttpServlet {
       @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	   PrintWriter pw = null;
    	   String url = null;
    	   res.setContentType("text/html");
    	   
    	  
    	   String stringToSearch = req.getParameter("searchstring");
    	   String engineName=req.getParameter("engine");
    	   
    	   if(engineName.equalsIgnoreCase("google")) {
    		   url="https://www.google.com/search?q="+stringToSearch;
    		   
    	   }else if(engineName.equalsIgnoreCase("yahoo")) {
    		   url="https://in.search.yahoo.com/search?q="+stringToSearch;
    		   
    	   }else if(engineName.equalsIgnoreCase("bing")) {
    		  url="https://www.bing.com/search?q="+stringToSearch; 
    		   
    	   }else {
    		   url="https://www.bing.com/search?q="+stringToSearch;
    	   }
    	   res.sendRedirect(url);
    }
       
       @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	doPost(req, res);
    }
}
