package com.bytecode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StateServletApp extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// set MIME type
		String[] districtOfUP= { "kanpur","Lucknow","Bijnor","Merrut","Moradabad"};
		String[] districtOfBihar= { "Gopalganj","Siwan","Vaishali","Gaya","Patna"};
		String[] districtOfRJ= { "Ajmer","Bikaner","Jodhpur","Kota","Udaipur"};
		String[] districtOfHP= { "Mandi","Solan","Chamba","Shimla","Kullu"};
		res.setContentType("text/html");
		// get printWriter object
		PrintWriter pw = res.getWriter();
		 String sn = req.getParameter("states");
		// get state based district that is select
		 if(sn.equalsIgnoreCase("up")) {
			 pw.println("Districts of UP"+Arrays.toString(districtOfUP));
		 }
		 else if(sn.equalsIgnoreCase("Bihar")) {
			 pw.println("Districts of Bihar"+Arrays.toString(districtOfBihar));
		 }
		 else if(sn.equalsIgnoreCase("hp")) {
			 pw.println("Districts of HP"+Arrays.toString(districtOfHP));
		 }
		 else {
			 pw.println("Districts of Rajasthan"+Arrays.toString(districtOfRJ));
		 }
		 pw.close();
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req,res);
	}
}
