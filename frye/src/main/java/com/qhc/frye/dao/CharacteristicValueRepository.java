/**
 * 
 */
package com.qhc.frye.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qhc.frye.entity.DCharacteristicValue;


/**
 * @author wang@dxc.com
 *
 */
@Repository
public interface CharacteristicValueRepository extends JpaRepository<DCharacteristicValue, String> {
	
	@Query(value = "select * from sap_characteristic_value where code = ?1 AND sap_characteristic_code=?2", nativeQuery = true)
    int selectId(String code,String characteristicCode);

}
