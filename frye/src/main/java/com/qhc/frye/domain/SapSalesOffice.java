package com.qhc.frye.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author lizuoshan
 *
 */
@Entity
@Table(name = "sap_sales_office")
public class SapSalesOffice implements Serializable{
	
	@Id
    @NotNull
    @Column(name="code",columnDefinition="CHAR",length=32)
    private String code;
	
	@NotNull
	@Column(name="name",columnDefinition="TEXT")
    private String name;
	
//	@OneToMany(mappedBy = "code",cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<ApplicationOfRolechange> apps;

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

//	public Set<ApplicationOfRolechange> getApps() {
//		return apps;
//	}
//
//	public void setApps(Set<ApplicationOfRolechange> apps) {
//		this.apps = apps;
//	}
	
	
	



}