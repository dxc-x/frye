/**
 * 
 */
package com.qhc.order.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qhc.order.entity.OrderVersion;

/**
 * @author 
 *
 */

public interface KOrderVersionRepository extends JpaRepository<OrderVersion, String> {
	
	public List<OrderVersion> findByOrderIdOrderByCreateTime(String orderId);
	
	@Query(value="select * from k_order_version where k_orders_id=:orderId order by create_time desc limit 1",nativeQuery=true)
	public OrderVersion findLastOneByOrderId(@Param("orderId")String orderId);
	
	@Query(value="select * from k_order_version left join k_orders on k_order_version.k_orders_id = k_orders.id where k_orders.sequence_number=:sequenceNumber order by create_time desc limit 1",nativeQuery=true)
	public OrderVersion findLastVersion(@Param("sequenceNumber")String sequenceNumber);
	
	@Query(value="select * from k_order_version left join k_orders on k_order_version.k_orders_id = k_orders.id where k_order_version.version =:version and k_orders.sequence_number=:seqNum limit 1",nativeQuery=true)
	public OrderVersion findVersion(@Param("seqNum")String seqNum,@Param("version")String version);
	
	@Query(value="select * from k_order_version where k_order_version.k_orders_id = :orderId and k_order_version.k_order_info_id=:orderInfoId limit 1",nativeQuery=true)
	public OrderVersion findByOrder(@Param("orderId")String orderid,@Param("orderInfoId")String orderInfoId);
	
}