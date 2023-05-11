package com.smac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.smac.dto.HelpDTO;
import com.smac.dto.StaffDTO;
import com.smac.entity.Help;

/**
 * The Interface HelpRepository.
 */
@Repository
public interface HelpRepository extends JpaRepository<Help, Long> {

	/**
	 * Find by created user.
	 *
	 * @param createdUser the created user
	 * @return the list
	 */
	@Query(value = "SELECT u FROM Help u where u.createdUser = ?1")
	List<Help> findByCreatedUser(String createdUser);

	@Query(value = "select new com.smac.dto.HelpDTO(s.staffId,h.parent,h.status,h.type,s.shopId) from Help h left join Staff s on s.staffCode = h.createdUser"
			+ " where s.staffId =:staffId " + "and (:parent is null or h.parent = :parent) "
			+ "and (:status is null or h.status = :status) " + "and (:type is null or h.type = :type) "
			+ "and (:shopId is null or s.shopId = :shopId) ")
	List<HelpDTO> searchHelps(@Param("staffId") Integer staffId, @Param("parent") Long parent,
			@Param("status") String status, @Param("type") String type, @Param("shopId") Integer shopId);
}