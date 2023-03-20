package com.laptrinhjavaweb.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.Departments;
@Service
public interface IAdminService {
	@Autowired
	List<Departments> findAll();

}
