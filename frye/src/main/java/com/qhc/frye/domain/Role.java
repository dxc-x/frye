/**
 * 
 */
package com.qhc.frye.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "b_roles")
public class Role implements Serializable{
	
	@Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
	
	@NotNull
	@Column(name="name",columnDefinition="TEXT",length = 64)
    private String name;
	
	@NotNull
	@Column(name="isActive",columnDefinition ="BIT")
	public Integer isActive;
	
	
	@OneToMany(mappedBy = "id",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ApplicationOfRolechange> apps;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Set<ApplicationOfRolechange> getApps() {
		return apps;
	}

	public void setApps(Set<ApplicationOfRolechange> apps) {
		this.apps = apps;
	}




}