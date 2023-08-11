package com.bytecode.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bytecode.dto.StudentDTO;
import com.bytecode.service.StudentService;
import com.bytecode.vo.StudentVO;

public class StudentServletController extends HttpServlet {
    
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = null;
		String sId = null;
		String sName = null;
		String m1= null;
		String m2= null;
		String m3 = null;
		StudentVO vo = null;
		StudentDTO dto= null;
		StudentService studentService = null;
		String result = null;
		// set MIME type
		
		res.setContentType("text/html");
		
		// get printwriter object
		pw = res.getWriter();
		
		sName=req.getParameter("sname");
		sId=req.getParameter("sid");
		m1=req.getParameter("mark1");
		m2=req.getParameter("mark2");
		m3=req.getParameter("mark3");
		
		vo = new StudentVO();
		vo.setsId(sId);
		vo.setsName(sName);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		
		dto = new StudentDTO();
		dto.setsName(vo.getsName());
		dto.setsId(vo.getsId());
		dto.setM1(Integer.parseInt(m1));
		dto.setM2(Integer.parseInt(m2));
		dto.setM3(Integer.parseInt(m3));
		 
		studentService = new StudentService(); 
		result = studentService.calculateResult(dto);
		
		 pw.println("<h1>"+result+"</h1>");
		 pw.close();
		 
		}
}
