package com.bytecode.service;

import com.bytecode.bo.BO_6;
import com.bytecode.dao.DAO_6;
import com.bytecode.dto.DTO_6;

public class Service_6 {
    
	BO_6 bo=null;
	DAO_6 dao=null;
			
	public boolean setAccurateData(DTO_6 dto) {
		 
		bo=new BO_6();
		bo.setName(dto.getFirstName()+" "+dto.getLastName());
		bo.setMobileNumber(dto.getMobileNumber());
		bo.setAddress(dto.getAddress1()+" "+dto.getAddress2()+" "+dto.getCity()+" "+dto.getState());
		bo.setZipCode(dto.getZipCode());
		bo.setNearestPoliceStationName(dto.getNearestPoliceStationName());
		bo.setComplainType(dto.getComplainType());
		bo.setWhereDidTheIncidentOccurs(dto.getWhereDidTheIncidentOccurs());
		bo.setAdditionalInformation(dto.getAdditionalInformation());
		bo.setUniqueId(dto.getUniqueId());
		
		dao = new DAO_6();
	
		if(dao.insert(bo)!=0) {
			return true;
		}
		return false;
	
		
	}
}
