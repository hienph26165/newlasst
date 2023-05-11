package com.smac.service;

import java.util.List;

import com.smac.dto.HelpDTO;
import com.smac.dto.StaffDTO;
import com.smac.entity.Help;

/**
 * The Interface StaffService.
 */
public interface StaffService {

	/**
	 * Search staffs.
	 *
	 * @return the list
	 */
	List<StaffDTO> searchStaffs(String staffCode, String staffName, String tel, String status, Integer shopId,
			Long helpId, String idNo);

}
