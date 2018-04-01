package com.cicada.dao;

import java.util.List;

import com.cicada.entity.Employee;

public interface EmployeeDao {
	/**
	 * 加载个人信息
	 * */
	public Employee getEmployeeById(int id);
	/**
	 * 加载所有员工信息
	 * */
	public List<Employee> getAllEmployee();
}
