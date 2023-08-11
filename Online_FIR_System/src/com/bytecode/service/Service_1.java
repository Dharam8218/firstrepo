package com.bytecode.service;

import com.bytecode.bo.BO_1;
import com.bytecode.dao.DAO_1;
import com.bytecode.dto.DTO_1;

public class Service_1 {

	boolean result = false;
	BO_1 bo = null;
	DAO_1 dao = null;
	int daoResult = 0;

	public boolean isPasswordSame(DTO_1 dto) {

		if (dto.getPassword().equals(dto.getConfirmPassword())) {
			result = true;
		} else {
			result = false;
		}

		// create BO_1 object having persistent data;
		bo = new BO_1();
		bo.setName(dto.getName());
		bo.setFatherName(dto.getFatherName());
		bo.setEmail(dto.getEmail());
		bo.setAge(dto.getAge());
		bo.setAddress(dto.getAddress());
		bo.setPassword(dto.getPassword());

		dao = new DAO_1();
		if (result == true) {
			daoResult = dao.insert(bo);

			if (daoResult != 0) {
				return true;
			}
		}
         return false;
	}
}
