package com.te.springboot.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.bean.dto.ItemBean;
import com.te.springboot.service.AdminService;
@RestController
public class AdminController<AdminInfoBean> {

//	@Autowired
//	private AdminService service;
//
//	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
//	public AdminResponse getItem(int id, AdminInfoBean AdminBean) {
//
//		AdminResponse response = new AdminResponse();
//		AdminBean infoBean = (AdminBean) service.getAllItems();
//
//		if (infoBean != null) {
//			response.setStatusCode(200);
//			response.setMsg("Success");
////			response.setBean(AdminBean);
//		} else {
//			response.setStatusCode(404);
//			response.setMsg("Failure , Data Not found");
//		}
//
//		return response;
//	}
//}
	@Autowired
	private AdminService service;

	@GetMapping(path = "/getEmp", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public AdminResponse getEmpData(int id) {

		AdminResponse response = new AdminResponse();
		ItemBean infoBean = service.getEmpData(id);

		if (infoBean != null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setBean(infoBean);
		} else {
			response.setStatusCode(404);
			response.setMsg("Failure , Data Not found");
		}

		return response;
	}// end of getEmpData

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public AdminResponse getAllEmployeeDetails() {
		AdminResponse response = new AdminResponse();
		List<ItemBean> infoBeans = service.getAllEmployeeDetails();

		if (infoBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setEmployeeInfos(infoBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("Datas not found");
		}

		return response;
	}// END OF GETALL

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public AdminResponse addEmpData(@RequestBody ItemBean infoBean) {
		AdminResponse response = new AdminResponse();

		if (service.addItem(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Added the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not add the data");
		}

		return response;
	}// end of addEmp

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public AdminResponse updateEmpData(@RequestBody ItemBean infoBean) {
		AdminResponse response = new AdminResponse();

		if (service.updateItem(infoBean)) {
			response.setStatusCode(200);
			response.setMsg("success , Updated the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not update the record");
		}
		return response;
	} // update

	
	@DeleteMapping(path = "/delete/{empId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public AdminResponse deleteEmpData(@PathVariable(name = "empId")int id ) {
		AdminResponse response = new AdminResponse();

		if (service.deleteItem(id)) {
			response.setStatusCode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}

}