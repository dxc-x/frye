package com.qhc.frye.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
/**
 * 
 * @author wang@dxc.com
 *
 */

@Entity
@Table(name="sap_currency")
public class DCurrency {
	@Id
    @NotNull
    @Column(name="code",columnDefinition="CHAR",length=3)
	private String code;

    @NotNull
    @Column(name="name",columnDefinition="TEXT")
	private String name;
    
    @NotNull
    @Column(name="rate",columnDefinition="DOUBLE")
	private double rate;
    
    @NotNull
    @Column(name="sap_sales_type_code",columnDefinition="CHAR",length=2)
    private String salesTypeCode;
    
    @NotNull
    @Column(name="is_reserved",columnDefinition="BIT",length=1)
    private boolean isReserved;
    

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
	
	
    
	public String getSalesTypeCode() {
		return salesTypeCode;
	}

	public void setSalesTypeCode(String salesTypeCode) {
		this.salesTypeCode = salesTypeCode;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	@Override
	public boolean equals(Object o) {
		if(o.getClass().equals(this.getClass()) ) {
			DCurrency obj = (DCurrency)o;
			if(obj.getCode().equals(this.getCode())) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int hashCode() {
		return this.getCode().hashCode();
	}
    
}
