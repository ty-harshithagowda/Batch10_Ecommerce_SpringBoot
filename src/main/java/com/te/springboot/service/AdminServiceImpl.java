package com.te.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.springboot.bean.dto.AdminBean;
import com.te.springboot.bean.dto.ItemBean;
import com.te.springboot.dao.AdminDAO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	AdminDAO dao;


	public ItemBean getEmpData(Integer aid) {
		return dao.getEmpData(aid);
	}


	public boolean addItem(ItemBean Bean) {
		return dao.addItem(Bean);
	}


	public boolean updateItem(ItemBean infoBean) {
		// TODO Auto-generated method stub
		return dao.updateItem(infoBean);
	}


	@Override
	public boolean deleteItem(Integer id) {
		// TODO Auto-generated method stub
		return dao.deleteItem(id);
	}


	@Override
	public List<ItemBean> getAllEmployeeDetails() {
		// TODO Auto-generated method stub
		return dao.getAllEmployeeDetails();
	}


	@Override
	public AdminBean authenticate(Integer aid, String password) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AdminBean getAllItems1() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AdminBean getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}


	




}
