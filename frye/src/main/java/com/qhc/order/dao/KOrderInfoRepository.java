package com.qhc.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.qhc.order.entity.OrderInfo;

@Repository
public interface KOrderInfoRepository extends JpaRepository<OrderInfo, String>, JpaSpecificationExecutor<OrderInfo> {

	@Query(value = "select * from k_order_info where id =(select k_order_info_id from k_parent_order_version where k_order_version_id =(SELECT id from k_order_version where k_orders_id=?1 and k_order_version_id=?2))", nativeQuery = true)
	OrderInfo findKOrderInfoByOrdersIdAndVersionId(String orderId, String sequenceNumber);

	@Query(value = "SELECT k_order_info.* FROM k_orders left join k_order_version on k_orders.id = k_order_version.k_orders_id left join k_order_info on k_order_version.k_order_info_id = k_order_info.id where k_orders.sequence_number = :seqNum and k_order_version.version=:version", nativeQuery = true)
	OrderInfo findOrderInfoBySeqAndVersion(@Param("seqNum") String seqNum, @Param("version") String version);

}