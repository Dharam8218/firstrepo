package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DiscountServlet extends HttpServlet {
	       
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw;
		String item;
		String sPrice;
		String sQuantity;
		int price;
		int quantity;
		int totalPrice;
		   //set content type
		res.setContentType("text/html");
		//get PrintWriter Object
		 pw = res.getWriter();
		 
		 //get values from html page 
		 item=req.getParameter("item");
		 sPrice=req.getParameter("price");
		 sQuantity=req.getParameter("quantity");
		 price=Integer.parseInt(sPrice);
		 quantity=Integer.parseInt(sQuantity);	
		 
		 totalPrice = price*quantity;
		 if(totalPrice>=50000) {
			 totalPrice=(totalPrice-(10*(totalPrice/100)));
			 pw.println("<h1>Total price after discount = "+totalPrice+"</h1>");
		 }
	}
}
