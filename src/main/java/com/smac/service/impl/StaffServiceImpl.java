package com.smac.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.smac.repository.HelpRepository;
import com.smac.repository.StaffRepository;
import com.smac.service.StaffService;
import com.smac.dto.HelpDTO;
import com.smac.dto.StaffDTO;
import com.smac.entity.Help;
import com.smac.entity.Staff;

// TODO: Auto-generated Javadoc
/**
 * The Class StaffServiceImpl.
 */
@Service
public class StaffServiceImpl implements StaffService {

	/** The staff repo. */
	@Autowired
	private StaffRepository staffRepo;

	/** The help repo. */
	@Autowired
	private HelpRepository helpRepo;

	/**
	 * Search staffs.
	 *
	 * @return the list
	 */
	@Override
	public List<StaffDTO> searchStaffs(String staffCode, String staffName, String tel, String status, Integer shopId,
			Long helpId, String idNo) {
		List<StaffDTO> lstStaffDTO = staffRepo.searchStaff(staffCode, staffName, tel, status, shopId, helpId, idNo);
		return lstStaffDTO;

	}

}
