package com.te.springboot.dao;
import java.util.List;

import com.te.springboot.bean.dto.AdminBean;
import com.te.springboot.bean.dto.ItemBean;



public interface AdminDAO {

	public AdminBean authenticate(Integer aid, String password);

	public ItemBean getEmpData(Integer aid);
	
	public boolean addItem(ItemBean Bean);
	
	public boolean updateItem(ItemBean infoBean);
	
	public boolean deleteItem(Integer id);
	
	public List<ItemBean> getAllEmployeeDetails();

}
