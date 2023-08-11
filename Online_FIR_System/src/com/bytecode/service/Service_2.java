package com.bytecode.service;

import com.bytecode.bo.BO_2;
import com.bytecode.dao.DAO_2;
import com.bytecode.dto.DTO_2;


public class Service_2 {
	
	BO_2 bo ; 
	DAO_2 dao ;
	private String name;
	
	public boolean isCredentialCorrect(DTO_2 dto) {
		bo = new BO_2();
		bo.setEmail(dto.getEmail());
		bo.setPassword(dto.getPassword());
		
		dao=new DAO_2();
		name=dao.checkCredential(bo);
		setName(name);
		if(name!=null) {
			return true;
		}
		
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
