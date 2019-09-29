/**
 * 
 */
package com.qhc.frye.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhc.frye.dao.SalesGroupRepository;
import com.qhc.frye.dao.SalesOfficeRepository;
import com.qhc.frye.domain.SapSalesGroups;
import com.qhc.frye.domain.SapSalesOffice;

import com.qhc.frye.rest.controller.entity.SalesGroup;

/**
 * @author wang@dxc.com
 *
 */
@Service
public class LocationService {

	@Autowired
	private SalesGroupRepository groupRepo;

	@Autowired
	private SalesOfficeRepository officeRepo;

	/**
	 * delete all data in DB table
	 */
	public void clean() {
		groupRepo.deleteAll();
		officeRepo.deleteAll();
	}
	/**
	 * put data to db table , please clean it before this.
	 */
	public void put(List<SalesGroup> salesGroups) {
		
		List<SapSalesGroups> groups = new ArrayList();
		Set<SapSalesOffice> offices = new HashSet();
		for (SalesGroup sg : salesGroups) {
			SapSalesGroups ssg = new SapSalesGroups();
			ssg.setCode(sg.getCode());
			ssg.setName(sg.getName());
			ssg.setOfficeCode(sg.getOfficeCode());
			
			SapSalesOffice sso = new SapSalesOffice();
			sso.setCode(sg.getOfficeCode());
			sso.setName(sg.getOfficeName());	
			
			groups.add(ssg);
			offices.add(sso);
		}
		officeRepo.saveAll(offices);
		groupRepo.saveAll(groups);
		
	}
	
}
