package com.laptrinhjavaweb.service.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dao.DepartmentDao;
import com.laptrinhjavaweb.entity.Departments;

@Service
public class AdminServiceImpl implements IAdminService {
	@Autowired
	private DepartmentDao departmentDao;
	@Override
	public List<Departments> findAll() {
		return departmentDao.findAll();
	}
}
