/**
 * 
 */
package com.qhc.frye.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author wang@dxc.com
 *
 */
@Entity
@Table(name="sap_materials")
public class DMaterial {
	@Id
    @NotNull
    @Column(name="code",length=18)
	private String code;
	
    @Column(name="description",columnDefinition="TEXT")
	private String description;
	
	@NotNull
    @Column(name="is_configurable",columnDefinition="BIT")
	private boolean isConfigurable;
	
	@NotNull
    @Column(name="stand_price",columnDefinition="DECIMAL", precision=13, scale=2)
	private double price;
	
//	@NotNull
//    @Column(name="transfer_price",columnDefinition="DECIMAL", precision=13, scale=2)
//	private double trPrice;
//	
//	@NotNull
//    @Column(name="marketing_price",columnDefinition="DECIMAL", precision=13, scale=2)
//	private double mkPrice;
//	
	@NotNull
    @Column(name="opt_time",columnDefinition="DATETIME")
	private Date optTime;
	
	@NotNull
    @Column(name="sap_material_type_number",length=4)
	private String type;
	
	@NotNull      
    @Column(name="sap_unit_of_measurement_code",length=3)
	private String unit;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isConfigurable() {
		return isConfigurable;
	}

	public void setConfigurable(boolean isConfigurable) {
		this.isConfigurable = isConfigurable;
	}

	
	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	

}
