package com.smac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smac.dto.HelpDTO;
import com.smac.dto.StaffDTO;
import com.smac.repository.StaffRepository;
import com.smac.service.StaffService;

// TODO: Auto-generated Javadoc
/**
 * The Class StaffController.
 */
@RestController
@RequestMapping("/api")
public class StaffController {

	/** The staff service. */
	@Autowired
	private StaffService staffService;

	@Autowired
	private StaffRepository staffRepo;

	/**
	 * Gets the staffs.
	 *
	 * @return the staffs
	 */
	@GetMapping("/staffs")
	public List<StaffDTO> getStaffs(String staffCode, String staffName, String tel,
			@RequestParam(name = "status", required = true) String status, Integer shopId, Long helpId, String idNo) {
		return staffService.searchStaffs(staffCode, staffName, tel, status, shopId, helpId, idNo);

	}

}
