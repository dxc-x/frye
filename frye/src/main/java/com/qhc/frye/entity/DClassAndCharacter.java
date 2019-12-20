/**
 * 
 */
package com.qhc.frye.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.qhc.frye.entity.identity.ClassCharacterIdentity;

/**
 * @author wang@dxc.com
 *
 */
@Entity
@Table(name="sap_clazz_and_character")
public class DClassAndCharacter {
	
	@EmbeddedId
	private ClassCharacterIdentity cci;

	public ClassCharacterIdentity getCci() {
		return cci;
	}

	public void setCci(ClassCharacterIdentity cci) {
		this.cci = cci;
	}
	
	
}