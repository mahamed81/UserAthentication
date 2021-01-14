package com.hcl.dao;


import org.springframework.data.repository.CrudRepository;

import com.hcl.model.User;

public interface EmpRepository  extends CrudRepository<User, Long>{
	
	

}
