/**
 * 
 */
package com.qhc.frye.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qhc.frye.domain.DOrder;

/**
 * @author wang@dxc.com
 *
 */
public interface SalesOrderRepository extends JpaRepository<DOrder, Integer>{

}