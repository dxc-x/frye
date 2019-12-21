package com.qhc.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.qhc.order.entity.ReportFormsInfo;

@Repository
public interface ReportFormsInfoRepository extends JpaRepository<ReportFormsInfo, String>, JpaSpecificationExecutor<ReportFormsInfo> {

}