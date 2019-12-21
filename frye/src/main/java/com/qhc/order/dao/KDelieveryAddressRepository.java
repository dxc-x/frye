/**
 * 
 */
package com.qhc.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qhc.order.entity.DelieveryAddress;

/**
 * @author 
 *
 */

@Repository
@Transactional
public interface KDelieveryAddressRepository extends JpaRepository<DelieveryAddress, String> {
	public List<DelieveryAddress> findByOrderInfoId(String orderId);
	@Query(value = "delete FROM k_bidding_plan where k_order_info_id= :orderInfoId", nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteByOrderInfoId(@Param("orderInfoId")String orderInfoId);

}