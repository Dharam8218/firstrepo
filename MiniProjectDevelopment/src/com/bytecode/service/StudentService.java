package com.bytecode.service;

import com.bytecode.bo.StudentBO;
import com.bytecode.dao.StudentDAO;
import com.bytecode.dto.StudentDTO;

public class StudentService {

	public String calculateResult(StudentDTO dto) {
		
		 int total=0;
		 float avg = 0.0f;
		 String result = null;
		 StudentBO bo = null;
		 StudentDAO dao = null;
		 int count = 0;
		 // use business logic to calculate result,toatl,avg
             
		 total = dto.getM1()+dto.getM2()+dto.getM3();
		 avg=total/3.0f;
		 if(avg<35) {
			 result="fail";
		 }else {
			 result="pass";
		 }
		 
		 // prepare bo class object having persistent data
		  bo= new StudentBO();
		  bo.setName(dto.getsName());
		  bo.setSid(dto.getsId());
		  bo.setAvg(avg);
		  bo.setResult(result);
		  bo.setTotal(total);
		  
		  dao = new StudentDAO();
		  count = dao.insert(bo);
		  
		 if(count==0) {
		 return "Registration Failed";
		 }
		 else {
			 
			 return "Registration completed and result is::"+result;
		 }
	}

}
