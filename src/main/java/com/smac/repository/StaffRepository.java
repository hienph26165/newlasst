package com.smac.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smac.dto.StaffDTO;
import com.smac.entity.Help;
import com.smac.entity.Staff;

/**
 * The Interface StaffRepository.
 */
@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

	@Query(value = "select new com.smac.dto.StaffDTO(s.staffCode,s.staffName,s.tel,s.status,s.shopId,h.helpId,s.idNo) from Staff s left join Help h on s.staffCode = h.createdUser"
			+ " where s.status = :status " + "and (:staffCode is null or s.staffCode = :staffCode) "
			+ "and (:staffName is null or s.staffName like '%:staffName%') " + "and (:tel is null or s.tel = :tel) "
			+ "and (:shopId is null or s.shopId = :shopId) " + "and (:helpId is null or h.helpId = :helpId) "
			+ "and (:idNo is null or s.idNo = :idNo) ")
	List<StaffDTO> searchStaff(@Param("staffCode") String staffCode, @Param("staffName") String staffName,
			@Param("tel") String tel, @Param("status") String status, @Param("shopId") Integer shopId,
			@Param("helpId") Long helpId, @Param("idNo") String idNo);

}
