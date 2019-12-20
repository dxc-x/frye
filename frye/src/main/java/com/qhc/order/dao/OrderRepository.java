package com.qhc.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qhc.order.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, String> ,JpaSpecificationExecutor<Order>{

	@Query(value="select * from k_orders where id =(select k_orders_id from k_order_version a ,k_orders b where a.version =?1 and b.sequence_number=?2)" ,nativeQuery=true)
	Order findByIdAndSequence(String orderVersionId, String sequenceNumber);
	
	@Query(value="select * from k_orders where sequence_number=?1" ,nativeQuery=true)
	Order findBySequence(String sequenceNumber);

}
