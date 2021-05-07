package com.te.springboot.controller;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.te.springboot.bean.dto.ItemBean;

import lombok.Data;



@Data
@JsonRootName("response")
@JsonPropertyOrder({"status" , "msg"})
@XmlRootElement(name = "response")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class  AdminResponse implements Serializable{

	@JsonProperty("status")
	@XmlElement(name = "status-code")
	private int statusCode;
	
	
	private String  msg;
	
	@JsonProperty("employee_info")
	@XmlElement(name = "employee-info")
	private ItemBean bean;

	private List<ItemBean> employeeInfos;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ItemBean getBean() {
		return bean;
	}

	public void setBean(ItemBean bean) {
		this.bean = bean;
	}

	public List<ItemBean> getEmployeeInfos() {
		return employeeInfos;
	}

	public void setEmployeeInfos(List<ItemBean> employeeInfos) {
		this.employeeInfos = employeeInfos;
	}
}
